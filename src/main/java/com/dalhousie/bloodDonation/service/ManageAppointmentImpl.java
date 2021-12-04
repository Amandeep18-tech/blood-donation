package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.repos.DonorMedicalRecordsRepository;
import com.dalhousie.bloodDonation.repos.MedicalAppointmentDetailRepository;
import com.dalhousie.bloodDonation.repos.MedicalAppointmentMasterRespository;
import com.dalhousie.bloodDonation.repos.OrganizationRepository;
import com.dalhousie.bloodDonation.repos.PersonRepository;
import com.dalhousie.bloodDonation.constants.SlotAvailableConstants;

import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.dalhousie.bloodDonation.constants.SlotAvailableConstants;
import com.dalhousie.bloodDonation.model.DonorMedicalRecords;
import com.dalhousie.bloodDonation.model.MedicalAppointmentDetails;
import com.dalhousie.bloodDonation.model.MedicalAppointmentMaster;
import com.dalhousie.bloodDonation.model.Organisation;
import com.dalhousie.bloodDonation.model.Person;
import com.dalhousie.bloodDonation.model.Organisation;

public class ManageAppointmentImpl implements ManageAppointment {

    @Override
    public String GetAvailableTime(MedicalAppointmentMaster medicalAppointmentMaster, String placeName)
            throws SQLException {
        if (medicalAppointmentMaster.getorganisationID().equals(placeName)) {
            
            return medicalAppointmentMaster.getslotNumber() + " " + medicalAppointmentMaster.getslotStartTime() + " "
                    + medicalAppointmentMaster.getslotEndTime();
        }

        return null;
    }

    @Override
    public String GetSlotId(String slotIdInput) throws SQLException {

        MedicalAppointmentMasterRespository medicalAppointmentMasterRespository = new MedicalAppointmentMasterRespository();
        List<MedicalAppointmentMaster> masterList = medicalAppointmentMasterRespository.getAllAppointment();
        for (MedicalAppointmentMaster medicalAppointmentMaster : masterList) {
            if (medicalAppointmentMaster.getslotNumber() == Integer.parseInt(slotIdInput)) {
                return medicalAppointmentMaster.getmedicalAppointmentMasterID();

            }

        }
        return SlotAvailableConstants.SLOT_UNAVAILABLE.toString();

    }

    @Override
    public boolean CompareDate(String dateFormatInput, String slotIdInput) throws SQLException, ParseException {
        MedicalAppointmentDetailRepository medicalAppointmentDetailRepository = new MedicalAppointmentDetailRepository();

        List<MedicalAppointmentDetails> detailList = medicalAppointmentDetailRepository.getAllDetails();

        for (MedicalAppointmentDetails medicalAppointmentDetail : detailList) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateToString = dateFormat.format(medicalAppointmentDetail.getslotDate());
            Date dateByUser = dateFormat.parse(dateToString);
            Date today = Calendar.getInstance().getTime();
            String todayDateToString = dateFormat.format(today);
            Date todayDate = dateFormat.parse(todayDateToString);
            
            
           if(todayDate.before(dateByUser)){
               return true;
           }

            if (medicalAppointmentDetail.getslotID().equals(slotIdInput) && dateToString.equals(dateFormatInput)) {
                return true;
            }

        }

        return false;

    }

    @Override
    public String SelectPlace(String placeName) throws SQLException {
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
    public String GetPersonWithInactiveStatus(Person person) throws SQLException {
        if (person.getAppointment_attended_flag() == 0) {
            return person.getName();
        }
        return null;

    }

    @Override
    public boolean CheckDonorMedicalID(String donorId) throws SQLException {

        DonorMedicalRecordsRepository donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        List<DonorMedicalRecords> donorMedicalList = donorMedicalRecordsRepository.getAllDonorMedicalRecords();

        for (DonorMedicalRecords donorMedicalRecords : donorMedicalList) {
            if (donorMedicalRecords.getDonor_id().equals(donorId)) {

                return true;
            }
        }

        return false;
    }

    public DonorMedicalRecords GetDonorDetails(String donorId) throws SQLException {

        DonorMedicalRecordsRepository donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        List<DonorMedicalRecords> donorMedicalList = donorMedicalRecordsRepository.getAllDonorMedicalRecords();

        for (DonorMedicalRecords donorMedicalRecords : donorMedicalList) {
            if (donorMedicalRecords.getDonor_id().equals(donorId)) {

                return donorMedicalRecords;

            }
        }

        return null;

    }
}
