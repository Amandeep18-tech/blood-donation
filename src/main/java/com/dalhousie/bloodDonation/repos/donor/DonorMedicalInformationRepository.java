package com.dalhousie.bloodDonation.repos.donor;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.donor.DonorInformation;

public interface DonorMedicalInformationRepository {
    DonorInformation getMatchingBloodTypeDonorMedicalInformation(DonorInformation donorInfo) throws CustomException;
}
