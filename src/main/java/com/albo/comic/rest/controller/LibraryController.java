package com.albo.comic.rest.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.albo.comic.rest.entities.CharactersResponse;
import com.albo.comic.rest.entities.ColaboratorsResponse;
import com.albo.comic.rest.services.LibraryService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/marvel")
public class LibraryController {
	
	private final LibraryService libraryService;
	
	@Autowired
    LibraryController(LibraryService libraryService){
        this.libraryService = libraryService;
    }
	
	@Operation(summary = "Get partners and comics by name hero")
    @ApiResponses(value = {
    		@ApiResponse(responseCode = "200", description = "found hero", content = { 
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CharactersResponse.class))}),
            @ApiResponse(responseCode = "204", description = "Invalid name hero, please verify this and retry", content = @Content)
    		})
	@GetMapping("/characters/{name}")
	public ResponseEntity<CharactersResponse> getCharacterByHero(@PathVariable(value = "name") String name) {
		Optional<CharactersResponse> characters = libraryService.findCharactersByHero(name);
		return characters.isPresent() ? new ResponseEntity<CharactersResponse>(characters.get(), HttpStatus.OK)
				: new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	
	@Operation(summary = "Get colaborators by name hero")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "found hero", content = { 
                    @Content(mediaType = "application/json", schema = @Schema(implementation = CharactersResponse.class))}),
            @ApiResponse(responseCode = "204", description = "Invalid name hero, please verify this and retry", content = @Content)})
	@GetMapping("/colaborators/{name}")
	public ResponseEntity<ColaboratorsResponse> getColaboratorsByHero(@PathVariable(value = "name") String name) {
		Optional<ColaboratorsResponse> colaborators = libraryService.findColaboratorsByHero(name);
		return colaborators.isPresent() ? new ResponseEntity<ColaboratorsResponse>(colaborators.get(), HttpStatus.OK)
				: new ResponseEntity<>( HttpStatus.NOT_FOUND);
	}
}
