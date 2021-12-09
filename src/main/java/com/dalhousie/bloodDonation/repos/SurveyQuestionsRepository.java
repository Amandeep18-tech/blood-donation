package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.SurveyQuestions;

import java.sql.SQLException;
import java.util.List;

public interface SurveyQuestionsRepository {
    void add(SurveyQuestions surveyQuestion) throws CustomException;

    void delete(int id) throws CustomException;

    SurveyQuestions getSurveyQuestion(int id) throws CustomException;

    List<SurveyQuestions> getAllSurveyQuestions(int surveyMasterId) throws CustomException;

    void update(SurveyQuestions surveyQuestion) throws CustomException;
}
