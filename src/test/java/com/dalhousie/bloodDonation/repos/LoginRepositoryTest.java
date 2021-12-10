package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.repos.common.LoginRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class LoginRepositoryTest {
    LoginRepository loginRepository = new LoginRepository();
    @Test
    void checkExistingUserTest() throws CustomException {
        String userName = "janhavisonawane33@gmail.com";
        String password =  "janhavi";
        boolean check = loginRepository.checkExistingUser(userName,password);
        assertEquals(check,true);
    }
    @Test
    @Disabled
    void checkExistingPatientTest() throws CustomException {
        String userName = "janhavisonawane33@gmail.com";
        String password = "janhavi";
        boolean check = loginRepository.checkExistingUser(userName,password);
        assertFalse(check);
    }

    @Test
    void checkExistingOrgansation()throws CustomException{
        String userName = "janhavisonawane33@gmail.com";
        String pass = "janhavi";
        boolean check = loginRepository.checkExistingOrgansation(userName,pass);
        assertFalse(check);
    }
    @Test
    void addUser(){
        String userName = "tanvisonawane11@gmil.com";
        String pass = "abc";

    }
}
