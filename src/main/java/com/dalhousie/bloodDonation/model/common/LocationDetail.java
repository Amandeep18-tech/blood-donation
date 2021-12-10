package com.dalhousie.bloodDonation.model.common;

public class LocationDetail {
    private String pinCode1;
    private String pinCode2;
    private float distance;

    public String getPinCode1() {
        return pinCode1;
    }

    public void setPinCode1(String pinCode1) {
        this.pinCode1 = pinCode1;
    }

    public String getPinCode2() {
        return pinCode2;
    }

    public void setPinCode2(String pinCode2) {
        this.pinCode2 = pinCode2;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }
}
