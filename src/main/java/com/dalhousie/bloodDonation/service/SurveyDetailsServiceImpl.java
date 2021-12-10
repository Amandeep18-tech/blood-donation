package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.SurveyDetails;
import com.dalhousie.bloodDonation.model.SurveyQuestions;
import com.dalhousie.bloodDonation.repos.SurveyDetailsRepository;
import com.dalhousie.bloodDonation.repos.SurveyDetailsRepositoryImpl;
import com.dalhousie.bloodDonation.repos.SurveyQuestionsRepository;
import com.dalhousie.bloodDonation.repos.SurveyQuestionsRepositoryImpl;
import com.dalhousie.bloodDonation.utils.IOUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SurveyDetailsServiceImpl implements SurveyDetailsService {
    private final SessionService sessionService;
    private final SurveyDetailsRepositoryImpl surveyDetailsRepository;
    private final SurveyQuestionsRepositoryImpl surveyQuestionsRepository;
    private final Scanner in;

    public SurveyDetailsServiceImpl() {
        sessionService = new SessionServiceImpl();
        surveyDetailsRepository = new SurveyDetailsRepositoryImpl();
        surveyQuestionsRepository = new SurveyQuestionsRepositoryImpl();
        in = IOUtils.getInstance();
    }

    @Override
    public void fillSurvey() throws CustomException {
        System.out.print("\nEnter Survey ID To Fill The Survey: ");
        int surveyMasterId = in.nextInt();
        in.nextLine();
        System.out.println();
        SurveyQuestionsRepository questionRepo = surveyQuestionsRepository;
        List<SurveyQuestions> questionList = questionRepo.getAllSurveyQuestions(surveyMasterId);
        List<SurveyDetails> surveyDetailsList = new ArrayList<>();
        String userId = String.valueOf(sessionService.getUserId());
        for (SurveyQuestions questionObj : questionList) {
            System.out.println("Question: " + questionObj.getSurveyQuestion());
            System.out.print("Answer: ");
            String answer = in.nextLine();
            SurveyDetails surveyDetails = new SurveyDetails();
            surveyDetails.setQuestionId(questionObj.getId());
            surveyDetails.setUserId(userId);
            surveyDetails.setSurveyAnswer(answer);
            surveyDetailsList.add(surveyDetails);
            SurveyDetailsRepository surveyDetailsRepositoryImpl = surveyDetailsRepository;
            surveyDetailsRepositoryImpl.add(surveyDetails);
        }
        System.out.println("\nSurvey Filled Successfully!");
    }
}
