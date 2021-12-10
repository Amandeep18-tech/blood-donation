package com.dalhousie.bloodDonation;

import com.dalhousie.bloodDonation.constants.UserType;
import com.dalhousie.bloodDonation.controller.InitController;
import com.dalhousie.bloodDonation.controller.OrgBloodRequestController;
import com.dalhousie.bloodDonation.service.SessionService;
import com.dalhousie.bloodDonation.service.SessionServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BloodDonationSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(BloodDonationSystemApplication.class, args);
//        SessionService sessionService = new SessionServiceImpl();
//        sessionService.setSession("001", UserType.ORGANIZATION);
//        new OrgBloodRequestController().mainMenu();
        new InitController().mainMenu();
    }

}
