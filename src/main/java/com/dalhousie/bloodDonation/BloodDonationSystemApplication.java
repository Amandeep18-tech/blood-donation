package com.dalhousie.bloodDonation;

import com.dalhousie.bloodDonation.controller.FinancialDonationController;
import com.dalhousie.bloodDonation.controller.AppointmentController;
import com.dalhousie.bloodDonation.controller.DonorAppointmentController;
import com.dalhousie.bloodDonation.controller.DonorMedicalRecordController;
import com.dalhousie.bloodDonation.controller.ListSuitableDonorController;
import com.dalhousie.bloodDonation.utils.DBUtils;
import com.dalhousie.bloodDonation.controller.MenuController;
import com.dalhousie.bloodDonation.exception.CustomException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

import javax.mail.MessagingException;

@SpringBootApplication
public class BloodDonationSystemApplication {

    public static void main(String[] args) throws SQLException, ParseException, CustomException, UnsupportedEncodingException, MessagingException {
        DBUtils dbUtils = new DBUtils();
        Connection conn = dbUtils.getConnection();
        
        // AppointmentController appointmentController= new AppointmentController();
        // DonorMedicalRecordController donorMedicalRecordController = new DonorMedicalRecordController();
        DonorAppointmentController donorAppointmentController = new DonorAppointmentController();
        // ListSuitableDonorController listSuitableDonorController= new ListSuitableDonorController();
        // appointmentController.displayAppointmentTime();
        // appointmentController.bookDate();
        // appointmentController.ShowPersonInactiveList();
        // appointmentController.MakePersonActive();
        // donorMedicalRecordController.addMedicalRecords();
        // donorMedicalRecordController.editMedicalRecords();
        // donorAppointmentController.seeDonorRequests();
        // donorAppointmentController.todayDonationConfirmation();
        // donorAppointmentController.confirmDonorRequests();
        donorAppointmentController.bookDonationPlace();
        donorAppointmentController.displayAppointmentTime();
        donorAppointmentController.bookDate();
        // listSuitableDonorController.patientDonorList();
        // listSuitableDonorController.organisationDonorSelection();
        // listSuitableDonorController.organisationDonorSelection();
        // MenuController menuController = new MenuController();
        // donorAppointmentController.seePatientRequestStatus();
        // donorAppointmentController.todayPatientRequestConfirmation();
        // menuController.displayMenu();
        SpringApplication.run(BloodDonationSystemApplication.class, args);
    }

}
