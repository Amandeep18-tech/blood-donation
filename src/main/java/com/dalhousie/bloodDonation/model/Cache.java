package com.dalhousie.bloodDonation.model;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cache {
    private static final Map<String,OTPDetails> otpMap = new ConcurrentHashMap<>();

    public static Map<String, OTPDetails> getOtpMap() {
        return otpMap;
    }
}
