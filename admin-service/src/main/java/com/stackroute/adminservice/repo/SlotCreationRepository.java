package com.stackroute.adminservice.repo;


import com.stackroute.adminservice.model.SlotCreation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SlotCreationRepository extends MongoRepository<SlotCreation, String> {
    
}

