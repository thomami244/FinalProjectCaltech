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

//import org.springframework.data.annotation.Id;

@Entity
@Table(name = "users")
public class User {

	@Id
	@Column(name="user_id")
    private Long Id;
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
    @Column
	@NotEmpty @Size ( min = 2, message = "the username should have more than 2 characters")
	private String username;
	
    @Column
    @NotEmpty @Size ( min = 5, message = "the password should have more than 5 characters")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String password;
	
//	@NotEmpty @Size ( min = 5, message = "the description should have more than 5 characters")
//	private String description;
//	private Date targetDate;
//	private boolean isDone;
	
	
	public User() {
		super(); //default
	}


	public User(Long id, String username, String password) {
		this(); // invoke constructor on line 14
		this.id = id;
		this.username = username;
		this.password = password;

	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
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
