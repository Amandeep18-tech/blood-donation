package com.dalhousie.bloodDonation.service;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.PatientBloodRequest;

public interface DonorDonationBooking{
    public String GetPatientRequestId(String donorID);
    public PatientBloodRequest GetPatientRequestDetails(String patientRequestID);
    public String SelectDonationPlace(String placeName) ;
    public String GetDonationSlotId(String slotIdInput) ;
    public boolean CompareDonationDate(String dateFormatInput, String slotIdInput) ;
    public ArrayList<String> GetTodayDonation() throws CustomException ;
}