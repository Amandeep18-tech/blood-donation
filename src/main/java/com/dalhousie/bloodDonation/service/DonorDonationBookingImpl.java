package com.dalhousie.bloodDonation.service;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.dalhousie.bloodDonation.constants.SlotAvailableConstants;
import com.dalhousie.bloodDonation.model.BloodDonationDetails;
import com.dalhousie.bloodDonation.model.BloodDonationDetaisHistory;
import com.dalhousie.bloodDonation.model.Organisation;
import com.dalhousie.bloodDonation.model.PatientBloodRequest;
import com.dalhousie.bloodDonation.model.PatientRequestMapping;
import com.dalhousie.bloodDonation.repos.BloodDonationDetailsHistoryRepository;
import com.dalhousie.bloodDonation.repos.BloodDonationDetailsRepository;
import com.dalhousie.bloodDonation.repos.OrganizationRepository;
import com.dalhousie.bloodDonation.repos.PatientBloodRequestRepository;
import com.dalhousie.bloodDonation.repos.PatientRequestMappingRepository;

public class DonorDonationBookingImpl implements DonorDonationBooking {

    @Override
    public String GetPatientRequestId(String donorID) throws SQLException{

        PatientRequestMappingRepository patientRequestMappingRepository= new PatientRequestMappingRepository();
        List<PatientRequestMapping> requestList = patientRequestMappingRepository.getAllDonorRequests();

        for(PatientRequestMapping patientRequestMapping:requestList){
            
            if(patientRequestMapping.getDonorOrOrganisationID().equals(donorID) )
            {
                if(patientRequestMapping.getAcceptFlag()==-1){

                
                return patientRequestMapping.getPatientBloodRequestID();
                }
            }
        }
        return null;
    }

    @Override
    public PatientBloodRequest GetPatientRequestDetails(String patientRequestID) throws SQLException{

        PatientBloodRequestRepository patientBloodRequestRepository = new PatientBloodRequestRepository();
        List<PatientBloodRequest> patientDetailsList = patientBloodRequestRepository.getAllDonorRequests();

        for(PatientBloodRequest patientBloodRequest:patientDetailsList){
            if(patientBloodRequest.getId().equals(patientRequestID)){
                return patientBloodRequest;
            }
            
            
        }
        return null;
    }

    @Override
    public String SelectDonationPlace(String placeName) throws SQLException {
        OrganizationRepository organizationRepository = new OrganizationRepository();
        List<Organisation> placeList = organizationRepository.getAllPlaces();

        for (Organisation organisation : placeList) {
            if (organisation.getOrganisation_name().equals(placeName)) {

                return organisation.getorganisationID();

            }
        }

        return null;

    }

    @Override
    public String GetDonationSlotId(String slotIdInput) throws SQLException {

        BloodDonationDetailsRepository bloodDonationDetailsRepository= new BloodDonationDetailsRepository();
        List<BloodDonationDetails> donationList = bloodDonationDetailsRepository.getAllDonorAppointment();
        for (BloodDonationDetails bloodDonationDetails : donationList) {
            if (bloodDonationDetails.getSlotNumber()== Integer.parseInt(slotIdInput)) {
                return bloodDonationDetails.getId();

            }

        }
        return SlotAvailableConstants.SLOT_UNAVAILABLE.toString();

    }

    @Override
    public boolean CompareDonationDate(String dateFormatInput, String slotIdInput) throws SQLException, ParseException {
        BloodDonationDetailsHistoryRepository bloodDonationDetailsHistoryRepository = new BloodDonationDetailsHistoryRepository();
        List<BloodDonationDetaisHistory> allDonationHistory = bloodDonationDetailsHistoryRepository.getAllDetails();

        for (BloodDonationDetaisHistory bloodDonationDetaisHistory : allDonationHistory) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateToString = dateFormat.format(bloodDonationDetaisHistory.getSlotDate());
            Date dateByUser = dateFormat.parse(dateToString);
            Date today = Calendar.getInstance().getTime();
            String todayDateToString = dateFormat.format(today);
            Date todayDate = dateFormat.parse(todayDateToString);
            
            
           if(todayDate.before(dateByUser)){
               return true;
           }


            if ((bloodDonationDetaisHistory.getSlotId().equals(slotIdInput)) && dateToString.equals(dateFormatInput) ) {
                return true;
            }

        }

        return false;

    }

    public ArrayList<String> GetTodayDonation() throws SQLException{
        BloodDonationDetailsHistoryRepository bloodDonationDetailsHistoryRepository = new BloodDonationDetailsHistoryRepository();
        List<BloodDonationDetaisHistory> bloodDonationDetailsHistoryList = bloodDonationDetailsHistoryRepository.getAllDetails();
        ArrayList<String> idList = new ArrayList<String>();
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String todayToString = simpleDateFormat.format(today);
        for(BloodDonationDetaisHistory bloodDonationDetaisHistory:bloodDonationDetailsHistoryList){
            System.out.println(bloodDonationDetaisHistory.getSlotDate());
            String donorDate= simpleDateFormat.format(bloodDonationDetaisHistory.getSlotDate());
            if(donorDate.equals(todayToString)){
                
                idList.add(bloodDonationDetaisHistory.getDonorId());
            }
        }
        return idList;
    
    }

}

