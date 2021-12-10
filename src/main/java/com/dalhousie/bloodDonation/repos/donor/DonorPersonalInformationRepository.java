package com.dalhousie.bloodDonation.repos.donor;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.donor.DonorInformation;

import java.util.List;

public interface DonorPersonalInformationRepository {
    List<DonorInformation> getAllMatchingBloodTypeDonors(String bloodGroup) throws CustomException;
}
