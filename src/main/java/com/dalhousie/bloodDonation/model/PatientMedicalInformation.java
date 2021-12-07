package com.dalhousie.bloodDonation.model;

public class PatientMedicalInformation {
    private int id;
    private int patientId;
    private String bloodGroup;
    private String currentLocation;
    private String drReference;
    private String requirementReason;
    private String priority;
    private int hasHepatitisB;
    private int hasHepatitisC;
    private int hasHIV;
    private int hasHemochromatosis;
    private int hemoglobinLevel;
    private int rbcCount;
    private int plateletCount;

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

    public String getRequirementReason() {
        return requirementReason;
    }

    public void setRequirementReason(String requirementReason) {
        this.requirementReason = requirementReason;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public int getHasHepatitisB() {
        return hasHepatitisB;
    }

    public void setHasHepatitisB(int hasHepatitisB) {
        this.hasHepatitisB = hasHepatitisB;
    }

    public int getHasHepatitisC() {
        return hasHepatitisC;
    }

    public void setHasHepatitisC(int hasHepatitisC) {
        this.hasHepatitisC = hasHepatitisC;
    }

    public int getHasHIV() {
        return hasHIV;
    }

    public void setHasHIV(int hasHIV) {
        this.hasHIV = hasHIV;
    }

    public int getHasHemochromatosis() {
        return hasHemochromatosis;
    }

    public void setHasHemochromatosis(int hasHemochromatosis) {
        this.hasHemochromatosis = hasHemochromatosis;
    }

    public int getHemoglobinLevel() {
        return hemoglobinLevel;
    }

    public void setHemoglobinLevel(int hemoglobinLevel) {
        this.hemoglobinLevel = hemoglobinLevel;
    }

    public int getRbcCount() {
        return rbcCount;
    }

    public void setRbcCount(int rbcCount) {
        this.rbcCount = rbcCount;
    }

    public int getPlateletCount() {
        return plateletCount;
    }

    public void setPlateletCount(int plateletCount) {
        this.plateletCount = plateletCount;
    }

    @Override
    public String toString() {
        return "patient_medical_information [patient_id=" + patientId + ", blood_group=" + bloodGroup + ", current_location=" + currentLocation + ", dr_reference=" + drReference + ", requirement_reason=" + requirementReason + ", priority=" + priority + ", has_hepatitis_B=" + hasHepatitisB + ", has_hepatitis_C=" + hasHepatitisC + ", has_HIV=" + hasHIV + ", hemoglobin_level=" + hemoglobinLevel + ", has_hemochromatosis=" + hasHemochromatosis + ", rbc_count=" + rbcCount + ", platelet_count=" + plateletCount + "]";
    }
}
