package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.model.Survey;
import com.dalhousie.bloodDonation.repos.SurveyRepositoryImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class SurveyServiceImpl implements SurveyService {
    private String surveyTitle;
    private String surveyDescription;
    private String surveyType;

    public SurveyServiceImpl() {
    }

    @Override
    public void getSurveyDetailsInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Survey Title: ");
        surveyTitle = in.nextLine();
        System.out.print("\nEnter Survey Description: ");
        surveyDescription = in.nextLine();
        System.out.print("\nEnter Survey Type: ");
        surveyType = in.nextLine();
    }

    @Override
    public int storeSurveyDetails() throws SQLException {
        Survey survey = new Survey();
        survey.setSurveyTitle(surveyTitle);
        survey.setSurveyDesc(surveyDescription);
        survey.setSurveyType(surveyType);
        SurveyRepositoryImpl surveyRepositoryImpl = new SurveyRepositoryImpl();
        return surveyRepositoryImpl.add(survey);
    }

    @Override
    public void viewAllSurvey() throws SQLException {
        SurveyRepositoryImpl surveyRepositoryImpl = new SurveyRepositoryImpl();
        List<Survey> surveyList = surveyRepositoryImpl.getAllSurvey();
        System.out.println();
        System.out.format("%5s%10s%32s%25s", "Survey ID", "Title", "Description", "Type");
        System.out.println();
        for (Survey survey : surveyList) {
            System.out.format("%-14s%-26s%-32s%-20s", survey.getId(), survey.getSurveyTitle(), survey.getSurveyDesc(), survey.getSurveyType());
            System.out.println();
        }
    }

    @Override
    public void deleteSurvey() throws SQLException {
        viewAllSurvey();
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Survey ID To Delete: ");
        int id = in.nextInt();
        SurveyRepositoryImpl surveyRepositoryImpl = new SurveyRepositoryImpl();
        surveyRepositoryImpl.delete(id);
        System.out.println("\nSurvey With ID- " + id + " Deleted Successfully!");
    }

    @Override
    public void updateSurvey() throws SQLException {
        viewAllSurvey();
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Survey ID To Update: ");
        int id = in.nextInt();
        in.nextLine();
        SurveyRepositoryImpl surveyRepositoryImpl = new SurveyRepositoryImpl();
        Survey survey = surveyRepositoryImpl.getSurvey(id);
        System.out.print("\nNote: Leave The Field Blank If You Do Not Want To Update");
        System.out.print("\nEnter Survey Title: ");
        surveyTitle = in.nextLine();
        System.out.print("\nEnter Survey Description: ");
        surveyDescription = in.nextLine();
        System.out.print("\nEnter Survey Type: ");
        surveyType = in.nextLine();
        if (surveyTitle.isEmpty()) {
            surveyTitle = survey.getSurveyTitle();
        }
        if (surveyDescription.isEmpty()) {
            surveyDescription = survey.getSurveyDesc();
        }
        if (surveyType.isEmpty()) {
            surveyType = survey.getSurveyType();
        }
        survey.setSurveyTitle(surveyTitle);
        survey.setSurveyDesc(surveyDescription);
        survey.setSurveyType(surveyType);
        surveyRepositoryImpl.update(survey);
        System.out.println("\nSurvey With ID- " + id + " Updated Successfully!");
    }
}
