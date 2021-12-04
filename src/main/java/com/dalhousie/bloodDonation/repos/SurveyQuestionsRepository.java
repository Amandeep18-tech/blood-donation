package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.SurveyQuestions;

import java.sql.SQLException;
import java.util.List;

public interface SurveyQuestionsRepository {
    void add(SurveyQuestions surveyQuestion) throws SQLException;

    void delete(int id) throws SQLException;

    SurveyQuestions getSurveyQuestion(int id) throws SQLException;

    List<SurveyQuestions> getAllSurveyQuestions(int surveyMasterId) throws SQLException;

    void update(SurveyQuestions surveyQuestion) throws SQLException;
}
