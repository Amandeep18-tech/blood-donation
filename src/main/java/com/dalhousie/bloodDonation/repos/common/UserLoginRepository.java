package com.dalhousie.bloodDonation.repos.common;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.patient.PatientLoginInformation;

public interface UserLoginRepository {
    void storeUserLoginInformationInDB(PatientLoginInformation patientLoginInfo) throws CustomException;
}
