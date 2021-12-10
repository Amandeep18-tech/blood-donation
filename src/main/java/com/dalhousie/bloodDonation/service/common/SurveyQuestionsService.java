package com.dalhousie.bloodDonation.service.common;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.common.SurveyQuestions;

import java.util.List;

public interface SurveyQuestionsService {
    List<SurveyQuestions> getSurveyQuestionsInput(int surveyMasterId);

    void storeSurveyQuestions(List<SurveyQuestions> questionList) throws CustomException;

    int addQuestionToExistingSurveyInput();

    void viewAllSurveyQuestions() throws CustomException;

    void deleteSurveyQuestion() throws CustomException;

    void updateSurveyQuestion() throws CustomException;
}
