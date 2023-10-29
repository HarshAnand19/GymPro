package com.stackroute.adminservice.gym.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.adminservice.gym.entity.Subscription;
import com.stackroute.adminservice.gym.service.SubscriptionService;

@RestController
@RequestMapping("/api/gym/subscriptions")
public class SubscriptionController {

	
	   private final SubscriptionService subscriptionService;

	    @Autowired
	    public SubscriptionController(SubscriptionService subscriptionService) {
	        this.subscriptionService = subscriptionService;
	    }
	    
	    //Add Subscription Plans
	    @PostMapping("/add")
	    public ResponseEntity<Subscription> addSubscription(@RequestBody Subscription subscription) {
	    	Subscription addedsubs= subscriptionService.addSubscription(subscription);
	    	if(addedsubs!= null) {
	            return new ResponseEntity<>(addedsubs, HttpStatus.CREATED);
	    	}else {
	            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	    	}
	    }
	    
	  
	    
	    //Get All Plans
	    @GetMapping("/all")
	    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
	        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();
	        return new ResponseEntity<>(subscriptions, HttpStatus.OK);
	    }
	    
	    
}
