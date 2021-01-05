
package com.informatorio.blog_info.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



import javax.validation.Valid;

import com.informatorio.blog_info.repository.CommentRepository;
import com.informatorio.blog_info.repository.PostRepository;
import com.informatorio.blog_info.repository.UserRepository;
import com.informatorio.blog_info.entity.Comment;
import com.informatorio.blog_info.entity.Post;
import com.informatorio.blog_info.entity.User;


@RestController
@RequestMapping("/comment")

public class CommentController {

	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private PostRepository postRepository;
	
	// Obtener todos los elementos de la base de datos y mandar un mensaje de OK con libreria HTTPStatus
	@GetMapping
	public ResponseEntity<?> getAllComment() {
		return new ResponseEntity<>(commentRepository.findAll(), HttpStatus.OK);
		}	
	
	
	
	@PostMapping("/{id_post}/{id_user}") 
    public ResponseEntity<?> createComment( @PathVariable Long id_user, @PathVariable Long id_post, @RequestBody Comment comment) {
		User user = userRepository.getOne(id_user);
		user.addComment(comment);
		Post post = postRepository.getOne(id_post);
		post.addComment(comment);
        return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.OK);
    }
    
	
	//Edita TODOS los campos
	@PutMapping("/{commentId}")
    public ResponseEntity<?> editComment(@PathVariable Long commentId, @Valid @RequestBody Comment comment) {
		Comment commentEdit = commentRepository.getOne(commentId);
        commentEdit.setContent(comment.getContent());
        commentEdit.setDate(comment.getDate());
        commentEdit.setAuthor(comment.getAuthor());
        return new ResponseEntity<>(commentRepository.save(commentEdit), HttpStatus.ACCEPTED);
    }
	
	@DeleteMapping("/{commentId}")
	public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
		Comment commentDelete = commentRepository.getOne(commentId);
		commentRepository.delete(commentDelete);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}

	}



	