package com.dalhousie.bloodDonation.service;

import java.sql.SQLException;

public interface SurveyService {
    void getSurveyDetailsInput();

    int storeSurveyDetails() throws SQLException;

    int viewAllSurvey() throws SQLException;

    void deleteSurvey() throws SQLException;

    void updateSurvey() throws SQLException;
}
