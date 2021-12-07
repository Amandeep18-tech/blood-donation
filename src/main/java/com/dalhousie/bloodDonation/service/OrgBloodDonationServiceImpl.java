package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.constants.BloodReqOrgStatus;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.BloodDonatedDetail;
import com.dalhousie.bloodDonation.model.BloodRequestOrganisation;
import com.dalhousie.bloodDonation.repos.BloodDonatedDetailRepository;
import com.dalhousie.bloodDonation.repos.BloodRequestOrganisationRepository;
import com.dalhousie.bloodDonation.utils.DateUtils;

import java.util.*;
import java.util.stream.Collectors;

public class OrgBloodDonationServiceImpl implements OrgBloodDonationService {

    private static BloodRequestOrganisationRepository bloodRequestOrganisationRepository = null;
    private static BloodDonatedDetailRepository bloodDonatedDetailRepository = null;

    public OrgBloodDonationServiceImpl(){
        bloodDonatedDetailRepository = new BloodDonatedDetailRepository();
        bloodRequestOrganisationRepository = new BloodRequestOrganisationRepository();
    }

    @Override
    public List<String[]> getListByDonorId(String orgId) throws CustomException {
        List<BloodDonatedDetail> bloodDonatedDetails = bloodDonatedDetailRepository.getAllRecords();
        return (List<String[]>) bloodDonatedDetails.stream()
                .filter(bloodDonatedDetail -> bloodDonatedDetail.getOrgId().equalsIgnoreCase(orgId))
                .map(bloodDonatedDetail -> {
                    return new String[]{bloodDonatedDetail.getOrgId(), bloodDonatedDetail.getDonorID(), bloodDonatedDetail.getDonatedAt(), bloodDonatedDetail.getBloodGroup().toString()};
                }).collect(Collectors.toList());
    }

    @Override
    public List<String[]> getListByBloodGroup(String orgId) throws CustomException {
        List<BloodDonatedDetail> bloodDonatedDetails = bloodDonatedDetailRepository.getAllRecords();
        Map<BloodGroup, List<BloodDonatedDetail>> map = bloodDonatedDetails.stream()
                .filter(bloodDonatedDetail -> bloodDonatedDetail.getOrgId().equalsIgnoreCase(orgId))
                .collect(Collectors.groupingBy(BloodDonatedDetail::getBloodGroup));
        List<String[]> returnValue = new ArrayList<>();
        map.forEach((bloodGroup, bloodDonationDetails1) -> {
            returnValue.add(new String[]{bloodGroup.type, String.valueOf(bloodDonationDetails1.size())});
        });
        return returnValue;
    }

    @Override
    public Map<Integer, String> getPendingRequests(String orgId) throws CustomException {
        return bloodRequestOrganisationRepository.getAllRecords()
                .stream().filter(bloodRequestOrganisation -> bloodRequestOrganisation.getOrgId().equalsIgnoreCase(orgId) && bloodRequestOrganisation.getStatus() == BloodReqOrgStatus.pending)
                .collect(Collectors.toMap(BloodRequestOrganisation::getId,x->x.getOrgId()+"\t"+x.getBloodGroup()+"\t"+x.getUnitsRequired()+"\t"+x.getTimestamp()));
    }

    @Override
    public void acceptBloodRequest(String optionSelected) throws CustomException {
        BloodRequestOrganisation bloodRequestOrganisation = bloodRequestOrganisationRepository.getAllRecords().stream()
                .filter(x -> x.getId() == Integer.valueOf(optionSelected))
                .collect(Collectors.toList()).get(0);

        int bloodRequested = bloodRequestOrganisation.getUnitsRequired();
        BloodGroup bloodGroup = bloodRequestOrganisation.getBloodGroup();

        List<BloodDonatedDetail> availableBloodDonatedDetails = bloodDonatedDetailRepository.getAllRecords().stream()
                .filter(x -> x.getOrgId().equalsIgnoreCase(bloodRequestOrganisation.getOrgId()))
                .collect(Collectors.groupingBy(BloodDonatedDetail::getBloodGroup))
                .get(bloodGroup);
        int bloodAvailable = availableBloodDonatedDetails.size();
        if (bloodRequested > bloodAvailable) {
            throw new CustomException("You don't have sufficient blood available.");
        }
        availableBloodDonatedDetails.stream()
                .limit(bloodRequested)
                .forEach(x -> {
                    x.setOrgId(bloodRequestOrganisation.getReceiverOrgId());
                    bloodDonatedDetailRepository.update(x);
                });
        bloodRequestOrganisation.setStatus(BloodReqOrgStatus.completed);
        bloodRequestOrganisationRepository.updateRecord(bloodRequestOrganisation);
    }

    @Override
    public LinkedHashMap<String, String> getRecommendedOrganisation(int unitsNeeded, BloodGroup bloodGroup) throws CustomException {
        Map<String, List<BloodDonatedDetail>> collect = bloodDonatedDetailRepository.getAllRecords().stream()
                .filter(x -> x.getBloodGroup() == bloodGroup)
                .collect(Collectors.groupingBy(BloodDonatedDetail::getOrgId));
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap();
        //Todo Added recommendation logics
        for (Map.Entry<String, List<BloodDonatedDetail>> entry : collect.entrySet()) {
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
        bloodRequestOrganisation.setStatus(BloodReqOrgStatus.pending);
        bloodRequestOrganisation.setTimestamp(DateUtils.getNow());
        bloodRequestOrganisationRepository.save(bloodRequestOrganisation);
    }
}
