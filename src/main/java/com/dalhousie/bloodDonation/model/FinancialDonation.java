package com.dalhousie.bloodDonation.model;

import com.dalhousie.bloodDonation.constants.DonationType;

public class FinancialDonation {
    private String donorId;
    private Double amount;
    private DonationType donationType;
    private String transRefNumber;

    public FinancialDonation(String donorId, Double amount, String transRefNumber, DonationType donationType) {
        this.donorId = donorId;
        this.amount = amount;
        this.transRefNumber = transRefNumber;
        this.donationType = donationType;
    }

    public String getDonorId() {
        return donorId;
    }

    public void setDonorId(String donorId) {
        this.donorId = donorId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public DonationType getDonationType() {
        return donationType;
    }

    public void setDonationType(DonationType donationType) {
        this.donationType = donationType;
    }

    public String getTransRefNumber() {
        return transRefNumber;
    }

    public void setTransRefNumber(String transRefNumber) {
        this.transRefNumber = transRefNumber;
    }
}
