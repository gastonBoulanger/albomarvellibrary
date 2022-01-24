package com.albo.comic.rest.entities;

import java.util.List;

public class CharactersResponse {
    private String lastSync;
    private List<CharacterResponse> characters;

    public String getLastSync() { return lastSync; }
    public void setLastSync(String value) { this.lastSync = value; }

    public List<CharacterResponse> getCharacters() { return characters; }
    public void setCharacters(List<CharacterResponse> value) { this.characters = value; }
}
