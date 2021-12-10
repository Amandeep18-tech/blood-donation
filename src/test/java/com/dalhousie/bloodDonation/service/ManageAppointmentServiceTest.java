package com.dalhousie.bloodDonation.service;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;

import com.dalhousie.bloodDonation.model.donor.DonorMedicalRecords;
import com.dalhousie.bloodDonation.model.donor.MedicalAppointmentMaster;
import com.dalhousie.bloodDonation.service.donor.ManageAppointmentImpl;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

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
    void compareDateTest() throws SQLException, ParseException {

        
        assertTrue(manageAppointmentImpl.compareDate("2021-12-17", "af02f0f7-3d82-11ec-917b-e2ed2ce588f5"));
    }
    @Test
    @DisplayName("Test for Select Place")
    void selectPlaceTest() throws SQLException {

        
        assertEquals(manageAppointmentImpl.selectPlace("Dal"),"dcf53fed-3cfb-11ec-917b-e2ed2ce588f5");
    }

    @Test
    @DisplayName("Test for Slot Id")
    void getSlotIdTest() throws SQLException {

        
        assertEquals(manageAppointmentImpl.getSlotId("5"),"af02f0f7-3d82-11ec-917b-e2ed2ce588f5");
    }
    @Test
    @DisplayName("Test for Get available time for wrong place")
    void getAvailableTimeTestWrongPlace() throws SQLException {

        MedicalAppointmentMaster medicalAppointmentMaster = new MedicalAppointmentMaster();
        medicalAppointmentMaster.setorganisationID("dcf53fed-3cfb-11ec-917b-e2ed2ce588f5");
        medicalAppointmentMaster.setslotNumber(5);
        
        
        assertEquals(manageAppointmentImpl.getAvailableTime(medicalAppointmentMaster, "Dal1"),null);
    }

    @Test
    @DisplayName("Test for Get available time")
    void getAvailableTimeTestRightPlace() throws SQLException {
        MedicalAppointmentMaster medicalAppointmentMaster = new MedicalAppointmentMaster();
        medicalAppointmentMaster.setorganisationID("dcf53fed-3cfb-11ec-917b-e2ed2ce588f5");
        medicalAppointmentMaster.setslotNumber(5);
        String slotStartTime="13:30:00";
        DateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        java.sql.Time timeValue=null;
        try {
            timeValue = new java.sql.Time(formatter.parse(slotStartTime).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        medicalAppointmentMaster.setslotStartTime(timeValue);
        medicalAppointmentMaster.setslotNumber(5);
        String slotEndTime="14:00:00";
        java.sql.Time timeValue2=null;
        try {
            timeValue2 = new java.sql.Time(formatter.parse(slotEndTime).getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        medicalAppointmentMaster.setslotEndTime(timeValue2);
        
        assertEquals(manageAppointmentImpl.getAvailableTime(medicalAppointmentMaster, "dcf53fed-3cfb-11ec-917b-e2ed2ce588f5"),medicalAppointmentMaster.getslotNumber() + " " + medicalAppointmentMaster.getslotStartTime() + " "
        + medicalAppointmentMaster.getslotEndTime());
    }
    @Test
    @DisplayName("Test for Slot Id ")
    @Disabled
    void getDonorID() throws SQLException {
        String donorID="5c256da3-3d82-11ec-917b-e2ed2ce588f5";
        assertEquals(true,manageAppointmentImpl.checkDonorMedicalID(donorID) );
        
        
    }

    @Test
    @DisplayName("Test for Slot Id wrong value")
    @Disabled
    void getDonorIDFalse() throws SQLException {
        String donorID="213";
        assertEquals(false,manageAppointmentImpl.checkDonorMedicalID(donorID) );
        
        
    }

    @Test
    @DisplayName("Test for Slot Id wrong value")
    @Disabled
    void getDonorDetails() throws SQLException {
        DonorMedicalRecords donorMedicalRecords= new DonorMedicalRecords();
        DonorMedicalRecords donorMedicalRecords1= new DonorMedicalRecords();
        donorMedicalRecords.setdonorID("5c256da3-3d82-11ec-917b-e2ed2ce588f5");
        donorMedicalRecords1=manageAppointmentImpl.getDonorDetails("5c256da3-3d82-11ec-917b-e2ed2ce588f5");
        assertEquals(donorMedicalRecords1.getdonorID(),donorMedicalRecords.getdonorID());
    }
    
}
