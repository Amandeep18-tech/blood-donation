package com.dalhousie.bloodDonation.service;

import java.sql.SQLException;

public interface DonorRecommendationService {
    int donorRecommendation(int patientId) throws SQLException;
}
