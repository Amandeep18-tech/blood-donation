package com.dalhousie.bloodDonation.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.dalhousie.bloodDonation.model.DonorMedicalRecords;
import com.dalhousie.bloodDonation.model.Person;
import com.dalhousie.bloodDonation.repos.DonorMedicalRecordsRepository;
import com.dalhousie.bloodDonation.repos.PersonRepository;

public class ListSuitableDonorImpl implements ListSuitableDonor {
  
    @Override
    public List<String> getSuitableDonorID(String bloodType) throws SQLException{
        PersonRepository personRepository = new PersonRepository();
        List<Person> personList = personRepository.getPerson();
        List<String> donorId= new ArrayList <String>();
        for(Person person:personList){
            if(person.getBlood_group().equals(bloodType)){
                 donorId.add(person.getPerson_id());
            }
        }
        return donorId;
        
    }

    @Override
    public DonorMedicalRecords getSuitableDonor(String donorId) throws SQLException{
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
    public String getDonorDetails(String donorId) throws SQLException{

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
    public String getBloodTypeId(String bloodType) throws SQLException{
        PersonRepository personRepository = new PersonRepository();
        List<Person> personList = personRepository.getPerson();
        for(Person person:personList){
            if(person.getBlood_group().equals(bloodType)){
                System.out.println(person.getBlood_group());
                return person.getPerson_id();
            }
        }
        return null;
    }
}
