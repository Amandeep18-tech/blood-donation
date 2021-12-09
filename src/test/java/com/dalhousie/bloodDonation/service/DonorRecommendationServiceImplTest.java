package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

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
    void testDonorRecommendation() throws SQLException, CustomException {
        int patientId = 62;
        int expectedRecommendations = 2;
        int actualRecommendations = donorRecommendationService.donorRecommendation(patientId);
        assertEquals(expectedRecommendations, actualRecommendations, "donorRecommendation Method Returns Correct Value");
    }
}