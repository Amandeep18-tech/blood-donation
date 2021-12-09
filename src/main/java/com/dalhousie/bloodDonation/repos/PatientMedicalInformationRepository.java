package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.PatientMedicalInformation;

import java.sql.SQLException;

public interface PatientMedicalInformationRepository {
    void addPatientMedicalInformation(PatientMedicalInformation patientMedicalInfo) throws CustomException;

    void delete(int patientId) throws CustomException;

    PatientMedicalInformation getPatientMedicalInformation(int patientId) throws CustomException;

    void update(PatientMedicalInformation patientMedicalInfo) throws CustomException;
}
