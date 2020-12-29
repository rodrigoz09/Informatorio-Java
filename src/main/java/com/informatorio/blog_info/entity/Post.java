package com.informatorio.blog_info.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String title;
	private String description;
	private String content;
	private String date;
	private String author;
	private Boolean published;
	
	
	
	public Long getId() { return id;}
	
	public void setId(Long id) {this.id = id; }
	
	public String getTitle() {return title; }
	
	public void setTitle(String title) {this.title = title;}
	
	public String getDescription() {return description;}
	
	public void setDescription(String description) {this.description = description;}
	
	public String getContent() { return content;}
	
	public void setContent(String content) {this.content = content; }
	
	public String getDate() { return date;}
	
	public void setDate(String date) {this.date = date; }
	
	public String getAuthor() { return author;}
	
	public void setAuthor(String author) {this.author = author; }
	
	public Boolean getPublished() { return published;}
	
	public void setPublished(Boolean published) {this.published = published; }
	
}


