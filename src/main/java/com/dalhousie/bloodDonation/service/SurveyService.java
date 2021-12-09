package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;

import java.sql.SQLException;

public interface SurveyService {
    void getSurveyDetailsInput();

    int storeSurveyDetails() throws CustomException;

    int viewAllSurvey() throws CustomException;

    void deleteSurvey() throws CustomException;

    void updateSurvey() throws CustomException;
}
