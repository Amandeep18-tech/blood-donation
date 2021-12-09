package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.PatientLoginInformation;

import java.sql.SQLException;

public interface PatientLoginInformationService {
    PatientLoginInformation getPatientInformation(int patient_id) throws CustomException;
    void storePatientLoginInformation(PatientLoginInformation patientLoginInfo) throws CustomException;
}
