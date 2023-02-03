package com.example.demo.model;

import javax.persistence.Access;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import java.util.Currency;
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

//import org.springframework.data.annotation.Id;

@Entity
@Table(name = "products")
@EnableTransactionManagement
public class Product {

	@Id
	@Column(name="product_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long product_id;
	
    @Column
	@NotEmpty @Size ( min = 2, message = "the productname should have more than 2 characters")
	private String productname;
	
    @Column
    @NotEmpty @Size ( min = 3, message = "the product description should have more than 3 characters")
	private String productdescription;
    
    @Column
    @NotEmpty @Size ( min = 2, message = "the product category should have more than 2 characters")
	private String productcategory;
    
    
    // unit price for each product
    @Column
    @NotEmpty
	private Currency productprice;
    
    // quantity of stock on hand
    @Column
    @NotEmpty
	private Long productquantity;
    
    // the admin can activate the product or deactivate the product from the store listing
    @Column(name="ISACTIVATED")
    @NotEmpty
    private boolean isActivated;
    
    
	public Product() {
		super(); //default
	}


	public Product(Long product_id, String productname, String productdescription, String productcategory, Currency productprice, Long productquantity, boolean isActivated) {
		this(); // invoke constructor above
		this.product_id = product_id;
		this.productname = productname;
		this.productdescription = productdescription;
		this.productcategory = productcategory;
		this.productprice = productprice;
		this.productquantity = productquantity;
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

	public String getProductcategory() {
		return productcategory;
	}


	public void setProductcategory(String productcategory) {
		this.productcategory = productcategory;
	}

	public Currency getProductprice() {
		return productprice;
	}


	public void setProductprice(Currency productprice) {
		this.productprice = productprice;
	}
	
	
	public Long getProductquantity() {
		return productquantity;
	}


	public void setProductquantity(Long productquantity) {
		this.productquantity = productquantity;
	}
	
	public boolean getIsActivated() {
		return isActivated;
	}


	public void setIsActivated(boolean isActivated) {
		this.isActivated = isActivated;
	}
	
	
}