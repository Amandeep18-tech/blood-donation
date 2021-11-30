package com.dalhousie.bloodDonation.constants;

public enum DonationType {
    CASH("Cash"),
    CARD("Credit/Debit Card"),
    CHEQUE("Cheque"),
    BANK_TRANSFER("Electronic Bank Transfers"),
    UPI("UPI"),
    MOBILE_BANKING("Mobile Banking");
    public final String type;

    private DonationType(String type) {
        this.type = type;
    }
}
