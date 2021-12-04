package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.PatientMedicalInformation;

import java.sql.SQLException;

public interface PatientMedicalInformationRepository {
    void addPatientMedicalInformation(PatientMedicalInformation patientMedicalInfo) throws SQLException;

    void delete(int patientId) throws SQLException;

    PatientMedicalInformation getPatientMedicalInformation(int patientId) throws SQLException;

    void update(PatientMedicalInformation patientMedicalInfo) throws SQLException;
}
