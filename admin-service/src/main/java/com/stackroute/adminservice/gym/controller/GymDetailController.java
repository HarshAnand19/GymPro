package com.stackroute.adminservice.gym.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.stackroute.adminservice.gym.entity.GymDetails;
import com.stackroute.adminservice.gym.service.GymDetailService;
import com.stackroute.adminservice.gym.service.GymNotFoundException;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/gym")
public class GymDetailController {

    private final GymDetailService gymDetailService;

    @Autowired
    public GymDetailController(GymDetailService gymDetailService) {
        this.gymDetailService = gymDetailService;
    }
    
 // Get all gym details
    @GetMapping("/all")
    public ResponseEntity<List<GymDetails>> getAllGyms() {
        List<GymDetails> allGyms = gymDetailService.getAllGyms();
        return new ResponseEntity<>(allGyms, HttpStatus.OK);
    }
    
 // Get gym details by gymId
    @GetMapping("/{gymId}")
    public ResponseEntity<GymDetails> getGymById(@PathVariable String gymId) {
        try {
            GymDetails gymDetail = gymDetailService.getGymById(gymId);
            return new ResponseEntity<>(gymDetail, HttpStatus.OK);
        } catch (GymNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Add a new gym
    @PostMapping("/add")
    public ResponseEntity<GymDetails> addGym(@RequestBody GymDetails gymDetails) {
        GymDetails addedGym = gymDetailService.addGym(gymDetails);
        return new ResponseEntity<>(addedGym, HttpStatus.CREATED);
    }

    // Delete a gym by gymId
    @DeleteMapping("/delete/{gymId}")
    public ResponseEntity<String> deleteGym(@PathVariable String gymId) {
        try {
            gymDetailService.deleteGym(gymId);
            return new ResponseEntity<>("Gym deleted successfully", HttpStatus.OK);
        } catch (GymNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Update gym details (name, email, address, phone)
    @PutMapping("/update/{gymId}")
    public ResponseEntity<GymDetails> updateGymDetails(@PathVariable String gymId,
                                                       @RequestParam String gymName,
                                                       @RequestParam String gymEmail,
                                                       @RequestParam String gymAddress,
                                                       @RequestParam String gymPhone) {
        try {
            GymDetails updatedGym = gymDetailService.updateGymDetails(gymId, gymName, gymEmail, gymAddress, gymPhone);
            return new ResponseEntity<GymDetails>(updatedGym, HttpStatus.OK);
        } catch (GymNotFoundException e) {
            return new ResponseEntity<GymDetails>(HttpStatus.NOT_FOUND);
        }
    }

    // Upload profile picture for a gym
    @PostMapping("/upload-picture/{gymId}")
    public ResponseEntity<String> uploadProfilePicture(@PathVariable String gymId,
                                                       @RequestParam("profilePicture") MultipartFile profilePicture) {
        try {
            gymDetailService.uploadProfilePicture(gymId, profilePicture);
            return new ResponseEntity<>("Profile picture uploaded successfully", HttpStatus.OK);
        } catch (IOException | GymNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Change profile picture for a gym
    @PutMapping("/change-picture/{gymId}")
    public ResponseEntity<?> changeProfilePicture(@PathVariable String gymId,
                                                       @RequestParam("profilePicture") MultipartFile profilePicture) {
        try {
            gymDetailService.changeProfilePicture(gymId, profilePicture);
            return new ResponseEntity<>("Profile picture changed successfully", HttpStatus.OK);
        } catch (IOException | GymNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Delete profile picture for a gym
    @DeleteMapping("/delete-picture/{gymId}")
    public ResponseEntity<String> deleteProfilePicture(@PathVariable String gymId) {
        try {
            gymDetailService.deleteProfilePicture(gymId);
            return new ResponseEntity<>("Profile picture deleted successfully", HttpStatus.OK);
        } catch (GymNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
}
