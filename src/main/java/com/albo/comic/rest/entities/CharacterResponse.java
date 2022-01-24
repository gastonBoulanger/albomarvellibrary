package com.albo.comic.rest.entities;

import java.util.List;

public class CharacterResponse {
    private String character;
    private List<String> comics;

    public String getCharacter() { return character; }
    public void setCharacter(String value) { this.character = value; }

    public List<String> getComics() { return comics; }
    public void setComics(List<String> value) { this.comics = value; }
}
