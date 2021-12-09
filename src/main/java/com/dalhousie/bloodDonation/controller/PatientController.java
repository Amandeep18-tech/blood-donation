package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.model.PatientLoginInformation;
import com.dalhousie.bloodDonation.model.PatientMedicalInformation;
import com.dalhousie.bloodDonation.service.PatientLoginInformationServiceImpl;
import com.dalhousie.bloodDonation.service.PatientMedicalInformationServiceImpl;
import com.dalhousie.bloodDonation.service.PatientPersonalInformationServiceImpl;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class PatientController {
    private final Scanner input;
    private final PatientPersonalInformationServiceImpl patientPersonalInfoService;
    private final PatientMedicalInformationServiceImpl patientMedicalInfoService;
    private final PatientLoginInformationServiceImpl patientLoginInfoService;

    public PatientController() {
        input = new Scanner(System.in);
        patientPersonalInfoService = new PatientPersonalInformationServiceImpl();
        patientMedicalInfoService = new PatientMedicalInformationServiceImpl();
        patientLoginInfoService = new PatientLoginInformationServiceImpl();
    }

    public void displayPatientMenuForOrganization() throws SQLException {
        System.out.println("\nPatient Menu");
        System.out.println("1. Add Patient\n2. View Patients\n3. Delete Patient\n4. Update Patient Information\n5. Add Medical Information\n6. Delete Medical Information\n7. View Patient Medical Information\n8. Update Patient Medical Information\n9. Import Patients\n10. Go Back\n11. Exit");
        System.out.print("Select: ");
        switch (input.nextInt()) {
            case 1:
                patientPersonalInfoService.getPatientInformationInput();
                int patient_id = patientPersonalInfoService.storePatientInformation();
                PatientLoginInformation patientLoginInfo = patientLoginInfoService.getPatientInformation(patient_id);
                patientLoginInfoService.storePatientLoginInformation(patientLoginInfo);
                PatientMedicalInformation patientMedicalInfo = patientMedicalInfoService.getPatientMedicalInformationInput(patient_id);
                patientMedicalInfoService.storePatientMedicalInformation(patientMedicalInfo);
                break;
            case 2:
                patientPersonalInfoService.viewAllPatients();
                break;
            case 3:
                patientPersonalInfoService.deletePatient();
                break;
            case 4:
                patientPersonalInfoService.updatePatientPersonalInformation();
                break;
            case 5:
                patientPersonalInfoService.viewAllPatients();
                patientMedicalInfo = patientMedicalInfoService.addMedicalInfoForExistingPatient();
                patientMedicalInfoService.storePatientMedicalInformation(patientMedicalInfo);
                break;
            case 6:
                patientPersonalInfoService.viewAllPatients();
                patientMedicalInfoService.deleteMedicalInformation();
                break;
            case 7:
                patientPersonalInfoService.viewAllPatients();
                patientMedicalInfoService.viewPatientMedicalInformation();
                break;
            case 8:
                patientPersonalInfoService.viewAllPatients();
                patientMedicalInfoService.updatePatientMedicalInformation();
                break;
            case 9:
                try {
                    patientPersonalInfoService.importPatientsFromFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 10:
                break;
            case 11:
                System.exit(0);
                break;
        }
    }
}
