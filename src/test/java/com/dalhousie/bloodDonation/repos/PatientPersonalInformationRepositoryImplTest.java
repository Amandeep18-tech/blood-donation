package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PatientPersonalInformationRepositoryImplTest {
    private static PatientPersonalInformationRepositoryImpl patientPersonalInformationRepository;

    @BeforeEach
    void setUp() {
        patientPersonalInformationRepository = new PatientPersonalInformationRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
        patientPersonalInformationRepository = null;
    }

    @Test
    void testClassExist() {
        assertNotNull(patientPersonalInformationRepository, "Class Exist");
    }

    @Test
    void getAllPatients() throws CustomException {
        assertNotNull(patientPersonalInformationRepository.getAllPatients());
    }
}