package com.example.registration.service;

import java.util.List;
import java.util.Optional;

import com.example.registration.entities.Admin;
import com.example.registration.entities.User;

public interface UserService {
	public void addUser(User user);
	public List<User> getUser();
	public Optional<User> getbyId(String email);
	public void update(User user, String email);
	public void delete(String email);
	}


