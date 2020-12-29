
package com.informatorio.blog_info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// import java.util.List;
import javax.validation.Valid;

import com.informatorio.blog_info.repository.PostRepository;
import com.informatorio.blog_info.entity.Post;
@RestController
@RequestMapping("/post")
public class PostController {

	@Autowired
	private PostRepository postRepository;
	
	// Obtener todos los elementos de la base de datos y mandar un mensaje de OK con libreria HTTPStatus
	@GetMapping
	public ResponseEntity<?> getAllPost() {
		return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
		}
	
	
	/*
	  
	
	@GetMapping // ~ /api/v1/post
    public ResponseEntity<?> getPosts(@RequestParam String title) {

        return new ResponseEntity<>(postRepository.findAll(), HttpStatus.OK);
    }
	
	
	@PostMapping
	public Post crearPost(@RequestBody Post post) {return postRepository.save(post);}
	*/
	
	
	
	@PostMapping
    public ResponseEntity<?> createPost(@RequestBody Post post) {
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
        return new ResponseEntity<>(postRepository.save(postEdit), HttpStatus.OK);
    }
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<?> deletePost(@PathVariable Long postId) {
		Post postDelete = postRepository.getOne(postId);
		postRepository.delete(postDelete);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}

