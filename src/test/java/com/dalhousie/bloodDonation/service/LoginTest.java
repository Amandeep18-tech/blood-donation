package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.model.User;
import com.dalhousie.bloodDonation.repos.LoginRepository;
import org.junit.jupiter.api.Test;

public class LoginTest {
   LoginRepository loginRepository = new LoginRepository();
    @Test
    void signupTest(){
        User user =  new User();
        user.setLastname("Sonawane");
        user.setFirstname("Janhavi");
        user.setBloodGroup("A+ve");
        user.setPassword("Janhavi");
        user.setUserName("janhavisonawane33@gmail.com");
        loginRepository.addUser(user);
    }

    @Test
    void loginTest(){
        String username = "janhavisonawane33@gmail.com";
        String password = "janhavi@123";
        loginRepository.checkExistingUser(username,password);
    }

    @Test
    void checkUpdatePassword() throws Exception {
        String username = "janhavisonawane33@gmail.com";
        String password = "janhavi";
        String OTP = "uthe453h";
        loginRepository.updatePass(username,password,OTP);
    }

   }
