package com.stackroute.paymentservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.paymentservice.entity.Checkout;
import com.stackroute.paymentservice.exceptions.CheckoutNotFoundException;
import com.stackroute.paymentservice.exceptions.EmailNotFoundException;
import com.stackroute.paymentservice.exceptions.EmptyCheckoutException;
import com.stackroute.paymentservice.repository.CheckoutRepository;

@Service
public class CheckoutService {
    private final CheckoutRepository checkoutRepository;

    @Autowired
    public CheckoutService(CheckoutRepository checkoutRepository) {
        this.checkoutRepository = checkoutRepository;
    }

    public void saveCheckout(Checkout checkout) {
        checkoutRepository.save(checkout);
    }
    
    public List<Checkout> getAll() { 	
        List<Checkout> list =checkoutRepository.findAll();
        
        if(list.isEmpty()) {
        	 throw new EmptyCheckoutException();
        }else {
        	return list;
        }    	
    }
    
    public List<Checkout> getCheckoutDetailsByEmail(String email) {
        List<Checkout> checkoutDetails = checkoutRepository.findByEmail(email);
        if (checkoutDetails.isEmpty()) {
            throw new EmailNotFoundException(email);
        }
        return checkoutDetails;
    }
    
    public Checkout getCheckoutDetailsByPaymentId(String paymentId) {
        Optional<Checkout> checkout = checkoutRepository.findByPaymentId(paymentId);
        if (checkout.isPresent()) {
            return checkout.get();
        } else {
            throw new CheckoutNotFoundException(paymentId);
        }
    }
}
