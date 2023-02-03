package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@Service(value = "productService")
public class ProductServiceImpl implements ProductService {
	

	
	private ProductRepository productRepository ;
	
	public ProductServiceImpl() {
		super();
	}
	
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		System.out.println("spring ioc container invoked constructor to assemble 'productRepository' bean");
		this.productRepository = productRepository;
	}

	@Autowired
	public void setProductRepository(ProductRepository productRepository) {
		System.out.println("spring ioc container invoked setter method to assemble 'productRepository' bean");
		this.productRepository = productRepository;
	}

	@Override
	public List<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Product findById(long theId) {
		return productRepository.findById(theId).get();
	}
	
	
	@Override
	public Product save(Product theProduct) {
		return productRepository.save(theProduct);
	}

	@Override
	public Product deleteById(long theId) {
		 productRepository.deleteById(theId);
		 return null;
	}


}