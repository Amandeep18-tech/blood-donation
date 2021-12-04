package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.SurveyDetails;

import java.sql.SQLException;

public interface SurveyDetailsRepository {
    void add(SurveyDetails surveyDetails) throws SQLException;
}