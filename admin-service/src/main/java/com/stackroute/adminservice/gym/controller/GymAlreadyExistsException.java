package com.stackroute.adminservice.gym.controller;

public class GymAlreadyExistsException extends Exception {
	public GymAlreadyExistsException(String message) {
        super(message);
    }
}
