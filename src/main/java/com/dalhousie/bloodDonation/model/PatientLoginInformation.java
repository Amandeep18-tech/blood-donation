package com.dalhousie.bloodDonation.model;

public class PatientLoginInformation {
    int id;
    int patientId;
    String patientName;
    String patientEmailID;
    String username;
    String password;

    public String getPatientEmailID() {
        return patientEmailID;
    }

    public void setPatientEmailID(String patient_emailID) {
        this.patientEmailID = patient_emailID;
    }

    public int getPatientId() {
        return patientId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "patient_login [patient_id=" + patientId + ", patient_name=" + patientName + ", patient_email_id=" + patientEmailID + ", patient_username=" + username + ", patient_password=" + password + "]";
    }
}
