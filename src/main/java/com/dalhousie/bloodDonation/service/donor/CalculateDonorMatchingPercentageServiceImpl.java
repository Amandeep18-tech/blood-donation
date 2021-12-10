package com.dalhousie.bloodDonation.service.donor;

import com.dalhousie.bloodDonation.model.donor.DonorInformation;

public class CalculateDonorMatchingPercentageServiceImpl implements CalculateDonorMatchingPercentageService {
    private int hemoglobinWeightage;
    private int rbcCountWeightage;
    private int plateletCountWeightage;

    @Override
    public DonorInformation getMatchingPercentage(DonorInformation donorInfo) {
        double hemoglobinLevelDifference = donorInfo.getHemoglobinLevelDifference();
        int rbcCountDifference = donorInfo.getRbcCountDifference();
        int plateletCountDifference = donorInfo.getPlateletCountDifference();
        if (hemoglobinLevelDifference >= 0 && hemoglobinLevelDifference <= 1) {
            hemoglobinWeightage = 40;
        } else if (hemoglobinLevelDifference > 1 && hemoglobinLevelDifference <= 2) {
            hemoglobinWeightage = 35;
        } else if (hemoglobinLevelDifference > 2 && hemoglobinLevelDifference <= 3) {
            hemoglobinWeightage = 30;
        } else if (hemoglobinLevelDifference > 3 && hemoglobinLevelDifference <= 4) {
            hemoglobinWeightage = 25;
        } else if (hemoglobinLevelDifference > 4 && hemoglobinLevelDifference <= 5) {
            hemoglobinWeightage = 20;
        } else if (hemoglobinLevelDifference > 5 && hemoglobinLevelDifference <= 6) {
            hemoglobinWeightage = 15;
        } else if (hemoglobinLevelDifference > 6 && hemoglobinLevelDifference <= 7) {
            hemoglobinWeightage = 10;
        } else if (hemoglobinLevelDifference > 7 && hemoglobinLevelDifference <= 8) {
            hemoglobinWeightage = 5;
        } else if (hemoglobinLevelDifference > 8) {
            hemoglobinWeightage = 0;
        }
        if (rbcCountDifference >= 0 && rbcCountDifference <= 50000) {
            rbcCountWeightage = 30;
        } else if (rbcCountDifference > 50000 && rbcCountDifference <= 100000) {
            rbcCountWeightage = 25;
        } else if (rbcCountDifference > 100000 && rbcCountDifference <= 150000) {
            rbcCountWeightage = 20;
        } else if (rbcCountDifference > 150000 && rbcCountDifference <= 200000) {
            rbcCountWeightage = 15;
        } else if (rbcCountDifference > 200000 && rbcCountDifference <= 250000) {
            rbcCountWeightage = 10;
        } else if (rbcCountDifference > 250000 && rbcCountDifference <= 300000) {
            rbcCountWeightage = 5;
        } else if (rbcCountDifference > 300000) {
            rbcCountWeightage = 0;
        }
        if (plateletCountDifference >= 0 && plateletCountDifference <= 25000) {
            plateletCountWeightage = 30;
        } else if (plateletCountDifference > 25000 && plateletCountDifference <= 75000) {
            plateletCountWeightage = 25;
        } else if (plateletCountDifference > 75000 && plateletCountDifference <= 150000) {
            plateletCountWeightage = 20;
        } else if (plateletCountDifference > 150000 && plateletCountDifference <= 200000) {
            plateletCountWeightage = 15;
        } else if (plateletCountDifference > 200000 && plateletCountDifference <= 300000) {
            plateletCountWeightage = 10;
        } else if (plateletCountDifference > 300000 && plateletCountDifference <= 400000) {
            plateletCountWeightage = 5;
        } else if (plateletCountDifference > 400000) {
            plateletCountWeightage = 0;
        }
        int overallMatchingPoints = hemoglobinWeightage + rbcCountWeightage + plateletCountWeightage;
        donorInfo.setMatchingPercentage(overallMatchingPoints);
        return donorInfo;
    }
}
