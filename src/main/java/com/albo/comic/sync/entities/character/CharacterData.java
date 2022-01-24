package com.albo.comic.sync.entities.character;

import com.albo.comic.sync.entities.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterData extends Data {
	
    private CharacterResult[] results;

    @JsonProperty("results")
    public CharacterResult[] getResults() { return results; }
    @JsonProperty("results")
    public void setResults(CharacterResult[] value) { this.results = value; }
}
