package com.example.demo.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartSessionNotFoundException extends RuntimeException {
	
	public CartSessionNotFoundException(String descriptionOfExcetion) {
		super(descriptionOfExcetion);
	}

}