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
import com.example.demo.model.Cart;
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

	
	
	@DeleteMapping ( path = "/users/{username}/cartsession/{cartSession_id}")
	public ResponseEntity delete(@PathVariable String username, @PathVariable long cartSession_id) {
		CartSession theCartSession = cartSessionService.deleteById(cartSession_id);
		
		if ( theCartSession != null ) {
			return ResponseEntity.noContent().build();
		}
		
		return  ResponseEntity.notFound().build();
	}
//	
//	
	@PostMapping( path = "/users/{username}/cartsession")
	public ResponseEntity createCartSession (@PathVariable String username ,@Valid @RequestBody CartSession theCartSession) {
		
		CartSession saveCartSession = cartSessionService.save(theCartSession);
		
		// current request  : http://localhost:8080/users/mdt/cartsession
		
		// current request + path =  http://localhost:8080/users/mdt/cartsession/1
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{cartSession_id}")
				.buildAndExpand(saveCartSession.getCartSessionId()).toUri();
		
		return ResponseEntity.created(location).build();
		
//		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
//				.buildAndExpand(saveCartSession).toUri();
//		
//		return ResponseEntity.created(location).build();
		
		
	}
	
	
	@PutMapping( path = "/users/{username}/cartsession/{cartSession_id}")
	public ResponseEntity updateCartSession (@PathVariable String username , @PathVariable long cartSession_id, @Valid @RequestBody CartSession theCartSession) {
		
//		User deleteUser = userService.deleteById(user_id);
//		
//		if ( theUser != null ) {
//			return ResponseEntity.noContent().build();
//		}
//		
//		if ( theUser != null ) {
//			return ResponseEntity.noContent().build();
//		}
		
		
CartSession saveCartSession = cartSessionService.save(theCartSession);
		
		// current request  : http://localhost:8080/users/mdt/cart/1
		
		// current request + path =  http://localhost:8080/users/mdt/cart/1
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.buildAndExpand(saveCartSession.getCartSessionId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	
	
	@Autowired
	private CartSessionService cartSessionService;
	
	@GetMapping ( path = "/users/{username}/cartsession" )
	public List<CartSession> getAllUserCartSessions( @PathVariable String username){
//		current request: http://localhost:8080/users/mdt/cartsession
		return cartSessionService.findAll();
	}
	
	@GetMapping ( path = "/users/cartsessions/all" )
	public List<CartSession> getAllCartSessions(){
//		current request: http://localhost:8080/users/cartsessions/all

		return cartSessionService.findAll();
	}
	
	
}