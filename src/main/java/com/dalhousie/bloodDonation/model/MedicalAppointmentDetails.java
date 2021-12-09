package com.dalhousie.bloodDonation.model;

import java.sql.Date;

public class MedicalAppointmentDetails {
    private String medicalAppointmentDetailsID;
    private String patientID;
    private String slotID;
    private Date slotDate;
    

    
    
    public String getmedicalAppointmentDetailsID() {
        return medicalAppointmentDetailsID;
    }
    public void setmedicalAppointmentDetailsID(String medicalAppointmentDetailsID) {
        this.medicalAppointmentDetailsID = medicalAppointmentDetailsID;
    }
    public String getpatientID() {
        return patientID;
    }
    public void setpatientID(String patientID) {
        this.patientID = patientID;
    }
    public String getslotID() {
        return slotID;
    }
    public void setslotID(String slotID) {
        this.slotID = slotID;
    }
    public Date getslotDate() {
        return slotDate;
    }
    public void setslotDate(Date slotDate) {
        this.slotDate = slotDate;
    }
    public Object getslotDate(Date date) {
        return null;
    }
    
}
