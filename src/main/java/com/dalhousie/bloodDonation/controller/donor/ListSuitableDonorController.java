package com.dalhousie.bloodDonation.controller.donor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import java.util.Scanner;

import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.donor.DonorMedicalRecords;
import com.dalhousie.bloodDonation.model.donor.Person;
import com.dalhousie.bloodDonation.repos.donor.PersonRepository;
import com.dalhousie.bloodDonation.service.donor.ListSuitableDonor;
import com.dalhousie.bloodDonation.service.donor.ListSuitableDonorImpl;
import com.dalhousie.bloodDonation.service.common.LocationService;
import com.dalhousie.bloodDonation.service.common.LocationServiceImpl;
import com.dalhousie.bloodDonation.service.common.SessionService;
import com.dalhousie.bloodDonation.service.common.SessionServiceImpl;


public class ListSuitableDonorController {
    private final PersonRepository personRepository;
    private final ListSuitableDonor listSuitableDonorImpl;
    private final LocationService LocationService;
    private final SessionService sessionService;
    private final Scanner sc;

    public ListSuitableDonorController() {
        personRepository = new PersonRepository();
        listSuitableDonorImpl = new ListSuitableDonorImpl();
        LocationService = new LocationServiceImpl();
        sessionService = new SessionServiceImpl();
        sc = new Scanner(System.in);     
    }

    public void patientDonorList() throws CustomException {
        System.out.println("List of Suitable patient based on your profile");
        String personBloodType = null;
        List<Person> personList = personRepository.getPerson();
        String currentId = sessionService.getUserId();
        for (Person person : personList) {

            if (person.getpersonId().equals(currentId)) {

                personBloodType = person.getbloodGroup();
            }

        }

        List<String> donorId = new ArrayList<String>();
        donorId = listSuitableDonorImpl.getSuitableDonorID(personBloodType);
        if (donorId == null) {
            throw new CustomException("No donor found");
        }
        donorId.remove(currentId);
        List<DonorMedicalRecords> donorMedicalRecordsList = new ArrayList<DonorMedicalRecords>();
        System.out.println(donorId);
        for (int i = 0; i < donorId.size(); i++) {
            donorMedicalRecordsList.add(listSuitableDonorImpl.getSuitableDonor(donorId.get(i)));

        }
        for (int i = 0; i < donorMedicalRecordsList.size(); i++) {
            System.out.println(listSuitableDonorImpl.getDonorDetails(donorMedicalRecordsList.get(i).getdonorID()));
        }

    }

    public void organisationDonorSelection() throws CustomException {
        System.out.println("Do you want to select Donors according to various criteria Yes or No");
        String selection = sc.nextLine();
        HashMap<String, List<String>> donorSelection = new HashMap<String, List<String>>();
        List<String> choicesByOrganization = new ArrayList<String>();
        String typeSelection=null;
        if (selection.toLowerCase().equals("yes")) {
            System.out.println("Which blood type you want to select?");
            System.out.println("1. A+ve");
            System.out.println("2. A-ve");
            System.out.println("3. B+ve");
            System.out.println("4. B-ve");
            System.out.println("5. AB+ve");
            System.out.println("6. AB-ve");
            System.out.println("7. 0+ve");
            System.out.println("8. 0-ve");
            System.out.println("Select the blood group needed:");
            int bloodGroupSelected = Integer.parseInt(sc.nextLine());
            BloodGroup bloodGroup = null;
            if (bloodGroupSelected == 1) {
                bloodGroup = BloodGroup.APos;
            } else if (bloodGroupSelected == 2) {
                bloodGroup = BloodGroup.ANeg;
            } else if (bloodGroupSelected == 3) {
                bloodGroup = BloodGroup.BPos;
            } else if (bloodGroupSelected == 4) {
                bloodGroup = BloodGroup.BNeg;
            } else if (bloodGroupSelected == 5) {
                bloodGroup = BloodGroup.ABPos;
            } else if (bloodGroupSelected == 6) {
                bloodGroup = BloodGroup.ABNeg;
            } else if (bloodGroupSelected == 7) {
                bloodGroup = BloodGroup.OPos;
            } else if (bloodGroupSelected == 8) {
                bloodGroup = BloodGroup.ONeg;
            } else {
                System.out.println("Invalid Option. Please retry");
            }
            choicesByOrganization.add(bloodGroup.toString());
            List<Person> personList = personRepository.getPerson();
            String getDonorId = null;
            for (Person person : personList) {
                getDonorId = listSuitableDonorImpl.getBloodTypeId(bloodGroup.toString(), person.getpersonId());
                if (getDonorId == null) {
                    continue;
                }
                donorSelection.put(getDonorId, choicesByOrganization);

            }

        }
        
        System.out.println("Do you want to choose hemologin level");
        typeSelection = sc.nextLine();
        if (typeSelection.toLowerCase().equals("yes")) {
            System.out.println("Choose hemoglobin level between between 120-175 grams per litre");
            Integer hemoglobinLevel = Integer.parseInt(sc.nextLine());
            boolean hemoglobinFound = false;
            choicesByOrganization.add(Integer.toString(hemoglobinLevel));
            for (String key : donorSelection.keySet()) {
                hemoglobinFound = listSuitableDonorImpl.getHemoglobinCount(key, hemoglobinLevel);
                if (hemoglobinFound) {
                    donorSelection.put(key, choicesByOrganization);
                } else {
                    donorSelection.remove(key);
                }

            }
        }

        System.out.println("Do you want to choose platelet level");
        typeSelection = sc.nextLine();
        if (typeSelection.toLowerCase().equals("yes")) {
            System.out.println("Choose platelet count ");
            Integer plateletCount = Integer.parseInt(sc.nextLine());
            boolean plateletCountFound = false;
            choicesByOrganization.add(Integer.toString(plateletCount));

            for (String key : donorSelection.keySet()) {
                plateletCountFound = listSuitableDonorImpl.getPlateletCount(key, plateletCount);
                if (plateletCountFound) {

                    donorSelection.put(key, choicesByOrganization);
                } else {
                    donorSelection.remove(key);
                }

            }
        }

        System.out.println("Do you want to choose RBC level");
        typeSelection = sc.nextLine();
        if (typeSelection.toLowerCase().equals("yes")) {
            System.out.println("Choose RBC count");
            Integer rbcCount = Integer.parseInt(sc.nextLine());
            boolean rbcCountFound = false;
            choicesByOrganization.add(Integer.toString(rbcCount));
            for (String key : donorSelection.keySet()) {
                rbcCountFound = listSuitableDonorImpl.getRBCCount(key, rbcCount);
                if (rbcCountFound) {
                    donorSelection.put(key, choicesByOrganization);
                } else {
                    donorSelection.remove(key);
                }

            }

        }
        System.out.println(
                "Do you want to maximum location and the user will be added if the distance is less than 1000 meters");
        typeSelection = sc.nextLine();
        if (typeSelection.toLowerCase().equals("yes")) {
            for (String key : donorSelection.keySet()) {
                System.out.println("Enter values for " + key);
                System.out.println("Enter your pin code");
                String pinCode1 = sc.nextLine();
                System.out.println("Enter organisation pin code");
                String pinCode2 = sc.nextLine();
                Float distanceValue = LocationService.getDistanceInMeters(pinCode1, pinCode2);
                choicesByOrganization.add(Float.toString(distanceValue));
                if (distanceValue < 1000) {
                    donorSelection.put(key, choicesByOrganization);
                } else {
                    donorSelection.remove(key);
                }
            }
        }
        if (donorSelection.isEmpty()) {
            sc.close();
            throw new CustomException("No suitable match");
        }
        donorSelection.forEach((key, value) -> {
            String name = listSuitableDonorImpl.getPersonName(key);
            System.out.println(name);
            System.out.println(value);
        });
        sc.close();

    }

}
