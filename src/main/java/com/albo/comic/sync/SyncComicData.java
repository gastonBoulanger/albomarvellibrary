package com.albo.comic.sync;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.albo.comic.db.entities.CharacterDTO;
import com.albo.comic.db.services.CharacterService;
import com.albo.comic.db.services.ComicService;
import com.albo.comic.db.services.MemberService;
import com.albo.comic.sync.entities.Member;
import com.albo.comic.sync.entities.character.CharacterMarvelResponse;
import com.albo.comic.sync.entities.character.CharacterResult;
import com.albo.comic.sync.entities.comic.ComicMarvelResponse;
import com.albo.comic.sync.entities.comic.ComicResult;
import com.albo.comic.sync.services.SyncService;

@Component
public class SyncComicData {
	private final SyncService syncService;
	private final CharacterService characterService;
	private final MemberService partnerService;
	private final ComicService comicService;

	@Autowired
	SyncComicData(SyncService syncService, CharacterService characterService, MemberService partnerService, ComicService comicService){
        this.syncService = syncService;
        this.characterService = characterService;
        this.partnerService = partnerService;
        this.comicService = comicService;
    }
	
	@PostConstruct
	public void loadFirstData() {
		Map<String, String> charactersName = characterService.getCharactersNames();
		if (charactersName.isEmpty()) {
			charactersName = new HashMap<String, String>();
			charactersName.put("Iron Man", "ironman");
			charactersName.put("Captain America", "capamerica");
			for(Map.Entry<String, String> character : charactersName.entrySet()) {
				syncCharacter(character.getKey(), character.getValue(), false, new Date());
			}
		}
	}
	
	public void syncData() {
		Iterable<CharacterDTO> characters = characterService.getCharacters();
		if (characters != null) {
			characters.forEach(character -> syncCharacter(character.getName(), character.getSearchName(), true, character.getUpdateAt()));
		}
	}
	
	public void syncCharacter(String name, String searchName,Boolean updateLastDay, Date lastSync) {
		try {
			CharacterMarvelResponse characterResponse = syncService.getMarvelCharacterByName(name);
			if (characterResponse != null && characterResponse.getData().getResults().length > 0) {
				CharacterResult result = characterResponse.getData().getResults()[0];
				String characterName = result.getName();
				Long characterId = result.getID(); 
				characterService.updateCharacter(characterId, characterName, searchName);
				syncComics(characterId, updateLastDay, lastSync);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void syncComics(Long characterId, Boolean updateLastDay, Date lastSync) {
		try {
			Long total = Long.MAX_VALUE;
			int saved = 0;
			int page = 0;
			do {
				ComicMarvelResponse comicResponse = syncService.getComicsByCharacterId(characterId, page, updateLastDay, lastSync);
				if (comicResponse != null) {
					ComicResult[] results = comicResponse.getData().getResults();
					if (results != null) {
						for (ComicResult result : results){
							createComic(result.getID(), result.getTitle());
							updateMembers(characterId, result.getID(), result.getCreators().getItems());
							updateMembers(characterId, result.getID(), result.getCharacters().getItems());
						}
					}
					if (page == 0) {
						total = comicResponse.getData().getTotal();						
					}
					saved += comicResponse.getData().getCount();
					page++;
				}
			} while (total > saved);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void createComic(long id, String title) {
		comicService.createComic(id, title);
	}

	private void updateMembers(Long characterId, Long comicId, Member[] items) {
		try {
			for (Member partner : items) {
				partnerService.createMember(characterId, comicId, partner);
			}
		} catch (Exception e) {
			System.out.println("/////// ERROR ////// " + e);
		}
	}
}
