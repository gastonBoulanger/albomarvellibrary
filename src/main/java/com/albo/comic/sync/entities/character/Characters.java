package com.albo.comic.sync.entities.character;

import com.albo.comic.sync.entities.Member;
import com.albo.comic.sync.entities.Members;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Characters extends Members {
private Member[] items;
	
	@JsonProperty("items")
    public Member[] getItems() { return items; }
    @JsonProperty("items")
    public void setItems(Member[] value) { this.items = value; }
}
