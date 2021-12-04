package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.PatientPersonalInformation;

import java.sql.SQLException;
import java.util.List;

public interface PatientPersonalInformationRepository {
    int addPatient(PatientPersonalInformation patientInfo) throws SQLException;

    List<PatientPersonalInformation> getAllPatients() throws SQLException;

    void delete(int id) throws SQLException;

    PatientPersonalInformation getPatient(int id) throws SQLException;

    void update(PatientPersonalInformation patientPersonalInfo) throws SQLException;

}
