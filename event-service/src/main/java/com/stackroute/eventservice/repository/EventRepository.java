package com.stackroute.eventservice.repository;

import com.stackroute.eventservice.model.Event;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EventRepository extends MongoRepository<Event, String> {
    List<Event> findByEventDateAfter(Date currentDate);

    List<Event> findByEventDateBefore(Date currentDate);

    List<Event> findByEventDateBetween(Date currentDate, Date futureDate);
}