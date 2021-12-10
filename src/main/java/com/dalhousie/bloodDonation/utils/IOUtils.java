package com.dalhousie.bloodDonation.utils;

import java.util.Scanner;

public class IOUtils {
    private static Scanner scanner = null;

    public static Scanner getInstance() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner;
    }
}
