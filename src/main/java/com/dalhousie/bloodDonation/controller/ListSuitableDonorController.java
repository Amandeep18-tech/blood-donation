package com.dalhousie.bloodDonation.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.dalhousie.bloodDonation.model.DonorMedicalRecords;
import com.dalhousie.bloodDonation.model.Person;
import com.dalhousie.bloodDonation.repos.DonorMedicalRecordsRepository;
import com.dalhousie.bloodDonation.repos.PersonRepository;
import com.dalhousie.bloodDonation.service.ListSuitableDonorImpl;

public class ListSuitableDonorController {
    PersonRepository personRepository = null;
    Person person=null;
    DonorMedicalRecords donorMedicalRecords=null;
    DonorMedicalRecordsRepository donorMedicalRecordsRepository=null;
    ListSuitableDonorImpl listSuitableDonorImpl=null;

    
    public ListSuitableDonorController() throws SQLException{
        personRepository= new PersonRepository();
        person = new Person();
        donorMedicalRecords = new DonorMedicalRecords();
        donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        listSuitableDonorImpl = new ListSuitableDonorImpl();
    }

    public void patientDonorList() throws SQLException {
        System.out.println("List of Suitable donor based on your profile");
        String personBloodType=null;
        List<Person> personList = personRepository.getPerson();
        String currentId="5d9b8b40-5213-11ec-917b-e2ed2ce588f5";
        for (Person person:personList){
            
            if(person.getPerson_id().equals(currentId)){
                
                personBloodType=person.getBlood_group();
            }
            
        }
        
        List<String> donorId = new ArrayList <String> ();
        donorId=listSuitableDonorImpl.getSuitableDonorID(personBloodType);
        donorId.remove(currentId);
        List<DonorMedicalRecords> donorMedicalRecordsList = new ArrayList <DonorMedicalRecords>();
        System.out.println(donorId);
        for (int i = 0; i < donorId.size(); i++) {
            donorMedicalRecordsList.add(listSuitableDonorImpl.getSuitableDonor(donorId.get(i)));
            
        }
        for(int i=0; i<donorMedicalRecordsList.size();i++){
            System.out.println(listSuitableDonorImpl.getDonorDetails(donorMedicalRecordsList.get(i).getDonor_id()));
        }
        
        
    }

    public void organisationDonorSelection() throws SQLException{
        System.out.println("Do you want to select Donors according to Blood Request Yes or No");
        Scanner sc = new Scanner(System.in);
        String selection=sc.nextLine();
        HashMap<String,List<String>> donorSelection = new HashMap<String,List<String>> ();
        List<String> choicesByOrganization = new ArrayList<String>();
        if(selection.toLowerCase().equals("yes")){
            System.out.println("Which blood type you want to select?");
            String bloodType=sc.nextLine();
            choicesByOrganization.add(bloodType);
            List<Person> personList= personRepository.getPerson();
            String getDonorId=null;
            for(Person person:personList){
                getDonorId= listSuitableDonorImpl.getBloodTypeId(bloodType);
                System.out.println(getDonorId);
                donorSelection.put(getDonorId,choicesByOrganization);
            }
            System.out.println(donorSelection);

        }

    }
}
