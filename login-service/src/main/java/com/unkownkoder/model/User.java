package com.unkownkoder.model;

import java.util.Set;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
	@Id
	private String email;
	private String password;
	private Set<String> role;
	
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(String email, String password, Set<String> authorities) {
		super();
		this.email = email;
		this.password = password;
		this.role = authorities;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Set<String> getRole() {
		return role;
	}
	public void setRole(Set<String> authorities) {
		this.role = authorities;
	}
	

}
