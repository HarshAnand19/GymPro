package com.stackroute.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stackroute.adminservice.model.SlotBooking;
import com.stackroute.adminservice.service.SlotBookingService;
import com.stackroute.adminservice.service.SlotNotAvailableException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/slot-bookings")
@CrossOrigin("*")
public class SlotBookingController {

    private final SlotBookingService slotBookingService;

    @Autowired
    public SlotBookingController(SlotBookingService slotBookingService) {
        this.slotBookingService = slotBookingService;
    }

    @PostMapping
    public ResponseEntity<?> bookSlot(@RequestBody SlotBooking slotBooking) throws SlotNotAvailableException {
        SlotBooking bookedSlot = slotBookingService.bookSlot(slotBooking);
        if (bookedSlot != null) {
            return new ResponseEntity<>(bookedSlot, HttpStatus.CREATED);
        } else {
            return ResponseEntity.badRequest().build(); // Slot not available or booking failed
        }
    }

    @PutMapping("/{bookingId}")
    public ResponseEntity<?> updateSlotBooking(@PathVariable String bookingId, @RequestBody SlotBooking updatedBooking) {
        SlotBooking updatedSlotBooking = slotBookingService.updateSlotBooking(bookingId, updatedBooking);
        if (updatedSlotBooking != null) {
            return new ResponseEntity<>(updatedSlotBooking, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build(); // Booking not found
        }
    }

    @DeleteMapping("/{bookingId}")
    public ResponseEntity<Void> cancelSlotBooking(@PathVariable String bookingId) {
        slotBookingService.cancelSlotBooking(bookingId);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{bookingId}")
    public ResponseEntity<?> getBookingDetails(@PathVariable String bookingId) {
        SlotBooking bookingDetails = slotBookingService.getBookingDetails(bookingId);
        if (bookingDetails != null) {
            return new ResponseEntity<>(bookingDetails, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build(); // Booking not found
        }
    }

    @GetMapping("/user/{userEmail}")
    public ResponseEntity<?> getAllBookingsForUser(@PathVariable String userEmail) {
    	List<SlotBooking> bookings = slotBookingService.getAllBookingsForUser(userEmail);
        if (bookings != null) {
            return new ResponseEntity<>(bookings, HttpStatus.OK);
        } else {
            return ResponseEntity.notFound().build(); // User not found or has no bookings
        }
    }
}

