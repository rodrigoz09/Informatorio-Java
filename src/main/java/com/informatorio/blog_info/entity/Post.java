package com.informatorio.blog_info.entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;









@Entity
public class Post {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
//	@Column(nullable = false)
//    @NotBlank
	private String title;
	


	private String description;
	
	private String content;
	
    private LocalDate date = LocalDate.now(); 
	
	
	private Boolean published;
	

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name="author", referencedColumnName = "id")
    private User author;
	
	 @OneToMany
	  private List<Comment> comments = new ArrayList<>();
	
	public Long getId() { return id;}
	
	public void setId(Long id) {this.id = id; }
	
	public String getTitle() {return title; }
	
	public void setTitle(String title) {this.title = title;}
	
	public String getDescription() {return description;}
	
	public void setDescription(String description) {this.description = description;}
	
	public String getContent() { return content;}
	
	public void setContent(String content) {this.content = content; }
	
	public LocalDate getDate() {return date; }
	
	public void setDate(LocalDate date) {this.date = date; }
	

	public User getAuthor() { return author;}
	
	public void setAuthor(User author) {this.author = author; }
	
	public Boolean getPublished() { return published;}
	


	public void setPublished(Boolean published) {this.published = published; }
	
	public void addComment(Comment comment) {
	    this.comments.add(comment);
	    comment.setPost(this);
	}
	
	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}
}


