package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.model.SurveyQuestions;
import com.dalhousie.bloodDonation.repos.SurveyQuestionsRepositoryImpl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SurveyQuestionsServiceImpl implements SurveyQuestionsService {
    private String surveyQuestion;
    private final List<SurveyQuestions> questionList = new ArrayList<>();

    public SurveyQuestionsServiceImpl() {
    }

    @Override
    public List<SurveyQuestions> getSurveyQuestionsInput(int surveyMasterId) {
        Scanner in = new Scanner(System.in);
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
    public void storeSurveyQuestions(List<SurveyQuestions> questionList) throws SQLException {
        SurveyQuestionsRepositoryImpl questionDAO = new SurveyQuestionsRepositoryImpl();
        for (SurveyQuestions questionObj : questionList) {
            questionDAO.add(questionObj);
        }
        System.out.println("Survey Created Successfully!");
    }

    @Override
    public void addQuestionToExistingSurvey() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Survey ID To View Survey Questions: ");
        int surveyMasterId = in.nextInt();
        List<SurveyQuestions> questionList = getSurveyQuestionsInput(surveyMasterId);
        storeSurveyQuestions(questionList);
        System.out.println("Questions Added To Survey With ID- " + surveyMasterId + " Successfully!");
    }

    @Override
    public void viewAllSurveyQuestions() throws SQLException {
        SurveyServiceImpl surveyServiceImpl = new SurveyServiceImpl();
        surveyServiceImpl.viewAllSurvey();
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Survey ID To View Survey Questions: ");
        int surveyMasterId = in.nextInt();
        SurveyQuestionsRepositoryImpl questionDAO = new SurveyQuestionsRepositoryImpl();
        List<SurveyQuestions> questionList = questionDAO.getAllSurveyQuestions(surveyMasterId);
        System.out.println();
        System.out.print("Question ID\t\tSurvey ID\t\tQuestion");
        System.out.println();
        for (SurveyQuestions questionObj : questionList) {
            System.out.print(questionObj.getId() + "\t\t\t\t" + questionObj.getSurveyMasterId() + "\t\t\t\t" + questionObj.getSurveyQuestion());
            System.out.println();
        }
    }

    @Override
    public void deleteSurveyQuestion() throws SQLException {
        viewAllSurveyQuestions();
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Question ID To Delete: ");
        int id = in.nextInt();
        SurveyQuestionsRepositoryImpl questionDAO = new SurveyQuestionsRepositoryImpl();
        questionDAO.delete(id);
        System.out.println("\nQuestion With ID- " + id + " Deleted Successfully!");
    }

    @Override
    public void updateSurveyQuestion() throws SQLException {
        viewAllSurveyQuestions();
        Scanner in = new Scanner(System.in);
        System.out.print("\n Enter Question ID To Update: ");
        int id = in.nextInt();
        in.nextLine();
        SurveyQuestionsRepositoryImpl questionDAO = new SurveyQuestionsRepositoryImpl();
        SurveyQuestions surveyQuestion = questionDAO.getSurveyQuestion(id);
        System.out.print("\nNote: Leave The Field Blank If You Do Not Want To Update");
        System.out.print("\nEnter Survey Question: ");
        this.surveyQuestion = in.nextLine();
        if (this.surveyQuestion.isEmpty()) {
            this.surveyQuestion = surveyQuestion.getSurveyQuestion();
        }
        surveyQuestion.setSurveyQuestion(this.surveyQuestion);
        questionDAO.update(surveyQuestion);
        System.out.println("\nQuestion With ID- " + id + " Updated Successfully!");
    }
}
