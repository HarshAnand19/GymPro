package com.example.registration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.example.registration.entities.User;

public interface UserRepository extends MongoRepository<User, String> {

}
