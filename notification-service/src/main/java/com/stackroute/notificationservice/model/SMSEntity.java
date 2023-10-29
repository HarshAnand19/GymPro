package com.stackroute.notificationservice.model;

import org.springframework.data.annotation.Id;

public class SMSEntity {
	@Id
	private String id;
	private String toPhoneNumber;
	private String message;
	
	public SMSEntity() {

	}
	public SMSEntity(String id, String toPhoneNumber, String message) {
		this.id = id;
		this.toPhoneNumber = toPhoneNumber;
		this.message = message;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getToPhoneNumber() {
		return toPhoneNumber;
	}
	public void setToPhoneNumber(String toPhoneNumber) {
		this.toPhoneNumber = toPhoneNumber;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}	

}
