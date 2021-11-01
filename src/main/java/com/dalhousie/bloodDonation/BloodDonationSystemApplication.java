package com.dalhousie.bloodDonation;

import com.dalhousie.bloodDonation.utils.DBUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

@SpringBootApplication
public class BloodDonationSystemApplication {

    public static void main(String[] args) throws SQLException {
        DBUtils dbUtils = new DBUtils();
        Connection conn = dbUtils.getConnection();
        SpringApplication.run(BloodDonationSystemApplication.class, args);
    }

}
