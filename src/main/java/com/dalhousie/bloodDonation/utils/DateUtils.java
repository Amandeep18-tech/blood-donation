package com.dalhousie.bloodDonation.utils;

import java.time.Instant;

public class DateUtils {
    public static String getNow(){
        return Instant.now().toString();
    }
}
