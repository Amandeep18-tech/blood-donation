package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.DonorInformation;

import java.sql.SQLException;

public interface DonorMedicalInformationRepository {
    DonorInformation getMatchingBloodTypeDonorMedicalInformation(DonorInformation donorInfo) throws CustomException;
}
