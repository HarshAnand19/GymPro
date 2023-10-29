package com.stackroute.adminservice.gym.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.stackroute.adminservice.gym.entity.GymDetails;
import com.stackroute.adminservice.gym.repo.GymDetailsRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class GymDetailService {

    private final GymDetailsRepository gymDetailRepository;

    @Autowired
    public GymDetailService(GymDetailsRepository gymDetailRepository) {
        this.gymDetailRepository = gymDetailRepository;
    }
    
 // Get all gym details
    public List<GymDetails> getAllGyms() {
        return gymDetailRepository.findAll();
    }

    // Get gym details by gymId
    public GymDetails getGymById(String gymId) throws GymNotFoundException {
        Optional<GymDetails> optionalGymDetail = gymDetailRepository.findById(gymId);
        if (optionalGymDetail.isPresent()) {
            return optionalGymDetail.get();
        } else {
            throw new GymNotFoundException("Gym with ID " + gymId + " not found.");
        }
    }

    // Add a new gym
    public GymDetails addGym(GymDetails gymDetail) {
        return gymDetailRepository.save(gymDetail);
    }

    // Delete a gym by gymId
    public void deleteGym(String gymId) throws GymNotFoundException {
        Optional<GymDetails> optionalGymDetail = gymDetailRepository.findById(gymId);
        if (optionalGymDetail.isPresent()) {
            gymDetailRepository.deleteById(gymId);
        } else {
            throw new GymNotFoundException("Gym with ID " + gymId + " not found.");
        }
    }

    // Update gym details (name, email, address, phone)
    public GymDetails updateGymDetails(String gymId, String gymName, String gymEmail, String gymAddress, String gymPhone) throws GymNotFoundException {
        Optional<GymDetails> optionalGymDetail = gymDetailRepository.findById(gymId);
        if (optionalGymDetail.isPresent()) {
            GymDetails gymDetail = optionalGymDetail.get();
            gymDetail.setGymName(gymName);
            gymDetail.setGymEmail(gymEmail);
            gymDetail.setGymAddress(gymAddress);
            gymDetail.setGymPhone(gymPhone);
            return gymDetailRepository.save(gymDetail);
        } else {
            throw new GymNotFoundException("Gym with ID " + gymId + " not found.");
        }
    }

    // Upload profile picture for a gym
    public void uploadProfilePicture(String gymId, MultipartFile profilePicture) throws IOException, GymNotFoundException {
        Optional<GymDetails> optionalGymDetail = gymDetailRepository.findById(gymId);
        if (optionalGymDetail.isPresent()) {
            GymDetails gymDetail = optionalGymDetail.get();
            gymDetail.setGymPic(profilePicture.getBytes());
            gymDetailRepository.save(gymDetail);
        } else {
            throw new GymNotFoundException("Gym with ID " + gymId + " not found.");
        }
    }

    // Change profile picture for a gym
    public void changeProfilePicture(String gymId, MultipartFile profilePicture) throws IOException, GymNotFoundException {
        uploadProfilePicture(gymId, profilePicture);
    }

    // Delete profile picture for a gym
    public void deleteProfilePicture(String gymId) throws GymNotFoundException {
        Optional<GymDetails> optionalGymDetail = gymDetailRepository.findById(gymId);
        if (optionalGymDetail.isPresent()) {
            GymDetails gymDetail = optionalGymDetail.get();
            gymDetail.setProfilePicture(null);
            gymDetailRepository.save(gymDetail);
        } else {
            throw new GymNotFoundException("Gym with ID " + gymId + " not found.");
        }
    }
}
