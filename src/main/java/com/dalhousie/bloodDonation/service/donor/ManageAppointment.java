package com.dalhousie.bloodDonation.service.donor;
import com.dalhousie.bloodDonation.model.donor.DonorMedicalRecords;
import com.dalhousie.bloodDonation.model.donor.MedicalAppointmentMaster;

public interface ManageAppointment {
    String getAvailableTime(MedicalAppointmentMaster medicalAppointmentMaster,String placeName);
    String getSlotId(String SlotIdInput);
    boolean compareDate(String dateFormat,String slotIdInput);
    String selectPlace(String placeName);
    boolean checkDonorMedicalID(String donorId);
    DonorMedicalRecords getDonorDetails(String donorId);
}
