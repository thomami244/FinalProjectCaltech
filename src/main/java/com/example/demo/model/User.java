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

//import org.springframework.data.annotation.Id;

@Entity
@Table(name = "users")
@EnableTransactionManagement
public class User {

	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long user_id;
	
    @Column
	@NotEmpty @Size ( min = 2, message = "the username should have more than 2 characters")
	private String username;
	
    @Column
    @NotEmpty @Size ( min = 5, message = "the password should have more than 5 characters")
	private String password;
		
	
	public User() {
		super(); //default
	}


	public User(Long user_id, String username, String password) {
		this(); // invoke constructor above
		this.user_id = user_id;
		this.username = username;
		this.password = password;

	}


	public Long getId() {
		return user_id;
	}


	public void setId(Long user_id) {
		this.user_id = user_id;
	}

	public String getUsername() {
		return username;
	}


	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	
	
}
