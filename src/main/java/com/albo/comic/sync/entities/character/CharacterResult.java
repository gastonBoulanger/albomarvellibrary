package com.albo.comic.sync.entities.character;

import com.albo.comic.sync.entities.comic.Comics;
import com.fasterxml.jackson.annotation.JsonProperty;

public class CharacterResult {
	private long id;
    private String name;
    private String description;
    private String modified;
    private String resourceURI;
    private Comics comics;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("modified")
    public String getModified() { return modified; }
    @JsonProperty("modified")
    public void setModified(String value) { this.modified = value; }

    @JsonProperty("resourceURI")
    public String getResourceURI() { return resourceURI; }
    @JsonProperty("resourceURI")
    public void setResourceURI(String value) { this.resourceURI = value; }

    @JsonProperty("comics")
    public Comics getComics() { return comics; }
    @JsonProperty("comics")
    public void setComics(Comics value) { this.comics = value; }
}
