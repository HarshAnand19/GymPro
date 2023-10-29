package com.stackroute.notificationservice.service;

public interface SMSService {
	String sendSMS(String id, String toPhoneNumber, String message);

}
