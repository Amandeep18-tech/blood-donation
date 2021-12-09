package com.dalhousie.bloodDonation.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.assertNotNull;

class DonorAppointmentControllerTest {
    private static DonorAppointmentController donorAppointmentController;
    @BeforeEach
    void setUp() throws SQLException {
        donorAppointmentController = new DonorAppointmentController();
    }
    @AfterEach
    void tearDown() {
        donorAppointmentController=null;
    }

    @Test
    @DisplayName("Test To Check If The Class Exist")
    void donorAppointmentControllerTest() {
        assertNotNull(donorAppointmentController, "Donor Appointment Controller Class Exist");
    }

}
