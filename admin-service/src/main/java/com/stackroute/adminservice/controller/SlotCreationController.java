package com.stackroute.adminservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.stackroute.adminservice.model.SlotCreation;
import com.stackroute.adminservice.service.SlotNotFoundException;
import com.stackroute.adminservice.service.SlotService;

import java.util.List;

@RestController
@RequestMapping("/api/Createslots")
public class SlotCreationController extends ResponseEntityExceptionHandler {

    private final SlotService slotService;

    @Autowired
    public SlotCreationController(SlotService slotService) {
        this.slotService = slotService;
    }

    @PostMapping
    public ResponseEntity<SlotCreation> createSlot(@RequestBody SlotCreation slotCreation) {
        SlotCreation createdSlot = slotService.createSlot(slotCreation);
        return new ResponseEntity<>(createdSlot, HttpStatus.CREATED);
    }

    @PutMapping("/{slotId}")
    public ResponseEntity<SlotCreation> updateSlot(@PathVariable String slotId, @RequestBody SlotCreation updatedSlot) {
        SlotCreation updated = slotService.updateSlot(slotId, updatedSlot);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    @DeleteMapping("/{slotId}")
    public ResponseEntity<Void> deleteSlot(@PathVariable String slotId) {
        slotService.deleteSlot(slotId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping
    public ResponseEntity<List<SlotCreation>> getAllSlots() {
        List<SlotCreation> slots = slotService.getAllSlots();
        return new ResponseEntity<>(slots, HttpStatus.OK);
    }

   @GetMapping("/{slotId}/users")
    public ResponseEntity<List<String>> getUsersForSlot(@PathVariable String slotId) {
        try {
            List<String> users = slotService.getUsersForSlot(slotId);
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch (SlotNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @ExceptionHandler(SlotNotFoundException.class)
    public ResponseEntity<String> handleSlotNotFoundException(SlotNotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }
}
