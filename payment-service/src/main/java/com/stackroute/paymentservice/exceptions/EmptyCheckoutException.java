package com.stackroute.paymentservice.exceptions;

public class EmptyCheckoutException extends RuntimeException {

	public EmptyCheckoutException() {
        super("No records found in database");
    }
}
