package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.SurveyQuestions;

import java.sql.SQLException;
import java.util.List;

public interface SurveyQuestionsService {
    List<SurveyQuestions> getSurveyQuestionsInput(int surveyMasterId);

    void storeSurveyQuestions(List<SurveyQuestions> questionList) throws CustomException;

    int addQuestionToExistingSurveyInput();

    void viewAllSurveyQuestions() throws CustomException;

    void deleteSurveyQuestion() throws CustomException;

    void updateSurveyQuestion() throws CustomException;
}
