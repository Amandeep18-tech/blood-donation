package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.PatientMedicalInformation;
import com.dalhousie.bloodDonation.repos.PatientMedicalInformationRepositoryImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class PatientMedicalInformationServiceImpl implements PatientMedicalInformationService {
    private String bloodGroup;
    private String currentLocation;
    private String drReference;
    private String requirementReason;
    private String priority;
    private String hasHepatitisB;
    private String hasHepatitisC;
    private String hasHIV;
    private String hasHemochromatosis;
    private String hemoglobinLevel;
    private String rbcCount;
    private String plateletCount;
    private PatientMedicalInformation patientMedicalInfo;

    public PatientMedicalInformationServiceImpl() {
    }

    @Override
    public PatientMedicalInformation getPatientMedicalInformationInput(int patientId) {
        Scanner in = new Scanner(System.in);
        System.out.print("\n============================");
        System.out.print("\nPatient Medical Information\n");
        System.out.println("============================");
        System.out.println("\nSelect Blood Group: ");
        System.out.println("1. A+ve");
        System.out.println("2. A-ve");
        System.out.println("3. B+ve");
        System.out.println("4. B-ve");
        System.out.println("5. AB+ve");
        System.out.println("6. AB-ve");
        System.out.println("7. O+ve");
        System.out.println("8. O-ve");
        System.out.print("Select: ");
        int bloodGroupSelected = in.nextInt();
        in.nextLine();
        if (bloodGroupSelected == 1) {
            bloodGroup = BloodGroup.APos.toString();
        } else if (bloodGroupSelected == 2) {
            bloodGroup = BloodGroup.ANeg.toString();
        } else if (bloodGroupSelected == 3) {
            bloodGroup = BloodGroup.BPos.toString();
        } else if (bloodGroupSelected == 4) {
            bloodGroup = BloodGroup.BNeg.toString();
        } else if (bloodGroupSelected == 5) {
            bloodGroup = BloodGroup.ABPos.toString();
        } else if (bloodGroupSelected == 6) {
            bloodGroup = BloodGroup.ABNeg.toString();
        } else if (bloodGroupSelected == 7) {
            bloodGroup = BloodGroup.OPos.toString();
        } else if (bloodGroupSelected == 8) {
            bloodGroup = BloodGroup.ONeg.toString();
        } else {
            System.out.println("Invalid Option. Please retry");
        }
        System.out.println("\nDoes The Patient Has Hepatitis B?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select: ");
        hasHepatitisB = in.nextLine();
        if (hasHepatitisB.equals("1")) {
            hasHepatitisB = "1";
        } else if (hasHepatitisB.equals("2")) {
            hasHepatitisB = "0";
        } else {
            System.out.println("Invalid Choice! Please Retry");
        }
        System.out.println("\nDoes The Patient Has Hepatitis C?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select: ");
        hasHepatitisC = in.nextLine();
        if (hasHepatitisC.equals("1")) {
            hasHepatitisC = "1";
        } else if (hasHepatitisC.equals("2")) {
            hasHepatitisC = "0";
        } else {
            System.out.println("Invalid Choice! Please Retry");
        }
        System.out.println("\nDoes The Patient Has HIV?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select: ");
        hasHIV = in.nextLine();
        if (hasHIV.equals("1")) {
            hasHIV = "1";
        } else if (hasHIV.equals("2")) {
            hasHIV = "0";
        } else {
            System.out.println("Invalid Choice! Please Retry");
        }
        System.out.println("\nDoes The Patient Has Hemochromatosis?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select: ");
        hasHemochromatosis = in.nextLine();
        if (hasHemochromatosis.equals("1")) {
            hasHemochromatosis = "1";
        } else if (hasHemochromatosis.equals("2")) {
            hasHemochromatosis = "0";
        } else {
            System.out.println("Invalid Choice! Please Retry");
        }
        System.out.print("\nEnter Hemoglobin Level: ");
        hemoglobinLevel = in.nextLine();
        System.out.print("\nEnter RBC Count: ");
        rbcCount = in.nextLine();
        System.out.print("\nEnter Platelet Count: ");
        plateletCount = in.nextLine();
        System.out.print("\nEnter Current Location: ");
        currentLocation = in.nextLine();
        System.out.print("\nReferred By: ");
        drReference = in.nextLine();
        System.out.print("\nEnter Reason For The Donation Requirement: ");
        requirementReason = in.nextLine();
        System.out.print("\nEnter Patient Priority (High-Required Immediately, Medium-Required Between 12 HRS To 2 Days, Low-After 2 Days) : ");
        priority = in.nextLine();

        patientMedicalInfo = new PatientMedicalInformation();
        patientMedicalInfo.setPatientId(patientId);
        patientMedicalInfo.setBloodGroup(bloodGroup);
        patientMedicalInfo.setCurrentLocation(currentLocation);
        patientMedicalInfo.setDrReference(drReference);
        patientMedicalInfo.setRequirementReason(requirementReason);
        patientMedicalInfo.setPriority(priority);
        patientMedicalInfo.setHasHepatitisB(Integer.parseInt(hasHepatitisB));
        patientMedicalInfo.setHasHepatitisC(Integer.parseInt(hasHepatitisC));
        patientMedicalInfo.setHasHIV(Integer.parseInt(hasHIV));
        patientMedicalInfo.setHasHemochromatosis(Integer.parseInt(hasHemochromatosis));
        patientMedicalInfo.setHemoglobinLevel(Integer.parseInt(hemoglobinLevel));
        patientMedicalInfo.setRbcCount(Integer.parseInt(rbcCount));
        patientMedicalInfo.setPlateletCount(Integer.parseInt(plateletCount));
        return patientMedicalInfo;
    }

    @Override
    public void storePatientMedicalInformation(PatientMedicalInformation patientMedicalInfo) throws CustomException {
        PatientMedicalInformationRepositoryImpl patientMedicalInfoRepo = new PatientMedicalInformationRepositoryImpl();
        patientMedicalInfoRepo.addPatientMedicalInformation(patientMedicalInfo);
        System.out.println("\nPatient Added Successfully!");
    }

    @Override
    public PatientMedicalInformation addMedicalInfoForExistingPatient() {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Patient ID To Add Medical Information: ");
        int patientId = in.nextInt();
        return getPatientMedicalInformationInput(patientId);
    }

    @Override
    public void deleteMedicalInformation() throws CustomException {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Patient ID To Delete Medical Information: ");
        int patientId = in.nextInt();
        PatientMedicalInformationRepositoryImpl patientMedicalInfoRepo = new PatientMedicalInformationRepositoryImpl();
        patientMedicalInfoRepo.delete(patientId);
        System.out.println("\nMedical Information For Patient ID-" + patientId + " Has Been Deleted Successfully!");
    }

    @Override
    public void viewPatientMedicalInformation() throws CustomException {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Patient ID To View Patient's Medical Information: ");
        int patientId = in.nextInt();
        PatientMedicalInformationRepositoryImpl patientMedicalInfoRepo = new PatientMedicalInformationRepositoryImpl();
        PatientMedicalInformation patientMedicalInfo = patientMedicalInfoRepo.getPatientMedicalInformation(patientId);

        if (patientMedicalInfo.getHasHepatitisB() == 1) {
            hasHepatitisB = "Yes";
        } else if (patientMedicalInfo.getHasHepatitisB() == 0) {
            hasHepatitisB = "No";
        }
        if (patientMedicalInfo.getHasHepatitisC() == 1) {
            hasHepatitisC = "Yes";
        } else if (patientMedicalInfo.getHasHepatitisC() == 0) {
            hasHepatitisC = "No";
        }
        if (patientMedicalInfo.getHasHIV() == 1) {
            hasHIV = "Yes";
        } else if (patientMedicalInfo.getHasHIV() == 0) {
            hasHIV = "No";
        }
        if (patientMedicalInfo.getHasHemochromatosis() == 1) {
            hasHemochromatosis = "Yes";
        } else if (patientMedicalInfo.getHasHemochromatosis() == 0) {
            hasHemochromatosis = "No";
        }
        System.out.println();
        System.out.format("%5s%15s%15s%15s%10s%20s%15s%15s%20s%15s%20s%22s%33s", "Patient ID", "Blood Group", "HepatitisB", "HepatitisC", "HIV", "Hemochromatosis", "Hemoglobin", "RBC Count", "Platelets Count", "Referred By", "Priority", "Requirement Reason", "Current Location");
        System.out.println();
        System.out.format("%-14s%-16s%-15s%-17s%-8s%-20s%-16s%-14s%-19s%-23s%-12s%-35s%-35s", patientMedicalInfo.getPatientId(), patientMedicalInfo.getBloodGroup(), patientMedicalInfo.getHasHepatitisB(), patientMedicalInfo.getHasHepatitisC(), patientMedicalInfo.getHasHIV(), patientMedicalInfo.getHasHemochromatosis(), patientMedicalInfo.getHemoglobinLevel(), patientMedicalInfo.getRbcCount(), patientMedicalInfo.getPlateletCount(), patientMedicalInfo.getDrReference(), patientMedicalInfo.getPriority(), patientMedicalInfo.getRequirementReason(), patientMedicalInfo.getCurrentLocation());
        System.out.println();
    }

    @Override
    public void updatePatientMedicalInformation() throws CustomException {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Patient ID To Update Medical Information: ");
        int patientId = in.nextInt();
        in.nextLine();
        PatientMedicalInformationRepositoryImpl patientMedicalInfoRepo = new PatientMedicalInformationRepositoryImpl();
        PatientMedicalInformation patientMedicalInfo = patientMedicalInfoRepo.getPatientMedicalInformation(patientId);
        System.out.println();
        System.out.format("%5s%15s%15s%15s%10s%20s%15s%15s%20s%15s%20s%22s%33s", "Patient ID", "Blood Group", "HepatitisB", "HepatitisC", "HIV", "Hemochromatosis", "Hemoglobin", "RBC Count", "Platelets Count", "Referred By", "Priority", "Requirement Reason", "Current Location");
        System.out.println();
        System.out.format("%-14s%-16s%-15s%-17s%-8s%-20s%-16s%-14s%-19s%-23s%-12s%-35s%-35s", patientMedicalInfo.getPatientId(), patientMedicalInfo.getBloodGroup(), patientMedicalInfo.getHasHepatitisB(), patientMedicalInfo.getHasHepatitisC(), patientMedicalInfo.getHasHIV(), patientMedicalInfo.getHasHemochromatosis(), patientMedicalInfo.getHemoglobinLevel(), patientMedicalInfo.getRbcCount(), patientMedicalInfo.getPlateletCount(), patientMedicalInfo.getDrReference(), patientMedicalInfo.getPriority(), patientMedicalInfo.getRequirementReason(), patientMedicalInfo.getCurrentLocation());
        System.out.println();
        System.out.print("\nNote: Leave The Field Blank If You Do Not Want To Update");
        System.out.println("\nSelect Blood Group: ");
        System.out.println("1. A+ve");
        System.out.println("2. A-ve");
        System.out.println("3. B+ve");
        System.out.println("4. B-ve");
        System.out.println("5. AB+ve");
        System.out.println("6. AB-ve");
        System.out.println("7. O+ve");
        System.out.println("8. O-ve");
        System.out.print("Select: ");
        int bloodGroupSelected = in.nextInt();
        in.nextLine();
        if (bloodGroupSelected == 1) {
            bloodGroup = BloodGroup.APos.toString();
        } else if (bloodGroupSelected == 2) {
            bloodGroup = BloodGroup.ANeg.toString();
        } else if (bloodGroupSelected == 3) {
            bloodGroup = BloodGroup.BPos.toString();
        } else if (bloodGroupSelected == 4) {
            bloodGroup = BloodGroup.BNeg.toString();
        } else if (bloodGroupSelected == 5) {
            bloodGroup = BloodGroup.ABPos.toString();
        } else if (bloodGroupSelected == 6) {
            bloodGroup = BloodGroup.ABNeg.toString();
        } else if (bloodGroupSelected == 7) {
            bloodGroup = BloodGroup.OPos.toString();
        } else if (bloodGroupSelected == 8) {
            bloodGroup = BloodGroup.ONeg.toString();
        } else {
            System.out.println("Invalid Option. Please retry");
        }
        System.out.println("\nDoes The Patient Has Hepatitis B?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select: ");
        hasHepatitisB = in.nextLine();
        if (hasHepatitisB.equals("1")) {
            hasHepatitisB = "1";
        } else if (hasHepatitisB.equals("2")) {
            hasHepatitisB = "0";
        } else {
            System.out.println("Invalid Choice! Please Retry");
        }
        System.out.println("\nDoes The Patient Has Hepatitis C?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select: ");
        hasHepatitisC = in.nextLine();
        if (hasHepatitisC.equals("1")) {
            hasHepatitisC = "1";
        } else if (hasHepatitisC.equals("2")) {
            hasHepatitisC = "0";
        } else {
            System.out.println("Invalid Choice! Please Retry");
        }
        System.out.println("\nDoes The Patient Has HIV?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select: ");
        hasHIV = in.nextLine();
        if (hasHIV.equals("1")) {
            hasHIV = "1";
        } else if (hasHIV.equals("2")) {
            hasHIV = "0";
        } else {
            System.out.println("Invalid Choice! Please Retry");
        }
        System.out.println("\nDoes The Patient Has Hemochromatosis?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select: ");
        hasHemochromatosis = in.nextLine();
        if (hasHemochromatosis.equals("1")) {
            hasHemochromatosis = "1";
        } else if (hasHemochromatosis.equals("2")) {
            hasHemochromatosis = "0";
        } else {
            System.out.println("Invalid Choice! Please Retry");
        }
        System.out.print("\nEnter Hemoglobin Level: ");
        hemoglobinLevel = in.nextLine();
        System.out.print("\nEnter RBC Count: ");
        rbcCount = in.nextLine();
        System.out.print("\nEnter Platelet Count: ");
        plateletCount = in.nextLine();
        System.out.print("\nEnter Current Location: ");
        currentLocation = in.nextLine();
        System.out.print("\nReferred By: ");
        drReference = in.nextLine();
        System.out.print("\nEnter Reason For The Donation Requirement: ");
        requirementReason = in.nextLine();
        System.out.print("\nEnter Patient Priority (High-Required Immediately, Medium-Required Between 12 HRS To 2 Days, Low-After 2 Days): ");
        priority = in.nextLine();
        if (bloodGroup.isEmpty()) {
            bloodGroup = patientMedicalInfo.getBloodGroup();
        }
        if (hasHepatitisB.isEmpty()) {
            hasHepatitisB = String.valueOf(patientMedicalInfo.getHasHepatitisB());
        }
        if (hasHepatitisC.isEmpty()) {
            hasHepatitisC = String.valueOf(patientMedicalInfo.getHasHepatitisC());
        }
        if (hasHIV.isEmpty()) {
            hasHIV = String.valueOf(patientMedicalInfo.getHasHIV());
        }
        if (hasHemochromatosis.isEmpty()) {
            hasHemochromatosis = String.valueOf(patientMedicalInfo.getHasHemochromatosis());
        }
        if (hemoglobinLevel.isEmpty()) {
            hemoglobinLevel = String.valueOf(patientMedicalInfo.getHemoglobinLevel());
        }
        if (rbcCount.isEmpty()) {
            rbcCount = String.valueOf(patientMedicalInfo.getRbcCount());
        }
        if (plateletCount.isEmpty()) {
            plateletCount = String.valueOf(patientMedicalInfo.getPlateletCount());
        }
        if (currentLocation.isEmpty()) {
            currentLocation = patientMedicalInfo.getCurrentLocation();
        }
        if (drReference.isEmpty()) {
            drReference = patientMedicalInfo.getDrReference();
        }
        if (requirementReason.isEmpty()) {
            requirementReason = patientMedicalInfo.getRequirementReason();
        }
        if (priority.isEmpty()) {
            priority = patientMedicalInfo.getPriority();
        }
        patientMedicalInfo.setBloodGroup(bloodGroup);
        patientMedicalInfo.setHasHepatitisB(Integer.parseInt(hasHepatitisB));
        patientMedicalInfo.setHasHepatitisC(Integer.parseInt(hasHepatitisC));
        patientMedicalInfo.setHasHIV(Integer.parseInt(hasHIV));
        patientMedicalInfo.setHasHemochromatosis(Integer.parseInt(hasHemochromatosis));
        patientMedicalInfo.setHemoglobinLevel(Integer.parseInt(hemoglobinLevel));
        patientMedicalInfo.setRbcCount(Integer.parseInt(rbcCount));
        patientMedicalInfo.setPlateletCount(Integer.parseInt(plateletCount));
        patientMedicalInfo.setCurrentLocation(currentLocation);
        patientMedicalInfo.setDrReference(drReference);
        patientMedicalInfo.setRequirementReason(requirementReason);
        patientMedicalInfo.setPriority(priority);
        patientMedicalInfoRepo.update(patientMedicalInfo);
        System.out.println("\nMedical Information For Patient ID-" + patientId + " Has Been Updated Successfully!");
    }
}
