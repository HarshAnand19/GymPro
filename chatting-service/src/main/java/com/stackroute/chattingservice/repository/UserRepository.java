package com.stackroute.chattingservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.stereotype.Repository;

import com.stackroute.chattingservice.model.User;

public interface UserRepository  extends MongoRepository<User, String> {
}

