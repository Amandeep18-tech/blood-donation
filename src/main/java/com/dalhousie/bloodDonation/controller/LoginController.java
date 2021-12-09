package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.Organisation;
import com.dalhousie.bloodDonation.model.Person;
import com.dalhousie.bloodDonation.model.SessionManagement;
import com.dalhousie.bloodDonation.model.User;
import com.dalhousie.bloodDonation.service.LoginService;
import com.dalhousie.bloodDonation.service.LoginServiceImpl;

import java.util.Scanner;

public class LoginController {
     User user;
     Person person;
    private LoginService loginService;
    Organisation organisation;
    Scanner sc = new Scanner(System.in);
    public LoginController() {
        loginService = new LoginServiceImpl();

    }
    public void menu() throws CustomException {
        try {
            int choice;
            do {
                System.out.println("1.Login");
                System.out.println("2.Signup for organisation:-");
                System.out.println("3.Signup for Donor:-");
                System.out.println("4.ForgetPassword");
                System.out.println("5.Get rewards");
                System.out.println("6.Exit");
                System.out.println("Enter your choice:-");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        loginMethod();
                        break;

                    case 2:
                        signupMethod();
                        break;

                    case 3:
                        //forgetPassword();
                        organizationSignupMethod();
                        break;


                }

            } while (choice != 4);
        }catch (CustomException e){
            e.printStackTrace();
            throw new CustomException("Error caught while logging in");
        }
    }

    public void loginMethod() throws CustomException{
        try {
            System.out.println("Enter UserName:-");
            String userName = sc.next();
            System.out.println("Enter Password");
            String password = sc.next();
            //boolean check = isloggedin(userName);
            //if (check) {
                System.out.println("Welcome Again:- " + userName);
                LoginController loginController = new LoginController();
                loginController.menu();
            //} else {
                loginService.userLogin(userName, password);
            //}
        }catch (Exception e){
            throw new CustomException("Error caught while login");
        }
    }
//    public boolean isloggedin(String userName){
////        SessionManagement session = new SessionManagement();
////      //  if(session.getUserId() ==  || session.getPatientId()) {
////            return true;
////        }
////        //return false;
//    }
    public void signupMethod() throws CustomException{
        try {
            System.out.println("Enter Firstname:-");
            String fname = sc.next();
            System.out.println("Enter Lastname:-");
            String lname = sc.next();
            System.out.println("Enter Email as username");
            String uname = sc.next();
            System.out.println("Enter password:-");
            String pass = sc.next();
            System.out.println("Enter your Blood Group:-");
            String bloodGroup = sc.next();
            System.out.println("Enter your Contact number:-");
            String contactNo = sc.next();
            System.out.println("Enter your PinCode:-");
            String pinCode = sc.next();
            user = new User();
            user.setBloodGroup(bloodGroup);
            user.setFirstname(fname);
            user.setUserName(uname);
            //String encpt=BCrypt.hashpw(pass, BCrypt.gensalt());
            user.setPassword(pass);
            user.setLastname(lname);
            loginService.userSignup(user);
            loginService.addPerson(contactNo,user,pinCode);
        }catch (Exception e){
            throw new CustomException("Error caught while signing up");
        }
    }
    public void forgetPassword() throws CustomException {
        try {
            System.out.println("Enter Email address:-");
            String email = sc.next();
            loginService.forgetPass(email);
        }catch (Exception e){
            throw new CustomException("Error caught while forget password");
        }
    }
//    public void organizationLogin() throws CustomException{
//        try {
//            System.out.println("Enter UserName:-");
//            String userName = sc.next();
//            System.out.println("Enter Password");
//            String password = sc.next();
////            boolean check = isloggedin(userName);
////            if (check) {
//                System.out.println("Welcome Again:- " + userName);
//                LoginController loginController = new LoginController();
//                loginController.menu();
////            } else {
//                loginService.organizationLogin(userName, password);
//          //  }
//        }catch (Exception e){
//            throw new CustomException("Error caught while login");
//        }
//    }
    public void organizationSignupMethod() throws CustomException{
        try {
            System.out.println("Enter organisation name");
            String oname=sc.next();
            System.out.println("Enter location:-");
            String location = sc.next();
            System.out.println("Organizatin type:-");
            String type = sc.next();
            System.out.println("Enter Email:-");
            String email = sc.next();
            System.out.println("Enter your password:-");
            String password = sc.next();
            System.out.println("Enter slots available:-");
            String slots = sc.next();
            System.out.println("Enter PinCode:-");
            String pinCode = sc.next();
            organisation= new Organisation();
            organisation.setorganisationName(oname);
            organisation.setLocation(location);
            organisation.setorganisationType(type);
            organisation.setPassword(password);
            organisation.setSlots_available(slots);
            organisation.setPinCode(pinCode);
            organisation.setEmail(email);
            loginService.organizationSignup(organisation);
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException("Error caught while signing up");
        }
    }

}
