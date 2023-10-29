package com.stackroute.eventservice.controller;

import com.stackroute.eventservice.model.Event;
import com.stackroute.eventservice.model.ParticipatedUser;
import com.stackroute.eventservice.model.Status;
import com.stackroute.eventservice.service.ParticipatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/participated-users")
@CrossOrigin
public class ParticipatedUserController {
    private final ParticipatedUserService userService;
    @Autowired
    public ParticipatedUserController(ParticipatedUserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ParticipatedUser registerUser(@RequestBody ParticipatedUser user) {
        return userService.registerUser(user);
    }
    @PutMapping("/{participantId}/status")
    public ResponseEntity<ParticipatedUser> updateUserStatus(@PathVariable String participantId, 
    		@RequestBody Map<String, String> requestBody) {
        String statusValue = requestBody.get("status");

        if (statusValue != null) {
            Status status = Status.valueOf(statusValue);
            ParticipatedUser updatedUser = userService.updateUserStatus(participantId, status);
            
            if (updatedUser != null) {
                return ResponseEntity.ok(updatedUser);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PutMapping("/{participantId}")
    public ParticipatedUser updateUserDetails(@PathVariable String participantId, @RequestBody ParticipatedUser updatedUser) {
        return userService.updateUserDetails(participantId, updatedUser);
    }

    @GetMapping("/events/{eventId}")
    public List<ParticipatedUser> getUsersByEventName(@PathVariable String eventId) {
        return userService.getUsersByEventName(eventId);
    }


    
    @GetMapping("/event/{emailId}")
   
    public List<Event> getEventsByUserEmail(@PathVariable String emailId) {
        return userService.getEventsByUserEmail(emailId);
    }
}