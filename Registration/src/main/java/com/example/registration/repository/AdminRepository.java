package com.example.registration.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.example.registration.entities.Admin;
@Repository
public interface AdminRepository extends MongoRepository<Admin, String>{

}
