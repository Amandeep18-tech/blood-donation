package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.constants.UserType;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.service.SessionService;
import com.dalhousie.bloodDonation.service.SessionServiceImpl;
import com.dalhousie.bloodDonation.utils.IOUtils;

import java.util.Scanner;

public class InitController {
    private final LoginController loginController;
    private final ListSuitableDonorController listSuitableDonorController;
    private final AppointmentController appointmentController;
    private final RewardsController rewardsController;
    private final FinancialDonationController financialDonationController;
    private final SurveyController surveyController;
    private final DonorRecommendationController donorRecommendationController;
    private final PatientController patientController;
    private final OrgBloodRequestController orgBloodRequestController;
    private final DonorAppointmentController donorAppointmentController;
    private final DonorMedicalRecordController donorMedicalRecordController;
    private final SessionService sessionService;
    private final Scanner sc;

    public InitController() {
        sc = IOUtils.getInstance();
        loginController = new LoginController();
        listSuitableDonorController = new ListSuitableDonorController();
        appointmentController = new AppointmentController();
        rewardsController = new RewardsController();
        financialDonationController = new FinancialDonationController();
        surveyController = new SurveyController();
        donorRecommendationController = new DonorRecommendationController();
        patientController = new PatientController();
        orgBloodRequestController = new OrgBloodRequestController();
        donorAppointmentController = new DonorAppointmentController();
        donorMedicalRecordController = new DonorMedicalRecordController();
        sessionService = new SessionServiceImpl();
    }

    public void mainMenu() {
        int choice = 0;
        do {
            try {
                System.out.println("1.Login");
                System.out.println("2.Signup for Donor");
                System.out.println("3.Signup for Organisation");
                System.out.println("4.ForgetPassword");
                System.out.println("5.Exit");
                System.out.println("Enter your choice:-");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        loginController.loginMethod();
                        break;
                    case 2:
                        loginController.signupMethod();
                        break;
                    case 3:
                        loginController.organizationSignupMethod();
                        break;
                    case 4:
                        loginController.forgetPassword();
                        break;
                    case 5:
//                        loginController.
                        break;
                    default:
                        System.out.println("Invalid option please retry!!");
                }
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
            if(sessionService.isLoggedIn()) {
                UserType userType = sessionService.getUserType();
                if (userType == UserType.DONOR) {
                    donor();
                } else if (userType == UserType.ORGANIZATION) {
                    organization();
                } else if (userType == UserType.PATIENT) {
                    patient();
                }
            }
        } while (choice != 4);
    }

    public void donor() {
        int choice = 0;
        do {
            try {
                System.out.println("1.List of Blood Request");
                System.out.println("2.Book Medical Appointment");
                System.out.println("3.Book Blood Donation");
                System.out.println("4.Reward Management System");
                System.out.println("5.Pending Survey");
                System.out.println("6.Financial Donation");
                System.out.println("7.Logout");
                System.out.println("Enter your choice:-");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        listSuitableDonorController.patientDonorList();
                        break;
                    case 2:
                        appointmentController.bookPlace();
                        break;
                    case 3:
                        appointmentController.bookDate();
                        break;
                    case 4:
                        rewardsController.menu();
                        break;
                    case 5:
                        surveyController.displayPendingSurveyToUser();
                        break;
                    case 6:
                        financialDonationController.selectModeOfPayment();
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Invalid option please retry!!");
                }
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 4);
    }

    public void patient() {
        int choice = 0;
        do {
            try {
                System.out.println("1.List of Donor");
                System.out.println("2.List of Recommended Donor");
                System.out.println("3.Request Status");
                System.out.println("4.Pending Survey");
                System.out.println("5.Financial Donation");
                System.out.println("6.Logout");
                System.out.println("Enter your choice:-");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        listSuitableDonorController.patientDonorList();
                        break;
                    case 2:
                        donorRecommendationController.displayRecommendedDonorsToPatient();
                        break;
                    case 3:
                        //Todo
                        break;
                    case 4:
                        surveyController.displayPendingSurveyToUser();
                        break;
                    case 5:
                        financialDonationController.selectModeOfPayment();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Invalid option please retry!!");
                }
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 4);
    }

    public void organization() {
        int choice = 0;
        do {
            try {
                System.out.println("1.List of Donor");
                System.out.println("2.List of Recommended Donor");
                System.out.println("3.Survey Management System");
                System.out.println("4.Patient Creation");
                System.out.println("5.Ask for Blood Donation");
                System.out.println("6.Request Blood from other Organization");
                System.out.println("7.Pending Request from other Organization");
                System.out.println("8.List blood donated available:(sort by expiry/group by blood group)");
                System.out.println("9.Donor Medical Appointment");
                System.out.println("10.Donor Blood Donation Appointment");
                System.out.println("11.Donor Management System");
                System.out.println("12.Financial Donation");
                System.out.println("13.Logout");
                System.out.println("Enter your choice:-");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        listSuitableDonorController.organisationDonorSelection();
                        break;
                    case 2:
                        donorRecommendationController.displayRecommendedDonorsToOrganization();
                        break;
                    case 3:
                        surveyController.displaySurveyMenuForOrganization();
                        break;
                    case 4:
                        patientController.displayPatientMenuForOrganization();
                        break;
                    case 5:
                        donorAppointmentController.addPatientRequest();
                        break;
                    case 6:
                        orgBloodRequestController.requestBlood();
                        break;
                    case 7:
                        orgBloodRequestController.pendingRequest();
                        break;
                    case 8:
                        orgBloodRequestController.listBloodAvailable();
                        break;
                    case 9:
                        donorMedicalRecordController.addMedicalRecords();
                        break;
                    case 10:
                        donorAppointmentController.todayDonationConfirmation();
                        break;
                    case 11:
                        donorMedicalRecordController.editMedicalRecords();
                        break;
                    case 12: financialDonationController.selectModeOfPayment();
                        break;
                    case 13:
                        break;
                    default:
                        System.out.println("Invalid option please retry!!");
                }
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        } while (choice != 4);
    }
}
