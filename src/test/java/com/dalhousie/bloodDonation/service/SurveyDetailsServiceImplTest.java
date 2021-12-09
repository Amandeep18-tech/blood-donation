package com.dalhousie.bloodDonation.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurveyDetailsServiceImplTest {
    private static SurveyDetailsServiceImpl service;

    @BeforeEach
    void setUp() {
        service = new SurveyDetailsServiceImpl();
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