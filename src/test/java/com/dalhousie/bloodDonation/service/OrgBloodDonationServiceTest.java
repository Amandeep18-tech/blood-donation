package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrgBloodDonationServiceTest {

    @Test
    void getListByDonorId() throws CustomException {
        OrgBloodDonationService orgBloodDonationService = new OrgBloodDonationServiceImpl();
        orgBloodDonationService.getListByDonorId("O001").forEach(strings -> {
            for(int i=0; i<strings.length;i++){
                System.out.print(strings[i]);
                System.out.print("||");
            }
            System.out.println();
        });
    }

    @Test
    void getListByBloodGroup() throws CustomException {
        OrgBloodDonationService orgBloodDonationService = new OrgBloodDonationServiceImpl();
        orgBloodDonationService.getListByBloodGroup("O001").forEach(strings -> {
            for(int i=0; i<strings.length;i++){
                System.out.print(strings[i]);
                System.out.print("||");
            }
            System.out.println();
        });
    }
}