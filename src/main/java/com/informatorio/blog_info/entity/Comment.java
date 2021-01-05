package com.informatorio.blog_info.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Comment {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
//	@Column(nullable = false)
//    @NotBlank
    @Size(max = 200)
	private String content;
	
	
    private LocalDate date = LocalDate.now(); 
	
    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="author", referencedColumnName = "id")
    private User author;
    
    

	@ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="post", referencedColumnName = "id")
    private Post post;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public LocalDate getDate() {
		return date;
	}
	public void setDate(LocalDate date) {
		this.date = date;
	}
	public User getAuthor() {
		return author;
	}
	public void setAuthor(User author) {
		this.author = author;
	}
	
	@JsonIgnore
    public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	
}