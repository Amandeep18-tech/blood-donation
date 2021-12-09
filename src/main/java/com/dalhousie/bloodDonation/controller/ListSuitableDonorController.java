package com.dalhousie.bloodDonation.controller;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.dalhousie.bloodDonation.exception.CustomException;
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

    
    public ListSuitableDonorController() {
        personRepository= new PersonRepository();
        person = new Person();
        donorMedicalRecords = new DonorMedicalRecords();
        donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        listSuitableDonorImpl = new ListSuitableDonorImpl();
    }

    public void patientDonorList() throws CustomException {
        System.out.println("List of Suitable patient based on your profile");
        String personBloodType=null;
        List<Person> personList = personRepository.getPerson();
        String currentId="5d9b8b40-5213-11ec-917b-e2ed2ce588f5";
        for (Person person:personList){
            
            if(person.getPerson_id().equals(currentId)){
                
                personBloodType=person.getBlood_group();
            }
            
        }// depends on the user login.
        
        List<String> donorId = new ArrayList <String> ();
        donorId=listSuitableDonorImpl.getSuitableDonorID(personBloodType);
        if (donorId==null){
            throw new CustomException("No donor found");
        }
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

    public void organisationDonorSelection() {
        System.out.println("Do you want to select Donors according to various criteria Yes or No");
        Scanner sc = new Scanner(System.in);
        String selection=sc.nextLine();
        HashMap<String,List<String>> donorSelection = new HashMap<String,List<String>> ();
        List<String> choicesByOrganization = new ArrayList<String>();
        String typeSelection=null;
        if(selection.toLowerCase().equals("yes")){
                System.out.println("Which blood type you want to select?");
                String bloodType=sc.nextLine();
                choicesByOrganization.add(bloodType);
                List<Person> personList= personRepository.getPerson();
                String getDonorId=null;
                for(Person person:personList){
                    getDonorId= listSuitableDonorImpl.getBloodTypeId(bloodType,person.getPerson_id());
                    if(getDonorId==null){
                        continue;
                    }
                    donorSelection.put(getDonorId,choicesByOrganization);
                }

            
            System.out.println("Do you want to choose hemologin level");
            typeSelection= sc.nextLine();
            if(typeSelection.toLowerCase().equals("yes")){
                System.out.println("Choose hemoglobin level between between 120-175 grams per litre");
                Integer hemoglobinLevel=Integer.parseInt(sc.nextLine());
                boolean hemoglobinFound=false;
                choicesByOrganization.add(Integer.toString(hemoglobinLevel));
                for (String key : donorSelection.keySet()) {
                    hemoglobinFound=listSuitableDonorImpl.getHemoglobinCount(key,hemoglobinLevel);
                    if(hemoglobinFound){
                        donorSelection.put(key,choicesByOrganization);
                    }
                    else{
                        donorSelection.remove(key);
                    }
                    
                }
            }
            
            System.out.println("Do you want to choose platelet level");
            typeSelection= sc.nextLine();
            if(typeSelection.toLowerCase().equals("yes")){
                System.out.println("Choose platelet count ");
                Integer plateletCount=Integer.parseInt(sc.nextLine());
                boolean plateletCountFound=false;
                choicesByOrganization.add(Integer.toString(plateletCount));
               
                for (String key : donorSelection.keySet()) {
                    plateletCountFound=listSuitableDonorImpl.getPlateletCount(key,plateletCount);
                    if(plateletCountFound){
                        
                        donorSelection.put(key,choicesByOrganization);
                    }
                    else{
                        donorSelection.remove(key);
                    }

                }
            }

            System.out.println("Do you want to choose RBC level");
            typeSelection= sc.nextLine();
            if(typeSelection.toLowerCase().equals("yes")){
                System.out.println("Choose RBC count");
                Integer rbcCount=Integer.parseInt(sc.nextLine());
                boolean rbcCountFound=false;
                choicesByOrganization.add(Integer.toString(rbcCount));
                for (String key : donorSelection.keySet()) {
                    rbcCountFound=listSuitableDonorImpl.getRBCCount(key,rbcCount);
                    if(rbcCountFound){
                        donorSelection.put(key,choicesByOrganization);
                    }
                    else{
                        donorSelection.remove(key);
                    }
                    

                }
            
            }
           
            
            

        }
        donorSelection.forEach((key, value) -> {
            String name= listSuitableDonorImpl.getPersonName(key);
            System.out.println(name);
            System.out.println(value);
        });

    }
}
