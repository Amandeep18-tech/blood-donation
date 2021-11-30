package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.constants.BloodReqOrgStatus;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.BloodDonationDetail;
import com.dalhousie.bloodDonation.model.BloodRequestOrganisation;
import com.dalhousie.bloodDonation.repos.BloodDonationDetailsRepository;
import com.dalhousie.bloodDonation.repos.BloodRequestOrganisationRepository;
import com.dalhousie.bloodDonation.utils.DateUtils;

import java.util.*;
import java.util.stream.Collectors;

public class OrgBloodDonationServiceImpl implements OrgBloodDonationService {

    private static BloodRequestOrganisationRepository bloodRequestOrganisationRepository = null;
    private static BloodDonationDetailsRepository bloodDonationDetailsRepository = null;

    public OrgBloodDonationServiceImpl(){
        bloodDonationDetailsRepository = new BloodDonationDetailsRepository();
        bloodRequestOrganisationRepository = new BloodRequestOrganisationRepository();
    }

    @Override
    public List<String[]> getListByDonorId(String orgId) throws CustomException {
        List<BloodDonationDetail> bloodDonationDetails =bloodDonationDetailsRepository.getAllRecords();
        return (List<String[]>) bloodDonationDetails.stream()
                .filter(bloodDonationDetail -> bloodDonationDetail.getOrgId().equalsIgnoreCase(orgId))
                .map(bloodDonationDetail -> {
                    return new String[]{bloodDonationDetail.getOrgId(), bloodDonationDetail.getDonorID(), bloodDonationDetail.getDonatedAt(), bloodDonationDetail.getBloodGroup().toString()};
                }).collect(Collectors.toList());
    }

    @Override
    public List<String[]> getListByBloodGroup(String orgId) throws CustomException {
        List<BloodDonationDetail> bloodDonationDetails =bloodDonationDetailsRepository.getAllRecords();
        Map<BloodGroup, List<BloodDonationDetail>> map = bloodDonationDetails.stream()
                .filter(bloodDonationDetail -> bloodDonationDetail.getOrgId().equalsIgnoreCase(orgId))
                .collect(Collectors.groupingBy(BloodDonationDetail::getBloodGroup));
        List<String[]> returnValue = new ArrayList<>();
        map.forEach((bloodGroup, bloodDonationDetails1) -> {
            returnValue.add(new String[]{bloodGroup.type, String.valueOf(bloodDonationDetails1.size())});
        });
        return returnValue;
    }

    @Override
    public Map<Integer, String> getPendingRequests(String orgId) throws CustomException {
        return bloodRequestOrganisationRepository.getAllRecords()
                .stream().filter(bloodRequestOrganisation -> bloodRequestOrganisation.getOrgId().equalsIgnoreCase(orgId))
                .collect(Collectors.toMap(BloodRequestOrganisation::getId,x->x.getOrgId()+"\t"+x.getBloodGroup()+"\t"+x.getUnitsRequired()+"\t"+x.getTimestamp()));
    }

    @Override
    public void acceptBloodRequest(String optionSelected) throws CustomException {
        BloodRequestOrganisation bloodRequestOrganisation = bloodRequestOrganisationRepository.getAllRecords().stream()
                .filter(x -> x.getId() == Integer.valueOf(optionSelected))
                .collect(Collectors.toList()).get(0);
        bloodRequestOrganisation.setBloodReqOrgStatus(BloodReqOrgStatus.completed);
        int bloodRequested = bloodRequestOrganisation.getUnitsRequired();
        BloodGroup bloodGroup = bloodRequestOrganisation.getBloodGroup();

        List<BloodDonationDetail> availableBloodDonationDetails = bloodDonationDetailsRepository.getAllRecords().stream()
                .filter(x -> x.getOrgId().equalsIgnoreCase(bloodRequestOrganisation.getOrgId()))
                .collect(Collectors.groupingBy(BloodDonationDetail::getBloodGroup))
                .get(bloodGroup);
        int bloodAvailable = availableBloodDonationDetails.size();
        if (bloodRequested > bloodAvailable) {
            throw new CustomException("You don't have sufficient blood available.");
        }
        availableBloodDonationDetails.stream()
                .limit(bloodRequested)
                .forEach(x -> {
                    x.setOrgId(bloodRequestOrganisation.getReceiverOrgId());
                    bloodDonationDetailsRepository.update(x);
                });
        bloodRequestOrganisationRepository.updateRecord(bloodRequestOrganisation);
    }

    @Override
    public LinkedHashMap<String, String> getRecommendedOrganisation(int unitsNeeded, BloodGroup bloodGroup) throws CustomException {
        Map<String, List<BloodDonationDetail>> collect = bloodDonationDetailsRepository.getAllRecords().stream()
                .filter(x -> x.getBloodGroup() == bloodGroup)
                .collect(Collectors.groupingBy(BloodDonationDetail::getOrgId));
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap();
        //Todo Added recommendation logics
        for (Map.Entry<String, List<BloodDonationDetail>> entry : collect.entrySet()) {
            linkedHashMap.put(entry.getKey(), String.valueOf(entry.getValue().size()));
        }
        return linkedHashMap;
    }

    @Override
    public void requestBlood(String orgId, String orgSelected, BloodGroup bloodGroup, int unitsNeeded) throws CustomException {
        BloodRequestOrganisation bloodRequestOrganisation = new BloodRequestOrganisation();
        bloodRequestOrganisation.setOrgId(orgSelected);
        bloodRequestOrganisation.setReceiverOrgId(orgId);
        bloodRequestOrganisation.setUnitsRequired(unitsNeeded);
        bloodRequestOrganisation.setBloodGroup(bloodGroup);
        bloodRequestOrganisation.setBloodReqOrgStatus(BloodReqOrgStatus.pending);
        bloodRequestOrganisation.setTimestamp(DateUtils.getNow());
        bloodDonationDetailsRepository.save(bloodRequestOrganisation);
    }
}
