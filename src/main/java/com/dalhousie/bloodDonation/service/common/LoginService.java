package com.dalhousie.bloodDonation.service.common;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.organisation.Organisation;
import com.dalhousie.bloodDonation.model.common.User;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

public interface LoginService {
    void userLogin(String userName,String password)throws Exception;
    void addPerson(String contactNo, User user, String pinCode);
    void organizationLogin(String userName,String password)throws Exception;
    void patientLogin(String userName,String password)throws Exception;
    void userSignup(User user) throws Exception;
    void organizationSignup(Organisation organisation) throws Exception;
    void forgetPass(String username) throws Exception;
    boolean sendVerificationEmail(User user, String otp) throws MessagingException, UnsupportedEncodingException, CustomException;
    void userLogout();
    boolean validateOTP(String username, String otp);
}
