package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.model.PatientMedicalInformation;

import java.sql.SQLException;

public interface PatientMedicalInformationService {
    PatientMedicalInformation getPatientMedicalInformationInput(int patientId);

    void storePatientMedicalInformation(PatientMedicalInformation patientMedicalInfo) throws SQLException;

    PatientMedicalInformation addMedicalInfoForExistingPatient() throws SQLException;

    void deleteMedicalInformation() throws SQLException;

    void viewPatientMedicalInformation() throws SQLException;

    void updatePatientMedicalInformation() throws SQLException;
}
