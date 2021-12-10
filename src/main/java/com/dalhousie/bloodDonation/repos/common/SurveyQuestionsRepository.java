package com.dalhousie.bloodDonation.repos.common;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.common.SurveyQuestions;

import java.util.List;

public interface SurveyQuestionsRepository {
    Boolean add(SurveyQuestions surveyQuestion) throws CustomException;

    void delete(int id) throws CustomException;

    SurveyQuestions getSurveyQuestion(int id) throws CustomException;

    List<SurveyQuestions> getAllSurveyQuestions(int surveyMasterId) throws CustomException;

    Boolean update(SurveyQuestions surveyQuestion) throws CustomException;
}
