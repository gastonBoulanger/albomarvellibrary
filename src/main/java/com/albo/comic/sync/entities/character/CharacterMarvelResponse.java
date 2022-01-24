package com.albo.comic.sync.entities.character;

import com.albo.comic.sync.entities.Response;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterMarvelResponse extends Response {
    
    private CharacterData data;

    @JsonProperty("data")
    public CharacterData getData() { return data; }
    @JsonProperty("data")
    public void setData(CharacterData value) { this.data = value; }
}
