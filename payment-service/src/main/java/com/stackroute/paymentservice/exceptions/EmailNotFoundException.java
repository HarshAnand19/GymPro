package com.stackroute.paymentservice.exceptions;

public class EmailNotFoundException extends RuntimeException {
	
	 public EmailNotFoundException(String email) {
		 super("No checkout records found for email: " + email);
	    }
}
