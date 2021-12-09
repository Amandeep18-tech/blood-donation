package com.dalhousie.bloodDonation;

import com.dalhousie.bloodDonation.controller.DonorMedicalRecordController;
import com.dalhousie.bloodDonation.controller.DonorRecommendationController;
import com.dalhousie.bloodDonation.controller.PatientController;
import com.dalhousie.bloodDonation.controller.SurveyController;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.utils.DBUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

@SpringBootApplication
public class BloodDonationSystemApplication {

    public static void main(String[] args) throws SQLException, ParseException, CustomException {
        DBUtils dbUtils = new DBUtils();
        Connection conn = dbUtils.getConnection();

        // AppointmentController appointmentController= new AppointmentController();
        DonorMedicalRecordController donorMedicalRecordController = new DonorMedicalRecordController();
        // DonorAppointmentController donorAppointmentController = new DonorAppointmentController();
        // ListSuitableDonorController listSuitableDonorController= new ListSuitableDonorController();
        // appointmentController.displayAppointmentTime();
        // appointmentController.bookDate();
        // appointmentController.ShowPersonInactiveList();
        // appointmentController.MakePersonActive();
        //donorMedicalRecordController.addMedicalRecords();
        // donorMedicalRecordController.editMedicalRecords();
        // donorAppointmentController.seeDonorRequests();
        // donorAppointmentController.todayDonationConfirmation();
        // donorAppointmentController.confirmDonorRequests();
        // donorAppointmentController.displayAppointmentTime();
        // donorAppointmentController.bookDate();
        // listSuitableDonorController.patientDonorList();
        // listSuitableDonorController.organisationDonorSelection();
        // listSuitableDonorController.organisationDonorSelection();
        // MenuController menuController = new MenuController();
        // menuController.displayMenu();
        SpringApplication.run(BloodDonationSystemApplication.class, args);
    }

}
