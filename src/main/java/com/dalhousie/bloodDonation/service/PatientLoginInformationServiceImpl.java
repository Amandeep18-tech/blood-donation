package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.model.PatientLoginInformation;
import com.dalhousie.bloodDonation.model.PatientPersonalInformation;
import com.dalhousie.bloodDonation.repos.PatientLoginInformationRepositoryImpl;
import com.dalhousie.bloodDonation.repos.PatientPersonalInformationRepositoryImpl;
import com.dalhousie.bloodDonation.repos.UserLoginRepositoryImpl;

import java.sql.SQLException;

public class PatientLoginInformationServiceImpl implements PatientLoginInformationService {
    @Override
    public PatientLoginInformation getPatientInformation(int patient_id) throws SQLException {
        PatientPersonalInformationRepositoryImpl patientPersonalInfoRepo = new PatientPersonalInformationRepositoryImpl();
        PatientPersonalInformation patientPersonalInfo = patientPersonalInfoRepo.getPatient(patient_id);
        PatientLoginInformation patientLoginInfo = new PatientLoginInformation();
        patientLoginInfo.setPatientId(patientPersonalInfo.getId());
        patientLoginInfo.setPatientName(patientPersonalInfo.getPatientName());
        patientLoginInfo.setPatientEmailID(patientPersonalInfo.getEmailId());
        patientLoginInfo.setUsername(patientPersonalInfo.getEmailId());
        patientLoginInfo.setPassword(patientPersonalInfo.getContactNumber());
        return patientLoginInfo;
    }

    @Override
    public void storePatientLoginInformation(PatientLoginInformation patientLoginInfo) throws SQLException {
        PatientLoginInformationRepositoryImpl patientLoginInfoRepo = new PatientLoginInformationRepositoryImpl();
        patientLoginInfoRepo.storePatientLoginInformationInDB(patientLoginInfo);
        UserLoginRepositoryImpl userLoginRepository = new UserLoginRepositoryImpl();
        userLoginRepository.storeUserLoginInformationInDB(patientLoginInfo);
        System.out.println("Patient Login Credentials Stored Successfully In Database");
    }
}
