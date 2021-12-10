package com.dalhousie.bloodDonation.service.donor;

import com.dalhousie.bloodDonation.model.donor.DonorInformation;

public interface CalculateDonorMatchingPercentageService {
    DonorInformation getMatchingPercentage(DonorInformation donorInfo);
}
