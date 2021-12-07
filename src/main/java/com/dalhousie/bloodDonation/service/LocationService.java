package com.dalhousie.bloodDonation.service;

public interface LocationService {
    String getShortestPath(String pinCode1, String pinCode2);
    float getDistanceInMeters(String pinCode1, String pinCode2);
}
