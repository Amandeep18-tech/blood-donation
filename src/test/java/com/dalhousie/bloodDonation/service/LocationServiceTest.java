package com.dalhousie.bloodDonation.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocationServiceTest {

    private static LocationService locationService;
    @BeforeAll
    static void setup(){
        locationService = new LocationServiceImpl();
    }

    @Test
    void testGetShortestPathSuccess() {
        String path = locationService.getShortestPath("B3H 4S8","B3J 3K3");
        Assertions.assertEquals("University Avenue->South Park Street->Dresden Row",path);
    }

    @Test
    void getDistanceInMetersSuccess() {
        Float distanceInMeters = locationService.getDistanceInMeters("B3H 4S8","B3J 3K3");
        Assertions.assertEquals(Float.parseFloat("847.308"),distanceInMeters);
    }

    @Test
    void testGetShortestPathFailure() {
        String path = locationService.getShortestPath("B3H 4S8","B3J 3K3");
        Assertions.assertNotEquals("University Avenue->Dresden Row",path);
    }

    @Test
    void getDistanceInMetersFailure() {
        Float distanceInMeters = locationService.getDistanceInMeters("B3H 4S8","B3J 3K3");
        Assertions.assertNotEquals(Float.parseFloat("857.308"),distanceInMeters);
    }
}