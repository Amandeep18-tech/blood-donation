package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.Survey;

import java.util.List;

public interface SurveyService {
    Survey getSurveyDetailsInput();

    int storeSurveyDetails(Survey survey) throws CustomException;

    List<Survey> viewAllSurvey() throws CustomException;

    void deleteSurvey() throws CustomException;

    void updateSurvey() throws CustomException;
}
