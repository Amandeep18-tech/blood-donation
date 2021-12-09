package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.SurveyQuestions;
import com.dalhousie.bloodDonation.repos.SurveyQuestionsRepository;
import com.dalhousie.bloodDonation.repos.SurveyQuestionsRepositoryImpl;
import com.dalhousie.bloodDonation.utils.IOUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SurveyQuestionsServiceImpl implements SurveyQuestionsService {
    private String surveyQuestion;
    private final List<SurveyQuestions> questionList = new ArrayList<>();
    private SurveyQuestionsRepositoryImpl surveyQuestionsRepository;
    private final Scanner in;

    public SurveyQuestionsServiceImpl() {
        surveyQuestionsRepository = new SurveyQuestionsRepositoryImpl();
        in = IOUtils.getInstance();
    }

    @Override
    public List<SurveyQuestions> getSurveyQuestionsInput(int surveyMasterId) {
        System.out.print("How Many Questions? ");
        int totalQuestions = in.nextInt();
        in.nextLine();
        for (int i = 0; i < totalQuestions; i++) {
            System.out.print("\nWrite Question-" + (i + 1) + ": ");
            surveyQuestion = in.nextLine();
            SurveyQuestions surveyQuestion = new SurveyQuestions();
            surveyQuestion.setSurveyMasterId(surveyMasterId);
            surveyQuestion.setSurveyQuestion(this.surveyQuestion);
            questionList.add(surveyQuestion);
        }
        return questionList;
    }

    @Override
    public void storeSurveyQuestions(List<SurveyQuestions> questionList) throws CustomException {
        SurveyQuestionsRepository questionRepo = surveyQuestionsRepository;
        for (SurveyQuestions questionObj : questionList) {
            questionRepo.add(questionObj);
        }
        System.out.println("Survey Questions Added Successfully!");
    }

    @Override
    public int addQuestionToExistingSurveyInput() {
        System.out.print("\nEnter Survey ID To View Survey Questions: ");
        int surveyMasterId = in.nextInt();
        return surveyMasterId;
    }

    @Override
    public void viewAllSurveyQuestions() throws CustomException {
        System.out.print("\nEnter Survey ID To View Survey Questions: ");
        int surveyMasterId = in.nextInt();
        SurveyQuestionsRepository questionRepo = surveyQuestionsRepository;
        List<SurveyQuestions> questionList = questionRepo.getAllSurveyQuestions(surveyMasterId);
        System.out.println();
        System.out.print("Question ID\t\tSurvey ID\t\tQuestion");
        System.out.println();
        for (SurveyQuestions questionObj : questionList) {
            System.out.print(questionObj.getId() + "\t\t\t\t" + questionObj.getSurveyMasterId() + "\t\t\t\t" + questionObj.getSurveyQuestion());
            System.out.println();
        }
    }

    @Override
    public void deleteSurveyQuestion() throws CustomException {
        System.out.print("\nEnter Question ID To Delete: ");
        int id = in.nextInt();
        SurveyQuestionsRepository questionRepo = surveyQuestionsRepository;
        questionRepo.delete(id);
        System.out.println("\nQuestion With ID- " + id + " Deleted Successfully!");
    }

    @Override
    public void updateSurveyQuestion() throws CustomException {
        System.out.print("\n Enter Question ID To Update: ");
        int id = in.nextInt();
        in.nextLine();
        SurveyQuestionsRepository questionRepo = surveyQuestionsRepository;
        SurveyQuestions surveyQuestion = questionRepo.getSurveyQuestion(id);
        System.out.print("\nNote: Leave The Field Blank If You Do Not Want To Update");
        System.out.print("\nEnter Survey Question: ");
        this.surveyQuestion = in.nextLine();
        if (this.surveyQuestion.isEmpty()) {
            this.surveyQuestion = surveyQuestion.getSurveyQuestion();
        }
        surveyQuestion.setSurveyQuestion(this.surveyQuestion);
        questionRepo.update(surveyQuestion);
        System.out.println("\nQuestion With ID- " + id + " Updated Successfully!");
    }
}
