package com.stackroute.adminservice.gym.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.adminservice.gym.entity.Trainer;
import com.stackroute.adminservice.gym.repo.TrainerRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TrainerService {

    private final TrainerRepository trainerRepository;

    @Autowired
    public TrainerService(TrainerRepository trainerRepository) {
        this.trainerRepository = trainerRepository;
    }
    
    

    // Get the total number of trainers
    public long getTotalTrainers() {
        return trainerRepository.count();
    }

    // Get all trainers
    public List<Trainer> getAllTrainers() {
        return trainerRepository.findAll();
    }

    // Get a trainer by trainerId
    public Trainer getTrainerById(String trainerId) {
        Optional<Trainer> optionalTrainer = trainerRepository.findById(trainerId);
        return optionalTrainer.orElse(null);
    }

    // Get trainers present in a specific slotId (if applicable)
    public List<Trainer> getTrainersInSlot(String slotId) {
    	return trainerRepository.findBySlotId(slotId);
    }

    // Edit a particular trainer's details
    public Trainer editTrainerDetails(String trainerId, Trainer updatedTrainer) {
        Optional<Trainer> optionalTrainer = trainerRepository.findById(trainerId);
        if (optionalTrainer.isPresent()) {
            Trainer trainer = optionalTrainer.get();
            // Update the trainer's details with the provided values
            trainer.setTrainerName(updatedTrainer.getTrainerName());
            trainer.setTrainerAddress(updatedTrainer.getTrainerAddress());
            trainer.setTrainerPhone(updatedTrainer.getTrainerPhone());
            return trainerRepository.save(trainer);
        } else {
            return null; // Trainer with the given ID not found
        }
    }



	public Trainer addTrainer(Trainer newTrainer) {
		// TODO Auto-generated method stub
		 return trainerRepository.save(newTrainer);
	}
	// Delete a trainer by trainerId
    public boolean deleteTrainerById(String trainerId) {
        Optional<Trainer> optionalTrainer = trainerRepository.findById(trainerId);
        if (optionalTrainer.isPresent()) {
            trainerRepository.deleteById(trainerId);
            return true;
        }
        return false;
    }
}
