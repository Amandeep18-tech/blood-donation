package com.dalhousie.bloodDonation.model;

import java.util.Date;

import com.dalhousie.bloodDonation.constants.BloodGroup;

public class BloodDonationDetaisHistory {
    String id;
    String donorId;
    String slotId;
    Date slotDate;
    BloodGroup bloodGroup;
    
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
    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }
    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }
    

    
    
    
}
