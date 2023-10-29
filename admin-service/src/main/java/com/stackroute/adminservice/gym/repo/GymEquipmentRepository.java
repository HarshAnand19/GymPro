package com.stackroute.adminservice.gym.repo;

import com.stackroute.adminservice.gym.entity.GymEquipment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymEquipmentRepository extends MongoRepository<GymEquipment, String> {
    
}
