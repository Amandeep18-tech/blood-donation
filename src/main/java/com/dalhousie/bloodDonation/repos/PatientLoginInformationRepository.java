package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.PatientLoginInformation;

import java.sql.SQLException;

public interface PatientLoginInformationRepository {
    void storePatientLoginInformationInDB(PatientLoginInformation patientLoginInfo) throws SQLException;
}
