
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


import javax.validation.Valid;

import com.informatorio.blog_info.repository.CommentRepository;
import com.informatorio.blog_info.entity.Comment;

@RestController
@RequestMapping("/comment")

public class CommentController {

	@Autowired
	private CommentRepository commentRepository;
	
	// Obtener todos los elementos de la base de datos y mandar un mensaje de OK con libreria HTTPStatus
	@GetMapping
	public ResponseEntity<?> getAllComment() {
		return new ResponseEntity<>(commentRepository.findAll(), HttpStatus.OK);
		}
	
		
	@PostMapping
	public Comment crearComment(@RequestBody Comment comment) {return commentRepository.save(comment);}
	
	@PostMapping
    public ResponseEntity<?> createPost(@RequestBody Comment comment) {
        return new ResponseEntity<>(commentRepository.save(comment), HttpStatus.CREATED);
    }
    
	
	//Edita TODOS los campos
	@PutMapping("/{commentId}")
    public ResponseEntity<?> editComment(@PathVariable Long commentId, @Valid @RequestBody Comment comment) {
		Comment commentEdit = commentRepository.getOne(commentId);
        commentEdit.setContent(comment.getContent());
        commentEdit.setDate(comment.getDate());
        commentEdit.setAuthor(comment.getAuthor());
        return new ResponseEntity<>(commentRepository.save(commentEdit), HttpStatus.OK);
    }
	
	@DeleteMapping("/{commentId}")
	public ResponseEntity<?> deleteComment(@PathVariable Long commentId) {
		Comment commentDelete = commentRepository.getOne(commentId);
		commentRepository.delete(commentDelete);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}



	