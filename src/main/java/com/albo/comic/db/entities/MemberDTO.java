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
@Table(name = "member")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class MemberDTO {
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
	
	@Column(name = "comic_id")
	private Long comic_id;

	@Column(name = "name")
	private String name;
	
	@Column(name = "role")
	private String role;

	public MemberDTO() {
		
	}
	
	public MemberDTO(Long characterId, Long comicId, String name, String role) {
		this.character_id = characterId;
		this.comic_id = comicId;
		this.name = name;
		this.role = role;
	}
	
	public Long getID() { return id; }
    public void setID(Long value) { this.id = value; }
    
    public Long getCharacterId() { return character_id; }
    public void setCharacterId(Long value) { this.character_id = value; }
    
    public Long getComicId() { return comic_id; }
    public void setComicId(Long value) { this.comic_id = value; }

    public String getName() { return name; }
    public void setName(String value) { this.name = value; }
    
    public String getRole() { return role; }
    public void setRole(String value) { this.role = value; }
}
