package com.dalhousie.bloodDonation.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PatientPersonalInformationTest {
    private static PatientPersonalInformation personalInformation;

    @BeforeEach
    void setUp() {
        personalInformation = new PatientPersonalInformation();
    }

    @AfterEach
    void tearDown() {
        personalInformation = null;
    }

    @Test
    @DisplayName("Check If PatientPersonalInformation Class Exist")
    void testCheckPatientPersonalInformationClassExist() {
        assertNotNull(personalInformation, "PatientPersonalInformation Class Exist");
    }

    @Test
    void testGetId() {
        int expectedId = 3;
        personalInformation.setId(expectedId);
        int actualId = personalInformation.getId();
        assertEquals(expectedId, actualId, "getId Method Returns Correct Value");
    }

    @Test
    void testGetPatientName() {
        String expectedPatientName = "Chetan Sadhu";
        personalInformation.setPatientName(expectedPatientName);
        String actualPatientName = personalInformation.getPatientName();
        assertEquals(expectedPatientName, actualPatientName, "getPatientName Method Returns Correct Value");
    }

    @Test
    void testGetDOB() {
        String expectedDOB = "08-10-1998";
        personalInformation.setDOB(expectedDOB);
        String actualDOB = personalInformation.getDOB();
        assertEquals(expectedDOB, actualDOB, "getDOB Method Returns Correct Value");
    }

    @Test
    void testGetAge() {
        int expectedAge = 23;
        personalInformation.setAge(expectedAge);
        int actualAge = personalInformation.getAge();
        assertEquals(expectedAge, actualAge, "getAge Method Returns Correct Value");
    }

    @Test
    void testGetAddress() {
        String expectedAddress = "2327 Brunswick Street";
        personalInformation.setAddress(expectedAddress);
        String actualAddress = personalInformation.getAddress();
        assertEquals(expectedAddress, actualAddress, "getAddress Method Returns Correct Value");
    }

    @Test
    void testGetContactNumber() {
        String expectedContactNumber = "782-640-9810";
        personalInformation.setContactNumber(expectedContactNumber);
        String actualContactNumber = personalInformation.getContactNumber();
        assertEquals(expectedContactNumber, actualContactNumber, "getContactNumber Method Returns Correct Value");
    }

    @Test
    void testGetEmailId() {
        String expectedEmailID = "vivek.r.patel1998@gmail.com";
        personalInformation.setEmailId(expectedEmailID);
        String actualEmailID = personalInformation.getEmailId();
        assertEquals(expectedEmailID, actualEmailID, "getEmailId Method Returns Correct Value");
    }

    @Test
    void testSetId() {
        int expectedId = 4;
        personalInformation.setId(expectedId);
        int actualId = personalInformation.getId();
        assertEquals(expectedId, actualId, "setId Method Sets Correct Value");
    }

    @Test
    void testSetPatientName() {
        String expectedPatientName = "Saurabh Sharma";
        personalInformation.setPatientName(expectedPatientName);
        String actualPatientName = personalInformation.getPatientName();
        assertEquals(expectedPatientName, actualPatientName, "setPatientName Method Sets Correct Value");
    }

    @Test
    void testSetDOB() {
        String expectedDOB = "26-03-1999";
        personalInformation.setDOB(expectedDOB);
        String actualDOB = personalInformation.getDOB();
        assertEquals(expectedDOB, actualDOB, "setDOB Method Sets Correct Value");
    }

    @Test
    void testSetAge() {
        int expectedAge = 24;
        personalInformation.setAge(expectedAge);
        int actualAge = personalInformation.getAge();
        assertEquals(expectedAge, actualAge, "setAge Method Sets Correct Value");
    }

    @Test
    void testSetAddress() {
        String expectedAddress = "3138 Chainlake Drive";
        personalInformation.setAddress(expectedAddress);
        String actualAddress = personalInformation.getAddress();
        assertEquals(expectedAddress, actualAddress, "setAddress Method Sets Correct Value");
    }

    @Test
    void testSetContactNumber() {
        String expectedContactNumber = "+91 8734949484";
        personalInformation.setContactNumber(expectedContactNumber);
        String actualContactNumber = personalInformation.getContactNumber();
        assertEquals(expectedContactNumber, actualContactNumber, "setContactNumber Method Sets Correct Value");
    }

    @Test
    void testSetEmailId() {
        String expectedEmailID = "vivek.patel9884@gmail.com";
        personalInformation.setEmailId(expectedEmailID);
        String actualEmailID = personalInformation.getEmailId();
        assertEquals(expectedEmailID, actualEmailID, "setEmailId Method Sets Correct Value");
    }
}