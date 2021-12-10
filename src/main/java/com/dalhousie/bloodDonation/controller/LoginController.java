package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.Organisation;
import com.dalhousie.bloodDonation.model.Person;
import com.dalhousie.bloodDonation.model.SessionManagement;
import com.dalhousie.bloodDonation.model.User;
import com.dalhousie.bloodDonation.repos.LoginRepository;
import com.dalhousie.bloodDonation.service.LoginService;
import com.dalhousie.bloodDonation.service.LoginServiceImpl;
import com.dalhousie.bloodDonation.utils.IOUtils;
import org.mindrot.jbcrypt.BCrypt;

import java.util.Scanner;

public class LoginController {
    User user;
    private LoginService loginService;
    Organisation organisation;
    private final Scanner sc;

    public LoginController() {
        loginService = new LoginServiceImpl();
        sc = IOUtils.getInstance();
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
                sc.nextLine();
                switch (choice) {
                    case 1:
                        loginMethod();
                        break;

                    case 2:
                        signupMethod();
                        break;

                    case 3:
                        organizationSignupMethod();
                        break;
                }
            } while (choice != 4);
        } catch (CustomException e) {
            e.printStackTrace();
            throw new CustomException("Error caught while logging in");
        }
    }

    public void loginMethod() throws CustomException {
        try {
            System.out.println("Enter UserName:-");
            String userName = sc.nextLine();
            System.out.println("Enter Password");
            String password = sc.nextLine();
            loginService.userLogin(userName, password);
        } catch (Exception e) {
            throw new CustomException("Error caught while login");
        }
    }

    public void signupMethod() throws CustomException {
        try {
            System.out.println("Enter Firstname:-");
            String fname = sc.nextLine();
            System.out.println("Enter Lastname:-");
            String lname = sc.nextLine();
            System.out.println("Enter Email as username");
            String uname = sc.nextLine();
            System.out.println("Enter password:-");
            String pass = sc.nextLine();
            System.out.println("Enter your Blood Group:-");
            String bloodGroup = sc.nextLine();
            System.out.println("Enter your Contact number:-");
            String contactNo = sc.nextLine();
            System.out.println("Enter your PinCode:-");
            String pinCode = sc.nextLine();
            user = new User();
            user.setBloodGroup(bloodGroup);
            user.setFirstname(fname);
            user.setUserName(uname);
            String encpt = BCrypt.hashpw(pass, BCrypt.gensalt());
            user.setPassword(encpt);
            user.setLastname(lname);
            loginService.userSignup(user);
            loginService.addPerson(contactNo, user, pinCode);
        } catch (Exception e) {
            throw new CustomException("Error caught while signing up");
        }
    }

    public void forgetPassword() throws CustomException {
        try {
            System.out.println("Enter Email address:-");
            String email = sc.nextLine();
            loginService.forgetPass(email);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Error caught while forget password");
        }
    }

    public void organizationSignupMethod() throws CustomException {
        try {
            System.out.println("Enter organisation name");
            String oname=sc.nextLine();
            System.out.println("Enter location:-");
            String location = sc.nextLine();
            System.out.println("Organizatin type:-");
            String type = sc.nextLine();
            System.out.println("Enter Email:-");
            String email = sc.nextLine();
            System.out.println("Enter your password:-");
            String password = sc.nextLine();
            System.out.println("Enter slots available:-");
            String slots = sc.nextLine();
            System.out.println("Enter PinCode:-");
            String pinCode = sc.nextLine();
            organisation= new Organisation();
            organisation.setorganisationName(oname);
            organisation.setLocation(location);
            organisation.setorganisationType(type);
            String encpt = BCrypt.hashpw(password, BCrypt.gensalt());
            organisation.setPassword(encpt);
            organisation.setSlots_available(slots);
            organisation.setPinCode(pinCode);
            organisation.setEmail(email);
            loginService.organizationSignup(organisation);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Error caught while signing up");
        }
    }

}
