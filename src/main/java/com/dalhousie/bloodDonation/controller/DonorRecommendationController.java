package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.service.DonorRecommendationServiceImpl;
import com.dalhousie.bloodDonation.service.PatientPersonalInformationServiceImpl;

import java.sql.SQLException;
import java.util.Scanner;

public class DonorRecommendationController {
    private DonorRecommendationServiceImpl donorRecommendationService;
    private PatientPersonalInformationServiceImpl patientPersonalInformationService;
    private Scanner input;

    public DonorRecommendationController() throws SQLException {
        donorRecommendationService = new DonorRecommendationServiceImpl();
        patientPersonalInformationService = new PatientPersonalInformationServiceImpl();
        input = new Scanner(System.in);
    }

    public int displayRecommendedDonorsToPatient() throws SQLException {
        int patientId=0;
        int size = donorRecommendationService.donorRecommendation(patientId);
        return size;
    }

    public void displayRecommendedDonorsToOrganization() throws SQLException {
        patientPersonalInformationService.viewAllPatients();
        System.out.println();
        System.out.print("Enter Patient ID For Whom You Want Donor Recommendation: ");
        int patientId = input.nextInt();
        System.out.println();
        donorRecommendationService.donorRecommendation(patientId);
    }
}
