package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.controller.donor.DonorMedicalRecordController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.assertNotNull;

class DonorMedicalRecordControllerTest {
    private static DonorMedicalRecordController donorMedicalRecordController;
    @BeforeEach
    void setUp() throws SQLException {
        donorMedicalRecordController= new DonorMedicalRecordController();
    }
    @AfterEach
    void tearDown() {
        donorMedicalRecordController=null;
    }

    @Test
    @DisplayName("Test To Check If The Class Exist")
    void donorDonorMedicalRecordTest() {
        assertNotNull( donorMedicalRecordController,"Donor Medical Class Exist");
    }

}

