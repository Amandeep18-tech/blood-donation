package com.dalhousie.bloodDonation;

import com.dalhousie.bloodDonation.controller.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BloodDonationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloodDonationSystemApplication.class, args);
        new InitController().mainMenu();
        new OrgBloodRequestController().mainMenu();
    }

}
