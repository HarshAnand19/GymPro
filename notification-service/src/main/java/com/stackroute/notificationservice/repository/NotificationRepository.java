package com.stackroute.notificationservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.stackroute.notificationservice.model.NotificationMessage;


@Repository
public interface NotificationRepository extends MongoRepository<NotificationMessage, Integer> {

}
