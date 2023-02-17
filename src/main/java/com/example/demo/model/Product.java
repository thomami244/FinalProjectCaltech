package com.example.demo.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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


//import org.springframework.data.annotation.Id;

@Entity
@Table(name = "products")
@EnableTransactionManagement
public class Product {

	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long product_id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "product_id")
    private List<Cart> carts;
//	private Set<Cart> cart = new HashSet<>();
	
	
    @Column
	@NotEmpty @Size ( min = 2, message = "the productname should have more than 2 characters")
	private String productname;
	
    @Column
	private String productdescription;
    
    @Column
   	private String productURL;
    
    @Column
    @NotEmpty @Size ( min = 2, message = "the product category should have more than 2 characters")
	private String productcategory;
    
    
    // unit price for each product
    @Column
    private float productprice;

    // quantity of stock on hand
    @Column
	private Long availablequantity;
    
    
//    // quantity of stock ordered
//    @Column
//	private Long productquantity;
//    
//    // quantity of stock ordered multiplied by the unit price
//    @Column
//	private float producttotal;
    
    
    // the admin can activate the product or deactivate the product from the store listing
    @Column(name="ISACTIVATED")
//    @NotEmpty
    private boolean isActivated;
    
    
	public Product() {
		super(); //default
	}


	public Product(Long product_id, String productname, String productdescription, String productURL, String productcategory, float productprice, Long availablequantity, Long productquantity, Long producttotal, boolean isActivated) {
		this(); // invoke constructor above
		this.product_id = product_id;
		this.productname = productname;
		this.productdescription = productdescription;
		this.productURL = productURL;
		this.productcategory = productcategory;
		this.productprice = productprice;
		this.availablequantity = availablequantity;
//		this.productquantity = productquantity;
//		this.producttotal = producttotal;
		this.isActivated = isActivated;
		
	}


	public Long getId() {
		return product_id;
	}


	public void setId(Long product_id) {
		this.product_id = product_id;
	}

	public String getProductname() {
		return productname;
	}


	public void setProductname(String productname) {
		this.productname = productname;
	}
	
	
	public String getProductdescription() {
		return productdescription;
	}


	public void setProductdescription(String productdescription) {
		this.productdescription = productdescription;
	}
	
	
	public String getProductURL() {
		return productURL;
	}


	public void setProductURL(String productURL) {
		this.productURL = productURL;
	}

	public String getProductcategory() {
		return productcategory;
	}


	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}

	public float getProductprice() {
		return productprice;
	}


	public void setProductprice(float productprice) {
		this.productprice = productprice;
	}
	
	public Long getAvailablequantity() {
		return availablequantity;
	}


	public void setAvailablequantity(Long availablequantity) {
		this.availablequantity = availablequantity;
	}
	
	
//	public Long getProductquantity() {
//		return productquantity;
//	}
//
//
//	public void setProductquantity(Long productquantity) {
//		this.productquantity = productquantity;
//	}
//	
//	public float getProducttotal() {
//		return producttotal;
//	}
//
//
//	public void setProducttotal(float producttotal) {
//		this.producttotal = producttotal;
//	}
	
	public boolean getIsActivated() {
		return isActivated;
	}


	public void setIsActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	
	
}