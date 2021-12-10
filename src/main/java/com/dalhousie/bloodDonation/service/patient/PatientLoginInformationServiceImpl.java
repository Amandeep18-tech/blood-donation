package com.dalhousie.bloodDonation.service.patient;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.patient.PatientLoginInformation;
import com.dalhousie.bloodDonation.model.patient.PatientPersonalInformation;
import com.dalhousie.bloodDonation.repos.common.UserLoginRepositoryImpl;
import com.dalhousie.bloodDonation.repos.patient.PatientLoginInformationRepository;
import com.dalhousie.bloodDonation.repos.patient.PatientLoginInformationRepositoryImpl;
import com.dalhousie.bloodDonation.repos.patient.PatientPersonalInformationRepository;
import com.dalhousie.bloodDonation.repos.patient.PatientPersonalInformationRepositoryImpl;

public class PatientLoginInformationServiceImpl implements PatientLoginInformationService {
    private final PatientLoginInformationRepositoryImpl patientLoginInformationRepository;
    private final PatientPersonalInformationRepositoryImpl patientPersonalInformationRepository;

    public PatientLoginInformationServiceImpl() {
        patientLoginInformationRepository = new PatientLoginInformationRepositoryImpl();
        patientPersonalInformationRepository = new PatientPersonalInformationRepositoryImpl();
    }

    @Override
    public PatientLoginInformation getPatientInformation(int patient_id) throws CustomException {
        PatientPersonalInformationRepository patientPersonalInfoRepo = patientPersonalInformationRepository;
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
    public void storePatientLoginInformation(PatientLoginInformation patientLoginInfo) throws CustomException {
        PatientLoginInformationRepository patientLoginInfoRepo = patientLoginInformationRepository;
        patientLoginInfoRepo.storePatientLoginInformationInDB(patientLoginInfo);
        UserLoginRepositoryImpl userLoginRepository = new UserLoginRepositoryImpl();
        userLoginRepository.storeUserLoginInformationInDB(patientLoginInfo);
        System.out.println("Patient Login Credentials Stored Successfully In Database");
    }
}
