package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.model.SurveyDetails;
import com.dalhousie.bloodDonation.model.SurveyQuestions;
import com.dalhousie.bloodDonation.repos.SurveyDetailsRepositoryImpl;
import com.dalhousie.bloodDonation.repos.SurveyQuestionsRepositoryImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SurveyDetailsServiceImpl implements SurveyDetailsService {

    @Override
    public void fillSurvey() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Survey ID That You Received In Mail: ");
        int surveyMasterId = in.nextInt();
        in.nextLine();
        System.out.println();
        SurveyQuestionsRepositoryImpl questionDAO = new SurveyQuestionsRepositoryImpl();
        List<SurveyQuestions> questionList = questionDAO.getAllSurveyQuestions(surveyMasterId);
        List<SurveyDetails> surveyDetailsList = new ArrayList<>();
        for (SurveyQuestions questionObj : questionList) {
            System.out.println("Question: " + questionObj.getSurveyQuestion());
            System.out.print("Answer: ");
            String answer = in.nextLine();
            SurveyDetails surveyDetails = new SurveyDetails();
            surveyDetails.setQuestionId(questionObj.getId());
            surveyDetails.setSurveyAnswer(answer);
            surveyDetailsList.add(surveyDetails);
            SurveyDetailsRepositoryImpl surveyDetailsRepositoryImpl = new SurveyDetailsRepositoryImpl();
            surveyDetailsRepositoryImpl.add(surveyDetails);
        }
        System.out.println("\nSurvey Filled Successfully!");
    }
}
