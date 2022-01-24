package com.albo.comic.db.services;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.albo.comic.db.entities.CharacterDTO;
import com.albo.comic.db.repository.CharacterRepository;

@Service
public class CharacterService {
	
	private final CharacterRepository characterRepository;
	
	@Autowired
	public CharacterService(CharacterRepository characterRepository) {
		this.characterRepository = characterRepository;
	}
	
	public Iterable<CharacterDTO> getCharacters() {
		return characterRepository.findAll();
	}
	
	public Map<String,String> getCharactersNames() {
		Map<String,String> charactersName = new HashMap<String,String>(); 
		Iterable<CharacterDTO> characters = characterRepository.findAll();
		characters.forEach(character -> {
			charactersName.put(character.getName(), character.getSearchName());
		});
		return charactersName;
	}

	public void updateCharacter(Long characterId, String characterName, String searchName) {
		Optional<CharacterDTO> optionalCharacterDto = characterRepository.findByName(characterName);
		if (!optionalCharacterDto.isEmpty()) {
			CharacterDTO characterDTO = optionalCharacterDto.get();
			characterDTO.setUpdateAt(new Date());
			characterRepository.save(characterDTO);
		} else {
			CharacterDTO character = new CharacterDTO(characterId, characterName, searchName);
			characterRepository.save(character);
		}
	}

}
