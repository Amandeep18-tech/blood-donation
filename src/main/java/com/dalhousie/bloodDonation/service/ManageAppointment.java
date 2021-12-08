package com.dalhousie.bloodDonation.service;
import com.dalhousie.bloodDonation.model.DonorMedicalRecords;
import com.dalhousie.bloodDonation.model.MedicalAppointmentMaster;
import com.dalhousie.bloodDonation.model.Person;

import java.sql.SQLException;
import java.text.ParseException;

// import com.dalhousie.bloodDonation.model.MedicalAppointmentMaster;



public interface ManageAppointment {
    public String GetAvailableTime(MedicalAppointmentMaster medicalAppointmentMaster,String placeName);
    public String GetSlotId(String SlotIdInput);
    public boolean CompareDate(String dateFormat,String slotIdInput);
    public String SelectPlace(String placeName);
    public boolean CheckDonorMedicalID(String donorId);
    public DonorMedicalRecords GetDonorDetails(String donorId);
   
    
}
