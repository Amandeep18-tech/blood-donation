package com.dalhousie.bloodDonation.model;

import com.dalhousie.bloodDonation.constants.BloodDonationStatus;
import com.dalhousie.bloodDonation.constants.BloodGroup;

public class BloodDonationDetail {
    private String donorID;
    private BloodGroup bloodGroup;
    private String donatedAt;
    private BloodDonationStatus status;
    private String orgId;

    public String getDonorID() {
        return donorID;
    }

    public void setDonorID(String donorID) {
        this.donorID = donorID;
    }

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getDonatedAt() {
        return donatedAt;
    }

    public void setDonatedAt(String donatedAt) {
        this.donatedAt = donatedAt;
    }

    public void setStatus(BloodDonationStatus status) {
        this.status = status;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }
}
