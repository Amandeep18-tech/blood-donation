package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.service.patient.PatientLoginInformationServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientLoginInformationServiceImplTest {
    private static PatientLoginInformationServiceImpl patientLoginInformationService;

    @BeforeEach
    void setUp() {
        patientLoginInformationService = new PatientLoginInformationServiceImpl();
    }

    @AfterEach
    void tearDown() {
        patientLoginInformationService = null;
    }

    @Test
    void testClassExist() {
        assertNotNull(patientLoginInformationService, "Class Exist");
    }
}