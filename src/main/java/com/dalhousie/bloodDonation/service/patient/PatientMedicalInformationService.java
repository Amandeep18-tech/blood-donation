package com.dalhousie.bloodDonation.service.patient;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.patient.PatientMedicalInformation;

public interface PatientMedicalInformationService {
    PatientMedicalInformation getPatientMedicalInformationInput(int patientId);

    void storePatientMedicalInformation(PatientMedicalInformation patientMedicalInfo) throws CustomException;

    PatientMedicalInformation addMedicalInfoForExistingPatient();

    void deleteMedicalInformation() throws CustomException;

    void viewPatientMedicalInformation() throws CustomException;

    void updatePatientMedicalInformation() throws CustomException;
}
