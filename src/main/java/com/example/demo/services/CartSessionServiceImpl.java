package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.CartSession;
import com.example.demo.repository.CartSessionRepository;

@Service(value = "cartSessionService")
public class CartSessionServiceImpl implements CartSessionService {
	

	
	private CartSessionRepository cartSessionRepository ;
	
	public CartSessionServiceImpl() {
		super();
	}
	
	
	public CartSessionServiceImpl(CartSessionRepository cartSessionRepository) {
		super();
		System.out.println("spring ioc container invoked constructor to assemble 'Repository' bean");
		this.cartSessionRepository = cartSessionRepository;
	}

	@Autowired
	public void setCartSessionRepository(CartSessionRepository cartSessionRepository) {
		System.out.println("spring ioc container invoked setter method to assemble 'Repository' bean");
		this.cartSessionRepository = cartSessionRepository;
	}

	@Override
	public List<CartSession> findAll() {
		return cartSessionRepository.findAll();
	}

	@Override
	public CartSession findById(long theId) {
		return cartSessionRepository.findById(theId).get();
	}
	
	
	@Override
	public CartSession save(CartSession theCartSession) {
		return cartSessionRepository.save(theCartSession);
	}

	@Override
	public CartSession deleteById(long theId) {
		 cartSessionRepository.deleteById(theId);
		 return null;
	}


}