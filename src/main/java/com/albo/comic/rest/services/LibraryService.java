package com.albo.comic.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.comic.db.entities.MemberDTO;
import com.albo.comic.db.repository.*;
import com.albo.comic.db.entities.CharacterDTO;
import com.albo.comic.db.entities.ComicDTO;
import com.albo.comic.rest.entities.CharacterResponse;
import com.albo.comic.rest.entities.CharactersResponse;
import com.albo.comic.rest.entities.ColaboratorsResponse;
import com.albo.comic.utils.Colaborators;
import com.albo.comic.utils.Helpers;

@Service
public class LibraryService {

	private final CharacterRepository characterRepository;
    private final ComicRepository comicRepository;
    private final MemberRepository memberRepository;
    
	@Autowired
	public LibraryService(CharacterRepository characterRepository, ComicRepository comicRepository, MemberRepository memberRepository){
        this.characterRepository = characterRepository;
        this.comicRepository = comicRepository;
        this.memberRepository = memberRepository;
    }
	
	public Optional<CharactersResponse> findCharactersByHero(String heroName) {
		Optional<CharactersResponse> charactersResponse = Optional.empty();
		Optional<CharacterDTO> optionalCharacter = characterRepository.findBySearchname(heroName);
		if (optionalCharacter.isPresent()) {
			CharacterDTO character = optionalCharacter.get();
			CharactersResponse newResponse = new CharactersResponse();
			newResponse.setLastSync(Helpers.libraryFormattedDate(character.getUpdateAt()));
			Optional<List<MemberDTO>> optionalPartners = memberRepository.findPartners(character.getCharacterId(), "partner");
			if (optionalPartners.isPresent()) {
				List<MemberDTO> partners = optionalPartners.get();
				List<CharacterResponse> charactersPartner = getPartners(partners);
				newResponse.setCharacters(charactersPartner);
			}
			charactersResponse = Optional.of(newResponse);
		}
		return charactersResponse;
	}
	
	private List<CharacterResponse> getPartners(List<MemberDTO> partners) {
		List<CharacterResponse> characters = new ArrayList<CharacterResponse>();
		Map<String, List<MemberDTO>> partnersByName = partners.stream()
				  .collect(Collectors.groupingBy(MemberDTO::getName));
		partnersByName.forEach((name, membersDTO) -> {
			CharacterResponse characterResponse = new CharacterResponse();
			characterResponse.setCharacter(name);
			List<String> nameComics = getNamesComic(membersDTO);
			characterResponse.setComics(nameComics);
			characters.add(characterResponse);
		});
		return characters;
	}

	private List<String> getNamesComic(List<MemberDTO> members) {
		List<String> nameComics = new ArrayList<String>();
		members.forEach((member -> {
			Optional<ComicDTO> optionalComic = comicRepository.getByComicId(member.getComicId());
			if(optionalComic.isPresent()) {
				ComicDTO comic = optionalComic.get();
				nameComics.add(comic.getTitle());
			}
		}));
		return nameComics;
	}

	public Optional<ColaboratorsResponse> findColaboratorsByHero(String shortName) {
		Optional<ColaboratorsResponse> colaboratorsResponse = Optional.empty();
		Optional<CharacterDTO> optionalCharacter = characterRepository.findBySearchname(shortName);
		if (optionalCharacter.isPresent()) {
			CharacterDTO character = optionalCharacter.get();
			ColaboratorsResponse newResponse = new ColaboratorsResponse();
			newResponse.setLastSync(Helpers.libraryFormattedDate(character.getUpdateAt()));
			for (Colaborators type: Colaborators.values()) {
				if (type != Colaborators.PARTNER) {
					String[] excludeRoles = { Colaborators.EDITOR.toString(), Colaborators.PARTNER.toString(), Colaborators.WRITER.toString()};
					Optional<List<String>> optional = type != Colaborators.COLORIST ? memberRepository.nameMembersByRole(character.getCharacterId(), type.toString()) : memberRepository.nameMembersByExcludeRole(character.getCharacterId(), excludeRoles);
					if (optional.isPresent()) {
						List<String> colaborators = optional.get();
						switch (type) {
							case WRITER:
								newResponse.setWriters(colaborators);
								break;
							case EDITOR:
								newResponse.setEditors(colaborators);
							default:
								newResponse.setColorists(colaborators);
								break;
						}
						
					}
				}
			}
			
			colaboratorsResponse = Optional.of(newResponse);
		}
		return colaboratorsResponse;
	}
}
