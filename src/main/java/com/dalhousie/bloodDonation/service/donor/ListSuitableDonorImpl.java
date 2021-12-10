package com.dalhousie.bloodDonation.service.donor;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.donor.DonorMedicalRecords;
import com.dalhousie.bloodDonation.model.donor.Person;
import com.dalhousie.bloodDonation.repos.donor.DonorMedicalRecordsRepository;
import com.dalhousie.bloodDonation.repos.donor.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class ListSuitableDonorImpl implements ListSuitableDonor {

    @Override
    public List<String> getSuitableDonorID(String bloodType) throws CustomException {
        PersonRepository personRepository = new PersonRepository();
        List<Person> personList = personRepository.getPerson();
        List<String> donorId = new ArrayList<String>();

        for (Person person : personList) {
            if (person.getbloodGroup().equals(bloodType)) {
                donorId.add(person.getpersonId());
            }
        }
        if (donorId.size() == 0) {
            throw new CustomException("no suitable donor");
        }
        return donorId;

    }

    @Override
    public DonorMedicalRecords getSuitableDonor(String donorId) {
        DonorMedicalRecordsRepository donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        List<DonorMedicalRecords> donorMedicalRecordsList = donorMedicalRecordsRepository.getAllDonorMedicalRecords();
        for (DonorMedicalRecords donorMedicalRecords : donorMedicalRecordsList) {
            if ((donorMedicalRecords.gethemoglobinLevel() > 150) && donorMedicalRecords.getHIVFlag().equals(0) && donorMedicalRecords.getHemochromatosis().equals(0) && donorMedicalRecords.gethepatitisB().equals(0) && donorMedicalRecords.gethepatitisC().equals(0) && donorMedicalRecords.getdonorID().equals(donorId)) {

                return donorMedicalRecords;
            }
        }
        return null;
    }

    @Override
    public String getDonorDetails(String donorId) {

        PersonRepository personRepository = new PersonRepository();
        List<Person> personList = personRepository.getPerson();
        for (Person person : personList) {
            if (person.getpersonId().equals(donorId)) {
                return person.getName();
            }
        }
        return null;
    }

    @Override
    public String getBloodTypeId(String bloodType, String donorId) {
        PersonRepository personRepository = new PersonRepository();
        List<Person> personList = personRepository.getPerson();
        DonorMedicalRecordsRepository donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        List<DonorMedicalRecords> donorMedicalRecordsList = donorMedicalRecordsRepository.getAllDonorMedicalRecords();
        for (Person person : personList) {
            if (person.getpersonId().equals(donorId)) {
                for (DonorMedicalRecords donorMedicalRecords : donorMedicalRecordsList) {
                    if (person.getbloodGroup().equals(bloodType) && donorMedicalRecords.getHIVFlag().equals(0) && donorMedicalRecords.getHemochromatosis().equals(0) && donorMedicalRecords.gethepatitisB().equals(0) && donorMedicalRecords.gethepatitisC().equals(0)) {
                        return donorId;
                    }
                }
            }
        }
        return null;
    }

    @Override
    public boolean getHemoglobinCount(String donorId, Integer hemoglobinCount) {
        DonorMedicalRecordsRepository donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        List<DonorMedicalRecords> donorMedicalRecordsList = donorMedicalRecordsRepository.getAllDonorMedicalRecords();
        for (DonorMedicalRecords donorMedicalRecords : donorMedicalRecordsList) {
            if (donorMedicalRecords.getdonorID().equals(donorId) && donorMedicalRecords.gethemoglobinLevel().equals(hemoglobinCount) && donorMedicalRecords.getHIVFlag().equals(0) && donorMedicalRecords.getHemochromatosis().equals(0) && donorMedicalRecords.gethepatitisB().equals(0) && donorMedicalRecords.gethepatitisC().equals(0)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean getRBCCount(String donorId, Integer rbcCount) {
        DonorMedicalRecordsRepository donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        List<DonorMedicalRecords> donorMedicalRecordsList = donorMedicalRecordsRepository.getAllDonorMedicalRecords();
        for (DonorMedicalRecords donorMedicalRecords : donorMedicalRecordsList) {
            if (donorMedicalRecords.getdonorID().equals(donorId) && donorMedicalRecords.getRbcCount().equals(rbcCount) && donorMedicalRecords.getHIVFlag().equals(0) && donorMedicalRecords.getHemochromatosis().equals(0) && donorMedicalRecords.gethepatitisB().equals(0) && donorMedicalRecords.gethepatitisC().equals(0)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean getPlateletCount(String donorId, Integer plateletCount) {
        DonorMedicalRecordsRepository donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        List<DonorMedicalRecords> donorMedicalRecordsList = donorMedicalRecordsRepository.getAllDonorMedicalRecords();
        for (DonorMedicalRecords donorMedicalRecords : donorMedicalRecordsList) {
            if (donorMedicalRecords.getdonorID().equals(donorId) && donorMedicalRecords.getPlateletCount().equals(plateletCount) && donorMedicalRecords.getHIVFlag().equals(0) && donorMedicalRecords.getHemochromatosis().equals(0) && donorMedicalRecords.gethepatitisB().equals(0) && donorMedicalRecords.gethepatitisC().equals(0)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public String getPersonName(String donorID) {
        PersonRepository personRepository = new PersonRepository();
        List<Person> personList = personRepository.getPerson();
        for (Person person : personList) {
            if (person.getpersonId().equals(donorID)) {
                return person.getName();
            }
        }
        return null;
    }
}
