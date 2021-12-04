package com.dalhousie.bloodDonation;

import com.dalhousie.bloodDonation.controller.FinancialDonationController;
import com.dalhousie.bloodDonation.controller.AppointmentController;
import com.dalhousie.bloodDonation.controller.DonorAppointmentController;
import com.dalhousie.bloodDonation.controller.DonorMedicalRecordController;
import com.dalhousie.bloodDonation.controller.ListSuitableDonorController;
import com.dalhousie.bloodDonation.utils.DBUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;

@SpringBootApplication
public class BloodDonationSystemApplication {

    public static void main(String[] args) throws SQLException, ParseException {
        DBUtils dbUtils = new DBUtils();
        Connection conn = dbUtils.getConnection();
        
        AppointmentController appointmentController= new AppointmentController();
        DonorMedicalRecordController donorMedicalRecordController = new DonorMedicalRecordController();
        DonorAppointmentController donorAppointmentController = new DonorAppointmentController();
        ListSuitableDonorController listSuitableDonorController= new ListSuitableDonorController();
        // appointmentController.displayAppointmentTime();
        
        // appointmentController.bookDate();
        // appointmentController.ShowPersonInactiveList();
        // appointmentController.MakePersonActive();
        donorMedicalRecordController.addMedicalRecords();
        // donorMedicalRecordController.editMedicalRecords();
        // donorAppointmentController.seeDonorRequests();
        // donorAppointmentController.confirmDonorRequests();
        // donorAppointmentController.displayAppointmentTime();
        // donorAppointmentController.bookDate();
        // listSuitableDonorController.patientDonorList();
        // listSuitableDonorController.organisationDonorSelection();
        SpringApplication.run(BloodDonationSystemApplication.class, args);
        // new FinancialDonationController().selectModeOfPayment();
    }

}
