package com.dalhousie.bloodDonation.service;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import com.dalhousie.bloodDonation.model.MedicalAppointmentDetails;
import com.dalhousie.bloodDonation.model.MedicalAppointmentMaster;
import com.dalhousie.bloodDonation.service.ManageAppointmentImpl;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
class ManageAppointmentServiceTest {
    
    private ManageAppointmentImpl manageAppointmentImpl;
    
    @BeforeEach
    void setUp() throws Exception {
        manageAppointmentImpl = new ManageAppointmentImpl();
    }
    

    @Test
    @DisplayName("Not null test for  Manage Appointment Class")
    void manageAppointmnetNotNull() {
       
        assertNotNull(manageAppointmentImpl, "Manage appointment class exist");
    }

    @Test
    @DisplayName("Test for compareDate")
    void compareDateTest() throws SQLException {

        
        assertTrue(manageAppointmentImpl.CompareDate("2021-12-17", "af02f0f7-3d82-11ec-917b-e2ed2ce588f5"));
    }
    @Test
    @DisplayName("Test for Select Place")
    void selectPlaceTest() throws SQLException {

        
        assertEquals(manageAppointmentImpl.SelectPlace("Dal"),"dcf53fed-3cfb-11ec-917b-e2ed2ce588f5");
    }

    @Test
    @DisplayName("Test for Slot Id")
    void getSlotIdTest() throws SQLException {

        
        assertEquals(manageAppointmentImpl.GetSlotId("5"),"af02f0f7-3d82-11ec-917b-e2ed2ce588f5");
    }
    @Test
    @DisplayName("Test for Get available time")
    void getAvailableTimeTest() throws SQLException {

        MedicalAppointmentMaster medicalAppointmentMaster = new MedicalAppointmentMaster();
        medicalAppointmentMaster.setorganisationID("dcf53fed-3cfb-11ec-917b-e2ed2ce588f5");
        medicalAppointmentMaster.setslotNumber(5);
        

        medicalAppointmentMaster.getslotStartTime();
       
        assertEquals(manageAppointmentImpl.GetAvailableTime(medicalAppointmentMaster, "dcf53fed-3cfb-11ec-917b-e2ed2ce588f5"),"5 13:30:00 14:00:00");
    }

    



    
}
