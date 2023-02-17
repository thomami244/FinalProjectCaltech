package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Cart;
import com.example.demo.repository.CartRepository;

@Service(value = "cartService")
public class CartServiceImpl implements CartService {
	

	
	private CartRepository cartRepository ;
	
	public CartServiceImpl() {
		super();
	}
	
	
	public CartServiceImpl(CartRepository cartRepository) {
		super();
		System.out.println("spring ioc container invoked constructor to assemble 'Repository' bean");
		this.cartRepository = cartRepository;
	}

	@Autowired
	public void setCartRepository(CartRepository cartRepository) {
		System.out.println("spring ioc container invoked setter method to assemble 'Repository' bean");
		this.cartRepository = cartRepository;
	}

	@Override
	public List<Cart> findAll() {
		return cartRepository.findAll();
	}

	@Override
	public Cart findById(long theId) {
		return cartRepository.findById(theId).get();
	}
	
	
	@Override
	public Cart save(Cart theCart) {
		return cartRepository.save(theCart);
	}

	@Override
	public Cart deleteById(long theId) {
		 cartRepository.deleteById(theId);
		 return null;
	}


}