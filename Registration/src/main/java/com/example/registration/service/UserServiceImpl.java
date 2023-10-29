package com.example.registration.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.registration.entities.User;
import com.example.registration.repository.UserRepository;
@Service
public class UserServiceImpl implements UserService {
@Autowired
private UserRepository repo;
	@Override
	public void addUser(User user) {
		repo.save(user);		
	}

	@Override
	public List<User> getUser() {
		// TODO Auto-generated method stub
		 return repo.findAll();
	}

	@Override
	public Optional<User> getbyId(String email) {
		
		 return repo.findById(email);   
			}

	@Override
	public void update(User user, String email) {
		// TODO Auto-generated method stub
		Optional<User> existingUser = repo.findById(email);
        if (existingUser.isPresent()) {
            
            User updatedUser = existingUser.get();
            updatedUser.setFirstName(user.getFirstName());
            updatedUser.setLastName(user.getLastName());
            
            
            updatedUser.setPhone(user.getPhone());
            updatedUser.setAge(user.getAge());
            updatedUser.setAddress(user.getAddress());
            updatedUser.setHeight(user.getHeight());
            updatedUser.setGender(user.getGender());
            updatedUser.setWeight(user.getWeight());
            updatedUser.setProfilePicturePath(user.getProfilePicturePath());
           
            updatedUser.setProfileImage(user.getProfileImage());
            updatedUser.setProfile_img(user.getProfile_img());
            
            
            
            
            

            
            repo.save(updatedUser); 
        } 

	}

	@Override
	public void delete(String email) {
		// TODO Auto-generated method stub
		repo.deleteById(email);

		
	}

}
