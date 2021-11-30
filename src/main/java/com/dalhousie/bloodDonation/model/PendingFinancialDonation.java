package com.dalhousie.bloodDonation.model;

import com.dalhousie.bloodDonation.constants.DonationType;

public class PendingFinancialDonation {
    private Double amount;
    private String tpRefNum;
    private DonationType donationType;

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTpRefNum() {
        return tpRefNum;
    }

    public void setTpRefNum(String tpRefNum) {
        this.tpRefNum = tpRefNum;
    }

    public DonationType getDonationType() {
        return donationType;
    }

    public void setDonationType(DonationType donationType) {
        this.donationType = donationType;
    }
}
