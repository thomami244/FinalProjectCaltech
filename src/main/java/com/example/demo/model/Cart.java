package com.example.demo.model;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.NotEmpty;
//import javax.validation.constraints.Size;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import javax.persistence.Id;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;
import com.example.demo.model.Product;

//import org.springframework.data.annotation.Id;

@Entity
@Table(name = "carts")
@EnableTransactionManagement
public class Cart {

	@Id
	@Column(name="cart_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cart_id;
	
	  // multiple cart items can belong to the same order
    @Column
	private Long orderId;
	    
    // quantity of stock ordered
    @Column
	private Long productquantity;
    
    // quantity of stock ordered multiplied by the unit price
    @Column
	private Long producttotal;
    
    
	@ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
    
      
    
	public Cart() {
		super(); //default
	}


	public Cart(Long cart_id, Long orderId, Long productquantity, Long producttotal, Product oroduct) {
		this(); // invoke constructor above
		this.cart_id = cart_id;
		this.orderId = orderId;

		this.productquantity = productquantity;
		this.producttotal = producttotal;
		this.product = product;
		
	}


	public Long getCartId() {
		return cart_id;
	}


	public void setCartId(Long cart_id) {
		this.cart_id = cart_id;
	}
	
	public Long getOrderId() {
		return orderId;
	}


	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	
	public Long getProductquantity() {
		return productquantity;
	}


	public void setProductquantity(Long productquantity) {
		this.productquantity = productquantity;
	}
	
	public Long getProducttotal() {
		return producttotal;
	}


	public void setProducttotal(Long producttotal) {
		this.producttotal = producttotal;
	}
	
	  public Product getProduct() {
	        return product;
	    }	
	
}