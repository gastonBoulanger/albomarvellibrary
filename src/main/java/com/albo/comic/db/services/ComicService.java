package com.albo.comic.db.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.albo.comic.db.entities.ComicDTO;
import com.albo.comic.db.repository.ComicRepository;

@Service
public class ComicService {
	
	private final ComicRepository comicRepository;
	
	ComicService(ComicRepository comicRepository) {
		this.comicRepository = comicRepository;
	}

	public void createComic(long id, String title) {
		Optional<ComicDTO> comic = comicRepository.getByComicId(id);
		if(!comic.isPresent()) {
			ComicDTO comicDTO = new ComicDTO(id, title);
			comicRepository.save(comicDTO);
		}
		
	}

}
