package com.albo.comic.sync.entities.comic;

import com.albo.comic.sync.entities.Response;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ComicMarvelResponse extends Response {
	
	private ComicData data;

    @JsonProperty("data")
    public ComicData getData() { return data; }
    @JsonProperty("data")
    public void setData(ComicData value) { this.data = value; }
}
