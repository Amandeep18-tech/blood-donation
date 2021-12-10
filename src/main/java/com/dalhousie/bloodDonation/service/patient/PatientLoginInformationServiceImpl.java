package com.dalhousie.bloodDonation.service.patient;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.patient.PatientLoginInformation;
import com.dalhousie.bloodDonation.model.patient.PatientPersonalInformation;
import com.dalhousie.bloodDonation.repos.common.UserLoginRepository;
import com.dalhousie.bloodDonation.repos.common.UserLoginRepositoryImpl;
import com.dalhousie.bloodDonation.repos.patient.PatientLoginInformationRepository;
import com.dalhousie.bloodDonation.repos.patient.PatientLoginInformationRepositoryImpl;
import com.dalhousie.bloodDonation.repos.patient.PatientPersonalInformationRepository;
import com.dalhousie.bloodDonation.repos.patient.PatientPersonalInformationRepositoryImpl;

public class PatientLoginInformationServiceImpl implements PatientLoginInformationService {
    private final PatientLoginInformationRepository patientLoginInformationRepository;
    private final PatientPersonalInformationRepository patientPersonalInformationRepository;
    private final UserLoginRepository userLoginRepository;

    public PatientLoginInformationServiceImpl() {
        patientLoginInformationRepository = new PatientLoginInformationRepositoryImpl();
        patientPersonalInformationRepository = new PatientPersonalInformationRepositoryImpl();
        userLoginRepository = new UserLoginRepositoryImpl();
    }

    @Override
    public PatientLoginInformation getPatientInformation(int patient_id) throws CustomException {
        PatientPersonalInformation patientPersonalInfo = patientPersonalInformationRepository.getPatient(patient_id);
        PatientLoginInformation patientLoginInfo = new PatientLoginInformation();
        patientLoginInfo.setPatientId(patientPersonalInfo.getId());
        patientLoginInfo.setPatientName(patientPersonalInfo.getPatientName());
        patientLoginInfo.setPatientEmailID(patientPersonalInfo.getEmailId());
        patientLoginInfo.setUsername(patientPersonalInfo.getEmailId());
        patientLoginInfo.setPassword(patientPersonalInfo.getContactNumber());
        return patientLoginInfo;
    }

    @Override
    public void storePatientLoginInformation(PatientLoginInformation patientLoginInfo) throws CustomException {
        patientLoginInformationRepository.storePatientLoginInformationInDB(patientLoginInfo);
        userLoginRepository.storeUserLoginInformationInDB(patientLoginInfo);
        System.out.println("Patient Login Credentials Stored Successfully In Database");
    }
}
