package com.example.registration.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Arrays;


@Document
public class User {

	private String userId;	
	private String firstName;
	private String lastName;
	@Id
	private String email;
	private String phone;
	private String password;
	private String age;
	private String address;
	private String height;
	private byte[] profileImage;
	private String profile_img;
	private String gender;
	private String role;
	private String weight;
	private String profilePicturePath;
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getHeight() {
		return height;
	}
	public void setHeight(String height) {
		this.height = height;
	}
	public byte[] getProfileImage() {
		return profileImage;
	}
	public void setProfileImage(byte[] profileImage) {
		this.profileImage = profileImage;
	}
	public String getProfile_img() {
		return profile_img;
	}
	public void setProfile_img(String profile_img) {
		this.profile_img = profile_img;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getWeight() {
		return weight;
	}
	public void setWeight(String weight) {
		this.weight = weight;
	}
	public String getProfilePicturePath() {
		return profilePicturePath;
	}
	public void setProfilePicturePath(String profilePicturePath) {
		this.profilePicturePath = profilePicturePath;
	}
	public User(String userId, String firstName, String lastName, String email, String phone, String password, String age,
			String address, String height, byte[] profileImage, String profile_img, String gender, String role,
			String weight, String profilePicturePath) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.password = password;
		this.age = age;
		this.address = address;
		this.height = height;
		this.profileImage = profileImage;
		this.profile_img = profile_img;
		this.gender = gender;
		this.role = role;
		this.weight = weight;
		this.profilePicturePath = profilePicturePath;
	}
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", phone=" + phone + ", password=" + password + ", age=" + age + ", address=" + address + ", height="
				+ height + ", profileImage=" + Arrays.toString(profileImage) + ", profile_img=" + profile_img + ", gender="
				+ gender + ", role=" + role + ", weight=" + weight + ", profilePicturePath=" + profilePicturePath + "]";
	}
//Getter and Setter for profilePicturePath
}
