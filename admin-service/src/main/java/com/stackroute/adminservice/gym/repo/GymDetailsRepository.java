package com.stackroute.adminservice.gym.repo;

import com.stackroute.adminservice.gym.entity.GymDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GymDetailsRepository extends MongoRepository<GymDetails, String> {
    
}
