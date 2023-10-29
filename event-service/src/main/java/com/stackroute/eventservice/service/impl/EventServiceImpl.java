package com.stackroute.eventservice.service.impl;

import com.stackroute.eventservice.model.Event;
import com.stackroute.eventservice.repository.EventRepository;
import com.stackroute.eventservice.service.EventService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class EventServiceImpl implements EventService {
    private final EventRepository eventRepository;

    @Autowired
    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEventById(String eventId) {
        return eventRepository.findById(eventId).orElse(null);
    }

    @Override
    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }
    
    @Override
    public Event updateEvent(String eventId, Event updatedEvent) {
        Event existingEvent = eventRepository.findById(eventId).orElse(null);
        if (existingEvent != null) {
            existingEvent.setEventName(updatedEvent.getEventName());
            existingEvent.setEventDate(updatedEvent.getEventDate());
            existingEvent.setEventLocation(updatedEvent.getEventLocation());
            existingEvent.setEventDetails(updatedEvent.getEventDetails());
            existingEvent.setRegistrationBeginsDate(updatedEvent.getRegistrationBeginsDate());
            existingEvent.setRegistrationEndsDate(updatedEvent.getRegistrationEndsDate());

            return eventRepository.save(existingEvent);
        }
        return null;
    } 

    @Override
    public void deleteEvent(String eventId) {
        eventRepository.deleteById(eventId);
    }

    @Override
    public List<Event> getUpcomingEvents() {
        Date currentDate = new Date();
        return eventRepository.findByEventDateAfter(currentDate);
    }
}