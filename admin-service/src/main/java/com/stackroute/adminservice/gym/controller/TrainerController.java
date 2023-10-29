package com.stackroute.adminservice.gym.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stackroute.adminservice.gym.entity.Trainer;
import com.stackroute.adminservice.gym.service.TrainerService;

import java.util.List;

@RestController
@RequestMapping("/api/gym/trainers")
public class TrainerController {

    private final TrainerService trainerService;

    @Autowired
    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }
    
    @PostMapping("/add")
    public ResponseEntity<Trainer> addTrainer(@RequestBody Trainer newTrainer) {
        Trainer addedTrainer = trainerService.addTrainer(newTrainer);
        if (addedTrainer != null) {
            return new ResponseEntity<>(addedTrainer, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }


    // Get the total number of trainers
    @GetMapping("/total")
    public ResponseEntity<Long> getTotalTrainers() {
        long totalTrainers = trainerService.getTotalTrainers();
        return new ResponseEntity<>(totalTrainers, HttpStatus.OK);
    }

    // Get all trainers
    @GetMapping("/all")
    public ResponseEntity<List<Trainer>> getAllTrainers() {
        List<Trainer> trainers = trainerService.getAllTrainers();
        return new ResponseEntity<>(trainers, HttpStatus.OK);
    }

    // Get a trainer by trainerId
    @GetMapping("/{trainerId}")
    public ResponseEntity<Trainer> getTrainerById(@PathVariable String trainerId) {
        Trainer trainer = trainerService.getTrainerById(trainerId);
        if (trainer != null) {
            return new ResponseEntity<>(trainer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get trainers in a specific slot by slotId
    @GetMapping("/slot/{slotId}")
    public ResponseEntity<List<Trainer>> getTrainersInSlot(@PathVariable String slotId) {
        List<Trainer> trainers = trainerService.getTrainersInSlot(slotId);
        if (trainers != null) {
            return new ResponseEntity<>(trainers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Edit a particular trainer's details
    @PutMapping("/{trainerId}")
    public ResponseEntity<Trainer> editTrainerDetails(
            @PathVariable String trainerId,
            @RequestBody Trainer updatedTrainer
    ) {
        Trainer editedTrainer = trainerService.editTrainerDetails(trainerId, updatedTrainer);
        if (editedTrainer != null) {
            return new ResponseEntity<>(editedTrainer, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	// Delete a trainer by trainerId
    @DeleteMapping("/{trainerId}")
    public ResponseEntity<Void> deleteTrainerById(@PathVariable String trainerId) {
        boolean deleted = trainerService.deleteTrainerById(trainerId);
        if (deleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
