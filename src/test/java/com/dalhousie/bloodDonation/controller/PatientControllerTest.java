package com.dalhousie.bloodDonation.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class PatientControllerTest {
    private static PatientController patientController;

    @BeforeEach
    void setUp() {
        patientController = new PatientController();
    }

    @AfterEach
    void tearDown() {
        patientController = null;
    }

    @Test
    @DisplayName("Check If The Patient Controller Class Exist")
    void testPatientControllerClassExist() {
        assertNotNull(patientController, "Patient Controller Class Exist");
    }
}