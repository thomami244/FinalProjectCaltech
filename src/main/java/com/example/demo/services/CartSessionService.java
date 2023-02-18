package com.example.demo.services;

import java.util.List;

import com.example.demo.model.CartSession;


public interface CartSessionService {

	public List<CartSession> findAll();
	public CartSession findById( long theId );

	public CartSession save ( CartSession theCartSession );
	public CartSession deleteById ( long theId );

	
}