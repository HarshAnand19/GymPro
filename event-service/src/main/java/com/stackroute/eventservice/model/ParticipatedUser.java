package com.stackroute.eventservice.model;

import java.util.Date;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection="ParticipatedUser")
public class ParticipatedUser {
	@Id
	private String participantId;
	private String emailId;
	private String eventId;
	private Status status;
	
	@JsonFormat(pattern = "yyyy-MM-dd")
	private Date dateOfRegistration;
	
	public ParticipatedUser(String emailId, String eventId, Status status) {
        this.participantId = generateParticipantId();
        this.emailId = emailId;
        this.eventId = eventId;
        this.status = status;
        this.dateOfRegistration = new Date();
    }

    private String generateParticipantId() {
        return UUID.randomUUID().toString();
    }

    public String getParticipantId() {
        return participantId;
    }

    public void setParticipantId(String participantId) {
        this.participantId = participantId;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

   

   

    public String getEventId() {
		return eventId;
	}

	public void setEventId(String eventId) {
		this.eventId = eventId;
	}

	public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDateOfRegistration() {
        return dateOfRegistration;
    }

    public void setDateOfRegistration(Date dateOfRegistration) {
        this.dateOfRegistration = dateOfRegistration;
    }
}
