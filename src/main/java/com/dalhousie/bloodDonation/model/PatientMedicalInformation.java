package com.dalhousie.bloodDonation.model;

public class PatientMedicalInformation {
    private int id;
    private int patientId;
    private String bloodGroup;
    private String currentLocation;
    private String drReference;
    private String requirementReason;
    private String priority;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    public String getDrReference() {
        return drReference;
    }

    public void setDrReference(String drReference) {
        this.drReference = drReference;
    }

    public String getRequirementReason() { return requirementReason; }

    public void setRequirementReason(String requirementReason) {
        this.requirementReason = requirementReason;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        return "patient_medical_information [patient_id=" + patientId + ", blood_group=" + bloodGroup + ", current_location=" + currentLocation + ", dr_reference=" + drReference + ", requirement_reason=" + requirementReason + ", priority=" + priority + "]";
    }
}
