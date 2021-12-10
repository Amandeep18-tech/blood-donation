package com.dalhousie.bloodDonation.service.patient;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.patient.PatientLoginInformation;

public interface PatientLoginInformationService {
    PatientLoginInformation getPatientInformation(int patient_id) throws CustomException;
    void storePatientLoginInformation(PatientLoginInformation patientLoginInfo) throws CustomException;
}
