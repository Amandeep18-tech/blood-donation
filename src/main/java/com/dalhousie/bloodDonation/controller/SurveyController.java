package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.Survey;
import com.dalhousie.bloodDonation.model.SurveyQuestions;
import com.dalhousie.bloodDonation.service.SurveyDetailsServiceImpl;
import com.dalhousie.bloodDonation.service.SurveyQuestionsServiceImpl;
import com.dalhousie.bloodDonation.service.SurveyServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SurveyController {
    private final Scanner input;
    private final SurveyServiceImpl surveyService;
    private final SurveyQuestionsServiceImpl surveyQuestionsService;
    private final SurveyDetailsServiceImpl surveyDetailsService;

    public SurveyController() {
        input = new Scanner(System.in);
        surveyService = new SurveyServiceImpl();
        surveyQuestionsService = new SurveyQuestionsServiceImpl();
        surveyDetailsService = new SurveyDetailsServiceImpl();
    }

    public void displaySurveyMenuForOrganization() throws CustomException {
        System.out.println("\nSurvey Menu");
        System.out.println("1. Create Survey\n2. View Survey\n3. Delete Survey\n4. Update Survey\n5. Add Survey Question\n6. View Survey Questions\n7. Delete Survey Question\n8. Update Survey Questions\n9. Go Back\n10. Exit");
        System.out.print("Select: ");
        switch (input.nextInt()) {
            case 1:
                Survey survey = surveyService.getSurveyDetailsInput();
                int survey_master_id = surveyService.storeSurveyDetails(survey);
                List<SurveyQuestions> questionList = surveyQuestionsService.getSurveyQuestionsInput(survey_master_id);
                surveyQuestionsService.storeSurveyQuestions(questionList);
                break;
            case 2:
                surveyService.viewAllSurvey();
                break;
            case 3:
                surveyService.viewAllSurvey();
                surveyService.deleteSurvey();
                break;
            case 4:
                surveyService.viewAllSurvey();
                surveyService.updateSurvey();
                break;
            case 5:
                surveyService.viewAllSurvey();
                int surveyMasterId = surveyQuestionsService.addQuestionToExistingSurveyInput();
                List<SurveyQuestions> questionsList = surveyQuestionsService.getSurveyQuestionsInput(surveyMasterId);
                surveyQuestionsService.storeSurveyQuestions(questionsList);
                break;
            case 6:
                surveyService.viewAllSurvey();
                surveyQuestionsService.viewAllSurveyQuestions();
                break;
            case 7:
                surveyService.viewAllSurvey();
                surveyQuestionsService.viewAllSurveyQuestions();
                surveyQuestionsService.deleteSurveyQuestion();
                break;
            case 8:
                surveyService.viewAllSurvey();
                surveyQuestionsService.viewAllSurveyQuestions();
                surveyQuestionsService.updateSurveyQuestion();
                break;
            case 9:
                break;
            case 10:
                System.exit(0);
                break;
            default:
                System.out.println("Please Select Correct Option From The Menu");
        }
    }

    public void displayPendingSurveyToUser() throws CustomException {
        surveyService.viewAllSurvey();
        surveyDetailsService.fillSurvey();
    }
}
