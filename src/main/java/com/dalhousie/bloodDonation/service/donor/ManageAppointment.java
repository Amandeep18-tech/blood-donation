package com.dalhousie.bloodDonation.service.donor;
import com.dalhousie.bloodDonation.model.donor.DonorMedicalRecords;
import com.dalhousie.bloodDonation.model.donor.MedicalAppointmentMaster;

public interface ManageAppointment {
    public String getAvailableTime(MedicalAppointmentMaster medicalAppointmentMaster,String placeName);
    public String getSlotId(String SlotIdInput);
    public boolean compareDate(String dateFormat,String slotIdInput);
    public String selectPlace(String placeName);
    public boolean checkDonorMedicalID(String donorId);
    public DonorMedicalRecords getDonorDetails(String donorId);
   
    
}
