package com.dalhousie.bloodDonation.service;

import java.util.ArrayList;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.PatientBloodRequest;

public interface DonorDonationBooking{
    public String getPatientRequestId(String donorID);
    public PatientBloodRequest getPatientRequestDetails(String patientRequestID);
    public String selectDonationPlace(String placeName) ;
    public String getDonationSlotId(String slotIdInput) ;
    public boolean compareDonationDate(String dateFormatInput, String slotIdInput) ;
    public ArrayList<String> getTodayDonation() throws CustomException ;
}