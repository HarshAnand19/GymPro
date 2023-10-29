package com.stackroute.adminservice.gym.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.adminservice.gym.entity.GymEquipment;
import com.stackroute.adminservice.gym.repo.GymEquipmentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class GymEquipmentService {

    private final GymEquipmentRepository gymEquipmentRepository;

    @Autowired
    public GymEquipmentService(GymEquipmentRepository gymEquipmentRepository) {
        this.gymEquipmentRepository = gymEquipmentRepository;
    }

    // Add a new gym equipment
    public GymEquipment addEquipment(GymEquipment equipment) {
        return gymEquipmentRepository.save(equipment);
    }

    // Delete a gym equipment by equipmentId
    public void deleteEquipment(String equipmentId) throws EquipmentNotFoundException {
        Optional<GymEquipment> optionalEquipment = gymEquipmentRepository.findById(equipmentId);
        if (optionalEquipment.isPresent()) {
            gymEquipmentRepository.deleteById(equipmentId);
        } else {
            throw new EquipmentNotFoundException("Equipment with ID " + equipmentId + " not found.");
        }
    }

    // Update equipment details (name, detail, quality status)
    public GymEquipment updateEquipmentDetails(String equipmentId, String equipmentName, String equipmentDetail, String equipmentQualityStatus) throws EquipmentNotFoundException {
        Optional<GymEquipment> optionalEquipment = gymEquipmentRepository.findById(equipmentId);
        if (optionalEquipment.isPresent()) {
            GymEquipment equipment = optionalEquipment.get();
            equipment.setEquipmentName(equipmentName);
            equipment.setEquipmentDetail(equipmentDetail);
            equipment.setEquipmentQualityStatus(equipmentQualityStatus);
            return gymEquipmentRepository.save(equipment);
        } else {
            throw new EquipmentNotFoundException("Equipment with ID " + equipmentId + " not found.");
        }
    }

    // Get all gym equipments
    public List<GymEquipment> getAllEquipments() {
        return gymEquipmentRepository.findAll();
    }

    // Get the total number of gym equipments
    public long getTotalEquipments() {
        return gymEquipmentRepository.count();
    }

    // Edit equipment quality status
    public GymEquipment editEquipmentQualityStatus(String equipmentId, String qualityStatus) throws EquipmentNotFoundException {
        Optional<GymEquipment> optionalEquipment = gymEquipmentRepository.findById(equipmentId);
        if (optionalEquipment.isPresent()) {
            GymEquipment equipment = optionalEquipment.get();
            equipment.setEquipmentQualityStatus(qualityStatus);
            return gymEquipmentRepository.save(equipment);
        } else {
            throw new EquipmentNotFoundException("Equipment with ID " + equipmentId + " not found.");
        }
    }
}
