package com.stackroute.chattingservice.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
// import org.springframework.stereotype.Repository;

import com.stackroute.chattingservice.model.Chat;

import java.util.HashSet;


public interface ChatRepository extends MongoRepository<Chat, Integer> {

    HashSet<Chat> getChatByFirstUserName(String username);

    HashSet<Chat> getChatBySecondUserName(String username);

    HashSet<Chat> getChatByFirstUserNameAndSecondUserName(String firstUserName, String secondUserName);

    HashSet<Chat> getChatBySecondUserNameAndFirstUserName(String firstUserName, String secondUserName);
}

