package com.dalhousie.bloodDonation.repos.common;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.common.Survey;

import java.util.List;

public interface SurveyRepository {
    int add(Survey survey) throws CustomException;

    void delete(int id) throws CustomException;

    Survey getSurvey(int id) throws CustomException;

    List<Survey> getAllSurvey() throws CustomException;

    Boolean update(Survey survey) throws CustomException;
}
