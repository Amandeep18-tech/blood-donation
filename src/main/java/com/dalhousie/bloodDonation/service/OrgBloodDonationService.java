package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.exception.CustomException;

import java.util.List;
import java.util.Map;

public interface OrgBloodDonationService {
    List<String[]> getListByDonorId(String orgId) throws CustomException;

    List<String[]> getListByBloodGroup(String orgId) throws CustomException;

    Map<Integer, String> getPendingRequests(String orgId) throws CustomException;

    void acceptBloodRequest(String optionSelected) throws CustomException;

    List<String[]> getRecommendedOrganisation(int unitsNeeded, BloodGroup bloodGroup) throws CustomException;

    void requestBlood(String orgId, String orgSelected, BloodGroup bloodGroup, int unitsNeeded) throws CustomException;
}
