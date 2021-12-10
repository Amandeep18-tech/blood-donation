package com.dalhousie.bloodDonation.service.donor;

import java.util.ArrayList;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.patient.PatientBloodRequest;

public interface DonorDonationBooking{
    public String getPatientRequestId(String donorID);
    public PatientBloodRequest getPatientRequestDetails(String patientRequestID);
    public String selectDonationPlace(String placeName) ;
    public String getDonationSlotId(String slotIdInput) ;
    public boolean compareDonationDate(String dateFormatInput, String slotIdInput) ;
    public ArrayList<String> getTodayDonation() throws CustomException ;
    public ArrayList<String> getTodayPatientRequest() throws CustomException ;
}