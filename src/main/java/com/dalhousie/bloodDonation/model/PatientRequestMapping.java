package com.dalhousie.bloodDonation.model;

public class PatientRequestMapping {
    String id;
    String patientBloodRequestID;
    String donorOrOrganisationID;
    Integer acceptFlag;
    
    public Integer getAcceptFlag() {
        return acceptFlag;
    }
    public void setAcceptFlag(Integer acceptFlag) {
        this.acceptFlag = acceptFlag;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getPatientBloodRequestID() {
        return patientBloodRequestID;
    }
    public void setPatientBloodRequestID(String patientBloodRequestID) {
        this.patientBloodRequestID = patientBloodRequestID;
    }
    public String getDonorOrOrganisationID() {
        return donorOrOrganisationID;
    }
    public void setDonorOrOrganisationID(String donorOrOrganisationID) {
        this.donorOrOrganisationID = donorOrOrganisationID;
    }
    
}
