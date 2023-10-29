package com.stackroute.eventservice.service;


import java.util.List;

import com.stackroute.eventservice.model.Event;

public interface EventService {
    List<Event> getAllEvents();

    Event getEventById(String eventId);

    Event createEvent(Event event);

    Event updateEvent(String eventId, Event event);

    void deleteEvent(String eventId);

    List<Event> getUpcomingEvents();
}