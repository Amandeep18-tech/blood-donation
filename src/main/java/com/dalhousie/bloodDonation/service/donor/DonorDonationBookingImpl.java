package com.dalhousie.bloodDonation.service.donor;

import com.dalhousie.bloodDonation.constants.SlotAvailableConstants;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.donor.BloodDonationDetails;
import com.dalhousie.bloodDonation.model.donor.BloodDonationDetaisHistory;
import com.dalhousie.bloodDonation.model.organisation.Organisation;
import com.dalhousie.bloodDonation.model.patient.PatientBloodRequest;
import com.dalhousie.bloodDonation.model.patient.PatientRequestMapping;
import com.dalhousie.bloodDonation.repos.donor.BloodDonationDetailsHistoryRepository;
import com.dalhousie.bloodDonation.repos.donor.BloodDonationDetailsRepository;
import com.dalhousie.bloodDonation.repos.organisation.OrganizationRepository;
import com.dalhousie.bloodDonation.repos.patient.PatientBloodRequestRepository;
import com.dalhousie.bloodDonation.repos.patient.PatientRequestMappingRepository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DonorDonationBookingImpl implements DonorDonationBooking {

    @Override
    public String getPatientRequestId(String donorID) {
        PatientRequestMappingRepository patientRequestMappingRepository = new PatientRequestMappingRepository();
        List<PatientRequestMapping> requestList = patientRequestMappingRepository.getAllDonorRequests();
        for (PatientRequestMapping patientRequestMapping : requestList) {
            if (patientRequestMapping.getDonorOrOrganisationID().equals(donorID)) {
                if (patientRequestMapping.getAcceptFlag() == -1) {
                    return patientRequestMapping.getPatientBloodRequestID();
                }
            }
        }
        return null;
    }

    @Override
    public PatientBloodRequest getPatientRequestDetails(String patientRequestID) {
        PatientBloodRequestRepository patientBloodRequestRepository = new PatientBloodRequestRepository();
        List<PatientBloodRequest> patientDetailsList = patientBloodRequestRepository.getAllDonorRequests();
        for (PatientBloodRequest patientBloodRequest : patientDetailsList) {
            if (patientBloodRequest.getId().equals(patientRequestID)) {
                return patientBloodRequest;
            }
        }
        return null;
    }

    @Override
    public String selectDonationPlace(String placeName) {
        OrganizationRepository organizationRepository = new OrganizationRepository();
        List<Organisation> placeList = organizationRepository.getAllPlaces();
        for (Organisation organisation : placeList) {
            if (organisation.getorganisationName().equals(placeName)) {
                return organisation.getorganisationID();
            }
        }
        return null;
    }

    @Override
    public String getDonationSlotId(String slotIdInput) {
        BloodDonationDetailsRepository bloodDonationDetailsRepository = new BloodDonationDetailsRepository();
        List<BloodDonationDetails> donationList = bloodDonationDetailsRepository.getAllDonorAppointment();
        for (BloodDonationDetails bloodDonationDetails : donationList) {
            if (bloodDonationDetails.getSlotNumber() == Integer.parseInt(slotIdInput)) {
                return bloodDonationDetails.getId();
            }
        }
        return SlotAvailableConstants.SLOT_UNAVAILABLE.toString();
    }

    @Override
    public boolean compareDonationDate(String dateFormatInput, String slotIdInput) {
        BloodDonationDetailsHistoryRepository bloodDonationDetailsHistoryRepository = new BloodDonationDetailsHistoryRepository();
        List<BloodDonationDetaisHistory> allDonationHistory = bloodDonationDetailsHistoryRepository.getAllDetails();
        for (BloodDonationDetaisHistory bloodDonationDetaisHistory : allDonationHistory) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateToString = dateFormat.format(bloodDonationDetaisHistory.getSlotDate());
            if ((bloodDonationDetaisHistory.getSlotId().equals(slotIdInput))
                    && dateToString.equals(dateFormatInput)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> getTodayDonation() throws CustomException {
        BloodDonationDetailsHistoryRepository bloodDonationDetailsHistoryRepository = new BloodDonationDetailsHistoryRepository();
        List<BloodDonationDetaisHistory> bloodDonationDetailsHistoryList = bloodDonationDetailsHistoryRepository
                .getAllDetails();
        ArrayList<String> idList = new ArrayList<String>();
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String todayToString = simpleDateFormat.format(today);
        for (BloodDonationDetaisHistory bloodDonationDetaisHistory : bloodDonationDetailsHistoryList) {
            String donorDate = simpleDateFormat.format(bloodDonationDetaisHistory.getSlotDate());
            if (donorDate.equals(todayToString)) {
                idList.add(bloodDonationDetaisHistory.getDonorId());
            }
        }
        if (idList.size() == 0) {
            throw new CustomException("No donation for today");
        }
        return idList;
    }

    public ArrayList<String> getTodayPatientRequest() throws CustomException {
        PatientBloodRequestRepository patientBloodRequestRepository = new PatientBloodRequestRepository();
        List<PatientBloodRequest> patientBloodRequestsList = patientBloodRequestRepository.getAllDonorRequests();
        ArrayList<String> idList = new ArrayList<String>();
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String todayToString = simpleDateFormat.format(today);
        for (PatientBloodRequest patientBloodRequest : patientBloodRequestsList) {
            String donorDate = simpleDateFormat.format(patientBloodRequest.getAppointmentDate());
            if (donorDate.equals(todayToString)) {
                idList.add(patientBloodRequest.getPatientID());
            }
        }
        if (idList.size() == 0) {
            throw new CustomException("No donation for today");
        }
        return idList;
    }
}