package com.dalhousie.bloodDonation.model;

public class DonorInformation {
    private String donorId;
    private String donorFirstName;
    private String donorLastName;
    private String donorContactNumber;
    private String donorBloodGroup;
    private int hasHepatitisB;
    private int hasHepatitisC;
    private int hasHIV;
    private int hasHemochromatosis;
    private int hemoglobinLevel;
    private int rbcCount;
    private int plateletCount;
    private double hemoglobinLevelDifference;
    private int rbcCountDifference;
    private int plateletCountDifference;
    private double matchingPercentage;

    public double getHemoglobinLevelDifference() {
        return hemoglobinLevelDifference;
    }

    public void setHemoglobinLevelDifference(double hemoglobinLevelDifference) {
        this.hemoglobinLevelDifference = hemoglobinLevelDifference;
    }

    public int getRbcCountDifference() {
        return rbcCountDifference;
    }

    public void setRbcCountDifference(int rbcCountDifference) {
        this.rbcCountDifference = rbcCountDifference;
    }

    public int getPlateletCountDifference() {
        return plateletCountDifference;
    }

    public void setPlateletCountDifference(int plateletCountDifference) {
        this.plateletCountDifference = plateletCountDifference;
    }


    public double getMatchingPercentage() {
        return matchingPercentage;
    }

    public void setMatchingPercentage(double matchingPercentage) {
        this.matchingPercentage = matchingPercentage;
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

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    public String getDonorFirstName() {
        return donorFirstName;
    }

    public void setDonorFirstName(String donorFirstName) {
        this.donorFirstName = donorFirstName;
    }

    public String getDonorLastName() {
        return donorLastName;
    }

    public void setDonorLastName(String donorLastName) {
        this.donorLastName = donorLastName;
    }

    public String getDonorContactNumber() {
        return donorContactNumber;
    }

    public void setDonorContactNumber(String donorContactNumber) {
        this.donorContactNumber = donorContactNumber;
    }

    public String getDonorBloodGroup() {
        return donorBloodGroup;
    }

    public void setDonorBloodGroup(String donorBloodGroup) {
        this.donorBloodGroup = donorBloodGroup;
    }
}
