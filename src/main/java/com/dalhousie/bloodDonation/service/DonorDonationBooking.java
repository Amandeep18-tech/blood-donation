package com.dalhousie.bloodDonation.service;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import com.dalhousie.bloodDonation.model.PatientBloodRequest;

public interface DonorDonationBooking{
    public String GetPatientRequestId(String donorID) throws SQLException;
    public PatientBloodRequest GetPatientRequestDetails(String patientRequestID) throws SQLException;
    public String SelectDonationPlace(String placeName) throws SQLException;
    public String GetDonationSlotId(String slotIdInput) throws SQLException;
    public boolean CompareDonationDate(String dateFormatInput, String slotIdInput) throws SQLException, ParseException;
    public ArrayList<String> GetTodayDonation() throws SQLException;
}