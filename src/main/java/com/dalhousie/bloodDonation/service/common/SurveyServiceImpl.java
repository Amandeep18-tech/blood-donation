package com.dalhousie.bloodDonation.service.common;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.common.Survey;
import com.dalhousie.bloodDonation.repos.common.SurveyRepository;
import com.dalhousie.bloodDonation.repos.common.SurveyRepositoryImpl;
import com.dalhousie.bloodDonation.utils.IOUtils;

import java.util.List;
import java.util.Scanner;

public class SurveyServiceImpl implements SurveyService {
    private String surveyTitle;
    private String surveyDescription;
    private String surveyType;
    private final Scanner in;
    private final SurveyRepository surveyRepository;

    public SurveyServiceImpl() {
        in = IOUtils.getInstance();
        surveyRepository = new SurveyRepositoryImpl();
    }

    @Override
    public Survey getSurveyDetailsInput() {
        System.out.print("\nEnter Survey Title: ");
        surveyTitle = in.nextLine();
        System.out.print("\nEnter Survey Description: ");
        surveyDescription = in.nextLine();
        System.out.print("\nEnter Survey Type: ");
        surveyType = in.nextLine();
        Survey survey = new Survey();
        survey.setSurveyTitle(surveyTitle);
        survey.setSurveyDesc(surveyDescription);
        survey.setSurveyType(surveyType);
        return survey;
    }

    @Override
    public int storeSurveyDetails(Survey survey) throws CustomException {
        return surveyRepository.add(survey);
    }

    @Override
    public List<Survey> viewAllSurvey() throws CustomException {
        List<Survey> surveyList = surveyRepository.getAllSurvey();
        System.out.println();
        System.out.format("%5s%9s%34s%38s", "Survey ID", "Type", "Survey Title", "Survey Description");
        System.out.println();
        surveyList.forEach(survey -> {
            System.out.format("%-14s%-26s%-32s%-20s", survey.getId(), survey.getSurveyType(), survey.getSurveyTitle(), survey.getSurveyDesc());
            System.out.println();
        });
        return surveyList;
    }

    @Override
    public void deleteSurvey() throws CustomException {
        System.out.print("\nEnter Survey ID To Delete: ");
        int id = in.nextInt();
        surveyRepository.delete(id);
        System.out.println("\nSurvey With ID- " + id + " Deleted Successfully!");
    }

    @Override
    public void updateSurvey() throws CustomException {
        System.out.print("\nEnter Survey ID To Update: ");
        int id = in.nextInt();
        in.nextLine();
        Survey survey = surveyRepository.getSurvey(id);
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
        surveyRepository.update(survey);
        System.out.println("\nSurvey With ID- " + id + " Updated Successfully!");
    }
}
