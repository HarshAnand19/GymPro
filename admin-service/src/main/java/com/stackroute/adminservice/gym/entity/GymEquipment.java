package com.stackroute.adminservice.gym.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gym_equipments")
public class GymEquipment {

    @Id
    private String equipmentId;
    private String equipmentName;
    private String equipmentDetail;
    private String equipmentQualityStatus;

    

    public GymEquipment() {
    }

    public GymEquipment(String equipmentName, String equipmentDetail, String equipmentQualityStatus) {
        this.equipmentName = equipmentName;
        this.equipmentDetail = equipmentDetail;
        this.equipmentQualityStatus = equipmentQualityStatus;
    }

    public String getEquipmentId() {
        return equipmentId;
    }

    public void setEquipmentId(String equipmentId) {
        this.equipmentId = equipmentId;
    }

    public String getEquipmentName() {
        return equipmentName;
    }

    public void setEquipmentName(String equipmentName) {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentDetail() {
        return equipmentDetail;
    }

    public void setEquipmentDetail(String equipmentDetail) {
        this.equipmentDetail = equipmentDetail;
    }

    public String getEquipmentQualityStatus() {
        return equipmentQualityStatus;
    }

    public void setEquipmentQualityStatus(String equipmentQualityStatus) {
        this.equipmentQualityStatus = equipmentQualityStatus;
    }
}
