package com.dalhousie.bloodDonation.model;

import java.sql.Time;

public class MedicalAppointmentMaster {
    private String medicalAppointmentMasterID;
    private String organisationID;
    private int slotNumber;
    private Time slotStartTime;
    private Time slotEndTime;
    
    public void setslotNumber(int slotNumber) {
        this.slotNumber = slotNumber;
    }
    public Time getslotStartTime() {
        return slotStartTime;
    }
    public void setslotStartTime(Time slotStartTime) {
        this.slotStartTime = slotStartTime;
    }
    public Time getslotEndTime() {
        return slotEndTime;
    }
    public void setslotEndTime(Time slotEndTime) {
        this.slotEndTime = slotEndTime;
    }
    
    public String getmedicalAppointmentMasterID() {
        return medicalAppointmentMasterID;
    }
    public void setmedicalAppointmentMasterID(String medicalAppointmentMasterID) {
        this.medicalAppointmentMasterID = medicalAppointmentMasterID;
    }
    public String getorganisationID() {
        return organisationID;
    }
    public void setorganisationID(String organisationID) {
        this.organisationID = organisationID;
    }
    public int getslotNumber() {
        return slotNumber;
    }
    

    
    
}
