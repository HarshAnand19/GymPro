package com.stackroute.adminservice.service;

import com.stackroute.adminservice.model.SlotCreation;
import java.util.List;
import java.util.Optional;

public interface SlotService {
    SlotCreation createSlot(SlotCreation slotCreation);
    SlotCreation updateSlot(String slotId, SlotCreation updatedSlot);
    void deleteSlot(String slotId);
    List<SlotCreation> getAllSlots();
    List<String> getUsersForSlot(String slotId);
}
