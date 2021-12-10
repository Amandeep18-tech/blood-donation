package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.controller.donor.ListSuitableDonorController;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;


import static org.junit.jupiter.api.Assertions.assertNotNull;

class ListSuitableDonorControllerTest {
    private static ListSuitableDonorController listSuitableDonorController;
    @BeforeEach
    void setUp() throws SQLException {
        listSuitableDonorController = new ListSuitableDonorController();
    }
    @AfterEach
    void tearDown() {
        listSuitableDonorController=null;
    }

    @Test
    @DisplayName("Test To Check If The Class Exist")
    void donorDonorMedicalRecordTest() {
        assertNotNull( listSuitableDonorController,"List suitable donor class  Exist");
    }

}


