package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.model.PatientMedicalInformation;
import com.dalhousie.bloodDonation.model.SurveyQuestions;
import com.dalhousie.bloodDonation.service.*;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class MenuController {
    private Scanner in;
    private SurveyServiceImpl surveyServiceImpl = null;
    private SurveyQuestionsServiceImpl questionService = null;
    private SurveyDetailsServiceImpl surveyDetailsServiceImpl = null;
    private PatientPersonalInformationServiceImpl patientPersonalInfoService = null;
    private PatientMedicalInformationServiceImpl patientMedicalInfoService = null;

    public void displayMenu() throws SQLException {
        while (true) {
            System.out.print("\nMain Menu\n");
            System.out.println("1. Survey\n2. Patients\n3. Exit");
            in = new Scanner(System.in);
            System.out.print("Select: ");
            switch (in.nextInt()) {
                case 1:
                    System.out.println("\nSelect Operation");
                    System.out.println("1. Create Survey\n2. View Survey\n3. Delete Survey\n4. Update Survey\n5. Fill Survey\n6. View Survey Questions\n7. Delete Survey Question\n8. Update Survey Questions\n9. Add Survey Question\n10. Go Back\n11. Exit");
                    System.out.print("Select: ");
                    surveyServiceImpl = new SurveyServiceImpl();
                    questionService = new SurveyQuestionsServiceImpl();
                    surveyDetailsServiceImpl = new SurveyDetailsServiceImpl();
                    switch (in.nextInt()) {
                        case 1:
                            surveyServiceImpl.getSurveyDetailsInput();
                            int survey_master_id = surveyServiceImpl.storeSurveyDetails();
                            List<SurveyQuestions> questionList = questionService.getSurveyQuestionsInput(survey_master_id);
                            questionService.storeSurveyQuestions(questionList);
                            break;
                        case 2:
                            surveyServiceImpl.viewAllSurvey();
                            break;
                        case 3:
                            surveyServiceImpl.deleteSurvey();
                            break;
                        case 4:
                            surveyServiceImpl.updateSurvey();
                            break;
                        case 5:
                            surveyDetailsServiceImpl.fillSurvey();
                            break;
                        case 6:
                            questionService.viewAllSurveyQuestions();
                            break;
                        case 7:
                            questionService.deleteSurveyQuestion();
                            break;
                        case 8:
                            questionService.updateSurveyQuestion();
                            break;
                        case 9:
                            surveyServiceImpl.viewAllSurvey();
                            questionService.addQuestionToExistingSurvey();
                            break;
                        case 10:
                            break;
                        case 11:
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Please select correct option");
                            break;
                    }
                    break;
                case 2:
                    System.out.println("\nSelect Operation");
                    System.out.println("1. Add Patient\n2. View Patients\n3. Delete Patient\n4. Update Patient Information\n5. Add Medical Information\n6. Delete Medical Information\n7. View Patient Medical Information\n8. Update Patient Medical Information\n9. Import Patients\n10. Exit\n11. Go Back");
                    System.out.print("Select: ");
                    patientPersonalInfoService = new PatientPersonalInformationServiceImpl();
                    patientMedicalInfoService = new PatientMedicalInformationServiceImpl();
                    switch (in.nextInt()) {
                        case 1:
                            patientPersonalInfoService.getPatientInformationInput();
                            int patient_id = patientPersonalInfoService.storePatientInformation();
                            PatientMedicalInformation patientMedicalInfo = patientMedicalInfoService.getPatientMedicalInformationInput(patient_id);
                            patientMedicalInfoService.storePatientMedicalInformation(patientMedicalInfo);
                            break;
                        case 2:
                            patientPersonalInfoService.viewAllPatients();
                            break;
                        case 3:
                            patientPersonalInfoService.deletePatient();
                            break;
                        case 4:
                            patientPersonalInfoService.updatePatientPersonalInformation();
                            break;
                        case 5:
                            patientPersonalInfoService.viewAllPatients();
                            patientMedicalInfo = patientMedicalInfoService.addMedicalInfoForExistingPatient();
                            patientMedicalInfoService.storePatientMedicalInformation(patientMedicalInfo);
                            break;
                        case 6:
                            patientPersonalInfoService.viewAllPatients();
                            patientMedicalInfoService.deleteMedicalInformation();
                            break;
                        case 7:
                            patientPersonalInfoService.viewAllPatients();
                            patientMedicalInfoService.viewPatientMedicalInformation();
                            break;
                        case 8:
                            patientPersonalInfoService.viewAllPatients();
                            patientMedicalInfoService.updatePatientMedicalInformation();
                            break;
                        case 9:
                            try {
                                patientPersonalInfoService.importPatientsFromFile();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            break;
                        case 10:
                            System.exit(0);
                            break;
                        case 11:
                            break;
                    }
                    break;
                case 3:
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please select correct option");
                    break;
            }
        }
    }
}
