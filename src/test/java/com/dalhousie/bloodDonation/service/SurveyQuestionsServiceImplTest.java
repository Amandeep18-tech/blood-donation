package com.dalhousie.bloodDonation.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurveyQuestionsServiceImplTest {
    private static SurveyQuestionsServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new SurveyQuestionsServiceImpl();
    }

    @AfterEach
    void tearDown() {
        service = null;
    }

    @Test
    void testClassExist() {
        assertNotNull(service, "Class Exist");
    }
}