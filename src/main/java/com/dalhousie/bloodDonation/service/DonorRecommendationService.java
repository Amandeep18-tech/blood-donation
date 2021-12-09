package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;

import java.sql.SQLException;

public interface DonorRecommendationService {
    int donorRecommendation(int patientId) throws SQLException, CustomException;
}
