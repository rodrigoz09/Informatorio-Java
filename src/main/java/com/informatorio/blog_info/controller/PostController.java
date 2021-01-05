
package com.informatorio.blog_info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.*;
import javax.validation.Valid;

import com.informatorio.blog_info.repository.CommentRepository;
import com.informatorio.blog_info.repository.PostRepository;
import com.informatorio.blog_info.repository.UserRepository;
import com.informatorio.blog_info.entity.Comment;
import com.informatorio.blog_info.entity.Post;
import com.informatorio.blog_info.entity.User;


@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private UserRepository userRepository;
	

	// Obtener todos los elementos de la base de datos y mandar un mensaje de OK con libreria HTTPStatus
	@GetMapping
	public ResponseEntity<?> getAllPost() {
		return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
		}
	
	
	@GetMapping("/published") 
	  public ResponseEntity<?> findPostByPublished(@RequestParam Boolean published) {
	    List<Post> posts = postRepository.findPostByPublished(published);
	    return new ResponseEntity<>(posts, HttpStatus.OK);
	  }
    
	@GetMapping("/title") 
	  public ResponseEntity<?> findByTitleLike(@RequestParam String title) {
	    List<Post> posts = postRepository.findByTitleLike(title);
	    return new ResponseEntity<>(posts, HttpStatus.OK);
	  }
	

	
	@GetMapping("/{postId}/limit{limit}") 
    public ResponseEntity<?> findById(@PathVariable Long limit, @PathVariable Long postId, Pageable pageable) {
		Post post = postRepository.getOne(postId);
	    List<Comment> comments = post.getComments();
	    Pageable paging = PageRequest.of(1, 5);
	    Page<Comment> page = new PageImpl<>(comments,paging,limit);
		return new ResponseEntity<>(page, HttpStatus.OK);
		}
    

	
	
	@PostMapping("/{id_user}") 
    public ResponseEntity<?> createPost(@PathVariable Long id_user, @RequestBody Post post) {
		User user = userRepository.getOne(id_user);
		user.addPost(post);
        return new ResponseEntity<>(postRepository.save(post), HttpStatus.CREATED);
    }
    




	
	//Edita TODOS los campos
	@PutMapping("/{postId}")
    public ResponseEntity<?> editPost(@PathVariable Long postId, @Valid @RequestBody Post post) {
        Post postEdit = postRepository.getOne(postId);
        postEdit.setTitle(post.getTitle());
        postEdit.setDescription(post.getDescription());
        postEdit.setContent(post.getContent());
        postEdit.setDate(post.getDate());
        postEdit.setAuthor(post.getAuthor());
        postEdit.setPublished(post.getPublished());
        return new ResponseEntity<>(postRepository.save(postEdit), HttpStatus.ACCEPTED);
    }
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable Long postId) {
		Post postDelete = postRepository.getOne(postId);
		postRepository.delete(postDelete);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}

