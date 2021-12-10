package com.dalhousie.bloodDonation.model.donor;

import java.sql.Time;

public class BloodDonationDetails {
    String id;
    Integer slotNumber;
    Time donationTime;
    String organisationID;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Integer getSlotNumber() {
        return slotNumber;
    }
    public void setSlotNumber(Integer slotNumber) {
        this.slotNumber = slotNumber;
    }
    public Time getDonationTime() {
        return donationTime;
    }
    public void setDonationTime(Time donationTime) {
        this.donationTime = donationTime;
    }
    public String getOrganisationID() {
        return organisationID;
    }
    public void setOrganisationID(String organisationID) {
        this.organisationID = organisationID;
    }
    

    


}
