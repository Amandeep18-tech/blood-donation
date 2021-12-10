package com.dalhousie.bloodDonation.service.donor;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.donor.DonorMedicalRecords;

import java.util.List;

public interface ListSuitableDonor {

    public List<String> getSuitableDonorID(String bloodType) throws CustomException;
    public DonorMedicalRecords getSuitableDonor(String donorId) ;
    public String getDonorDetails(String donorId);
    public String getBloodTypeId(String bloodType, String donorId);
    public boolean getHemoglobinCount(String donorId,Integer hemoglobinCount);
    public boolean getRBCCount(String donorId,Integer rbcCount);
    public boolean getPlateletCount(String donorId,Integer plateletCount);
    public String getPersonName(String donorID);
}
