package com.dalhousie.bloodDonation.service;

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
    private PatientMedicalInformation patientMedicalInfo;

    public PatientMedicalInformationServiceImpl() {
    }

    @Override
    public PatientMedicalInformation getPatientMedicalInformationInput(int patientId) {
        Scanner in = new Scanner(System.in);
        System.out.print("\n============================");
        System.out.print("\nPatient Medical Information\n");
        System.out.println("============================");
        System.out.print("\nEnter Blood Group: ");
        bloodGroup = in.nextLine();
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
        return patientMedicalInfo;
    }

    @Override
    public void storePatientMedicalInformation(PatientMedicalInformation patientMedicalInfo) throws SQLException {
        PatientMedicalInformationRepositoryImpl patientMedicalInfoDAO = new PatientMedicalInformationRepositoryImpl();
        patientMedicalInfoDAO.addPatientMedicalInformation(patientMedicalInfo);
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
    public void deleteMedicalInformation() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Patient ID To Delete Medical Information: ");
        int patientId = in.nextInt();
        PatientMedicalInformationRepositoryImpl patientMedicalInfoDAO = new PatientMedicalInformationRepositoryImpl();
        patientMedicalInfoDAO.delete(patientId);
        System.out.println("\nMedical Information For Patient ID-" + patientId + " Has Been Deleted Successfully!");
    }

    @Override
    public void viewPatientMedicalInformation() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Patient ID To View Patient's Medical Information: ");
        int patientId = in.nextInt();
        PatientMedicalInformationRepositoryImpl patientMedicalInfoDAO = new PatientMedicalInformationRepositoryImpl();
        PatientMedicalInformation patientMedicalInfo = patientMedicalInfoDAO.getPatientMedicalInformation(patientId);
        System.out.println();
        System.out.format("%5s%15s%16s%20s%22s%33s", "Patient ID", "Blood Group", "Referred By", "Priority", "Requirement Reason", "Current Location");
        System.out.println();
        System.out.format("%-14s%-16s%-23s%-12s%-35s%-35s", patientMedicalInfo.getPatientId(), patientMedicalInfo.getBloodGroup(), patientMedicalInfo.getDrReference(), patientMedicalInfo.getPriority(), patientMedicalInfo.getRequirementReason(), patientMedicalInfo.getCurrentLocation());
        System.out.println();
    }

    @Override
    public void updatePatientMedicalInformation() throws SQLException {
        Scanner in = new Scanner(System.in);
        System.out.print("\nEnter Patient ID To Update Medical Information: ");
        int patientId = in.nextInt();
        in.nextLine();
        PatientMedicalInformationRepositoryImpl patientMedicalInfoDAO = new PatientMedicalInformationRepositoryImpl();
        PatientMedicalInformation patientMedicalInfo = patientMedicalInfoDAO.getPatientMedicalInformation(patientId);
        System.out.println();
        System.out.format("%5s%15s%16s%20s%22s%33s", "Patient ID", "Blood Group", "Referred By", "Priority", "Requirement Reason", "Current Location");
        System.out.println();
        System.out.format("%-14s%-16s%-23s%-12s%-35s%-35s", patientMedicalInfo.getPatientId(), patientMedicalInfo.getBloodGroup(), patientMedicalInfo.getDrReference(), patientMedicalInfo.getPriority(), patientMedicalInfo.getRequirementReason(), patientMedicalInfo.getCurrentLocation());
        System.out.println();
        System.out.print("\nNote: Leave The Field Blank If You Do Not Want To Update");
        System.out.print("\nEnter Blood Group: ");
        bloodGroup = in.nextLine();
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
        patientMedicalInfo.setCurrentLocation(currentLocation);
        patientMedicalInfo.setDrReference(drReference);
        patientMedicalInfo.setRequirementReason(requirementReason);
        patientMedicalInfo.setPriority(priority);
        patientMedicalInfoDAO.update(patientMedicalInfo);
        System.out.println("\nMedical Information For Patient ID-" + patientId + " Has Been Updated Successfully!");
    }
}
