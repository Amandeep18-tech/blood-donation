package com.dalhousie.bloodDonation.service.patient;

import com.dalhousie.bloodDonation.exception.CustomException;

import java.io.IOException;
import java.sql.SQLException;

public interface PatientPersonalInformationService {
    void getPatientInformationInput();

    int storePatientInformation() throws CustomException;

    void viewAllPatients() throws CustomException;

    void deletePatient() throws CustomException;

    void updatePatientPersonalInformation() throws CustomException;

    void importPatientsFromFile() throws CustomException;
}
