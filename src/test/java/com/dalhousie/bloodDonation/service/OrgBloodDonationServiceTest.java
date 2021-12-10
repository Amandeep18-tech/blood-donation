package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.exception.CustomException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrgBloodDonationServiceTest {

    private static OrgBloodDonationService orgBloodDonationService;
    @BeforeAll
    static void setUp(){
        orgBloodDonationService = new OrgBloodDonationServiceImpl();
    }

    @Test
    void getListByDonorId() throws CustomException {
        Assertions.assertNotNull(orgBloodDonationService.getListByDonorId("5c256da3-3d82-11ec-917b-e2ed2ce588f5"));
    }

    @Test
    void getListByBloodGroup() throws CustomException {
        Assertions.assertNotNull(orgBloodDonationService.getListByBloodGroup("494b72c5-5ffb-46e7-abb5-507f84a5fce6"));
    }

    @Test
    void testGetListByDonorId() throws CustomException {
        Assertions.assertNotNull(orgBloodDonationService.getListByDonorId("494b72c5-5ffb-46e7-abb5-507f84a5fce6"));
    }

    @Test
    void testGetListByBloodGroup() throws CustomException {
        Assertions.assertNotNull(orgBloodDonationService.getListByBloodGroup("494b72c5-5ffb-46e7-abb5-507f84a5fce6"));
    }

    @Test
    void getPendingRequests() throws CustomException {
        Assertions.assertNotNull(orgBloodDonationService.getPendingRequests("494b72c5-5ffb-46e7-abb5-507f84a5fce6"));
    }

    @Test
    void getRecommendedOrganisation() throws CustomException {
        Assertions.assertNotNull(orgBloodDonationService.getRecommendedOrganisation(2, BloodGroup.ABNeg));
    }

}