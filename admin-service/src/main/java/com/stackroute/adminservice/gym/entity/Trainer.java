package com.stackroute.adminservice.gym.entity;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "trainers")
public class Trainer {

    @Id
    private String trainerId;
    private String trainerName;
    private String trainerAddress;
    private String trainerPhone;
    private String slotId;
    

   

	public Trainer() {
    }

    public Trainer(String trainerName, String trainerAddress, String trainerPhone, String slotId) {
        this.trainerName = trainerName;
        this.trainerAddress = trainerAddress;
        this.trainerPhone = trainerPhone;
        this.slotId= slotId;
    }

    public String getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(String trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerName() {
        return trainerName;
    }

    public void setTrainerName(String trainerName) {
        this.trainerName = trainerName;
    }

    public String getTrainerAddress() {
        return trainerAddress;
    }

    public void setTrainerAddress(String trainerAddress) {
        this.trainerAddress = trainerAddress;
    }

    public String getTrainerPhone() {
        return trainerPhone;
    }

    public void setTrainerPhone(String trainerPhone) {
        this.trainerPhone = trainerPhone;
    }
    public String getSlotId() {
		return slotId;
	}

	public void setSlotId(String slotId) {
		this.slotId = slotId;
	}
}
