package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.DonorInformation;

import java.sql.SQLException;
import java.util.List;

public interface DonorPersonalInformationRepository {
    List<DonorInformation> getAllMatchingBloodTypeDonors(String bloodGroup) throws SQLException;
}
