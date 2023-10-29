package com.stackroute.eventservice.model;

import org.springframework.data.annotation.Id;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="Event")
public class Event {
    @Id
    private String eventId;
    private String eventName;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date eventDate;
    
    private String eventLocation;
    private String eventDetails;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date registrationBeginsDate;
    
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date registrationEndsDate;
    
    public Event() {
        // Generate a unique eventId using UUID
        this.eventId = UUID.randomUUID().toString();
    }

    public String getEventId() {
        return eventId;
    }

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventLocation() {
        return eventLocation;
    }

    public void setEventLocation(String eventLocation) {
        this.eventLocation = eventLocation;
    }

    public String getEventDetails() {
        return eventDetails;
    }

    public void setEventDetails(String eventDetails) {
        this.eventDetails = eventDetails;
    }

    public Date getRegistrationBeginsDate() {
        return registrationBeginsDate;
    }

    public void setRegistrationBeginsDate(Date registrationBeginsDate) {
        this.registrationBeginsDate = registrationBeginsDate;
    }

    public Date getRegistrationEndsDate() {
        return registrationEndsDate;
    }

    public void setRegistrationEndsDate(Date registrationEndsDate) {
        this.registrationEndsDate = registrationEndsDate;
    }   
    
}