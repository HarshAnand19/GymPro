package com.example.registration.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
public class KafkaMessageProducer {
	@Autowired
	private KafkaTemplate<String, String> kafkaTemplate;

	public void sendRegistrationData(String email, String password, String role) {
	    // Create a JSON or other format message with email, password, and role
	    String registrationData = "{\"email\":\"" + email + "\",\"password\":\"" + password + "\",\"role\":\"" + role + "\"}";    
	    kafkaTemplate.send("registration-topic", registrationData);  
	}
}
