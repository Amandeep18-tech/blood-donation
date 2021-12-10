package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.service.patient.PatientMedicalInformationServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientMedicalInformationServiceImplTest {
    private static PatientMedicalInformationServiceImpl patientMedicalInformationService;

    @BeforeEach
    void setUp() {
        patientMedicalInformationService = new PatientMedicalInformationServiceImpl();
    }

    @AfterEach
    void tearDown() {
        patientMedicalInformationService = null;
    }

    @Test
    void testClassExist() {
        assertNotNull(patientMedicalInformationService, "Class Exist");
    }
}