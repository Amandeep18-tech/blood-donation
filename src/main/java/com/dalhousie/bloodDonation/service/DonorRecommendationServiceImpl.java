package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.model.DonorInformation;
import com.dalhousie.bloodDonation.model.PatientMedicalInformation;
import com.dalhousie.bloodDonation.repos.DonorMedicalInformationRepositoryImpl;
import com.dalhousie.bloodDonation.repos.DonorPersonalInformationRepositoryImpl;
import com.dalhousie.bloodDonation.repos.PatientMedicalInformationRepositoryImpl;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class DonorRecommendationServiceImpl implements DonorRecommendationService {
    private final PatientMedicalInformationRepositoryImpl patientMedicalInfoRepo;
    private final DonorPersonalInformationRepositoryImpl donorPersonalInfoRepo;
    private final DonorMedicalInformationRepositoryImpl donorMedicalInfoRepo;
    private final CalculateDonorMatchingPercentageServiceImpl donorMatchingPercentage;

    public DonorRecommendationServiceImpl() throws SQLException {
        patientMedicalInfoRepo = new PatientMedicalInformationRepositoryImpl();
        donorPersonalInfoRepo = new DonorPersonalInformationRepositoryImpl();
        donorMedicalInfoRepo = new DonorMedicalInformationRepositoryImpl();
        donorMatchingPercentage = new CalculateDonorMatchingPercentageServiceImpl();
    }

    @Override
    public int donorRecommendation(int patientId) throws SQLException {
        PatientMedicalInformation patientMedicalInfo = patientMedicalInfoRepo.getPatientMedicalInformation(patientId);
        List<DonorInformation> donorListByMatchedBloodGroup = donorPersonalInfoRepo.getAllMatchingBloodTypeDonors(patientMedicalInfo.getBloodGroup());
        List<DonorInformation> completeDonorInfo = new ArrayList<>();
        for (DonorInformation donorInformation : donorListByMatchedBloodGroup) {
            completeDonorInfo.add(donorMedicalInfoRepo.getMatchingBloodTypeDonorMedicalInformation(donorInformation));
        }
        List<DonorInformation> filteredDonorListWithoutDisease = new ArrayList<>();
        for (DonorInformation donorInformation : completeDonorInfo) {
            if (donorInformation.getHasHepatitisB() == 0 && donorInformation.getHasHepatitisC() == 0 && donorInformation.getHasHIV() == 0 && donorInformation.getHasHemochromatosis() == 0) {
                filteredDonorListWithoutDisease.add(donorInformation);
            }
        }
        List<DonorInformation> donorListWithParameterDifference = new ArrayList<>();
        for (DonorInformation donorInformation : filteredDonorListWithoutDisease) {
            DecimalFormat df = new DecimalFormat("##.##");
            Double patientHemoglobin = Double.valueOf(df.format(patientMedicalInfo.getHemoglobinLevel()));
            Double donorHemoglobin = Double.valueOf(df.format(donorInformation.getHemoglobinLevel() / 10));
            List<Double> hemoglobinLevelValues = new ArrayList<>() {{
                add(patientHemoglobin);
                add(donorHemoglobin);
            }};
            Double hemoglobinLevelDifference = Collections.max(hemoglobinLevelValues) - Collections.min(hemoglobinLevelValues);

            int patientRbcCount = patientMedicalInfo.getRbcCount();
            int donorRbcCount = donorInformation.getRbcCount();
            List<Integer> rbcCountValues = new ArrayList<>() {{
                add(patientRbcCount);
                add(donorRbcCount);
            }};
            int rbcCountDifference = Collections.max(rbcCountValues) - Collections.min(rbcCountValues);

            int patientPlateletCount = patientMedicalInfo.getPlateletCount();
            int donorPlateletCount = donorInformation.getPlateletCount();
            List<Integer> plateletCountValues = new ArrayList<>() {{
                add(patientPlateletCount);
                add(donorPlateletCount);
            }};
            int plateletCountDifference = Collections.max(plateletCountValues) - Collections.min(plateletCountValues);
            donorInformation.setHemoglobinLevelDifference(hemoglobinLevelDifference);
            donorInformation.setRbcCountDifference(rbcCountDifference);
            donorInformation.setPlateletCountDifference(plateletCountDifference);
            donorListWithParameterDifference.add(donorInformation);
        }
        List<DonorInformation> donorListWithMatchingPercentage = new CopyOnWriteArrayList<>();
        for (DonorInformation donorInformation : donorListWithParameterDifference) {
            donorListWithMatchingPercentage.add(donorMatchingPercentage.getMatchingPercentage(donorInformation));
        }
        List<Double> matchingPercentageList = new CopyOnWriteArrayList<>();
        for (DonorInformation donorInformation : donorListWithMatchingPercentage) {
            matchingPercentageList.add(donorInformation.getMatchingPercentage());
        }

        List<DonorInformation> donorInformationListSortedByMaximumPercentage = new ArrayList<>();

        matchingPercentageList.stream().mapToInt(matchingPercentage -> matchingPercentageList.indexOf(Collections.max(matchingPercentageList))).forEach(index -> {
            donorInformationListSortedByMaximumPercentage.add(donorListWithMatchingPercentage.get(index));
            donorListWithMatchingPercentage.remove(index);
            matchingPercentageList.remove(index);
        });
        System.out.println();
        System.out.format("%5s%6s%33s%26s%15s%15s%20s", "Match(%)", "Name", "Contact", "Blood Group", "Hemoglobin", "RBC Count", "Platelet Count");
        System.out.println();
        for (DonorInformation donorInformation : donorInformationListSortedByMaximumPercentage) {
            System.out.format("%-10s%-30s%-22s%-16s%-16s%-15s%-15s", donorInformation.getMatchingPercentage(), donorInformation.getDonorFirstName() + " " + donorInformation.getDonorLastName(), donorInformation.getDonorContactNumber(), donorInformation.getDonorBloodGroup(), donorInformation.getHemoglobinLevel(), donorInformation.getRbcCount(), donorInformation.getPlateletCount());
            System.out.println();
        }
        int size = donorInformationListSortedByMaximumPercentage.size();
        return size;
    }
}
