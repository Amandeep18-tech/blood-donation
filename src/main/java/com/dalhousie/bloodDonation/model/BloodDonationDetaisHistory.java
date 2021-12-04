package com.dalhousie.bloodDonation.model;

import java.util.Date;

public class BloodDonationDetaisHistory {
    String id;
    String donorId;
    String slotId;
    Date slotDate;
    String bloodGroup;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDonorId() {
        return donorId;
    }
    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }
    public String getSlotId() {
        return slotId;
    }
    public void setSlotId(String slotId) {
        this.slotId = slotId;
    }
    public Date getSlotDate() {
        return slotDate;
    }
    public void setSlotDate(Date slotDate) {
        this.slotDate = slotDate;
    }
    public String getBloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    

    
    
    
}
