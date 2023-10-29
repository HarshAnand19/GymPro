package com.example.registration.service;

import java.util.List;
import java.util.Optional;

import com.example.registration.entities.Admin;

public interface AdminService {
public void addAdmin(Admin admin);
public List<Admin> getAdmin();
public Optional<Admin> getbyId(String email);
public void update(Admin admin, String email);
public void delete(String email);
}
