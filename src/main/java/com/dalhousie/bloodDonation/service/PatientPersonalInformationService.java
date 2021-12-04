package com.dalhousie.bloodDonation.service;

import java.io.IOException;
import java.sql.SQLException;

public interface PatientPersonalInformationService {
    void getPatientInformationInput();

    int storePatientInformation() throws SQLException;

    void viewAllPatients() throws SQLException;

    void deletePatient() throws SQLException;

    void updatePatientPersonalInformation() throws SQLException;

    void importPatientsFromFile() throws SQLException, IOException;
}
