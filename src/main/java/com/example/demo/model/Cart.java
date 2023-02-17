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


	public Cart(Long cart_id, Long productquantity, Long producttotal, Product oroduct) {
		this(); // invoke constructor above
		this.cart_id = cart_id;

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

//	public String getProductname() {
//		return productname;
//	}
//
//
//	public void setProductname(String productname) {
//		this.productname = productname;
//	}
//	
//	
//	public String getProductdescription() {
//		return productdescription;
//	}
//
//
//	public void setProductdescription(String productdescription) {
//		this.productdescription = productdescription;
//	}
//	
//	
//	public String getProductURL() {
//		return productURL;
//	}
//
//
//	public void setProductURL(String productURL) {
//		this.productURL = productURL;
//	}
//
//	public String getProductcategory() {
//		return productcategory;
//	}
//
//
//	public void setProductcategory(String productcategory) {
//		this.productcategory = productcategory;
//	}
//
//	public float getProductprice() {
//		return productprice;
//	}
//
//
//	public void setProductprice(float productprice) {
//		this.productprice = productprice;
//	}
//	
//	public Long getAvailablequantity() {
//		return availablequantity;
//	}
//
//
//	public void setAvailablequantity(Long availablequantity) {
//		this.availablequantity = availablequantity;
//	}
//	
	
	
	
//	public boolean getIsActivated() {
//		return isActivated;
//	}
//
//
//	public void setIsActivated(boolean isActivated) {
//		this.isActivated = isActivated;
//	}
	
	
}