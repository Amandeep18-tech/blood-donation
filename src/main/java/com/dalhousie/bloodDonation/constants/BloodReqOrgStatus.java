package com.dalhousie.bloodDonation.constants;

public enum BloodReqOrgStatus {
    pending("Pending"),
    completed("Completed"),
    declined("Declined");
    public final String status;

    private BloodReqOrgStatus(String status) {
        this.status = status;
    }
}
