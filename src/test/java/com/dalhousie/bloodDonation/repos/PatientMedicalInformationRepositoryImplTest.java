package com.dalhousie.bloodDonation.repos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientMedicalInformationRepositoryImplTest {
    private static PatientMedicalInformationRepositoryImpl patientMedicalInformationRepository;

    @BeforeEach
    void setUp() {
        patientMedicalInformationRepository = new PatientMedicalInformationRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
        patientMedicalInformationRepository = null;
    }

    @Test
    void testClassExist() {
        assertNotNull(patientMedicalInformationRepository, "Class Exist");
    }
}