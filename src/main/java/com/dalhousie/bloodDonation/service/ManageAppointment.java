package com.dalhousie.bloodDonation.service;
import com.dalhousie.bloodDonation.model.DonorMedicalRecords;
import com.dalhousie.bloodDonation.model.MedicalAppointmentMaster;
import com.dalhousie.bloodDonation.model.Person;

import java.sql.SQLException;

// import com.dalhousie.bloodDonation.model.MedicalAppointmentMaster;



public interface ManageAppointment {
    public String GetAvailableTime(MedicalAppointmentMaster medicalAppointmentMaster,String placeName) throws SQLException;
    public String GetSlotId(String SlotIdInput) throws SQLException;
    public boolean CompareDate(String dateFormat,String slotIdInput) throws SQLException;
    public String SelectPlace(String placeName) throws SQLException;
    public String GetPersonWithInactiveStatus(Person person) throws SQLException;
    public boolean CheckDonorMedicalID(String donorId) throws SQLException;
    public DonorMedicalRecords GetDonorDetails(String donorId) throws SQLException;
   
    
}
