package com.stackroute.adminservice.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonFormat;

@Document(collection = "slot_creation")
public class SlotCreation {
	@Id
	private String slotId = UUID.randomUUID().toString();
	private String slotName;
	private String trainerId;
    private String trainerName;
	@JsonFormat(shape=JsonFormat.Shape.STRING,pattern="yyyy-MM-dd")
    private LocalDate slotDate;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="HH:mm")
    private LocalTime startTime;
    @JsonFormat(shape=JsonFormat.Shape.STRING,pattern="HH:mm")
    private LocalTime endTime;
    private Integer personsAllowed;
    public String getSlotId() {
		return slotId;
	}
	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
	
	public String getSlotName() {
		return slotName;
	}
	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}
	public String getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public LocalDate getSlotDate() {
		return slotDate;
	}
	public void setSlotDate(LocalDate slotDate) {
		this.slotDate = slotDate;
	}
	public LocalTime getStartTime() {
		return startTime;
	}
	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}
	public LocalTime getEndTime() {
		return endTime;
	}
	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}
	public Integer getPersonsAllowed() {
		return personsAllowed;
	}
	public void setPersonsAllowed(Integer personsAllowed) {
		this.personsAllowed = personsAllowed;
	}
	public void setId(String slotId) {
		// TODO Auto-generated method stub
		
	}
	

    
}
