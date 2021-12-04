package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.model.SurveyQuestions;

import java.sql.SQLException;
import java.util.List;

public interface SurveyQuestionsService {
    List<SurveyQuestions> getSurveyQuestionsInput(int surveyMasterId);

    void storeSurveyQuestions(List<SurveyQuestions> questionList) throws SQLException;

    void addQuestionToExistingSurvey() throws SQLException;

    void viewAllSurveyQuestions() throws SQLException;

    void deleteSurveyQuestion() throws SQLException;

    void updateSurveyQuestion() throws SQLException;
}
