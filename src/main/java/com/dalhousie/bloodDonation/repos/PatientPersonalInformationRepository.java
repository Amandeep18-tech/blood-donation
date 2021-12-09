package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.PatientPersonalInformation;

import java.sql.SQLException;
import java.util.List;

public interface PatientPersonalInformationRepository {
    int addPatient(PatientPersonalInformation patientInfo) throws CustomException;

    List<PatientPersonalInformation> getAllPatients() throws CustomException;

    void delete(int id) throws CustomException;

    PatientPersonalInformation getPatient(int id) throws CustomException;

    void update(PatientPersonalInformation patientPersonalInfo) throws CustomException;

}
