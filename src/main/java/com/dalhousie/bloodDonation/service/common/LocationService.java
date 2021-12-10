package com.dalhousie.bloodDonation.service.common;

public interface LocationService {
    String getShortestPath(String pinCode1, String pinCode2);

    float getDistanceInMeters(String pinCode1, String pinCode2);
}
