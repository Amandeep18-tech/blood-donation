package com.dalhousie.bloodDonation.service;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientPersonalInformationServiceImplTest {
    private static PatientPersonalInformationServiceImpl patientPersonalInformationService;

    @BeforeEach
    void setUp() {
        patientPersonalInformationService = new PatientPersonalInformationServiceImpl();
    }

    @AfterEach
    void tearDown() {
        patientPersonalInformationService = null;
    }

    @Test
    void testClassExist() {
        assertNotNull(patientPersonalInformationService, "Class Exist");
    }
}