package com.dalhousie.bloodDonation.model;

public class DonorMedicalRecords {
    String id;
    String donor_id;
    Integer  hepatitis_B;
    Integer hepatitis_C;
    Integer HIV_flag;
    Integer hemoglobin_level;
    Integer hemochromatosis;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getDonor_id() {
        return donor_id;
    }
    public void setDonor_id(String donor_id) {
        this.donor_id = donor_id;
    }
    public Integer getHepatitis_B() {
        return hepatitis_B;
    }
    public void setHepatitis_B(Integer hepatitis_B) {
        this.hepatitis_B = hepatitis_B;
    }
    public Integer getHepatitis_C() {
        return hepatitis_C;
    }
    public void setHepatitis_C(Integer hepatitis_C) {
        this.hepatitis_C = hepatitis_C;
    }
    public Integer getHIV_flag() {
        return HIV_flag;
    }
    public void setHIV_flag(Integer hIV_flag) {
        HIV_flag = hIV_flag;
    }
    public Integer getHemoglobin_level() {
        return hemoglobin_level;
    }
    public void setHemoglobin_level(Integer hemoglobin_level) {
        this.hemoglobin_level = hemoglobin_level;
    }
    public Integer getHemochromatosis() {
        return hemochromatosis;
    }
    public void setHemochromatosis(Integer hemochromatosis) {
        this.hemochromatosis = hemochromatosis;
    }
    
}
