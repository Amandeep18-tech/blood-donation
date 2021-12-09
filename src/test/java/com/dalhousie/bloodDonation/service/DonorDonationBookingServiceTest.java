package com.dalhousie.bloodDonation.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.PatientBloodRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DonorDonationBookingServiceTest {
    
    private DonorDonationBookingImpl donationBookingImpl;
    
    @BeforeEach
    void setUp() throws Exception {
        donationBookingImpl= new DonorDonationBookingImpl();
    }

    @Test
    @DisplayName("Not null test for  Donor Donation Class")
    void DonorDonationBookingImplNotNull() {
       
        assertNotNull(donationBookingImpl, "Donor Donation class Exist class exist");
    }

    @Test
    @DisplayName("Test for compareDate")
    void compareDateTest() throws SQLException, ParseException {

        assertTrue(donationBookingImpl.compareDonationDate("2021-12-17", "af02f0f7-3d82-11ec-917b-e2ed2ce588f5"));
    }

    @Test
    @DisplayName("Test for Select Place")
    void selectPlaceTest() throws SQLException {

        
        assertEquals(donationBookingImpl.selectDonationPlace("Dal"),"dcf53fed-3cfb-11ec-917b-e2ed2ce588f5");
    }

    @Test
    @DisplayName("Test for Slot Id")
    void getSlotIdTest() throws SQLException {

        
        assertEquals(donationBookingImpl.getDonationSlotId("1"),"c4e4bbfa-4d5f-11ec-917b-e2ed2ce588f5");
    }

    @Test
    @DisplayName("Test for Slot Id unavailable")
    void getSlotIdTestForIncorrectValue() throws SQLException {

        
        assertEquals(donationBookingImpl.getDonationSlotId("2"),"SLOT_UNAVAILABLE");
    }

    @Test
    @DisplayName("Test Patient request Id")
    void getPatientRequestId() throws SQLException {

        
        assertEquals(donationBookingImpl.getPatientRequestId("5d9793a1-5213-11ec-917b-e2ed2ce588f5"),"5c256da3-3d82-11ec-917b-e2ed2ce588f5");
    }
    @Test
    @DisplayName("Test Patient request wrong Id ")
    void getPatientRequestIdNull() throws SQLException {

        
        assertEquals(donationBookingImpl.getPatientRequestId("5d9793a1-5213-11ec-917b-e2ed2ce5"),null);
    }

    @Test
    @DisplayName("Get today Donation")
    void getTodayDonationExceptionTest() throws CustomException {
        Exception exception = assertThrows(CustomException.class, () -> {
            donationBookingImpl.getTodayDonation();
        });
    
        String expectedMessage = "No donation for today";
        String actualMessage = exception.getMessage();
    
        assertTrue(actualMessage.contains(expectedMessage));
        
        
    }// test will fail because there is donation for today

    @Test
    @DisplayName("Get today Donation")
    void getTodayDonationTest() throws CustomException {
        ArrayList<String> idList = new ArrayList<String>();
        idList.add("6c111307-4cbe-11ec-917b-e2ed2ce588f5");
        assertEquals(donationBookingImpl.getTodayDonation(),idList);
    }// test will fail if no donation for today

    @Test
    @DisplayName("Get Patient request Details")
    void getPatientRequestDetails()  {  
        PatientBloodRequest patientBloodRequest= new PatientBloodRequest();
        patientBloodRequest =donationBookingImpl.getPatientRequestDetails("9bfb7085-2103-463f-b229-7bc6ef5b9371");
        assertEquals("9bfb7085-2103-463f-b229-7bc6ef5b9371", patientBloodRequest.getId());
       
    }

    
    

}