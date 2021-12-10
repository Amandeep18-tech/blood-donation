package com.dalhousie.bloodDonation.repos.patient;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.patient.PatientMedicalInformation;

public interface PatientMedicalInformationRepository {
    void addPatientMedicalInformation(PatientMedicalInformation patientMedicalInfo) throws CustomException;

    void delete(int patientId) throws CustomException;

    PatientMedicalInformation getPatientMedicalInformation(int patientId) throws CustomException;

    void update(PatientMedicalInformation patientMedicalInfo) throws CustomException;
}
