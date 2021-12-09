package com.dalhousie.bloodDonation.controller;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertNotNull;

class AppointmentControllerTest {
    private static AppointmentController appointmentController;
    @BeforeEach
    void setUp() throws SQLException {
        appointmentController = new AppointmentController();
    }
    @AfterEach
    void tearDown() {
        appointmentController=null;
    }

    @Test
    @DisplayName("Test To Check If The Class Exist")
    void testAppointmentControllerTest() {
        assertNotNull(appointmentController, "Appointnment Controller Class Exist");
    }

}