
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

import com.informatorio.blog_info.repository.UserRepository;
import com.informatorio.blog_info.entity.User;
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepository;
	
	// Obtener todos los elementos de la base de datos y mandar un mensaje de OK con libreria HTTPStatus
	@GetMapping
	public ResponseEntity<?> getAllUser() {
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
		}
	
	
	
	
	@PostMapping
    public ResponseEntity<?> createUser(@RequestBody User user) {
        return new ResponseEntity<>(userRepository.save(user), HttpStatus.CREATED);
    }
    
	
	//Edita TODOS los campos
	@PutMapping("/{userId}")
    public ResponseEntity<?> editUser(@PathVariable Long userId, @Valid @RequestBody User user) {
        User userEdit = userRepository.getOne(userId);
        userEdit.setName(user.getName());
        userEdit.setLastName(user.getLastName());
        userEdit.setEmail(user.getEmail());
        userEdit.setDate(user.getDate());
        userEdit.setPassword(user.getPassword());
        userEdit.setCity(user.getCity());
        userEdit.setProvince(user.getProvince());
        userEdit.setCountry(user.getCountry());
        return new ResponseEntity<>(userRepository.save(userEdit), HttpStatus.OK);
    }
	
	@DeleteMapping("/{postId}")
	public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
		User userDelete = userRepository.getOne(userId);
		userRepository.delete(userDelete);
		return new ResponseEntity<>(HttpStatus.OK);
		
	}
}

