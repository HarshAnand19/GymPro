package com.unkownkoder.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.unkownkoder.model.User;

public interface UserRepository extends MongoRepository<User, String> {
	Optional<User> findByEmail(String email);
}
