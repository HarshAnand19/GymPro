package com.stackroute.paymentservice.exceptions;

public class CheckoutNotFoundException extends RuntimeException {

    public CheckoutNotFoundException(String paymentId) {
        super("Checkout with paymentId " + paymentId + " not found.");
    }
}

