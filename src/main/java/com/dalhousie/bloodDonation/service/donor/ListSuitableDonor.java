package com.dalhousie.bloodDonation.service.donor;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.donor.DonorMedicalRecords;

import java.util.List;

public interface ListSuitableDonor {
    List<String> getSuitableDonorID(String bloodType) throws CustomException;
    DonorMedicalRecords getSuitableDonor(String donorId) ;
    String getDonorDetails(String donorId);
    String getBloodTypeId(String bloodType, String donorId);
    boolean getHemoglobinCount(String donorId,Integer hemoglobinCount);
    boolean getRBCCount(String donorId,Integer rbcCount);
    boolean getPlateletCount(String donorId,Integer plateletCount);
    String getPersonName(String donorID);
}
