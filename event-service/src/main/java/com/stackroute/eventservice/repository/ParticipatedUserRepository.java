package com.stackroute.eventservice.repository;

import com.stackroute.eventservice.model.ParticipatedUser;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipatedUserRepository extends MongoRepository<ParticipatedUser, String> {
    List<ParticipatedUser> findByEmailId(String emailId);
    List<ParticipatedUser> findByEventId(String eventId);
    List<ParticipatedUser> findParticipatedUsersByEmailId(String emailId);
}