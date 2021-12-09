package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.model.DonorInformation;

public interface CalculateDonorMatchingPercentageService {
    DonorInformation getMatchingPercentage(DonorInformation donorInfo);
}
