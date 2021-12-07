package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.model.PatientMedicalInformation;
import com.dalhousie.bloodDonation.model.PatientPersonalInformation;
import com.dalhousie.bloodDonation.repos.PatientMedicalInformationRepositoryImpl;
import com.dalhousie.bloodDonation.repos.PatientPersonalInformationRepositoryImpl;

import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class PatientPersonalInformationServiceImpl implements PatientPersonalInformationService {
    private String patientName;
    private String dateOfBirth;
    private int age;
    private String address;
    private String contactNumber;
    private String emailId;

    @Override
    public void getPatientInformationInput() {
        Scanner in = new Scanner(System.in);
        System.out.print("\n=============================");
        System.out.print("\nPatient Personal Information\n");
        System.out.println("=============================");
        System.out.print("\nEnter Patient Name: ");
        patientName = in.nextLine();
        System.out.print("\nEnter Date of Birth (DD-MM-YYYY): ");
        dateOfBirth = in.nextLine();
        System.out.print("\nEnter Age: ");
        age = in.nextInt();
        in.nextLine();
        System.out.print("\nEnter Patient's Address: ");
        address = in.nextLine();
        System.out.print("\nEnter Contact Number: ");
        contactNumber = in.nextLine();
        System.out.print("\nEnter Email ID: ");
        emailId = in.nextLine();
    }

    @Override
    public int storePatientInformation() throws SQLException {
        PatientPersonalInformation patientInfo = new PatientPersonalInformation();
        patientInfo.setPatientName(patientName);
        patientInfo.setDOB(dateOfBirth);
        patientInfo.setAge(age);
        patientInfo.setAddress(address);
        patientInfo.setContactNumber(contactNumber);
        patientInfo.setEmailId(emailId);
        PatientPersonalInformationRepositoryImpl patientInfoRepo = new PatientPersonalInformationRepositoryImpl();
        return patientInfoRepo.addPatient(patientInfo);
    }

    @Override
    public void viewAllPatients() throws SQLException {
        PatientPersonalInformationRepositoryImpl patientInfoRepo = new PatientPersonalInformationRepositoryImpl();
        List<PatientPersonalInformation> patientList = patientInfoRepo.getAllPatients();
        System.out.println();
        System.out.format("%5s%8s%25s%15s%12s%36s%13s", "Patient ID", "Name", "DOB", "Age", "Email ID", "Contact Number", "Address");
        System.out.println();
        for (PatientPersonalInformation patientInfo : patientList) {
            System.out.format("%-14s%-26s%-15s%-7s%-30s%-20s%-18s", patientInfo.getId(), patientInfo.getPatientName(), patientInfo.getDOB(), patientInfo.getAge(), patientInfo.getEmailId(), patientInfo.getContactNumber(), patientInfo.getAddress());
            System.out.println();
        }
    }

    @Override
    public void deletePatient() throws SQLException {
        viewAllPatients();
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Patient ID To Delete: ");
        int id = in.nextInt();
        PatientPersonalInformationRepositoryImpl patientPersonalInfoRepo = new PatientPersonalInformationRepositoryImpl();
        patientPersonalInfoRepo.delete(id);
        System.out.println("\nPatient With ID- " + id + " Deleted Successfully!");
    }

    @Override
    public void updatePatientPersonalInformation() throws SQLException {
        viewAllPatients();
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Patient ID To Update: ");
        int id = in.nextInt();
        in.nextLine();
        PatientPersonalInformationRepositoryImpl patientPersonalInfoRepo = new PatientPersonalInformationRepositoryImpl();
        PatientPersonalInformation patientPersonalInfo = patientPersonalInfoRepo.getPatient(id);
        System.out.print("\nNote: Leave The Field Blank If You Do Not Want To Update");
        System.out.print("\nEnter Patient Name: ");
        patientName = in.nextLine();
        System.out.print("\nEnter Date of Birth (DD-MM-YYYY): ");
        dateOfBirth = in.nextLine();
        System.out.print("\nEnter Age: ");
        String ageStr = in.nextLine();
        System.out.print("\nEnter Address: ");
        address = in.nextLine();
        System.out.print("\nEnter Contact Number: ");
        contactNumber = in.nextLine();
        System.out.print("\nEnter Email ID: ");
        emailId = in.nextLine();
        if (patientName.isEmpty()) {
            patientName = patientPersonalInfo.getPatientName();
        }
        if (dateOfBirth.isEmpty()) {
            dateOfBirth = patientPersonalInfo.getDOB();
        }
        if (ageStr.isEmpty()) {
            ageStr = String.valueOf(patientPersonalInfo.getAge());
        }
        if (address.isEmpty()) {
            address = patientPersonalInfo.getAddress();
        }
        if (contactNumber.isEmpty()) {
            contactNumber = patientPersonalInfo.getContactNumber();
        }
        if (emailId.isEmpty()) {
            emailId = patientPersonalInfo.getEmailId();
        }
        patientPersonalInfo.setPatientName(patientName);
        patientPersonalInfo.setDOB(dateOfBirth);
        patientPersonalInfo.setAge(Integer.parseInt(ageStr));
        patientPersonalInfo.setAddress(address);
        patientPersonalInfo.setContactNumber(contactNumber);
        patientPersonalInfo.setEmailId(emailId);
        patientPersonalInfoRepo.update(patientPersonalInfo);
        System.out.println("\nPatient With ID- " + id + " Updated Successfully!");
    }

    @Override
    public void importPatientsFromFile() throws SQLException, IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Name Of The File From Which You Want To Import Patient Data: ");
        String fileName = in.nextLine();
        File file = new File(classloader.getResource(fileName).getFile());
        Scanner scan = new Scanner(file);
        PatientPersonalInformation patientPersonalInfo;
        PatientMedicalInformation patientMedicalInfo;
        String headers = scan.nextLine();
        List<String> headerList = Arrays.asList(headers.split(","));
        PatientPersonalInformationRepositoryImpl patientPersonalInfoRepo = new PatientPersonalInformationRepositoryImpl();
        PatientMedicalInformationRepositoryImpl patientMedicalInfoRepo = new PatientMedicalInformationRepositoryImpl();
        if (headerList.size() == 6) {
            while (scan.hasNextLine()) {
                patientPersonalInfo = new PatientPersonalInformation();
                List<String> rowValues = Arrays.asList(scan.nextLine().split(","));
                patientPersonalInfo.setPatientName(rowValues.get(0));
                patientPersonalInfo.setDOB(rowValues.get(1));
                patientPersonalInfo.setAge(Integer.parseInt(rowValues.get(2)));
                patientPersonalInfo.setAddress(rowValues.get(3));
                patientPersonalInfo.setContactNumber(rowValues.get(4));
                patientPersonalInfo.setEmailId(rowValues.get(5));
                int patientId = patientPersonalInfoRepo.addPatient(patientPersonalInfo);
                System.out.println("Personal Information For Patient With ID-" + patientId + " Imported Successfully!");
            }
        }
        if (headerList.size() == 18) {
            scan.close();
            scan = new Scanner(file);
            scan.nextLine();
            while (scan.hasNextLine()) {
                patientPersonalInfo = new PatientPersonalInformation();
                List<String> rowValues = Arrays.asList(scan.nextLine().split(","));
                patientPersonalInfo.setPatientName(rowValues.get(0));
                patientPersonalInfo.setDOB(rowValues.get(1));
                patientPersonalInfo.setAge(Integer.parseInt(rowValues.get(2)));
                patientPersonalInfo.setAddress(rowValues.get(3));
                patientPersonalInfo.setContactNumber(rowValues.get(4));
                patientPersonalInfo.setEmailId(rowValues.get(5));
                int patientId = patientPersonalInfoRepo.addPatient(patientPersonalInfo);
                patientMedicalInfo = new PatientMedicalInformation();
                patientMedicalInfo.setPatientId(patientId);
                patientMedicalInfo.setBloodGroup(rowValues.get(6));
                patientMedicalInfo.setCurrentLocation(rowValues.get(7));
                patientMedicalInfo.setDrReference(rowValues.get(8));
                patientMedicalInfo.setRequirementReason(rowValues.get(9));
                patientMedicalInfo.setPriority(rowValues.get(10));
                patientMedicalInfo.setHasHepatitisB(Integer.parseInt(rowValues.get(11)));
                patientMedicalInfo.setHasHepatitisC(Integer.parseInt(rowValues.get(12)));
                patientMedicalInfo.setHasHIV(Integer.parseInt(rowValues.get(13)));
                patientMedicalInfo.setHasHemochromatosis(Integer.parseInt(rowValues.get(14)));
                patientMedicalInfo.setHemoglobinLevel(Integer.parseInt(rowValues.get(15)));
                patientMedicalInfo.setRbcCount(Integer.parseInt(rowValues.get(14)));
                patientMedicalInfo.setPlateletCount(Integer.parseInt(rowValues.get(15)));
                patientMedicalInfoRepo.addPatientMedicalInformation(patientMedicalInfo);
                System.out.println("Complete Information For Patient With ID-" + patientId + " Imported Successfully!");
            }
        }

    }
}
