package com.dalhousie.bloodDonation.service.donor;

import com.dalhousie.bloodDonation.exception.CustomException;

import java.sql.SQLException;

public interface DonorRecommendationService {
    int donorRecommendation(int patientId) throws CustomException;
}
