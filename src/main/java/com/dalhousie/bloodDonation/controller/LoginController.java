package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.SessionManagement;
import com.dalhousie.bloodDonation.model.User;
import com.dalhousie.bloodDonation.service.LoginService;
import com.dalhousie.bloodDonation.service.LoginServiceImpl;

import java.util.Scanner;

public class LoginController {
     User user;
    private LoginService loginService;

    Scanner sc = new Scanner(System.in);
    public LoginController() {
        loginService = new LoginServiceImpl();

    }
    public void menu() throws CustomException {
        try {
            int choice;
            do {
                System.out.println("1.Login");
                System.out.println("2.Signup");
                System.out.println("3.ForgetPassword");
                System.out.println("4.Get rewards");
                System.out.println("5.Exit");
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
                        forgetPassword();
                        break;
                    case 4:
                        getRewards();
                        break;

                }

            } while (choice != 5);
        }catch (CustomException e){
            throw new CustomException("Error caught while logging in");
        }
    }

    public void loginMethod() throws CustomException{
        try {
            System.out.println("Enter UserName:-");
            String userName = sc.next();
            System.out.println("Enter Password");
            String password = sc.next();
            boolean check = isloggedin(userName);
            if (check) {
                System.out.println("Welcome Again:- " + userName);
                LoginController loginController = new LoginController();
                loginController.menu();
            } else {
                loginService.userLogin(userName, password);
            }
        }catch (Exception e){
            throw new CustomException("Error caught while login");
        }
    }
    public boolean isloggedin(String userName){
        SessionManagement session = new SessionManagement();
        if(session.getSessionMap().containsKey(userName)) {
            return true;
        }
        return false;
    }
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
            user = new User();
            user.setBloodGroup(bloodGroup);
            user.setFirstname(fname);
            user.setUserName(uname);
            //String encpt=BCrypt.hashpw(pass, BCrypt.gensalt());
            user.setPassword(pass);
            user.setLastname(lname);
            loginService.userSignup(user);
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
    public void getRewards(){

    }
}
