package com.albo.comic.sync.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Members {
	private long available;
    private String collectionURI;
    private long returned;

    @JsonProperty("available")
    public long getAvailable() { return available; }
    @JsonProperty("available")
    public void setAvailable(long value) { this.available = value; }

    @JsonProperty("collectionURI")
    public String getCollectionURI() { return collectionURI; }
    @JsonProperty("collectionURI")
    public void setCollectionURI(String value) { this.collectionURI = value; }

    @JsonProperty("returned")
    public long getReturned() { return returned; }
    @JsonProperty("returned")
    public void setReturned(long value) { this.returned = value; }
}
