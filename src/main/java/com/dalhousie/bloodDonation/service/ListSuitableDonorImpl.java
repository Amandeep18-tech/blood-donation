package com.dalhousie.bloodDonation.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.DonorMedicalRecords;
import com.dalhousie.bloodDonation.model.Person;
import com.dalhousie.bloodDonation.repos.DonorMedicalRecordsRepository;
import com.dalhousie.bloodDonation.repos.PersonRepository;

public class ListSuitableDonorImpl implements ListSuitableDonor {
  
    @Override
    public List<String> getSuitableDonorID(String bloodType) throws CustomException{
        PersonRepository personRepository = new PersonRepository();
        List<Person> personList = personRepository.getPerson();
        List<String> donorId= new ArrayList <String>();
        
        for(Person person:personList){
            if(person.getBlood_group().equals(bloodType)){
                 donorId.add(person.getPerson_id());
            }
        }
        if(donorId.size()==0){
            throw new CustomException("no suitable donor");
        }
        return donorId;
        
    }

    @Override
    public DonorMedicalRecords getSuitableDonor(String donorId){
        HashMap<Person,DonorMedicalRecords> suitableDonors = new HashMap<Person,DonorMedicalRecords>();
        DonorMedicalRecordsRepository donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        PersonRepository personRepository = new PersonRepository();
        List<DonorMedicalRecords> donorMedicalRecordsList= donorMedicalRecordsRepository.getAllDonorMedicalRecords();
        List<Person> personList=personRepository.getPerson();
        
            for(DonorMedicalRecords donorMedicalRecords:donorMedicalRecordsList){
                if((donorMedicalRecords.getHemoglobin_level()>150) && donorMedicalRecords.getHIV_flag().equals(0) && donorMedicalRecords.getHemochromatosis().equals(0)&& donorMedicalRecords.getHepatitis_B().equals(0) && donorMedicalRecords.getHepatitis_C().equals(0) && donorMedicalRecords.getDonor_id().equals(donorId)){
                   
                    return donorMedicalRecords;    
                }
            }
        
        return null;
    }

    @Override
    public String getDonorDetails(String donorId){

        PersonRepository personRepository = new PersonRepository();
        List<Person> personList= personRepository.getPerson();
        for(Person person:personList){
            if(person.getPerson_id().equals(donorId)){
                return person.getName();
            }
        }
        return null;
    }

    @Override
    public String getBloodTypeId(String bloodType, String donorId){
        PersonRepository personRepository = new PersonRepository();
        List<Person> personList= personRepository.getPerson();
        DonorMedicalRecordsRepository donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        List<DonorMedicalRecords> donorMedicalRecordsList= donorMedicalRecordsRepository.getAllDonorMedicalRecords();
        for(Person person:personList){
            if(person.getPerson_id().equals(donorId)){
                for(DonorMedicalRecords donorMedicalRecords: donorMedicalRecordsList){
                    System.out.println(person.getBlood_group());
                    System.out.println(bloodType);
                if(person.getBlood_group().equals(bloodType) && donorMedicalRecords.getHIV_flag().equals(0) && donorMedicalRecords.getHemochromatosis().equals(0)&& donorMedicalRecords.getHepatitis_B().equals(0) && donorMedicalRecords.getHepatitis_C().equals(0)){
                    return donorId;
                }
            }
            }
        }
        return null;
    }
    @Override
    public boolean getHemoglobinCount(String donorId, Integer hemoglobinCount){
        DonorMedicalRecordsRepository donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        List<DonorMedicalRecords> donorMedicalRecordsList= donorMedicalRecordsRepository.getAllDonorMedicalRecords();
        for(DonorMedicalRecords donorMedicalRecords: donorMedicalRecordsList ){
            if(donorMedicalRecords.getDonor_id().equals(donorId) && donorMedicalRecords.getHemoglobin_level().equals(hemoglobinCount) && donorMedicalRecords.getHIV_flag().equals(0) && donorMedicalRecords.getHemochromatosis().equals(0)&& donorMedicalRecords.getHepatitis_B().equals(0) && donorMedicalRecords.getHepatitis_C().equals(0)){
                return true;
            }

        }
        return false;
    }
    @Override
    public boolean getRBCCount(String donorId,Integer rbcCount){
        DonorMedicalRecordsRepository donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        List<DonorMedicalRecords> donorMedicalRecordsList= donorMedicalRecordsRepository.getAllDonorMedicalRecords();
        for(DonorMedicalRecords donorMedicalRecords: donorMedicalRecordsList ){
            if(donorMedicalRecords.getDonor_id().equals(donorId) && donorMedicalRecords.getRbcCount().equals(rbcCount) && donorMedicalRecords.getHIV_flag().equals(0) && donorMedicalRecords.getHemochromatosis().equals(0)&& donorMedicalRecords.getHepatitis_B().equals(0) && donorMedicalRecords.getHepatitis_C().equals(0)){
                return true;
            }

        }
        return false;
    }
    @Override
    public boolean getPlateletCount(String donorId,Integer plateletCount){
        DonorMedicalRecordsRepository donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        List<DonorMedicalRecords> donorMedicalRecordsList= donorMedicalRecordsRepository.getAllDonorMedicalRecords();
        for(DonorMedicalRecords donorMedicalRecords: donorMedicalRecordsList ){
            if(donorMedicalRecords.getDonor_id().equals(donorId) && donorMedicalRecords.getPlateletCount().equals(plateletCount) && donorMedicalRecords.getHIV_flag().equals(0) && donorMedicalRecords.getHemochromatosis().equals(0)&& donorMedicalRecords.getHepatitis_B().equals(0) && donorMedicalRecords.getHepatitis_C().equals(0)){
                return true;
            }

        }
        return false;
    }

    @Override
    public String getPersonName(String donorID){
        PersonRepository personRepository = new PersonRepository();
        List<Person> personList = personRepository.getPerson();

        for(Person person:personList){
            if(person.getPerson_id().equals(donorID)){
                return person.getName();
            }
        }
        return null;
    }
}
