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

import com.example.demo.errors.CartSessionNotFoundException;
import com.example.demo.model.CartSession;
import com.example.demo.services.CartSessionService;



@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class CartSessionResource {
	
	
	@GetMapping ( path = "/users/{username}/cartsession/{cartSession_id}" )
	public CartSession getCartSession (@PathVariable String username, @PathVariable long cartSession_id) {
		CartSession theCartSession = cartSessionService.findById(cartSession_id);
		//		current request: http://localhost:8080/users/admin/cartsession/1
		if ( theCartSession == null ) {
			throw new CartSessionNotFoundException("id - " + cartSession_id);
		}
		
		return theCartSession;	
	}

	
	
//	@DeleteMapping ( path = "/users/{username}/todos/{id}")
//	public ResponseEntity delete(@PathVariable String username, @PathVariable long id) {
//		Todo theTodo = todoService.deleteById(id);
//		
//		if ( theTodo != null ) {
//			return ResponseEntity.noContent().build();
//		}
//		
//		return  ResponseEntity.notFound().build();
//	}
//	
//	
	@PostMapping( path = "/users/{username}/cartsession")
	public ResponseEntity createCartSession (@PathVariable String username ,@Valid @RequestBody CartSession theCartSession) {
		
		CartSession saveCartSession = cartSessionService.save(theCartSession);
		
		// current request  : http://localhost:8080/users/admin/cartsession
		
		// current request + path =  http://localhost:8080/users/admin/cartsession/1
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.buildAndExpand(saveCartSession).toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	@Autowired
	private CartSessionService cartSessionService;
	
	@GetMapping ( path = "/users/{username}/cartsession" )
	public List<CartSession> getAllCartSessions( @PathVariable String username){
//		System.out.println( " username : " + username);
		return cartSessionService.findAll();
	}
	
	
}