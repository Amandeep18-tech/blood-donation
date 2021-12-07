package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.exception.CustomException;

import java.util.Scanner;

public class InitController {

    private final Scanner sc;
    private final LoginController loginController;
    private final ListSuitableDonorController listSuitableDonorController;
    private final AppointmentController appointmentController;
    private final RewardsController rewardsController;
    private final MenuController menuController;
    private final FinancialDonationController financialDonationController;

    public InitController() {
        sc = new Scanner(System.in);
        loginController = new LoginController();
        listSuitableDonorController = new ListSuitableDonorController();
        appointmentController = new AppointmentController();
        rewardsController = new RewardsController();
        menuController = new MenuController();
        financialDonationController = new FinancialDonationController();
    }

    public void mainMenu() {
        int choice = 0;
        do {
            try {
                System.out.println("1.Login");
                System.out.println("2.Signup");
                System.out.println("3.ForgetPassword");
                System.out.println("4.Exit");
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
                        loginController.forgetPassword();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid option please retry!!");
                }
            }catch (CustomException e){
                System.out.println(e.getMessage());
            }
            //Todo If login success
            donor();
            organization();
            patient();
        } while (choice != 4);
    }

    public void donor(){
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
                        menuController.displayMenu();
                        break;
                    case 6:
                        financialDonationController.selectModeOfPayment();
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Invalid option please retry!!");
                }
            }catch (CustomException e){
                System.out.println(e.getMessage());
            }
        } while (choice != 4);
    }

    public void patient(){
        int choice = 0;
        do {
            try {
                System.out.println("1.List of Donor");
                System.out.println("2.List of Recommended Donor");
                System.out.println("3.Request Status");
                System.out.println("4.Profile");
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
                        //Todo
                        break;
                    case 3:
                        //Todo
                        break;
                    case 4:
                        //Todo
                        break;
                    case 5:
                        menuController.displayMenu();
                        break;
                    case 6:
                        financialDonationController.selectModeOfPayment();
                        break;
                    case 7:
                        break;
                    default:
                        System.out.println("Invalid option please retry!!");
                }
            }catch (CustomException e){
                System.out.println(e.getMessage());
            }
        } while (choice != 4);
    }

    public void organization(){
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
                        //Todo
                        break;
                    case 3:
                        menuController.displayMenu();
                        break;
                    case 4:
                        menuController.displayMenu();
                        break;
                    case 5:
                        break;
                    case 6:
                        break;
                    case 7:
                        break;
                    case 8:
                        break;
                    case 9:
                        break;
                    case 10:
                        break;
                    case 11:
                        break;
                    case 12:
                        break;
                    default:
                        System.out.println("Invalid option please retry!!");
                }
            }catch (CustomException e){
                System.out.println(e.getMessage());
            }
        } while (choice != 4);
    }
}
