package com.example.registration.Controller;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.registration.entities.User;
import com.example.registration.producer.KafkaMessageProducer;
import com.example.registration.repository.UserRepository;

import com.example.registration.service.UserServiceImpl;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
@RestController
@RequestMapping("/auth")  
@CrossOrigin("*")
public class UserController {
@Autowired
private UserServiceImpl impl;
@Autowired
private UserRepository repo;
@Autowired
private final KafkaMessageProducer producer;

public UserController(KafkaMessageProducer producer) {
    this.producer = producer;
}
@PostMapping("/addUser")
public ResponseEntity<?> addUser(@RequestBody User user) {
	        
	        

	        impl.addUser(user);
       producer.sendRegistrationData(user.getEmail(), user.getPassword(), user.getRole());
	        return new ResponseEntity<String>("User Added Successfully", HttpStatus.CREATED);
	    }

	    @GetMapping("/getAllUsers")
	    public ResponseEntity<?> getAllUsers() {
	        List<User> users = impl.getUser();
	        if (users.isEmpty()) {
	            return new ResponseEntity<String>("No User Found", HttpStatus.NOT_FOUND);
	        } else {
	            return new ResponseEntity<List<User>>(users, HttpStatus.OK);
	        }
	    }
	    @GetMapping("/getbyId/{email}")
	    public ResponseEntity<?> getuserById(@PathVariable String email,User user){
	   	 if(repo.existsById(user.getEmail())) {
	   	 Optional<User> user1=impl.getbyId(email);
	   	 return new ResponseEntity<Optional<User>>(user1,HttpStatus.OK);
	    }
	   	 else {
	   		 return new ResponseEntity<String>("Id Not Found",HttpStatus.BAD_REQUEST);
	   	 }
	    }

	    @DeleteMapping("/deleteUser/{email}")
	    public ResponseEntity<?> deleteAdmin(@PathVariable String email,User user) {
	        if(repo.existsById(user.getEmail())) {
	            impl.delete(email);
	            return new ResponseEntity<String>("User Deleted", HttpStatus.OK);
	        }
	        else {
	        	return new ResponseEntity<String>("No Id Found",HttpStatus.NOT_FOUND);
	        }
	    }
	    

        
	    @PutMapping("/updateUser/{email}")
	    public ResponseEntity<?> updateAdmin(
	            @RequestParam("profilePicture") MultipartFile profilePicture,
	            @RequestParam("data") String userData,
	            @PathVariable String email
	    ) {
	        try {
	            User user = new ObjectMapper().readValue(userData, User.class);

	            // Convert the uploaded image to byte[] and set it in the user object
	            if (!profilePicture.isEmpty()) {
	                user.setProfileImage(profilePicture.getBytes()); 
	            }

	            if (repo.existsById(user.getEmail())) {
	                impl.update(user, email);
	                return new ResponseEntity<String>("User Updated Successfully", HttpStatus.OK);
	            } else {
	                return new ResponseEntity<String>("No Id Found", HttpStatus.NOT_FOUND);
	            }
	        } catch (JsonParseException | JsonMappingException e) {
	            return new ResponseEntity<String>("JSON Parsing Error: " + e.getMessage(), HttpStatus.BAD_REQUEST);
	        } catch (IOException e) {
	            return new ResponseEntity<String>("IO Error: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	        }
	    }
}
