package com.dalhousie.bloodDonation.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.BloodDonationDetaisHistory;
import com.dalhousie.bloodDonation.model.DonorMedicalRecords;
import com.dalhousie.bloodDonation.model.PatientBloodRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListSuitableDonorTest {
    
    private ListSuitableDonor listSuitableDonor;
    
    @BeforeEach
    void setUp() throws Exception {
        listSuitableDonor= new ListSuitableDonorImpl();
    }

    @Test
    @DisplayName("Not null test for  Manage Appointment Class")
    void listSuitableDonorNotNull() {
       
        assertNotNull(listSuitableDonor, "Manage appointment class exist");
    }

    @Test
    @DisplayName("Test suitable donor ")
    void testSuitableDonorId() throws CustomException{
        List<String> donorid= new ArrayList<String>();
        donorid.add("5d9b8b40-5213-11ec-917b-e2ed2ce588f5");
        donorid.add("bce4f555-522c-11ec-917b-e2ed2ce588f5");
        String bloodType="ANeg";
        assertEquals(donorid,listSuitableDonor.getSuitableDonorID(bloodType));
    }

    @Test
    @DisplayName("Test donor id")
    void testgetSuitableDonor() throws CustomException {
        String id="5d9b8b40-5213-11ec-917b-e2ed2ce588f5";
       
        String getDonorid=listSuitableDonor.getDonorDetails(id);
        assertEquals(getDonorid,"Janhavi");
    }

    @Test
    void testBloodGroup(){
        String id="5d9b8b40-5213-11ec-917b-e2ed2ce588f5";
        String bloodType="ANeg";

        assertEquals(listSuitableDonor.getBloodTypeId(bloodType, id),id);
    }

    @Test
    void testPlateletCount(){
        String id="5d9b8b40-5213-11ec-917b-e2ed2ce588f5";
        Integer plateletCount=300000;

        assertTrue(listSuitableDonor.getPlateletCount(id,plateletCount));
    }

    @Test
    void testHemoglobimCount(){
        String id="5d9b8b40-5213-11ec-917b-e2ed2ce588f5";
        Integer hemoglobinCount=120;

        assertTrue(listSuitableDonor.getHemoglobinCount(id,hemoglobinCount));
    }

    @Test
    void testRBCCount(){
        String id="5d9b8b40-5213-11ec-917b-e2ed2ce588f5";
        Integer rbcCount=300000;

        assertTrue(listSuitableDonor.getRBCCount(id,rbcCount));
    }

   
}