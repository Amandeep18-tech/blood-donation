package com.dalhousie.bloodDonation.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PatientLoginInformationTest {
    private static PatientLoginInformation patientLoginInformation;

    @BeforeEach
    void setUp() {
        patientLoginInformation = new PatientLoginInformation();
    }

    @AfterEach
    void tearDown() {
        patientLoginInformation = null;
    }

    @Test
    @DisplayName("Check If The Patient Information Class Exist")
    void testPatientLoginInformationClassExist() {
        assertNotNull(patientLoginInformation, "PatientLoginInformation Class Exist");
    }

    @Test
    void testGetPatientEmailID() {
        String expectedPatientEmailID = "vivek.r.patel1998@gmail.com";
        patientLoginInformation.setPatientEmailID(expectedPatientEmailID);
        String actualPatientEmailID = patientLoginInformation.getPatientEmailID();
        assertEquals(expectedPatientEmailID, actualPatientEmailID, "getPatientEmailID Method Returns Correct Value");
    }

    @Test
    void testSetPatientEmailID() {
        String expectedPatientEmailID = "vivek.patel9884@gmail.com";
        patientLoginInformation.setPatientEmailID(expectedPatientEmailID);
        String actualPatientEmailID = patientLoginInformation.getPatientEmailID();
        assertEquals(expectedPatientEmailID, actualPatientEmailID, "setPatientEmailID Method Sets Correct Value");
    }

    @Test
    void testGetPatientId() {
        int expectedPatientId = 10;
        patientLoginInformation.setPatientId(expectedPatientId);
        int actualPatientId = patientLoginInformation.getPatientId();
        assertEquals(expectedPatientId, actualPatientId, "getPatientId Method Returns Correct Value");
    }

    @Test
    void testGetId() {
        int expectedId = 2;
        patientLoginInformation.setId(expectedId);
        int actualId = patientLoginInformation.getId();
        assertEquals(expectedId, actualId, "getId Method Returns Correct Value");
    }

    @Test
    void testSetId() {
        int expectedId = 2;
        patientLoginInformation.setId(expectedId);
        int actualId = patientLoginInformation.getId();
        assertEquals(expectedId, actualId, "setId Method Sets Correct Value");
    }

    @Test
    void testSetPatientId() {
        int expectedPatientId = 20;
        patientLoginInformation.setPatientId(expectedPatientId);
        int actualPatientId = patientLoginInformation.getPatientId();
        assertEquals(expectedPatientId, actualPatientId, "getPatientId Method Sets Correct Value");
    }

    @Test
    void testGetPatientName() {
        String expectedPatientName = "Karthik";
        patientLoginInformation.setPatientName(expectedPatientName);
        String actualPatientName = patientLoginInformation.getPatientName();
        assertEquals(expectedPatientName, actualPatientName, "getPatientName Method Returns Correct Value");
    }

    @Test
    void testSetPatientName() {
        String expectedPatientName = "Amandeep";
        patientLoginInformation.setPatientName(expectedPatientName);
        String actualPatientName = patientLoginInformation.getPatientName();
        assertEquals(expectedPatientName, actualPatientName, "getPatientName Method Sets Correct Value");
    }

    @Test
    void testGetUsername() {
        String expectedUsername = "vivek@810";
        patientLoginInformation.setUsername(expectedUsername);
        String actualUsername = patientLoginInformation.getUsername();
        assertEquals(expectedUsername, actualUsername, "getUsername Method Returns Correct Value");
    }

    @Test
    void testSetUsername() {
        String expectedUsername = "vivekpatel810";
        patientLoginInformation.setUsername(expectedUsername);
        String actualUsername = patientLoginInformation.getUsername();
        assertEquals(expectedUsername, actualUsername, "setUsername Method Sets Correct Value");
    }

    @Test
    void testGetPassword() {
        String expectedPassword = "dopealicious8";
        patientLoginInformation.setPassword(expectedPassword);
        String actualPassword = patientLoginInformation.getPassword();
        assertEquals(expectedPassword, actualPassword, "getPassword Method Returns Correct Value");
    }

    @Test
    void testSetPassword() {
        String expectedPassword = "warMachineRocks";
        patientLoginInformation.setPassword(expectedPassword);
        String actualPassword = patientLoginInformation.getPassword();
        assertEquals(expectedPassword, actualPassword, "setPassword Method Sets Correct Value");
    }
}