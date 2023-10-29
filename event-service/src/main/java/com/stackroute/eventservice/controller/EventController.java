package com.stackroute.eventservice.controller;

import com.stackroute.eventservice.model.Event;
import com.stackroute.eventservice.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/events")
@CrossOrigin("*")
public class EventController {
    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/allevents")
    public List<Event> getAllEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/{eventId}")
    public Event getEventById(@PathVariable String eventId) {
        return eventService.getEventById(eventId);
    }

    @PostMapping("/createevent")
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @PutMapping("/{eventId}")
    public Event updateEvent(@PathVariable String eventId, @RequestBody Event event) {
        return eventService.updateEvent(eventId, event);
    }

    @DeleteMapping("/{eventId}")
    public void deleteEvent(@PathVariable String eventId) {
        eventService.deleteEvent(eventId);
    }

    @GetMapping("/upcoming")
    public List<Event> getUpcomingEvents() {
        return eventService.getUpcomingEvents();
    }
}