package com.example.demo.errors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class CartNotFoundException extends RuntimeException {
	
	public CartNotFoundException(String descriptionOfExcetion) {
		super(descriptionOfExcetion);
	}

}