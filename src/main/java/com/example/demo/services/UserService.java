package com.example.demo.services;

import java.util.List;

import com.example.demo.model.User;


public interface UserService {

	public List<User> findAll();
	public User findById( long theId );
	public User save ( User theUser );
	public User deleteById ( long theId );
	
}