package com.albo.comic.sync.entities;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Member {
	private String resourceURI;
    private String name;
    private String role;

    @JsonProperty("resourceURI")
    public String getResourceURI() { return resourceURI; }
    @JsonProperty("resourceURI")
    public void setResourceURI(String value) { this.resourceURI = value; }

    @JsonProperty("name")
    public String getName() { return name; }
    @JsonProperty("name")
    public void setName(String value) { this.name = value; }

    @JsonProperty("role")
    public String getRole() { return role; }
    @JsonProperty("role")
    public void setRole(String value) { this.role = value; }
}
