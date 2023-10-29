package com.stackroute.adminservice.gym.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.adminservice.gym.entity.Subscription;
import com.stackroute.adminservice.gym.repo.SubscriptionRepository;

@Service
public class SubscriptionService {

	
	  private final SubscriptionRepository subscriptionRepository;

	    @Autowired
	    public SubscriptionService(SubscriptionRepository subscriptionRepository) {
	        this.subscriptionRepository = subscriptionRepository;
	    }
	    
	    public  Subscription addSubscription(Subscription subscription) {
	    	return subscriptionRepository.save(subscription);
	    }
	    
	    public List<Subscription> getAllSubscriptions(){
	    	return subscriptionRepository.findAll();
	    }
}
