package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.repos.patient.PatientLoginInformationRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientLoginInformationRepositoryImplTest {
    private static PatientLoginInformationRepositoryImpl patientLoginInformationRepository;

    @BeforeEach
    void setUp() {
        patientLoginInformationRepository = new PatientLoginInformationRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
        patientLoginInformationRepository = null;
    }

    @Test
    void testClassExist() {
        assertNotNull(patientLoginInformationRepository, "Class Exist");
    }
}