package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.Organisation;
import com.dalhousie.bloodDonation.model.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;

public interface LoginService {
    void userLogin(String userName,String password)throws Exception;
    void addPerson(String contactNo,User user);
    void organizationLogin(String userName,String password)throws Exception;
    void patientLogin(String userName,String password)throws Exception;
    void userSignup(User user) throws Exception;
    void organizationSignup(Organisation organisation) throws Exception;
    void forgetPass(String username) throws Exception;
    boolean sendVerificationEmail(User user, String otp) throws MessagingException, UnsupportedEncodingException, CustomException;
    void userLogout() throws Exception;
    boolean validateOTP(String username, String otp);
}
