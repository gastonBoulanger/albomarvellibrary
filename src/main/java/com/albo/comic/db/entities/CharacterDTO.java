package com.albo.comic.db.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "charactercomic")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class CharacterDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false, updatable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@CreatedDate
	private Date created_at;
	
	@Column(nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	@LastModifiedDate
	private Date updated_at;
	
	@Column(name = "character_id")
	private Long character_id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "search_name")
	private String search_name;
	
	public CharacterDTO() {
		
	}
	
	public CharacterDTO(Long characterId, String name, String searchName) {
		this.character_id = characterId;
		this.name = name;
		this.search_name = searchName;
	}
	
	public Date getUpdateAt() { return updated_at; }
	public void setUpdateAt(Date value) { this.updated_at = value; }
	
	public Long getId() { return id; }
    public void setId(Long value) { this.id = value; }
    
    public Long getCharacterId() { return character_id; }
    public void setCharacterId(Long value) { this.character_id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
    
    public String getSearchName() { return search_name; }
    public void setSearchName(String value) { this.search_name = value; }
}
