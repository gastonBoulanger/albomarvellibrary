package com.albo.comic.sync.entities.comic;

import com.albo.comic.sync.entities.character.Characters;
import com.albo.comic.sync.entities.creator.Creators;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ComicResult {
	private long id;
    private long digitalID;
    private String title;
    private long issueNumber;
    private String variantDescription;
    private String description;
    private String modified;
    private String isbn;
    private String upc;
    private String diamondCode;
    private String ean;
    private String issn;
    private String format;
    private long pageCount;
    private Creators creators;
    private Characters characters;

    @JsonProperty("id")
    public long getID() { return id; }
    @JsonProperty("id")
    public void setID(long value) { this.id = value; }

    @JsonProperty("digitalId")
    public long getDigitalID() { return digitalID; }
    @JsonProperty("digitalId")
    public void setDigitalID(long value) { this.digitalID = value; }

    @JsonProperty("title")
    public String getTitle() { return title; }
    @JsonProperty("title")
    public void setTitle(String value) { this.title = value; }

    @JsonProperty("issueNumber")
    public long getIssueNumber() { return issueNumber; }
    @JsonProperty("issueNumber")
    public void setIssueNumber(long value) { this.issueNumber = value; }

    @JsonProperty("variantDescription")
    public String getVariantDescription() { return variantDescription; }
    @JsonProperty("variantDescription")
    public void setVariantDescription(String value) { this.variantDescription = value; }

    @JsonProperty("description")
    public String getDescription() { return description; }
    @JsonProperty("description")
    public void setDescription(String value) { this.description = value; }

    @JsonProperty("modified")
    public String getModified() { return modified; }
    @JsonProperty("modified")
    public void setModified(String value) { this.modified = value; }

    @JsonProperty("isbn")
    public String getIsbn() { return isbn; }
    @JsonProperty("isbn")
    public void setIsbn(String value) { this.isbn = value; }

    @JsonProperty("upc")
    public String getUpc() { return upc; }
    @JsonProperty("upc")
    public void setUpc(String value) { this.upc = value; }

    @JsonProperty("diamondCode")
    public String getDiamondCode() { return diamondCode; }
    @JsonProperty("diamondCode")
    public void setDiamondCode(String value) { this.diamondCode = value; }

    @JsonProperty("ean")
    public String getEan() { return ean; }
    @JsonProperty("ean")
    public void setEan(String value) { this.ean = value; }

    @JsonProperty("issn")
    public String getIssn() { return issn; }
    @JsonProperty("issn")
    public void setIssn(String value) { this.issn = value; }

    @JsonProperty("format")
    public String getFormat() { return format; }
    @JsonProperty("format")
    public void setFormat(String value) { this.format = value; }

    @JsonProperty("pageCount")
    public long getPageCount() { return pageCount; }
    @JsonProperty("pageCount")
    public void setPageCount(long value) { this.pageCount = value; }

    @JsonProperty("creators")
    public Creators getCreators() { return creators; }
    @JsonProperty("creators")
    public void setCreators(Creators value) { this.creators = value; }

    @JsonProperty("characters")
    public Characters getCharacters() { return characters; }
    @JsonProperty("characters")
    public void setCharacters(Characters value) { this.characters = value; }
}
