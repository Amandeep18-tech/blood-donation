package com.dalhousie.bloodDonation.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.dalhousie.bloodDonation.model.BloodDonationDetails;
import com.dalhousie.bloodDonation.model.BloodDonationDetaisHistory;
import com.dalhousie.bloodDonation.model.Organisation;
import com.dalhousie.bloodDonation.model.PatientBloodRequest;
import com.dalhousie.bloodDonation.repos.BloodDonationDetailsHistoryRepository;
import com.dalhousie.bloodDonation.repos.BloodDonationDetailsRepository;
import com.dalhousie.bloodDonation.repos.OrganizationRepository;
import com.dalhousie.bloodDonation.repos.PatientRequestMappingRepository;
import com.dalhousie.bloodDonation.service.DonorDonationBookingImpl;

public class DonorAppointmentController {
    DonorDonationBookingImpl donationBookingImpl = null;
    PatientBloodRequest patientBloodRequest = null;
    PatientRequestMappingRepository patientRequestMappingRepository = null;
    BloodDonationDetaisHistory bloodDonationDetaisHistory=null;
    BloodDonationDetailsHistoryRepository bloodDonationDetailsHistoryRepository=null;

    public DonorAppointmentController() throws SQLException {
        donationBookingImpl = new DonorDonationBookingImpl();
        patientBloodRequest = new PatientBloodRequest();
        patientRequestMappingRepository = new PatientRequestMappingRepository();
        bloodDonationDetaisHistory = new BloodDonationDetaisHistory();
        bloodDonationDetailsHistoryRepository = new BloodDonationDetailsHistoryRepository();
        
    }

    public void seeDonorRequests() throws SQLException {

        System.out.println("Please look into the blood donation requests you have");
        String donorId = "6c111307-4cbe-11ec-917b-e2ed2ce588f5";
        String getPatientId = donationBookingImpl.GetPatientRequestId(donorId);

        patientBloodRequest = donationBookingImpl.GetPatientRequestDetails(getPatientId);
        System.out.println("Appointment Time " + patientBloodRequest.getAppointmentTime());
        System.out.println("Appointment Time " + patientBloodRequest.getAppointmentDate());
    }

    public void confirmDonorRequests() throws SQLException {
        System.out.println("Do you want to confirm this appointment");
        System.out.println("Press 1 to confirm ");
        System.out.println("Press 2 to decline");
        Scanner sc = new Scanner(System.in);
        String choiceForDonation = sc.nextLine();

        if (choiceForDonation.equals("1")) {

            boolean checkUpdate = patientRequestMappingRepository.updateRequest("6c111307-4cbe-11ec-917b-e2ed2ce588f5",
                    1);
            if (checkUpdate) {
                System.out.println("Your appointment has been made");
            }
        } else {
            System.out.println("Thank you.. Please try to schedule a different appointment");
        }
    }

    public void displayAppointmentTime() throws SQLException {
        System.out.println("The available time is");

        System.out.println();

        BloodDonationDetailsRepository bloodDonationDetailsRepository = new BloodDonationDetailsRepository();

        List<BloodDonationDetails> donationList = bloodDonationDetailsRepository.getAllDonorAppointment();

        System.out.println("Slot ID Start time  End Time");
        for (BloodDonationDetails bloodDonationDetails : donationList) {
            System.out.println(bloodDonationDetails.getDonationTime());
        }

    }

    public String bookDonationPlace() throws SQLException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your choice");
        OrganizationRepository organizationRepository = new OrganizationRepository();
        List<Organisation> organisations = organizationRepository.getAllPlaces();
        System.out.println("Location   \t\tOrganisation name");
        for (Organisation organisation : organisations) {
            System.out.println(organisation.getLocation() + "\t" + organisation.getOrganisation_name());

        }
        String inputPlaceName = null;
        inputPlaceName = scanner.nextLine();

        String checkDonationPlace = null;
        checkDonationPlace = donationBookingImpl.SelectDonationPlace(checkDonationPlace);
        if (checkDonationPlace != null) {
            return checkDonationPlace;
        }
        return null;

    }

    public void bookDate() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        String appointmentBookingChoice = null;
        String slotDonationIdInput = null;
        boolean dateAvailable;
        String dateConfirmation = null;
        System.out.println();
        System.out.println("Please enter your choice");
        System.out.println("1.Press one for booking an appointment");
        System.out.println("2.Press two for exiting");

        appointmentBookingChoice = scanner.next();
        do {
            System.out.println();
            System.out.println("Enter the Date in YYYY-MM-DD format you want to book an appointment");
            switch (appointmentBookingChoice) {

                case "1":
                    System.out.println();

                    String dateInput = scanner.next();

                    System.out.println("Enter the Slot ID");

                    slotDonationIdInput = scanner.next();
                    System.out.println();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                    java.util.Date dateInput2 = null;
                    String getDonationSlotId = donationBookingImpl.GetDonationSlotId(slotDonationIdInput);

                    try {

                        dateInput2 = simpleDateFormat.parse(dateInput);
                    } catch (ParseException e) {

                        e.printStackTrace();
                    }
                    String dateFormat = simpleDateFormat.format(dateInput2);

                    dateAvailable = donationBookingImpl.CompareDonationDate(dateFormat, slotDonationIdInput);

                    if (dateAvailable) {
                        System.out.println();
                        System.out.println("Please enter a different date, this date is booked.");
                        continue;
                    }

                    else {
                        System.out.println();
                        System.out.println("Confirming this date");
                        System.out.println("Please press 1 for confirming this date");
                        System.out.println("Please press 2 for trying another date ");
                        dateConfirmation = scanner.next();
                        if (dateConfirmation.equals("1")) {
                            System.out.println();
                            boolean confirmDate = false;
                            confirmDate = bloodDonationDetailsHistoryRepository.saveDonationDate(bloodDonationDetaisHistory,
                                    getDonationSlotId,
                                    dateFormat);
                            if (confirmDate == true) {
                                System.out.println("Your appointment is booked");
                                System.out.println("Thank you");

                                appointmentBookingChoice = "2";
                                break;
                            }

                        }
                        continue;
                    }

                case "2":
                    System.out.println();
                    System.out.println("Thank you");
                    break;

            }
        } while (!appointmentBookingChoice.equals("2"));

    }

}
