package com.albo.comic.sync.entities.comic;

import com.albo.comic.sync.entities.Data;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ComicData extends Data {
	
	private ComicResult[] results;
	
	@JsonProperty("results")
	public ComicResult[] getResults() { return results; }
	@JsonProperty("results")
	public void setResults(ComicResult[] value) { this.results = value; }

}
