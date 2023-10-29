package com.stackroute.adminservice.service;

public class SlotNotFoundException extends RuntimeException {

    public SlotNotFoundException(String message) {
        super(message);
    }
}