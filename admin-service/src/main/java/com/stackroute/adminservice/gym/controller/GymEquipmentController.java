package com.stackroute.adminservice.gym.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.stackroute.adminservice.gym.entity.GymEquipment;
import com.stackroute.adminservice.gym.service.EquipmentNotFoundException;
import com.stackroute.adminservice.gym.service.GymEquipmentService;

import java.util.List;

@RestController
@RequestMapping("/api/gym/equipments")
public class GymEquipmentController {

    private final GymEquipmentService gymEquipmentService;

    @Autowired
    public GymEquipmentController(GymEquipmentService gymEquipmentService) {
        this.gymEquipmentService = gymEquipmentService;
    }

    // Add a new gym equipment
    @PostMapping("/add")
    public ResponseEntity<GymEquipment> addEquipment(@RequestBody GymEquipment equipment) {
        GymEquipment addedEquipment = gymEquipmentService.addEquipment(equipment);
        return new ResponseEntity<>(addedEquipment, HttpStatus.CREATED);
    }

    // Delete a gym equipment by equipmentId
    @DeleteMapping("/delete/{equipmentId}")
    public ResponseEntity<?> deleteEquipment(@PathVariable String equipmentId) {
        try {
            gymEquipmentService.deleteEquipment(equipmentId);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (EquipmentNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    // Update equipment details (name, detail, quality status)
    @PutMapping("/update/{equipmentId}")
    public ResponseEntity<GymEquipment> updateEquipmentDetails(
            @PathVariable String equipmentId,
            @RequestParam String equipmentName,
            @RequestParam String equipmentDetail,
            @RequestParam String equipmentQualityStatus) {
        try {
            GymEquipment updatedEquipment = gymEquipmentService.updateEquipmentDetails(
                    equipmentId, equipmentName, equipmentDetail, equipmentQualityStatus);
            return new ResponseEntity<>(updatedEquipment, HttpStatus.OK);
        } catch (EquipmentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all gym equipments
    @GetMapping("/all")
    public ResponseEntity<List<GymEquipment>> getAllEquipments() {
        List<GymEquipment> equipments = gymEquipmentService.getAllEquipments();
        return new ResponseEntity<>(equipments, HttpStatus.OK);
    }

    // Get the total number of gym equipments
    @GetMapping("/count")
    public ResponseEntity<Long> getTotalEquipments() {
        long totalEquipments = gymEquipmentService.getTotalEquipments();
        return new ResponseEntity<>(totalEquipments, HttpStatus.OK);
    }

    // Edit equipment quality status
    @PutMapping("/quality/{equipmentId}")
    public ResponseEntity<GymEquipment> editEquipmentQualityStatus(
            @PathVariable String equipmentId, @RequestParam String qualityStatus) {
        try {
            GymEquipment updatedEquipment = gymEquipmentService.editEquipmentQualityStatus(equipmentId, qualityStatus);
            return new ResponseEntity<>(updatedEquipment, HttpStatus.OK);
        } catch (EquipmentNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
