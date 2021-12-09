package com.dalhousie.bloodDonation.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.MedicalAppointmentDetails;
import com.dalhousie.bloodDonation.model.PatientBloodRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DonorMedicalRecordTest {
    
    private DonorMedicalRecord donorMedicalRecord;
    
    @BeforeEach
    void setUp() throws Exception {
        donorMedicalRecord= new DonorMedicalRecordImpl();
    }
    @Test
    @DisplayName("Not null test for  Donor Donation Class")
    void DonorDonationBookingImplNotNull() {
       
        assertNotNull(donorMedicalRecord, "Donor Donation class Exist class exist");
    }

    @Test
    @DisplayName("Get today Donation")
    void getTodayPatientRequestTest() throws CustomException {
        ArrayList<String> idList = new ArrayList<String>();
        MedicalAppointmentDetails medicalAppointmentDetails= new MedicalAppointmentDetails();
        Date today = Calendar.getInstance().getTime();
        java.sql.Date sqlDate = new java.sql.Date(today.getTime());
        medicalAppointmentDetails.setslotDate(sqlDate);
        medicalAppointmentDetails.setmedicalAppointmentDetailsID("955ea362-ec6b-4c6c-a8c7-6a34607ca085");
        idList.add("955ea362-ec6b-4c6c-a8c7-6a34607ca085");
        
        assertEquals(idList,donorMedicalRecord.getTodayMedicalRecord());
    }

}
