package com.dalhousie.bloodDonation.model;

import com.dalhousie.bloodDonation.model.patient.PatientMedicalInformation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class PatientMedicalInformationTest {
    private static PatientMedicalInformation patientMedicalInformation;

    @BeforeEach
    void setUp() {
        patientMedicalInformation = new PatientMedicalInformation();
    }

    @AfterEach
    void tearDown() {
        patientMedicalInformation = null;
    }

    @Test
    @DisplayName("Check If PatientMedicalInformation Class Exist")
    void testPatientInformationClassExist() {
        assertNotNull(patientMedicalInformation, "PatientMedicalInformation Class Exist");
    }

    @Test
    void testGetId() {
        int expectedId = 2;
        patientMedicalInformation.setId(expectedId);
        int actualId = patientMedicalInformation.getId();
        assertEquals(expectedId, actualId, "getId Method Returns Correct Value");
    }

    @Test
    void testSetId() {
        int expectedId = 4;
        patientMedicalInformation.setId(expectedId);
        int actualId = patientMedicalInformation.getId();
        assertEquals(expectedId, actualId, "setId Method Sets Correct Value");
    }

    @Test
    void testGetPatientId() {
        int expectedPatientId = 20;
        patientMedicalInformation.setPatientId(expectedPatientId);
        int actualPatientId = patientMedicalInformation.getPatientId();
        assertEquals(expectedPatientId, actualPatientId, "getPatientId Method Returns Correct Value");
    }

    @Test
    void testSetPatientId() {
        int expectedPatientId = 40;
        patientMedicalInformation.setPatientId(expectedPatientId);
        int actualPatientId = patientMedicalInformation.getPatientId();
        assertEquals(expectedPatientId, actualPatientId, "setPatientId Method Sets Correct Value");
    }

    @Test
    void testGetBloodGroup() {
        String expectedBloodGroup = "A Positive";
        patientMedicalInformation.setBloodGroup(expectedBloodGroup);
        String actualBloodGroup = patientMedicalInformation.getBloodGroup();
        assertEquals(expectedBloodGroup, actualBloodGroup, "getBloodGroup Method Returns Correct Value");
    }

    @Test
    void testSetBloodGroup() {
        String expectedBloodGroup = "B Positive";
        patientMedicalInformation.setBloodGroup(expectedBloodGroup);
        String actualBloodGroup = patientMedicalInformation.getBloodGroup();
        assertEquals(expectedBloodGroup, actualBloodGroup, "getBloodGroup Method Sets Correct Value");
    }

    @Test
    void testGetCurrentLocation() {
        String expectedCurrentLocation = "2327 Brunswick Street";
        patientMedicalInformation.setCurrentLocation(expectedCurrentLocation);
        String actualCurrentLocation = patientMedicalInformation.getCurrentLocation();
        assertEquals(expectedCurrentLocation, actualCurrentLocation, "getCurrentLocation Method Returns Correct Value");
    }

    @Test
    void testSetCurrentLocation() {
        String expectedCurrentLocation = "3138 Chainlake Drive";
        patientMedicalInformation.setCurrentLocation(expectedCurrentLocation);
        String actualCurrentLocation = patientMedicalInformation.getCurrentLocation();
        assertEquals(expectedCurrentLocation, actualCurrentLocation, "getCurrentLocation Method Sets Correct Value");
    }

    @Test
    void testGetDrReference() {
        String expectedDrReference = "Dr. Honey";
        patientMedicalInformation.setDrReference(expectedDrReference);
        String actualDrReference = patientMedicalInformation.getDrReference();
        assertEquals(expectedDrReference, actualDrReference, "getDrReference Method Returns Correct Value");
    }

    @Test
    void testSetDrReference() {
        String expectedDrReference = "Dr. Patel";
        patientMedicalInformation.setDrReference(expectedDrReference);
        String actualDrReference = patientMedicalInformation.getDrReference();
        assertEquals(expectedDrReference, actualDrReference, "setDrReference Method Sets Correct Value");
    }

    @Test
    void testGetRequirementReason() {
        String expectedRequirementReason = "Accident";
        patientMedicalInformation.setRequirementReason(expectedRequirementReason);
        String actualRequirementReason = patientMedicalInformation.getRequirementReason();
        assertEquals(expectedRequirementReason, actualRequirementReason, "getRequirementReason Method Returns Correct Value");
    }

    @Test
    void testSetRequirementReason() {
        String expectedRequirementReason = "Blood Transfusion";
        patientMedicalInformation.setRequirementReason(expectedRequirementReason);
        String actualRequirementReason = patientMedicalInformation.getRequirementReason();
        assertEquals(expectedRequirementReason, actualRequirementReason, "setRequirementReason Method Sets Correct Value");
    }

    @Test
    void testGetPriority() {
        String expectedPriority = "High";
        patientMedicalInformation.setPriority(expectedPriority);
        String actualPriority = patientMedicalInformation.getPriority();
        assertEquals(expectedPriority, actualPriority, "getPriority Method Returns Correct Value");
    }

    @Test
    void testSetPriority() {
        String expectedPriority = "Low";
        patientMedicalInformation.setPriority(expectedPriority);
        String actualPriority = patientMedicalInformation.getPriority();
        assertEquals(expectedPriority, actualPriority, "setPriority Method Sets Correct Value");
    }

    @Test
    void testGetHasHepatitisB() {
        int expectedHasHepatitisB = 0;
        patientMedicalInformation.setHasHepatitisB(expectedHasHepatitisB);
        int actualHasHepatitisB = patientMedicalInformation.getHasHepatitisB();
        assertEquals(expectedHasHepatitisB, actualHasHepatitisB, "getHasHepatitisB Method Returns Correct Value");
    }

    @Test
    void testSetHasHepatitisB() {
        int expectedHasHepatitisB = 1;
        patientMedicalInformation.setHasHepatitisB(expectedHasHepatitisB);
        int actualHasHepatitisB = patientMedicalInformation.getHasHepatitisB();
        assertEquals(expectedHasHepatitisB, actualHasHepatitisB, "setHasHepatitisB Method Sets Correct Value");
    }

    @Test
    void testGetHasHepatitisC() {
        int expectedHasHepatitisC = 1;
        patientMedicalInformation.setHasHepatitisC(expectedHasHepatitisC);
        int actualHasHepatitisC = patientMedicalInformation.getHasHepatitisC();
        assertEquals(expectedHasHepatitisC, actualHasHepatitisC, "getHasHepatitisC Method Returns Correct Value");
    }

    @Test
    void testSetHasHepatitisC() {
        int expectedHasHepatitisC = 0;
        patientMedicalInformation.setHasHepatitisC(expectedHasHepatitisC);
        int actualHasHepatitisC = patientMedicalInformation.getHasHepatitisC();
        assertEquals(expectedHasHepatitisC, actualHasHepatitisC, "setHasHepatitisC Method Sets Correct Value");
    }

    @Test
    void testGetHasHIV() {
        int expectedHasHIV = 0;
        patientMedicalInformation.setHasHIV(expectedHasHIV);
        int actualHasHIV = patientMedicalInformation.getHasHIV();
        assertEquals(expectedHasHIV, actualHasHIV, "getHasHIV Method Returns Correct Value");
    }

    @Test
    void testSetHasHIV() {
        int expectedHasHIV = 0;
        patientMedicalInformation.setHasHIV(expectedHasHIV);
        int actualHasHIV = patientMedicalInformation.getHasHIV();
        assertEquals(expectedHasHIV, actualHasHIV, "setHasHIV Method Sets Correct Value");
    }

    @Test
    void testGetHasHemochromatosis() {
        int expectedHasHemochromatosis = 1;
        patientMedicalInformation.setHasHemochromatosis(expectedHasHemochromatosis);
        int actualHasHemochromatosis = patientMedicalInformation.getHasHemochromatosis();
        assertEquals(expectedHasHemochromatosis, actualHasHemochromatosis, "getHasHemochromatosis Method Returns Correct Value");
    }

    @Test
    void testSetHasHemochromatosis() {
        int expectedHasHemochromatosis = 1;
        patientMedicalInformation.setHasHemochromatosis(expectedHasHemochromatosis);
        int actualHasHemochromatosis = patientMedicalInformation.getHasHemochromatosis();
        assertEquals(expectedHasHemochromatosis, actualHasHemochromatosis, "setHasHemochromatosis Method Sets Correct Value");
    }

    @Test
    void testGetHemoglobinLevel() {
        int expectedHemoglobinLevel = 12;
        patientMedicalInformation.setHemoglobinLevel(expectedHemoglobinLevel);
        int actualHemoglobinLevel = patientMedicalInformation.getHemoglobinLevel();
        assertEquals(expectedHemoglobinLevel, actualHemoglobinLevel, "getHemoglobinLevel Method Returns Correct Value");
    }

    @Test
    void testSetHemoglobinLevel() {
        int expectedHemoglobinLevel = 14;
        patientMedicalInformation.setHemoglobinLevel(expectedHemoglobinLevel);
        int actualHemoglobinLevel = patientMedicalInformation.getHemoglobinLevel();
        assertEquals(expectedHemoglobinLevel, actualHemoglobinLevel, "setHemoglobinLevel Method Sets Correct Value");
    }

    @Test
    void testGetRbcCount() {
        int expectedRbcCount = 100000;
        patientMedicalInformation.setRbcCount(expectedRbcCount);
        int actualRbcCount = patientMedicalInformation.getRbcCount();
        assertEquals(expectedRbcCount, actualRbcCount, "getRbcCount Method Returns Correct Value");
    }

    @Test
    void testSetRbcCount() {
        int expectedRbcCount = 400000;
        patientMedicalInformation.setRbcCount(expectedRbcCount);
        int actualRbcCount = patientMedicalInformation.getRbcCount();
        assertEquals(expectedRbcCount, actualRbcCount, "setRbcCount Method Sets Correct Value");
    }

    @Test
    void testGetPlateletCount() {
        int expectedPlateletCount = 200000;
        patientMedicalInformation.setPlateletCount(expectedPlateletCount);
        int actualPlateletCount = patientMedicalInformation.getPlateletCount();
        assertEquals(expectedPlateletCount, actualPlateletCount, "getPlateletCount Method Returns Correct Value");
    }

    @Test
    void testSetPlateletCount() {
        int expectedPlateletCount = 300000;
        patientMedicalInformation.setPlateletCount(expectedPlateletCount);
        int actualPlateletCount = patientMedicalInformation.getPlateletCount();
        assertEquals(expectedPlateletCount, actualPlateletCount, "setPlateletCount Method Sets Correct Value");
    }
}