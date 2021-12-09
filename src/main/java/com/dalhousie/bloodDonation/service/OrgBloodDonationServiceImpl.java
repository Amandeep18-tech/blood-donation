package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.constants.BloodReqOrgStatus;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.BloodDonatedDetail;
import com.dalhousie.bloodDonation.model.BloodRequestOrganisation;
import com.dalhousie.bloodDonation.model.Organisation;
import com.dalhousie.bloodDonation.model.Person;
import com.dalhousie.bloodDonation.repos.*;
import com.dalhousie.bloodDonation.utils.DateUtils;

import java.util.*;
import java.util.stream.Collectors;

public class OrgBloodDonationServiceImpl implements OrgBloodDonationService {

    private final BloodRequestOrganisationRepository bloodRequestOrganisationRepository;
    private final BloodDonatedDetailsRepository bloodDonatedDetailsRepository;
    private final PersonRepository personRepository;
    private final OrganizationRepository organizationRepository;
    private final SessionService sessionService;

    public OrgBloodDonationServiceImpl() {
        bloodDonatedDetailsRepository = new BloodDonatedDetailsRepository();
        bloodRequestOrganisationRepository = new BloodRequestOrganisationRepository();
        personRepository = new PersonRepository();
        organizationRepository = new OrganizationRepository();
        sessionService = new SessionServiceImpl();
    }

    @Override
    public List<String[]> getListByDonorId(String orgId) throws CustomException {
        List<BloodDonatedDetail> bloodDonatedDetails = bloodDonatedDetailsRepository.getAllRecords();
        List<Person> personList = personRepository.getPerson();
        return bloodDonatedDetails.stream()
                .filter(bloodDonatedDetail -> bloodDonatedDetail.getOrgId().equalsIgnoreCase(orgId))
                .map(bloodDonatedDetail -> {
                    Person person = personList.stream().filter(x -> x.getpersonId().equalsIgnoreCase(bloodDonatedDetail.getDonorID())).collect(Collectors.toList()).get(0);
                    return new String[]{bloodDonatedDetail.getOrgId(), person.getName(), person.getcontactNumber(), bloodDonatedDetail.getDonatedAt(), bloodDonatedDetail.getBloodGroup().type};
                }).collect(Collectors.toList());
    }

    @Override
    public List<String[]> getListByBloodGroup(String orgId) throws CustomException {
        List<BloodDonatedDetail> bloodDonatedDetails = bloodDonatedDetailsRepository.getAllRecords();
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
        List<Organisation> organisations = organizationRepository.getAllPlaces();
        return bloodRequestOrganisationRepository.getAllRecords()
                .stream().filter(bloodRequestOrganisation -> bloodRequestOrganisation.getOrgId().equalsIgnoreCase(orgId) && bloodRequestOrganisation.getStatus() == BloodReqOrgStatus.pending)
                .collect(Collectors.toMap(BloodRequestOrganisation::getId, x -> {
                    Organisation organisation = organisations.stream().filter(org -> org.getorganisationID().equalsIgnoreCase(x.getOrgId())).collect(Collectors.toList()).get(0);
                    return String.format("%-20s%-20s%-20s%-20s", organisation.getorganisationName(), x.getBloodGroup().type, x.getUnitsRequired(), x.getTimestamp());
                }));
    }

    @Override
    public void acceptBloodRequest(String optionSelected) throws CustomException {
        List<BloodRequestOrganisation> bloodRequestOrganisations = bloodRequestOrganisationRepository.getAllRecords().stream()
                .filter(x -> x.getId() == Integer.valueOf(optionSelected) && x.getStatus() == BloodReqOrgStatus.pending)
                .collect(Collectors.toList());
        if (bloodRequestOrganisations.size() != 1) {
            throw new CustomException("Invalid Request ID. Kindly retry!");
        }
        BloodRequestOrganisation bloodRequestOrganisation = bloodRequestOrganisations.get(0);

        int bloodRequested = bloodRequestOrganisation.getUnitsRequired();
        BloodGroup bloodGroup = bloodRequestOrganisation.getBloodGroup();


        List<BloodDonatedDetail> availableBloodDonatedDetails = bloodDonatedDetailsRepository.getAllRecords().stream()
                .filter(x -> x.getOrgId().equalsIgnoreCase(bloodRequestOrganisation.getOrgId()))
                .collect(Collectors.groupingBy(BloodDonatedDetail::getBloodGroup))
                .get(bloodGroup);
        if (availableBloodDonatedDetails == null || bloodRequested > availableBloodDonatedDetails.size()) {
            throw new CustomException("You don't have sufficient blood available.");
        }
        availableBloodDonatedDetails.stream()
                .limit(bloodRequested)
                .forEach(x -> {
                    x.setOrgId(bloodRequestOrganisation.getReceiverOrgId());
                    bloodDonatedDetailsRepository.update(x);
                });
        bloodRequestOrganisation.setStatus(BloodReqOrgStatus.completed);
        bloodRequestOrganisationRepository.updateRecord(bloodRequestOrganisation);
    }

    @Override
    public LinkedHashMap<String, String> getRecommendedOrganisation(int unitsNeeded, BloodGroup bloodGroup) throws CustomException {
        List<Organisation> organisations = organizationRepository.getAllPlaces();
        String currentPinCode = organisations.stream()
                .filter(x->x.getorganisationID().equalsIgnoreCase(sessionService.getUserId()))
                .collect(Collectors.toList())
                .get(0).getPinCode();
        Map<String, List<BloodDonatedDetail>> collect = bloodDonatedDetailsRepository.getAllRecords().stream()
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
