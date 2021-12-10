package com.dalhousie.bloodDonation.model;

import com.dalhousie.bloodDonation.model.donor.DonorInformation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class DonorInformationTest {
    private static DonorInformation donorInformation;

    @BeforeEach
    void setUp() {
        donorInformation = new DonorInformation();
    }

    @AfterEach
    void tearDown() {
        donorInformation = null;
    }

    @Test
    @DisplayName("Check If The DonorInformation Class Exist")
    void testDonorInformationClassExist() {
        assertNotNull(donorInformation, "DonorInformation Class Exist");
    }

    @Test
    void testGetHemoglobinLevelDifference() {
        double expectedHemoglobinLevelDifference = 10;
        donorInformation.setHemoglobinLevelDifference(10);
        double actualHemoglobinLevelDifference = donorInformation.getHemoglobinLevelDifference();
        assertEquals(expectedHemoglobinLevelDifference, actualHemoglobinLevelDifference, "getHemoglobinLevelDifference Method Returns Correct Value");
    }

    @Test
    void testSetHemoglobinLevelDifference() {
        double expectedHemoglobinLevelDifference = 20;
        donorInformation.setHemoglobinLevelDifference(20);
        double actualHemoglobinLevelDifference = donorInformation.getHemoglobinLevelDifference();
        assertEquals(expectedHemoglobinLevelDifference, actualHemoglobinLevelDifference, "setHemoglobinLevelDifference Method Sets Correct Value");
    }

    @Test
    void testGetRbcCountDifference() {
        int expectedRbcCountDifference = 100000;
        donorInformation.setRbcCountDifference(expectedRbcCountDifference);
        int actualRbcCountDifference = donorInformation.getRbcCountDifference();
        assertEquals(expectedRbcCountDifference, actualRbcCountDifference, "getRbcCountDifference Method Returns Correct Value");
    }

    @Test
    void testSetRbcCountDifference() {
        int expectedRbcCountDifference = 200000;
        donorInformation.setRbcCountDifference(expectedRbcCountDifference);
        int actualRbcCountDifference = donorInformation.getRbcCountDifference();
        assertEquals(expectedRbcCountDifference, actualRbcCountDifference, "setRbcCountDifference Method Sets Correct Value");
    }

    @Test
    void testGetPlateletCountDifference() {
        int expectedPlateletCountDifference = 100000;
        donorInformation.setPlateletCountDifference(expectedPlateletCountDifference);
        int actualPlateletCountDifference = donorInformation.getPlateletCountDifference();
        assertEquals(expectedPlateletCountDifference, actualPlateletCountDifference, "getPlateletCountDifference Method Returns Correct Value");
    }

    @Test
    void testSetPlateletCountDifference() {
        int expectedPlateletCountDifference = 200000;
        donorInformation.setPlateletCountDifference(expectedPlateletCountDifference);
        int actualPlateletCountDifference = donorInformation.getPlateletCountDifference();
        assertEquals(expectedPlateletCountDifference, actualPlateletCountDifference, "setPlateletCountDifference Method Sets Correct Value");
    }

    @Test
    void testGetMatchingPercentage() {
        double expectedMatchingPercentage = 90;
        donorInformation.setMatchingPercentage(expectedMatchingPercentage);
        double actualMatchingPercentage = donorInformation.getMatchingPercentage();
        assertEquals(expectedMatchingPercentage, actualMatchingPercentage, "getMatchingPercentage Method Returns Correct Value");
    }

    @Test
    void testSetMatchingPercentage() {
        double expectedMatchingPercentage = 80;
        donorInformation.setMatchingPercentage(expectedMatchingPercentage);
        double actualMatchingPercentage = donorInformation.getMatchingPercentage();
        assertEquals(expectedMatchingPercentage, actualMatchingPercentage, "setMatchingPercentage Method Sets Correct Value");
    }

    @Test
    void testGetHasHepatitisB() {
        int expectedHasHepatitisB = 0;
        donorInformation.setHasHepatitisB(expectedHasHepatitisB);
        int actualHasHepatitisB = donorInformation.getHasHepatitisB();
        assertEquals(expectedHasHepatitisB, actualHasHepatitisB, "getHasHepatitisB Method Returns Correct Value");
    }

    @Test
    void testSetHasHepatitisB() {
        int expectedHasHepatitisB = 1;
        donorInformation.setHasHepatitisB(expectedHasHepatitisB);
        int actualHasHepatitisB = donorInformation.getHasHepatitisB();
        assertEquals(expectedHasHepatitisB, actualHasHepatitisB, "setHasHepatitisB Method Sets Correct Value");
    }

    @Test
    void testGetHasHepatitisC() {
        int expectedHasHepatitisC = 1;
        donorInformation.setHasHepatitisC(expectedHasHepatitisC);
        int actualHasHepatitisC = donorInformation.getHasHepatitisC();
        assertEquals(expectedHasHepatitisC, actualHasHepatitisC, "getHasHepatitisC Method Returns Correct Value");
    }

    @Test
    void testSetHasHepatitisC() {
        int expectedHasHepatitisC = 0;
        donorInformation.setHasHepatitisC(expectedHasHepatitisC);
        int actualHasHepatitisC = donorInformation.getHasHepatitisC();
        assertEquals(expectedHasHepatitisC, actualHasHepatitisC, "setHasHepatitisC Method Sets Correct Value");
    }

    @Test
    void testGetHasHIV() {
        int expectedHasHIV = 0;
        donorInformation.setHasHIV(expectedHasHIV);
        int actualHasHIV = donorInformation.getHasHIV();
        assertEquals(expectedHasHIV, actualHasHIV, "getHasHIV Method Returns Correct Value");
    }

    @Test
    void testSetHasHIV() {
        int expectedHasHIV = 0;
        donorInformation.setHasHIV(expectedHasHIV);
        int actualHasHIV = donorInformation.getHasHIV();
        assertEquals(expectedHasHIV, actualHasHIV, "setHasHIV Method Sets Correct Value");
    }

    @Test
    void testGetHasHemochromatosis() {
        int expectedHasHemochromatosis = 1;
        donorInformation.setHasHemochromatosis(expectedHasHemochromatosis);
        int actualHasHemochromatosis = donorInformation.getHasHemochromatosis();
        assertEquals(expectedHasHemochromatosis, actualHasHemochromatosis, "getHasHemochromatosis Method Returns Correct Value");
    }

    @Test
    void testSetHasHemochromatosis() {
        int expectedHasHemochromatosis = 1;
        donorInformation.setHasHemochromatosis(expectedHasHemochromatosis);
        int actualHasHemochromatosis = donorInformation.getHasHemochromatosis();
        assertEquals(expectedHasHemochromatosis, actualHasHemochromatosis, "setHasHemochromatosis Method Sets Correct Value");
    }

    @Test
    void testGetHemoglobinLevel() {
        int expectedHemoglobinLevel = 12;
        donorInformation.setHemoglobinLevel(expectedHemoglobinLevel);
        int actualHemoglobinLevel = donorInformation.getHemoglobinLevel();
        assertEquals(expectedHemoglobinLevel, actualHemoglobinLevel, "getHemoglobinLevel Method Returns Correct Value");
    }

    @Test
    void testSetHemoglobinLevel() {
        int expectedHemoglobinLevel = 14;
        donorInformation.setHemoglobinLevel(expectedHemoglobinLevel);
        int actualHemoglobinLevel = donorInformation.getHemoglobinLevel();
        assertEquals(expectedHemoglobinLevel, actualHemoglobinLevel, "setHemoglobinLevel Method Sets Correct Value");
    }

    @Test
    void testGetRbcCount() {
        int expectedRbcCount = 100000;
        donorInformation.setRbcCount(expectedRbcCount);
        int actualRbcCount = donorInformation.getRbcCount();
        assertEquals(expectedRbcCount, actualRbcCount, "getRbcCount Method Returns Correct Value");
    }

    @Test
    void testSetRbcCount() {
        int expectedRbcCount = 400000;
        donorInformation.setRbcCount(expectedRbcCount);
        int actualRbcCount = donorInformation.getRbcCount();
        assertEquals(expectedRbcCount, actualRbcCount, "setRbcCount Method Sets Correct Value");
    }

    @Test
    void testGetPlateletCount() {
        int expectedPlateletCount = 200000;
        donorInformation.setPlateletCount(expectedPlateletCount);
        int actualPlateletCount = donorInformation.getPlateletCount();
        assertEquals(expectedPlateletCount, actualPlateletCount, "getPlateletCount Method Returns Correct Value");
    }

    @Test
    void testSetPlateletCount() {
        int expectedPlateletCount = 300000;
        donorInformation.setPlateletCount(expectedPlateletCount);
        int actualPlateletCount = donorInformation.getPlateletCount();
        assertEquals(expectedPlateletCount, actualPlateletCount, "setPlateletCount Method Sets Correct Value");
    }

    @Test
    void testGetDonorId() {
        String expectedDonorId = "5c256da3-3d82-11ec-917b-e2ed2ce588f5";
        donorInformation.setDonorId(expectedDonorId);
        String actualDonorId = donorInformation.getDonorId();
        assertEquals(expectedDonorId, actualDonorId, "getDonorId Method Returns Correct Value");
    }

    @Test
    void testSetDonorId() {
        String expectedDonorId = "5d9793a1-5213-11ec-917b-e2ed2ce588f5";
        donorInformation.setDonorId(expectedDonorId);
        String actualDonorId = donorInformation.getDonorId();
        assertEquals(expectedDonorId, actualDonorId, "setDonorId Method Sets Correct Value");
    }

    @Test
    void testGetDonorFirstName() {
        String expectedDonorFirstName = "Vivek";
        donorInformation.setDonorFirstName(expectedDonorFirstName);
        String actualDonorFirstName = donorInformation.getDonorFirstName();
        assertEquals(expectedDonorFirstName, actualDonorFirstName, "getDonorFirstName Methods Returns Correct Value");
    }

    @Test
    void testSetDonorFirstName() {
        String expectedDonorFirstName = "Janhavi";
        donorInformation.setDonorFirstName(expectedDonorFirstName);
        String actualDonorFirstName = donorInformation.getDonorFirstName();
        assertEquals(expectedDonorFirstName, actualDonorFirstName, "setDonorFirstName Methods Sets Correct Value");
    }

    @Test
    void testGetDonorLastName() {
        String expectedDonorLastName = "Patel";
        donorInformation.setDonorLastName(expectedDonorLastName);
        String actualLastName = donorInformation.getDonorLastName();
        assertEquals(expectedDonorLastName, actualLastName, "getDonorLastName Method Returns Correct Value");
    }

    @Test
    void testSetDonorLastName() {
        String expectedDonorLastName = "Sonawane";
        donorInformation.setDonorLastName(expectedDonorLastName);
        String actualLastName = donorInformation.getDonorLastName();
        assertEquals(expectedDonorLastName, actualLastName, "getDonorLastName Method Sets Correct Value");
    }

    @Test
    void testGetDonorContactNumber() {
        String expectedContactNumber = "782-640-9810";
        donorInformation.setDonorContactNumber(expectedContactNumber);
        String actualContactNumber = donorInformation.getDonorContactNumber();
        assertEquals(expectedContactNumber, actualContactNumber, "getDonorContactNumber Method Returns Correct Value");
    }

    @Test
    void testSetDonorContactNumber() {
        String expectedContactNumber = "+91 8734949484";
        donorInformation.setDonorContactNumber(expectedContactNumber);
        String actualContactNumber = donorInformation.getDonorContactNumber();
        assertEquals(expectedContactNumber, actualContactNumber, "setDonorContactNumber Method Sets Correct Value");
    }

    @Test
    void testGetDonorBloodGroup() {
        String expectedDonorBloodGroup = "A Positive";
        donorInformation.setDonorBloodGroup(expectedDonorBloodGroup);
        String actualDonorBloodGroup = donorInformation.getDonorBloodGroup();
        assertEquals(expectedDonorBloodGroup, actualDonorBloodGroup, "getDonorBloodGroup Method Returns Correct Value");
    }

    @Test
    void testSetDonorBloodGroup() {
        String expectedDonorBloodGroup = "B Positive";
        donorInformation.setDonorBloodGroup(expectedDonorBloodGroup);
        String actualDonorBloodGroup = donorInformation.getDonorBloodGroup();
        assertEquals(expectedDonorBloodGroup, actualDonorBloodGroup, "setDonorBloodGroup Method Sets Correct Value");
    }
}