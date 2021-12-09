package com.dalhousie.bloodDonation.constants;

public enum BloodDonationStatus {

    unused("Unused"),
    used("Used"),
    expired("Expired");
    public final String status;

    private BloodDonationStatus(String status) {
        this.status = status;
    }
}
