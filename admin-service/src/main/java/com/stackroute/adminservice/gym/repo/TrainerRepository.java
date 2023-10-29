package com.stackroute.adminservice.gym.repo;

import com.stackroute.adminservice.gym.entity.Trainer;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainerRepository extends MongoRepository<Trainer, String> {
	List<Trainer> findBySlotId(String slotId);
    
}
