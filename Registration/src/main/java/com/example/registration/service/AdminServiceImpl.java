package com.example.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registration.entities.Admin;
import com.example.registration.repository.AdminRepository;
@Service
public class AdminServiceImpl implements AdminService {
@Autowired
private AdminRepository repo;
	@Override
	public void addAdmin(Admin admin) {
		repo.save(admin);
	}

	@Override
	public List<Admin> getAdmin() {
		return repo.findAll();
	}

	@Override
	public Optional<Admin> getbyId(String email) {
	 return repo.findById(email);    
	}

	@Override
	public void update(Admin admin, String email) {
		Optional<Admin> existingAdmin = repo.findById(email);
        if (existingAdmin.isPresent()) {
            
            Admin updatedAdmin = existingAdmin.get();
            updatedAdmin.setFirstName(admin.getFirstName());
            updatedAdmin.setLastName(admin.getLastName());
            
            updatedAdmin.setPhone(admin.getPhone());
            

            
            repo.save(updatedAdmin);
        } 
	}

	@Override
	public void  delete(String email) {
		
		repo.deleteById(email);
	}

}
