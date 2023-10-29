package com.stackroute.adminservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.adminservice.model.SlotBooking;
import com.stackroute.adminservice.model.SlotCreation;
import com.stackroute.adminservice.repo.SlotBookingRepository;
import com.stackroute.adminservice.repo.SlotCreationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class SlotBookingService {

    private final SlotBookingRepository slotBookingRepository;
    private final SlotCreationRepository slotCreationRepository;

    @Autowired
    public SlotBookingService(SlotBookingRepository slotBookingRepository, SlotCreationRepository slotCreationRepository) {
        this.slotBookingRepository = slotBookingRepository;
        this.slotCreationRepository = slotCreationRepository;
    }

    public SlotBooking bookSlot(SlotBooking slotBooking) throws SlotNotAvailableException {
        Optional<SlotCreation> optionalSlot = slotCreationRepository.findById(slotBooking.getSlotId());

        if (optionalSlot.isPresent()) {
            SlotCreation slot = optionalSlot.get();
            if (slot.getPersonsAllowed() > 0) {
                // Update personsAllowed count and save SlotCreation
                slot.setPersonsAllowed(slot.getPersonsAllowed() - 1);
                slotCreationRepository.save(slot);

                // Create the booking
                slotBooking.setBookingStatus(true);
                return slotBookingRepository.save(slotBooking);
            } else {
                throw new SlotNotAvailableException("No persons allowed for this slot.");
            }
        } else {
            throw new SlotNotAvailableException("Slot not found.");
        }
    }


    public SlotBooking updateSlotBooking(String bookingId, SlotBooking updatedBooking) {
        SlotBooking existingBooking = slotBookingRepository.findById(bookingId).orElse(null);

        if (existingBooking != null) {
            // Update booking details
            existingBooking.setUserEmail(updatedBooking.getUserEmail());
            existingBooking.setBookingDate(updatedBooking.getBookingDate());
            // You can update other fields as needed

            return slotBookingRepository.save(existingBooking);
        }

        return null; // Booking not found
    }

    public void cancelSlotBooking(String bookingId) {
        SlotBooking existingBooking = slotBookingRepository.findById(bookingId).orElse(null);

        if (existingBooking != null) {
            // Mark booking as canceled
            existingBooking.setBookingStatus(false);
            slotBookingRepository.save(existingBooking);

            // Increase personsAllowed count in SlotCreation
            Optional<SlotCreation> optionalSlot = slotCreationRepository.findById(existingBooking.getSlotId());

            if (optionalSlot.isPresent()) {
                SlotCreation slot = optionalSlot.get();
                slot.setPersonsAllowed(slot.getPersonsAllowed() + 1);
                slotCreationRepository.save(slot);
            }
        }
    }

    public SlotBooking getBookingDetails(String bookingId) {
        return slotBookingRepository.findById(bookingId).orElse(null);
    }

    public List<SlotBooking> getAllBookingsForUser(String userEmail) {
        return slotBookingRepository.findByUserEmail(userEmail);
    }
}
