package com.dalhousie.bloodDonation.controller.patient;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.patient.PatientLoginInformation;
import com.dalhousie.bloodDonation.model.patient.PatientMedicalInformation;
import com.dalhousie.bloodDonation.service.patient.*;
import com.dalhousie.bloodDonation.utils.IOUtils;

import java.util.Scanner;

public class PatientController {
    private final Scanner input;
    private final PatientPersonalInformationService patientPersonalInfoService;
    private final PatientMedicalInformationService patientMedicalInfoService;
    private final PatientLoginInformationService patientLoginInfoService;

    public PatientController() {
        input = IOUtils.getInstance();
        patientPersonalInfoService = new PatientPersonalInformationServiceImpl();
        patientMedicalInfoService = new PatientMedicalInformationServiceImpl();
        patientLoginInfoService = new PatientLoginInformationServiceImpl();
    }

    public void displayPatientMenuForOrganization() throws CustomException {
        int choice = 0;
        do {
            System.out.println("\nPatient Menu");
            System.out.println("1. Add Patient\n2. View Patients\n3. Delete Patient\n4. Update Patient Information\n5. Add Medical Information\n6. Delete Medical Information\n7. View Patient Medical Information\n8. Update Patient Medical Information\n9. Import Patients\n10. Go Back");
            System.out.print("Select: ");
            choice = input.nextInt();
            input.nextLine();
            switch (choice) {
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
                    patientPersonalInfoService.viewAllPatients();
                    patientPersonalInfoService.deletePatient();
                    break;
                case 4:
                    patientPersonalInfoService.viewAllPatients();
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
                    patientPersonalInfoService.importPatientsFromFile();
                    break;
                case 10:
                    break;
                default:
                    System.out.println("Please Enter Valid Choice");
                    break;
            }
        } while (choice != 10);
    }
}
