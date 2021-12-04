package com.dalhousie.bloodDonation.controller;

import java.rmi.ConnectIOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Scanner;

import com.dalhousie.bloodDonation.model.MedicalAppointmentDetails;
import com.dalhousie.bloodDonation.model.MedicalAppointmentMaster;
import com.dalhousie.bloodDonation.model.Organisation;
import com.dalhousie.bloodDonation.model.Person;
import com.dalhousie.bloodDonation.repos.MedicalAppointmentMasterRespository;
import com.dalhousie.bloodDonation.repos.OrganizationRepository;
import com.dalhousie.bloodDonation.repos.PersonRepository;
import com.dalhousie.bloodDonation.service.ManageAppointmentImpl;
import com.dalhousie.bloodDonation.repos.MedicalAppointmentDetailRepository;

public class AppointmentController {
    private ManageAppointmentImpl manageAppointmentImpl = null;
    private MedicalAppointmentMaster medicalAppointmentMaster = null;
    private OrganizationRepository organizationRepository = null;
    private MedicalAppointmentDetails medicalAppointmentDetails = null;
    private MedicalAppointmentDetailRepository medicalAppointmentDetailRepository = null;
    private PersonRepository personRepository=null;


    public AppointmentController() throws SQLException {
        personRepository= new PersonRepository();
        manageAppointmentImpl = new ManageAppointmentImpl();
        medicalAppointmentMaster = new MedicalAppointmentMaster();
        organizationRepository = new OrganizationRepository();
        medicalAppointmentDetailRepository = new MedicalAppointmentDetailRepository();
        medicalAppointmentDetails = new MedicalAppointmentDetails();

    }

    public void displayAppointmentTime() throws SQLException {
        System.out.println("The available time is");

        System.out.println();

        MedicalAppointmentMasterRespository appointmentDAOImpl = new MedicalAppointmentMasterRespository();
        List<MedicalAppointmentMaster> appointmentList = appointmentDAOImpl.getAllAppointment();
        String storeCheckPlace = bookPlace();
        String slotTime = null;
        System.out.println("Slot ID Start time  End Time");
        for (MedicalAppointmentMaster medical_appointment_available : appointmentList) {
            slotTime = manageAppointmentImpl.GetAvailableTime(medical_appointment_available, storeCheckPlace);
            System.out.println(slotTime);
        }

    }

    public String bookPlace() throws SQLException {
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

        String checkPlace = null;
        checkPlace = manageAppointmentImpl.SelectPlace(inputPlaceName);
        if (checkPlace != null) {
            return checkPlace;
        }
        return null;

    }

    public void bookDate() throws SQLException {

        Scanner scanner = new Scanner(System.in);

        String appointmentBookingChoice = null;
        String slotIdInput = null;
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

                slotIdInput = scanner.next();
                System.out.println();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

                java.util.Date dateInput2 = null;
                String getSlotId = manageAppointmentImpl.GetSlotId(slotIdInput);

                try {

                    dateInput2 = simpleDateFormat.parse(dateInput);
                } catch (ParseException e) {

                    e.printStackTrace();
                }
                String dateFormat = simpleDateFormat.format(dateInput2);

                dateAvailable = manageAppointmentImpl.CompareDate(dateFormat, getSlotId);

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

    }

    public void ShowPersonInactiveList() throws SQLException
    {
        
        List<Person> personList=personRepository.getPerson();
        
        String personDetail;
        System.out.println("List of person with inactive status");
        for (Person person:personList) {
            personDetail = manageAppointmentImpl.GetPersonWithInactiveStatus(person);
            System.out.println(personDetail);
        }


    }

    public void MakePersonActive() throws SQLException{
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the first name of the person who attended their appointment");
        String inputName=scanner.nextLine();
        personRepository.updatePersonStatus();
        
        


    }



}
