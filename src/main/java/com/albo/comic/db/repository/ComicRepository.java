package com.albo.comic.db.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.albo.comic.db.entities.ComicDTO;

public interface ComicRepository  extends CrudRepository <ComicDTO, Long> {

	@Query("SELECT c FROM ComicDTO c WHERE comicId = ?1")
	Optional<ComicDTO> getByComicId(Long comicId);

}
