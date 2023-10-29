package com.stackroute.adminservice.gym.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "gym_details")
public class GymDetails {

    @Id
    private String gymId;

    private String gymName;
    private byte[] gymPic;
    private String gymAddress;
    private String gymPhone;
    private String gymEmail;
    private String trainerId;
    private String equipmentId;

    public GymDetails() {
    }

    public GymDetails(String gymName, byte[] gymPic, String gymAddress, String gymPhone, String gymEmail, String equipmentId, String trainerId) {
        this.gymName = gymName;
        this.gymPic = gymPic;
        this.gymAddress = gymAddress;
        this.gymPhone = gymPhone;
        this.gymEmail = gymEmail;
        this.equipmentId= equipmentId;
        this.trainerId = trainerId;
    }

    public String getGymId() {
        return gymId;
    }

    public void setGymId(String gymId) {
        this.gymId = gymId;
    }

    public String getGymName() {
        return gymName;
    }

    public void setGymName(String gymName) {
        this.gymName = gymName;
    }

    public byte[] getGymPic() {
        return gymPic;
    }

    public void setGymPic(byte[] gymPic) {
        this.gymPic = gymPic;
    }

    public String getGymAddress() {
        return gymAddress;
    }

    public void setGymAddress(String gymAddress) {
        this.gymAddress = gymAddress;
    }

    public String getGymPhone() {
        return gymPhone;
    }

    public void setGymPhone(String gymPhone) {
        this.gymPhone = gymPhone;
    }

    public String getGymEmail() {
        return gymEmail;
    }

    public void setGymEmail(String gymEmail) {
        this.gymEmail = gymEmail;
    }

	public String getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(String trainerId) {
		this.trainerId = trainerId;
	}

	public String getEquipmentId() {
		return equipmentId;
	}

	public void setEquipmentId(String equipmentId) {
		this.equipmentId = equipmentId;
	}

	public void setProfilePicture(byte[] bytes) {
		// TODO Auto-generated method stub
		
	}
    
}
