package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.service.donor.DonorRecommendationServiceImpl;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DonorRecommendationServiceImplTest {
    private static DonorRecommendationServiceImpl donorRecommendationService;

    @BeforeEach
    void setUp() {
        donorRecommendationService = new DonorRecommendationServiceImpl();
    }

    @AfterEach
    void tearDown() {
        donorRecommendationService = null;
    }

    @Test
    @DisplayName("Check If DonorRecommendationServiceImpl Class Exist")
    void testDonorRecommendationClassExist() {
        assertNotNull(donorRecommendationService, "DonorRecommendation Class Exist");
    }

    @Test
    @Disabled
    void testDonorRecommendation() throws CustomException {
        int patientId = 62;
        int expectedRecommendations = 2;
        int actualRecommendations = donorRecommendationService.donorRecommendation(patientId);
        assertEquals(expectedRecommendations, actualRecommendations, "donorRecommendation Method Returns Correct Value");
    }
}