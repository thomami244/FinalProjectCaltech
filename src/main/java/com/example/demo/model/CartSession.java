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
import java.util.List;
import java.util.Set;
import com.example.demo.model.User;

//import org.springframework.data.annotation.Id;

@Entity
@Table(name = "cartSessions")
@EnableTransactionManagement
public class CartSession {

	@Id
	@Column(name="cartSession_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long cartSession_id;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cartSession")
    private List<Cart> carts;
//	private Set<Cart> cart = new H
//	private Set<Cart> cart = new HashSet<>();
	
    
	@ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    
      
    
	public CartSession() {
		super(); //default
	}


	public CartSession(Long cartSession_id, User user) {
		this(); // invoke constructor above
		this.cartSession_id = cartSession_id;

		this.user = user;
		
	}


	public Long getCartSessionId() {
		return cartSession_id;
	}


	public void setCartSessionId(Long cartSession_id) {
		this.cartSession_id = cartSession_id;
	}
	
	
	
	  public User getUser() {
	        return user;
	    }	
	
}