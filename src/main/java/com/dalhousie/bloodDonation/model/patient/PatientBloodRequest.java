package com.dalhousie.bloodDonation.model.patient;

import java.sql.Time;
import java.util.Date;

public class PatientBloodRequest {
    String id;
    String patientID;
    String priority;
    Date appointmentDate;
    Time appointmentTime;
    Integer status;
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPatientID() {
        return patientID;
    }
    public void setPatientID(String patientID) {
        this.patientID = patientID;
    }
    public String getPriority() {
        return priority;
    }
    public void setPriority(String priority) {
        this.priority = priority;
    }
    public Date getAppointmentDate() {
        return appointmentDate;
    }
    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }
    public Time getAppointmentTime() {
        return appointmentTime;
    }
    public void setAppointmentTime(Time appointmentTime) {
        this.appointmentTime = appointmentTime;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    
    
}
