package com.dalhousie.bloodDonation.repos.patient;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.patient.PatientLoginInformation;

public interface PatientLoginInformationRepository {
    void storePatientLoginInformationInDB(PatientLoginInformation patientLoginInfo) throws CustomException;
}
