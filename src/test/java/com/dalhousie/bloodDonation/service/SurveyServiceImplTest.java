package com.dalhousie.bloodDonation.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurveyServiceImplTest {
    private static SurveyServiceImpl surveyService;

    @BeforeEach
    void setUp() {
        surveyService = new SurveyServiceImpl();
    }

    @AfterEach
    void tearDown() {
        surveyService = null;
    }

    @Test
    void testClassExist() {
        assertNotNull(surveyService, "Class Exist");
    }
}