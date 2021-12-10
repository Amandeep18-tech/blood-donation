package com.dalhousie.bloodDonation.controller.donor;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.service.common.SessionService;
import com.dalhousie.bloodDonation.service.common.SessionServiceImpl;
import com.dalhousie.bloodDonation.service.donor.DonorRecommendationService;
import com.dalhousie.bloodDonation.service.donor.DonorRecommendationServiceImpl;
import com.dalhousie.bloodDonation.service.patient.PatientPersonalInformationService;
import com.dalhousie.bloodDonation.service.patient.PatientPersonalInformationServiceImpl;
import com.dalhousie.bloodDonation.utils.IOUtils;

import java.util.Scanner;

public class DonorRecommendationController {
    private final DonorRecommendationService donorRecommendationService;
    private final PatientPersonalInformationService patientPersonalInformationService;
    private final Scanner input;
    private final SessionService sessionService;

    public DonorRecommendationController() {
        donorRecommendationService = new DonorRecommendationServiceImpl();
        patientPersonalInformationService = new PatientPersonalInformationServiceImpl();
        input = IOUtils.getInstance();
        sessionService = new SessionServiceImpl();
    }

    public void displayRecommendedDonorsToPatient() throws CustomException {
        int patientId = Integer.parseInt(sessionService.getUserId());
        donorRecommendationService.donorRecommendation(patientId);
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
