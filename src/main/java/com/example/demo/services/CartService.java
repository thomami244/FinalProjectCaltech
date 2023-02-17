package com.example.demo.services;

import java.util.List;

import com.example.demo.model.Cart;


public interface CartService {

	public List<Cart> findAll();
	public Cart findById( long theId );

	public Cart save ( Cart theCart );
	public Cart deleteById ( long theId );

	
}