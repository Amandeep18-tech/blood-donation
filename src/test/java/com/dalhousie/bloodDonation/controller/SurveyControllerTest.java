package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.controller.common.SurveyController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class SurveyControllerTest {
    private static SurveyController surveyController;

    @BeforeEach
    void setUp() {
        surveyController = new SurveyController();
    }

    @AfterEach
    void tearDown() {
        surveyController = null;
    }

    @Test
    @DisplayName("Check If The Survey Controller Class Exist")
    void testSurveyControllerClassExist() {
        assertNotNull(surveyController, "SurveyController Class Exist");
    }
}