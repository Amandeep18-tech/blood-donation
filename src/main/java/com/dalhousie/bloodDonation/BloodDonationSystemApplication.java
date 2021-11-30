package com.dalhousie.bloodDonation;

import com.dalhousie.bloodDonation.controller.FinancialDonationController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class BloodDonationSystemApplication {

    public static void main(String[] args) throws SQLException {
        SpringApplication.run(BloodDonationSystemApplication.class, args);
        new FinancialDonationController().selectModeOfPayment();
    }

}
