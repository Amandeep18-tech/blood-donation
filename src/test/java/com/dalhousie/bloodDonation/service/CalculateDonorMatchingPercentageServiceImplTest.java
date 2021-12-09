package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.model.DonorInformation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculateDonorMatchingPercentageServiceImplTest {
    private static CalculateDonorMatchingPercentageServiceImpl calculateDonorMatchingPercentageService;
    private static DonorInformation donorInformation;

    @BeforeEach
    void setUp() {
        calculateDonorMatchingPercentageService = new CalculateDonorMatchingPercentageServiceImpl();
        donorInformation = new DonorInformation();
    }

    @AfterEach
    void tearDown() {
        calculateDonorMatchingPercentageService = null;
        donorInformation = null;
    }

    @Test
    void testGetMatchingPercentage() {
        double hemoglobinLevelDifference = 0.5;
        int rbcCountDifference = 55000;
        int plateletCountDifference = 30000;
        donorInformation.setHemoglobinLevelDifference(hemoglobinLevelDifference);
        donorInformation.setRbcCountDifference(rbcCountDifference);
        donorInformation.setPlateletCountDifference(plateletCountDifference);
        double expectedOverallMatchingPercentage = 40 + 25 + 25;
        DonorInformation donorInfo = calculateDonorMatchingPercentageService.getMatchingPercentage(donorInformation);
        double actualOverallMatchingPercentage = donorInfo.getMatchingPercentage();
        assertEquals(expectedOverallMatchingPercentage, actualOverallMatchingPercentage, "getMatchingPercentage Method Returns Correct Value");
    }
}