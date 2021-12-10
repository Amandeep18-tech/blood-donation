package com.dalhousie.bloodDonation.controller.organisation;

import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.service.common.SessionService;
import com.dalhousie.bloodDonation.service.common.SessionServiceImpl;
import com.dalhousie.bloodDonation.service.organisation.OrgBloodDonationService;
import com.dalhousie.bloodDonation.service.organisation.OrgBloodDonationServiceImpl;
import com.dalhousie.bloodDonation.utils.IOUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class OrgBloodRequestController {

    private final OrgBloodDonationService orgBloodDonationService;
    private final Scanner scanner;
    private final SessionService sessionService;

    public OrgBloodRequestController() {
        orgBloodDonationService = new OrgBloodDonationServiceImpl();
        scanner = IOUtils.getInstance();
        sessionService = new SessionServiceImpl();
    }

    public void mainMenu() {
        System.out.println("*********Organization blood request*******");
        int optionSelected;
        do {
            System.out.println("1. Request Blood from other Organization");
            System.out.println("2. Pending Request");
            System.out.println("3. List blood donated available:(sort by expiry/group by bloodGroup)");
            optionSelected = scanner.nextInt();
            scanner.nextLine();
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

    public void requestBlood() throws CustomException {
        String orgSelected;
        System.out.println("Enter the units of blood needed:");
        int unitsNeeded = scanner.nextInt();
        scanner.nextLine();
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
        scanner.nextLine();
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
        List<String[]> recommendedOrganisation = orgBloodDonationService.getRecommendedOrganisation(unitsNeeded, bloodGroup);
        System.out.println(String.format("%-50s%-50s%-50s%-50s%-50s%-50s","Org ID","Org Name","Units Available","Location","Shortest Path","Distance in Ms"));
        if (recommendedOrganisation.size() > 0) {
            for (String[] response : recommendedOrganisation) {
                for (int i = 0; i < response.length; i++) {
                    System.out.print(String.format("%-50s", response[i] ));
                }
                System.out.println();
            }
        }
        System.out.println("Select the organisation to request(#-go back):");
        orgSelected = scanner.nextLine();
        if (orgSelected.equalsIgnoreCase("#")) return;
        try {
            orgBloodDonationService.requestBlood(sessionService.getUserId(), orgSelected, bloodGroup, unitsNeeded);
            System.out.println("Blood Requested!");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }
    }

    public void pendingRequest() throws CustomException {
        HashMap<Integer, String> pendingRequests = (HashMap<Integer, String>) orgBloodDonationService.getPendingRequests(sessionService.getUserId());
        if (pendingRequests.isEmpty()) {
            System.out.println("No Pending Request!");
            return;
        }
        String optionSelected;
        System.out.println(String.format("%-20s%-20s%-20s%-20s%-20s", "Request ID", "Organization Name", "Blood Group", "Units Requested", "Time Requested"));
        pendingRequests.entrySet().forEach(integerStringEntry -> System.out.println(String.format("%-20s%s", integerStringEntry.getKey(), integerStringEntry.getValue())));
        System.out.println("Select the request to approve(# to go back):");
        optionSelected = scanner.nextLine();
        if (optionSelected.equalsIgnoreCase("#")) return;
        try {
            orgBloodDonationService.acceptBloodRequest(optionSelected);
            System.out.println("Blood Donated!");
        } catch (CustomException e) {
            System.out.println(e.getMessage());
        }

    }

    public void listBloodAvailable() throws CustomException {
        int optionSelected;
        do {
            System.out.println("1. Show by Donor");
            System.out.println("2. Show by Blood Group");
            System.out.println("9. Return to Previous Menu");
            optionSelected = scanner.nextInt();
            scanner.nextLine();
            try {
                List<String[]> responses = new ArrayList<>();
                switch (optionSelected) {
                    case 1:
                        responses = orgBloodDonationService.getListByDonorId(sessionService.getUserId());
                        System.out.println(String.format("%-50s%-50s%-50s%-50s%-50s","Organization ID","Donor Name","Donor Contact No","Donated Time","Donor Blood Group"));
                        break;
                    case 2:
                        responses = orgBloodDonationService.getListByBloodGroup(sessionService.getUserId());
                        System.out.println(String.format("%-50s %-50s","Blood Group","Units Available"));
                        break;
                    default:
                        System.out.println("Invalid Option. Please retry");
                }
                if (responses.size() > 0) {
                    for (String[] response : responses) {
                        for (int i = 0; i < response.length; i++) {
                            System.out.print(String.format("%-50s", response[i] ));
                        }
                        System.out.println();
                    }
                }
            } catch (CustomException e) {
                System.out.println("Invalid Details: " + e.getMessage());
            }
        } while (optionSelected != 9);
    }
}
