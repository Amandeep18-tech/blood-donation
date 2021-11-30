package com.dalhousie.bloodDonation.controller;

import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.service.OrgBloodDonationService;
import com.dalhousie.bloodDonation.service.OrgBloodDonationServiceImpl;

import java.util.*;

public class OrgBloodRequestController {

    private OrgBloodDonationService orgBloodDonationService;
    private Scanner scanner;
    private String ORG_ID = "O001";

    public OrgBloodRequestController() {
        orgBloodDonationService = new OrgBloodDonationServiceImpl();
        scanner = new Scanner(System.in);
    }

    public void mainMenu() {
        System.out.println("*********Organization blood request*******");
        int optionSelected;
        do {
            System.out.println("1. Request Blood from other Organization");
            System.out.println("2. Pending Request");
            System.out.println("3. List blood donated available:(sort by expiry/group by bloodGroup)");
            optionSelected = scanner.nextInt();
            try {
                switch (optionSelected) {
                    case 1:
                        requestBlood();
                        break;
                    case 2:
                        pendingRequest();
                        break;
                    case 3:
                        listBloodAvailable();
                        break;
                    default:
                        System.out.println("Invalid option. Retry.");
                }
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        } while (optionSelected != 9);
        System.out.println("Redirecting to previous menu.");
    }

    private void requestBlood() throws CustomException {
        String orgSelected;
        do {
            System.out.println("Enter the units of blood needed:");
            int unitsNeeded = scanner.nextInt();
            System.out.println("1. A+ve");
            System.out.println("2. A-ve");
            System.out.println("3. B+ve");
            System.out.println("4. B-ve");
            System.out.println("5. AB+ve");
            System.out.println("6. AB-ve");
            System.out.println("7. 0+ve");
            System.out.println("8. 0-ve");
            System.out.println("Select the blood group needed:");
            int bloodGroupSelected = scanner.nextInt();
            BloodGroup bloodGroup = null;
            if(bloodGroupSelected == 1){
                bloodGroup = BloodGroup.APos;
            }else if(bloodGroupSelected == 2){
                bloodGroup = BloodGroup.ANeg;
            }else if(bloodGroupSelected == 3){
                bloodGroup = BloodGroup.BPos;
            }else if(bloodGroupSelected == 4){
                bloodGroup = BloodGroup.BNeg;
            }else if(bloodGroupSelected == 5){
                bloodGroup = BloodGroup.ABPos;
            }else if(bloodGroupSelected == 6){
                bloodGroup = BloodGroup.ABNeg;
            }else if(bloodGroupSelected == 7){
                bloodGroup = BloodGroup.OPos;
            }else if(bloodGroupSelected == 8){
                bloodGroup = BloodGroup.ONeg;
            } else{
                System.out.println("Invalid Option. Please retry");
            }
            LinkedHashMap<String, String> recommendedOrganisation = orgBloodDonationService.getRecommendedOrganisation(unitsNeeded, bloodGroup);
            recommendedOrganisation.entrySet().forEach(System.out::println);
            System.out.println("Select the organisation to request(*-all/#-go back):");
            orgSelected = scanner.next();
            try {
                orgBloodDonationService.requestBlood(ORG_ID, orgSelected, bloodGroup, unitsNeeded);
                System.out.println("Blood Requested!");
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        } while (orgSelected != "#");
    }

    private void pendingRequest() throws CustomException {
        HashMap<Integer, String> pendingRequests = (HashMap<Integer, String>) orgBloodDonationService.getPendingRequests(ORG_ID);
        String optionSelected;
        do {
            pendingRequests.entrySet().forEach(System.out::println);
            System.out.println("Select the request to approve(# to go back):");
            optionSelected = scanner.next();
            try {
                orgBloodDonationService.acceptBloodRequest(optionSelected);
                System.out.println("Blood Donated!");
            } catch (CustomException e) {
                System.out.println(e.getMessage());
            }
        } while (optionSelected != "#");
    }

    private void listBloodAvailable() throws CustomException {
        int optionSelected;
        do {
            System.out.println("1. Show by Donor ID");
            System.out.println("2. Show by Blood Group");
            System.out.println("9. Return to Previous Menu");
            optionSelected = scanner.nextInt();
            try {
                List<String[]> responses = new ArrayList<>();
                switch (optionSelected) {
                    case 1:
                        responses = orgBloodDonationService.getListByDonorId(ORG_ID);
                        break;
                    case 2:
                        responses = orgBloodDonationService.getListByBloodGroup(ORG_ID);
                        break;
                    default:
                        System.out.println("Invalid Option. Please retry");
                }
                if (responses.size() > 0) {
                    for (String[] response : responses) {
                        for (int i = 0; i < response.length; i++) {
                            System.out.print(response[i] + "|");
                        }
                    }
                }
            } catch (CustomException e) {
                System.out.println("Invalid Details: " + e.getMessage());
            }
        } while (optionSelected != 9);
    }
}
