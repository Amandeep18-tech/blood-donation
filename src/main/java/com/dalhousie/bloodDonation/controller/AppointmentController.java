package com.dalhousie.bloodDonation.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.MedicalAppointmentDetails;
import com.dalhousie.bloodDonation.model.MedicalAppointmentMaster;
import com.dalhousie.bloodDonation.model.Organisation;
import com.dalhousie.bloodDonation.repos.MedicalAppointmentMasterRespository;
import com.dalhousie.bloodDonation.repos.OrganizationRepository;
import com.dalhousie.bloodDonation.service.LocationService;
import com.dalhousie.bloodDonation.service.LocationServiceImpl;
import com.dalhousie.bloodDonation.service.ManageAppointment;
import com.dalhousie.bloodDonation.service.ManageAppointmentImpl;
import com.dalhousie.bloodDonation.repos.MedicalAppointmentDetailRepository;
import com.dalhousie.bloodDonation.utils.IOUtils;

public class AppointmentController {
    private final ManageAppointment manageAppointment;
    private final MedicalAppointmentDetails medicalAppointmentDetails;
    private final MedicalAppointmentDetailRepository medicalAppointmentDetailRepository;
    private final LocationService locationService;
    private final Scanner scanner;

    public AppointmentController() {
        manageAppointment = new ManageAppointmentImpl();
        medicalAppointmentDetailRepository = new MedicalAppointmentDetailRepository();
        medicalAppointmentDetails = new MedicalAppointmentDetails();
        locationService = new LocationServiceImpl();
        scanner = IOUtils.getInstance();

    }

    public void displayAppointmentTime() throws CustomException {
        System.out.println("The available time is");

        System.out.println();

        MedicalAppointmentMasterRespository appointmentDAOImpl = new MedicalAppointmentMasterRespository();
        List<MedicalAppointmentMaster> appointmentList = appointmentDAOImpl.getAllAppointment();
        String storeCheckPlace = bookPlace();
        String slotTime = null;
        System.out.println("Slot ID Start time  End Time");
        for (MedicalAppointmentMaster medical_appointment_available : appointmentList) {
            slotTime = manageAppointment.getAvailableTime(medical_appointment_available, storeCheckPlace);
            System.out.println(slotTime);
        }

    }

    public String bookPlace() throws CustomException {
        System.out.println("Please enter your choice");
        OrganizationRepository organizationRepository = new OrganizationRepository();
        List<Organisation> organisations = organizationRepository.getAllPlaces();
        System.out.println("Location   \t\tOrganisation name");
        for (Organisation organisation : organisations) {
            System.out.println(organisation.getLocation() + "\t" + organisation.getorganisationName());

        }
        String inputPlaceName = null;
        inputPlaceName = scanner.nextLine();

        String checkPlace = null;
        checkPlace = manageAppointment.selectPlace(inputPlaceName);
        if (checkPlace == null) {
            throw new CustomException("Invalid place");
        }

        return checkPlace;

    }

    public void bookDate() {
        String appointmentBookingChoice = null;
        String slotIdInput = null;
        boolean dateAvailable;
        String dateConfirmation = null;
        System.out.println();
        System.out.println("Please enter your choice");
        System.out.println("1.Press one for booking an appointment");
        System.out.println("2.Press two for exiting");
        appointmentBookingChoice = scanner.nextLine();
        do {
            System.out.println();
            System.out.println("Enter the Date in YYYY-MM-DD format you want to book an appointment");
            switch (appointmentBookingChoice) {

                case "1":
                    System.out.println();
                    String dateInput = scanner.nextLine();
                    System.out.println("Enter the Slot ID");
                    slotIdInput = scanner.nextLine();
                    System.out.println();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                    java.util.Date dateInput2 = null;
                    String getSlotId = manageAppointment.getSlotId(slotIdInput);
                    try {

                        dateInput2 = simpleDateFormat.parse(dateInput);
                    } catch (ParseException e) {
                        e.printStackTrace();
                    }
                    String dateFormat = simpleDateFormat.format(dateInput2);
                    dateAvailable = manageAppointment.compareDate(dateFormat, getSlotId);
                    if (dateAvailable) {
                        System.out.println();
                        System.out.println("Please enter a different date, this date is unavailable");
                        continue;
                    } else {
                        System.out.println();
                        System.out.println("Confirming this date");
                        System.out.println("Please press 1 for confirming this date");
                        System.out.println("Please press 2 for trying another date ");
                        dateConfirmation = scanner.nextLine();
                        if (dateConfirmation.equals("1")) {
                            System.out.println();
                            boolean confirmDate = false;
                            confirmDate = medicalAppointmentDetailRepository.saveDate(medicalAppointmentDetails, getSlotId,
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

        getRouteToOrganisation();
    }

    public void getRouteToOrganisation() {
        System.out.println("Enter your pin code");
        String pinCode1 = scanner.nextLine();
        System.out.println("Enter your pin code");
        String pinCode2 = scanner.nextLine();
        String route = locationService.getShortestPath(pinCode1, pinCode2);
        System.out.println(route);
        scanner.close();
    }

    public void confirmMedicalAppointment() throws CustomException {
        displayAppointmentTime();
        bookDate();
    }
}
