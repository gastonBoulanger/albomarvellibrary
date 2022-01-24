package com.albo.comic.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.albo.comic.db.entities.CharacterDTO;

public interface CharacterRepository extends CrudRepository <CharacterDTO, Long> {
	 
	@Query("SELECT c FROM CharacterDTO c WHERE name = ?1")
    Optional<CharacterDTO> findByName(String name);
	
	@Query("SELECT c FROM CharacterDTO c WHERE search_name = ?1")
    Optional<CharacterDTO> findBySearchname(String search_name);
	
}
