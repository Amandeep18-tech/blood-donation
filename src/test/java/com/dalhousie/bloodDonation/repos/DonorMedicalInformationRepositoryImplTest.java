package com.dalhousie.bloodDonation.repos;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DonorMedicalInformationRepositoryImplTest {
    private static DonorMedicalInformationRepositoryImpl donorMedicalInformationRepository;

    @BeforeEach
    void setUp() {
        donorMedicalInformationRepository = new DonorMedicalInformationRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
        donorMedicalInformationRepository = null;
    }

    @Test
    void testClassExist() {
        assertNotNull(donorMedicalInformationRepository, "Class Exist");
    }
}