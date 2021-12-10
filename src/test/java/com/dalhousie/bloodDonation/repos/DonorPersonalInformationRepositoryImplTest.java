package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.repos.donor.DonorPersonalInformationRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DonorPersonalInformationRepositoryImplTest {
    private static DonorPersonalInformationRepositoryImpl donorPersonalInformationRepository;

    @BeforeEach
    void setUp() {
        donorPersonalInformationRepository = new DonorPersonalInformationRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
        donorPersonalInformationRepository = null;
    }

    @Test
    void testClassExist() {
        assertNotNull(donorPersonalInformationRepository, "Class Exist");
    }

    @Test
    void getAllMatchingBloodTypeDonors() throws CustomException {
    String bloodGroup = "APos";
    assertNotNull(donorPersonalInformationRepository.getAllMatchingBloodTypeDonors(bloodGroup));
    }
}