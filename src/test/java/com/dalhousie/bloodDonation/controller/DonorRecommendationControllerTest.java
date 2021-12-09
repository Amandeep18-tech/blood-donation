package com.dalhousie.bloodDonation.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class DonorRecommendationControllerTest {
    private static DonorRecommendationController donorRecommendationController;

    @BeforeEach
    void setUp() {
        donorRecommendationController = new DonorRecommendationController();
    }

    @AfterEach
    void tearDown() {
        donorRecommendationController = null;
    }

    @Test
    @DisplayName("Test To Check If The Class Exist")
    void testDonorRecommendationControllerClassExist() {
        assertNotNull(donorRecommendationController, "DonorRecommendationController Class Exist");
    }

}