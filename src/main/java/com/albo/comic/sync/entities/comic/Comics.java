package com.albo.comic.sync.entities.comic;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Comics {
	private long available;
    private String collectionURI;
    private Comic[] items;
    private long returned;

    @JsonProperty("available")
    public long getAvailable() { return available; }
    @JsonProperty("available")
    public void setAvailable(long value) { this.available = value; }

    @JsonProperty("collectionURI")
    public String getCollectionURI() { return collectionURI; }
    @JsonProperty("collectionURI")
    public void setCollectionURI(String value) { this.collectionURI = value; }

    @JsonProperty("items")
    public Comic[] getItems() { return items; }
    @JsonProperty("items")
    public void setItems(Comic[] value) { this.items = value; }

    @JsonProperty("returned")
    public long getReturned() { return returned; }
    @JsonProperty("returned")
    public void setReturned(long value) { this.returned = value; }
}
