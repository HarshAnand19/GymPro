package com.stackroute.eventservice.service;

import com.stackroute.eventservice.model.Event;
import com.stackroute.eventservice.model.ParticipatedUser;
import com.stackroute.eventservice.model.Status;

import java.util.List;

public interface ParticipatedUserService {
    ParticipatedUser registerUser(ParticipatedUser user);
    ParticipatedUser updateUserStatus(String participantId, Status status);
    ParticipatedUser updateUserDetails(String participantId, ParticipatedUser updatedUser);
    List<ParticipatedUser> getUsersByEventName(String eventId);
    List<Event> getEventsByUserEmail(String emailId);}