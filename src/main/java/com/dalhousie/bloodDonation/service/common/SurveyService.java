package com.dalhousie.bloodDonation.service.common;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.common.Survey;

import java.util.List;

public interface SurveyService {
    Survey getSurveyDetailsInput();

    int storeSurveyDetails(Survey survey) throws CustomException;

    List<Survey> viewAllSurvey() throws CustomException;

    void deleteSurvey() throws CustomException;

    void updateSurvey() throws CustomException;
}
