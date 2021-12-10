package com.dalhousie.bloodDonation.service.common;

import com.dalhousie.bloodDonation.exception.CustomException;

public interface LocationService {
    String getShortestPath(String pinCode1, String pinCode2) throws CustomException;

    float getDistanceInMeters(String pinCode1, String pinCode2) throws CustomException;
}
