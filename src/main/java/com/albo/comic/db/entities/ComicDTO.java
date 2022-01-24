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
@Table(name = "comic")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = { "created_at", "updated_at" }, allowGetters = true)
public class ComicDTO {
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
	
	@Column(name = "comicId")
	private Long comicId;
	
	@Column(name = "title")
	private String title;
	
	public ComicDTO() {
		
	}
	
	public ComicDTO(long comicId, String title) {
		this.comicId = comicId;
		this.title = title;
	}

	public Long getId() { return id; }
    public void setId(Long value) { this.id = value; }
    
    public Long getComicId() { return comicId; }
    public void setComicId(Long value) { this.comicId = value; }

    public String getTitle() { return title; }
    public void setTitle(String value) { this.title = value; }
}
