package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.User;
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
    void checkExistingPatientTest() throws CustomException {
        String userName = "janhavisonawane33@gmail.com";
        String password = "janhavi";
        boolean check = loginRepository.checkExistingUser(userName,password);
        assertEquals(check,true);
    }

}
