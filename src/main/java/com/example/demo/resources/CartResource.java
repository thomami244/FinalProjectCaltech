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

import com.example.demo.errors.CartNotFoundException;
import com.example.demo.model.Cart;
import com.example.demo.services.CartService;



@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class CartResource {
	
	
	@GetMapping ( path = "/users/{username}/cart/{cart_id}" )
	public Cart getCart (@PathVariable String username, @PathVariable long cart_id) {
		Cart theCart = cartService.findById(cart_id);
		
		if ( theCart == null ) {
			throw new CartNotFoundException("id - " + cart_id);
		}
		
		return theCart;	
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
	@PostMapping( path = "/users/{username}/cart")
	public ResponseEntity createCart (@PathVariable String username ,@Valid @RequestBody Cart theCart) {
		
		Cart saveCart = cartService.save(theCart);
		
		// current request  : http://localhost:8080/users/admin/cart/
		
		// current request + path =  http://localhost:8080/users/admin/cart/4
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.buildAndExpand(saveCart).toUri();
		
		return ResponseEntity.created(location).build();
		
		
	}
	
	@Autowired
	private CartService cartService;
	
	@GetMapping ( path = "/users/{username}/cart" )
	public List<Cart> getAllCarts( @PathVariable String username){
//		System.out.println( " username : " + username);
		return cartService.findAll();
	}
	
	
}
