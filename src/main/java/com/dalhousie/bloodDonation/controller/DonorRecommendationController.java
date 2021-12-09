package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.service.DonorRecommendationServiceImpl;
import com.dalhousie.bloodDonation.service.PatientPersonalInformationServiceImpl;
import com.dalhousie.bloodDonation.service.SessionService;
import com.dalhousie.bloodDonation.service.SessionServiceImpl;
import com.dalhousie.bloodDonation.utils.IOUtils;

import java.util.Scanner;

public class DonorRecommendationController {
    private DonorRecommendationServiceImpl donorRecommendationService;
    private PatientPersonalInformationServiceImpl patientPersonalInformationService;
    private Scanner input;
    private final SessionService sessionService;

    public DonorRecommendationController() {
        donorRecommendationService = new DonorRecommendationServiceImpl();
        patientPersonalInformationService = new PatientPersonalInformationServiceImpl();
        input = IOUtils.getInstance();
        sessionService = new SessionServiceImpl();
    }

    public int displayRecommendedDonorsToPatient() throws CustomException {
        int patientId = Integer.parseInt(sessionService.getUserId());
        int size = donorRecommendationService.donorRecommendation(patientId);
        return size;
    }

    public void displayRecommendedDonorsToOrganization() throws CustomException {
        patientPersonalInformationService.viewAllPatients();
        System.out.println();
        System.out.print("Enter Patient ID For Whom You Want Donor Recommendation: ");
        int patientId = input.nextInt();
        System.out.println();
        donorRecommendationService.donorRecommendation(patientId);
    }
}
