package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@Service(value = "userService")
public class UserServiceImpl implements UserService {
	
	// depends on 'TodoRepository'
	
	private UserRepository userRepository ;
	
	public UserServiceImpl() {
		super();
	}
	
	
	public UserServiceImpl(UserRepository userRepository) {
		super();
		System.out.println("spring ioc container invoked constructor to assemble 'userRepository' bean");
		this.userRepository = userRepository;
	}

	@Autowired
	public void setUserRepository(UserRepository userRepository) {
		System.out.println("spring ioc container invoked setter method to assemble 'userRepository' bean");
		this.userRepository = userRepository;
	}

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User findById(long theId) {
		return userRepository.findById(theId).get();
	}
	
//	@Override
//	public User findByUsername(String theUsername) {
//		return userRepository.findByUsername(theUsername).get();
//	}
	
	@Override
	public User save(User theUser) {
		return userRepository.save(theUser);
	}

	@Override
	public User deleteById(long theId) {
		 userRepository.deleteById(theId);
		 return null;
	}


//	@Override
//	public User deleteByUsername(String theUsername) {
//		 userRepository.deleteByUsername(theUsername);
//		// TODO Auto-generated method stub
//		return null;
//	}

}