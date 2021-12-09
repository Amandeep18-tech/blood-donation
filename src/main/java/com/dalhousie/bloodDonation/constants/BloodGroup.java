package com.dalhousie.bloodDonation.constants;

public enum BloodGroup {

    APos("A+ve"),
    ANeg("A-ve"),
    BPos("B+ve"),
    BNeg("B-ve"),
    ABPos("AB+ve"),
    ABNeg("AB-ve"),
    OPos("O+ve"),
    ONeg("O-ve");
    public final String type;

    private BloodGroup(String type) {
        this.type = type;
    }
}
