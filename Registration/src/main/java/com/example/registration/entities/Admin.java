package com.example.registration.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Admin {

private String  adminId;
private String firstName;
private String lastName;
@Id
private String email;
private String phone;
private String password;
private String role;
public String getAdminId() {
	return adminId;
}
public void setAdminId(String adminId) {
	this.adminId = adminId;
}
public String getFirstName() {
	return firstName;
}
public void setFirstName(String firstName) {
	this.firstName = firstName;
}
public String getLastName() {
	return lastName;
}
public void setLastName(String lastName) {
	this.lastName = lastName;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhone() {
	return phone;
}
public void setPhone(String phone) {
	this.phone = phone;
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
public Admin(String adminId, String firstName, String lastName, String email, String phone, String password, String role) {
	super();
	this.adminId = adminId;
	this.firstName = firstName;
	this.lastName = lastName;
	this.email = email;
	this.phone = phone;
	this.password = password;
	this.role = role;
}
public Admin() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Admin [adminId=" + adminId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
			+ ", Phone=" + phone + ", password=" + password + ", role=" + role + "]";
}

}
