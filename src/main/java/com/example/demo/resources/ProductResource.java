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

import com.example.demo.errors.ProductNotFoundException;
import com.example.demo.model.Product;
import com.example.demo.services.ProductService;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
public class ProductResource {
	
	
	@GetMapping ( path = "/products/{product_id}" )
	public Product getProduct (@PathVariable long product_id) {
		Product theProduct = productService.findById(product_id);
		
		if ( theProduct == null ) {
			throw new ProductNotFoundException("id - " + product_id);
		}
		
		return theProduct;	
	}

	

	
	@DeleteMapping ( path = "/products/{product_id}")
	public ResponseEntity delete(@PathVariable long product_id) {
		Product theProduct = productService.deleteById(product_id);
		
		if ( theProduct != null ) {
			return ResponseEntity.noContent().build();
		}
		
		return  ResponseEntity.notFound().build();
	}
	
	
	@PostMapping( path = "/products/")
	public ResponseEntity createProduct (@Valid @RequestBody Product theProduct) {
		
		Product saveProduct = productService.save(theProduct);
		
		// current request  : http://localhost:8080/users/
		
		// current request + path =  http://localhost:8080/users/vinodh/todos/4
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.buildAndExpand(saveProduct).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	
	
	@PutMapping( path = "/products/{product_id}")
	public ResponseEntity updateProduct (@PathVariable long product_id ,@Valid @RequestBody Product theProduct) {
		

		
		Product saveProduct = productService.save(theProduct);
		
		// current request  : http://localhost:8080/users/vinodh/todos
		
		// current request + path =  http://localhost:8080/users/vinodh/todos/4
		
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.buildAndExpand(saveProduct.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	
	@Autowired
	private ProductService productService;
	
	@GetMapping ( path = "/products/all" )
	public List<Product> getAllProducts(){
		
		return productService.findAll();
	}
	
	
}
