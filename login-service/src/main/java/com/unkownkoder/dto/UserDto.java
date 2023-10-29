package com.unkownkoder.dto;


public class UserDto {
	private String email;
	private String password;
	private String role;
	
	
	public UserDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserDto(String email, String password, String role) {
		super();
		this.email = email;
		this.password = password;
		this.role=role;
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
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	
	
}
