package com.dalhousie.bloodDonation.model;

public class DonorMedicalRecords {
    String id;
    String donorID;
    Integer  hepatitisB;
    Integer hepatitisC;
    Integer HIVFlag;
    Integer hemoglobinLevel;
    Integer hemochromatosis;
    Integer rbcCount;
    Integer plateletCount;

    public Integer getRbcCount() {
        return rbcCount;
    }
    public void setRbcCount(Integer rbcCount) {
        this.rbcCount = rbcCount;
    }
    public Integer getPlateletCount() {
        return plateletCount;
    }
    public void setPlateletCount(Integer plateletCount) {
        this.plateletCount = plateletCount;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getdonorID() {
        return donorID;
    }
    public void setdonorID(String donorID) {
        this.donorID = donorID;
    }
    public Integer gethepatitisB() {
        return hepatitisB;
    }
    public void sethepatitisB(Integer hepatitisB) {
        this.hepatitisB = hepatitisB;
    }
    public Integer gethepatitisC() {
        return hepatitisC;
    }
    public void sethepatitisC(Integer hepatitisC) {
        this.hepatitisC = hepatitisC;
    }
    public Integer getHIVFlag() {
        return HIVFlag;
    }
    public void setHIVFlag(Integer HIVFlag) {
        this.HIVFlag = HIVFlag;
    }
    public Integer gethemoglobinLevel() {
        return hemoglobinLevel;
    }
    public void sethemoglobinLevel(Integer hemoglobinLevel) {
        this.hemoglobinLevel = hemoglobinLevel;
    }
    public Integer getHemochromatosis() {
        return hemochromatosis;
    }
    public void setHemochromatosis(Integer hemochromatosis) {
        this.hemochromatosis = hemochromatosis;
    }
    
}
