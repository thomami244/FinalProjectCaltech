package com.example.demo.resources;

import java.net.URI;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.demo.errors.UserNotFoundException;
import com.example.demo.model.User;
import com.example.demo.services.UserService;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class UserResource {
	
	
//	@GetMapping ( path = "/users/{username}" )
//	public User getUser (@PathVariable String username) {
//		User theUser = userService.findByUsername(username);
//		
//		if ( theUser == null ) {
//			throw new UserNotFoundException("username - " + username);
//		}
//		
//		return theUser;	
//	}
	
	@GetMapping ( path = "/users/{user_id}" )
	public User getUser (@PathVariable long user_id) {
		User theUser = userService.findById(user_id);
		
		if ( theUser == null ) {
			throw new UserNotFoundException("id - " + user_id);
		}
		
		return theUser;	
	}

	
	
//	@DeleteMapping ( path = "/users/{username}")
//	public ResponseEntity delete(@PathVariable String username) {
//		User theUser = userService.deleteByUsername(username);
//		
//		if ( theUser != null ) {
//			return ResponseEntity.noContent().build();
//		}
//		
//		return  ResponseEntity.notFound().build();
//	}
	
	@DeleteMapping ( path = "/users/{user_id}")
	public ResponseEntity delete(@PathVariable long user_id) {
		User theUser = userService.deleteById(user_id);
		
		if ( theUser != null ) {
			return ResponseEntity.noContent().build();
		}
		
		return  ResponseEntity.notFound().build();
	}
	
	
	@PostMapping( path = "/users/")
	public ResponseEntity createUser (@Valid @RequestBody User theUser) {
		
		User saveUser = userService.save(theUser);
		
		// current request  : http://localhost:8080/users/
		
		// current request + path =  http://localhost:8080/users/vinodh/todos/4
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.buildAndExpand(saveUser).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	
//	@PostMapping( path = "/users/{username}")
//	public ResponseEntity createUser (@PathVariable String username ,@Valid @RequestBody User theUser) {
//		
//		User saveUser = userService.save(theUser);
//		
//		// current request  : http://localhost:8080/users/vinodh/todos
//		
//		// current request + path =  http://localhost:8080/users/vinodh/todos/4
//		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("")
//				.buildAndExpand(saveUser.getUsername()).toUri();
//		
//		return ResponseEntity.created(location).build();
//		
//	}
	
	@PutMapping( path = "/users/{user_id}")
	public ResponseEntity updateUser (@PathVariable long user_id ,@Valid @RequestBody User theUser) {
		
//		User deleteUser = userService.deleteById(user_id);
//		
//		if ( theUser != null ) {
//			return ResponseEntity.noContent().build();
//		}
//		
//		if ( theUser != null ) {
//			return ResponseEntity.noContent().build();
//		}
		
		User saveUser = userService.save(theUser);
		
		// current request  : http://localhost:8080/users/vinodh/todos
		
		// current request + path =  http://localhost:8080/users/vinodh/todos/4
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.buildAndExpand(saveUser.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping ( path = "/users/all" )
	public List<User> getAllUsers(){
//		System.out.println( " username : " + username);
		return userService.findAll();
	}
	
	
}
