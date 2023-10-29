package com.stackroute.adminservice.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.adminservice.model.SlotCreation;
import com.stackroute.adminservice.model.SlotBooking;
import com.stackroute.adminservice.repo.SlotCreationRepository;
import com.stackroute.adminservice.repo.SlotBookingRepository;

@Service
public class SlotServiceImpl implements SlotService {

    private final SlotCreationRepository slotCreationRepository;
    private final SlotBookingRepository slotBookingRepository;

    @Autowired
    public SlotServiceImpl(SlotCreationRepository slotCreationRepository, SlotBookingRepository slotBookingRepository) {
        this.slotCreationRepository = slotCreationRepository;
        this.slotBookingRepository = slotBookingRepository;
    }

    @Override
    public SlotCreation createSlot(SlotCreation slotCreation) {
        return slotCreationRepository.save(slotCreation);
    }

    @Override
    public SlotCreation updateSlot(String slotId, SlotCreation updatedSlot) {
        updatedSlot.setId(slotId);
        return slotCreationRepository.save(updatedSlot);
    }

    @Override
    public void deleteSlot(String slotId) {
        slotCreationRepository.deleteById(slotId);
    }

    @Override
    public List<SlotCreation> getAllSlots() {
        return slotCreationRepository.findAll();
    }
    
    @Override
    public List<String> getUsersForSlot(String slotId) {
        Optional<SlotCreation> optionalSlot = slotCreationRepository.findById(slotId);

        if (optionalSlot.isPresent()) {
            // Fetch all bookings for the specified slot using your custom repository method
            List<SlotBooking> bookingsForSlot = slotBookingRepository.findBySlotId(slotId);

            // Extract user IDs from the bookings
            List<String> userIds = bookingsForSlot.stream()
                    .map(SlotBooking::getUserEmail)
                    .collect(Collectors.toList());

            return userIds;
        } else {
            // Throw a custom exception when the slot doesn't exist
            throw new SlotNotFoundException("Slot with ID " + slotId + " not found");
        }
    }

}



