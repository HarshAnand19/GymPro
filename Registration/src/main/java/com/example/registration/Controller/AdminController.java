package com.example.registration.Controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.registration.entities.Admin;
import com.example.registration.producer.KafkaMessageProducer;
import com.example.registration.repository.AdminRepository;
import com.example.registration.service.AdminService;
import com.example.registration.service.AdminServiceImpl;

@RestController
@RequestMapping("/auth")  
@CrossOrigin("*")
public class AdminController {

    @Autowired
    private AdminServiceImpl impl;
    
    @Autowired
    private AdminRepository repo;
    @Autowired
    private  KafkaMessageProducer producer;

    

    @PostMapping("/addAdmin")
    public ResponseEntity<?> addAdmin(@RequestBody Admin admin) {
        
        

        impl.addAdmin(admin);

        producer.sendRegistrationData(admin.getEmail(), admin.getPassword(), admin.getRole());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping("/getAllAdmins")  
    public ResponseEntity<?> getAllAdmins() {
        List<Admin> admins = impl.getAdmin();
        if (admins.isEmpty()) {
            return new ResponseEntity<String>("No Admins Found", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<List<Admin>>(admins, HttpStatus.OK);
        }
    }
 @GetMapping("/getAdminbyId/{email}")
 public ResponseEntity<?> getadminById(@PathVariable String email,Admin admin){
	 if(repo.existsById(admin.getEmail())) {
	 Optional<Admin> admins=impl.getbyId(email);
	 return new ResponseEntity<Optional<Admin>>(admins,HttpStatus.OK);
 }
	 else {
		 return new ResponseEntity<String>("Id Not Found",HttpStatus.BAD_REQUEST);
	 }
 }
 
    @DeleteMapping("/deleteAdmin/{email}")
    public ResponseEntity<?> deleteAdmin(@PathVariable String email,Admin admin) {
        if(repo.existsById(admin.getEmail())) {
            impl.delete(email);
            return new ResponseEntity<String>("Admin Deleted", HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<String>("No Id Found",HttpStatus.NOT_FOUND);
        }
    }
    

    @PutMapping("/updateAdmin/{email}")
    public ResponseEntity<?> updateAdmin(@RequestBody Admin admin, @PathVariable String email) {
         if(repo.existsById(admin.getAdminId())) {
            impl.update(admin, email);
            return new ResponseEntity<String>("Admin Updated Successfully", HttpStatus.OK);
        }
         else {
        	 return new ResponseEntity<String>("No Id Found",HttpStatus.NOT_FOUND);
         }
    }
}
