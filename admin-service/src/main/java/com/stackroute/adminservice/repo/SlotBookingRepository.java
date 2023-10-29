package com.stackroute.adminservice.repo;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.stackroute.adminservice.model.SlotBooking;

public interface SlotBookingRepository extends MongoRepository<SlotBooking, String> {
	List<SlotBooking> findBySlotId(String slotId);
	List<SlotBooking> findByUserEmail(String userEmail);
    
}