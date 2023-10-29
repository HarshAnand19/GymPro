package com.stackroute.paymentservice.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.stackroute.paymentservice.entity.Checkout;


public interface CheckoutRepository extends JpaRepository<Checkout, Long> {

	List<Checkout> findByEmail(String email);
	
	Optional<Checkout> findByPaymentId(String paymentId);
}
