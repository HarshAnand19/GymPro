package com.stackroute.eventservice.service.impl;

import com.stackroute.eventservice.model.Event;
import com.stackroute.eventservice.model.ParticipatedUser;
import com.stackroute.eventservice.model.Status;
import com.stackroute.eventservice.repository.EventRepository;
import com.stackroute.eventservice.repository.ParticipatedUserRepository;
import com.stackroute.eventservice.service.ParticipatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service

public class ParticipatedUserServiceImpl implements ParticipatedUserService {
    private final ParticipatedUserRepository userRepository;
    @Autowired
    private EventRepository eventrepository;

    @Autowired
    public ParticipatedUserServiceImpl(ParticipatedUserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public ParticipatedUser registerUser(ParticipatedUser user) {
        return userRepository.save(user);
    }

    @Override
    public ParticipatedUser updateUserStatus(String participantId, Status status) {
        ParticipatedUser user = userRepository.findById(participantId).orElse(null);
        if (user != null) {
            user.setStatus(status);
            return userRepository.save(user);
        }
        return null;
    }
    
    @Override
    public ParticipatedUser updateUserDetails(String participantId, ParticipatedUser updatedUser) {
        ParticipatedUser existingUser = userRepository.findById(participantId).orElse(null);
        if (existingUser != null) {
            existingUser.setEmailId(updatedUser.getEmailId());
            existingUser.setEventId(updatedUser.getEventId());
            return userRepository.save(existingUser);
        }
        return null;
    }

    @Override
    public List<ParticipatedUser> getUsersByEventName(String eventId) {
        return userRepository.findByEventId(eventId);
    }

    @Override
    public List<Event> getEventsByUserEmail(String emailId) {
        List<ParticipatedUser> users = userRepository.findParticipatedUsersByEmailId(emailId);
        List<String>eventId= users.stream()
                .map(ParticipatedUser::getEventId)
                .collect(Collectors.toList());
         List<Event> res=new ArrayList<>();
         for(String id:eventId){
        	 if(id!=null){  Event event=eventrepository.findById(id).orElse(null); 
        	 res.add(event);}
        	
        	
         }
         return res;
    }
}