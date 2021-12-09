package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.PatientLoginInformation;

import java.sql.SQLException;

public interface UserLoginRepository {
    void storeUserLoginInformationInDB(PatientLoginInformation patientLoginInfo) throws CustomException;
}
