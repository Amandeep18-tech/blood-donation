package com.dalhousie.bloodDonation.service.donor;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import com.dalhousie.bloodDonation.constants.SlotAvailableConstants;
import com.dalhousie.bloodDonation.model.donor.DonorMedicalRecords;
import com.dalhousie.bloodDonation.model.donor.MedicalAppointmentDetails;
import com.dalhousie.bloodDonation.model.donor.MedicalAppointmentMaster;
import com.dalhousie.bloodDonation.model.organisation.Organisation;
import com.dalhousie.bloodDonation.repos.donor.DonorMedicalRecordsRepository;
import com.dalhousie.bloodDonation.repos.donor.MedicalAppointmentDetailRepository;
import com.dalhousie.bloodDonation.repos.donor.MedicalAppointmentMasterRespository;
import com.dalhousie.bloodDonation.repos.organisation.OrganizationRepository;

public class ManageAppointmentImpl implements ManageAppointment {

    @Override
    public String getAvailableTime(MedicalAppointmentMaster medicalAppointmentMaster, String placeName){
        
        if (medicalAppointmentMaster.getorganisationID().equals(placeName)) {
            
            return medicalAppointmentMaster.getslotNumber() + " " + medicalAppointmentMaster.getslotStartTime() + " "
                    + medicalAppointmentMaster.getslotEndTime();
        }

        return null;
    }

    @Override
    public String getSlotId(String slotIdInput) {

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
    public boolean compareDate(String dateFormatInput, String slotIdInput) {
        MedicalAppointmentDetailRepository medicalAppointmentDetailRepository = new MedicalAppointmentDetailRepository();

        List<MedicalAppointmentDetails> detailList = medicalAppointmentDetailRepository.getAllDetails();

        for (MedicalAppointmentDetails medicalAppointmentDetail : detailList) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String dateToString = dateFormat.format(medicalAppointmentDetail.getslotDate());
            
            if (medicalAppointmentDetail.getslotID().equals(slotIdInput) && dateToString.equals(dateFormatInput)) {
                return true;
            }

        }

        return false;

    }

    @Override
    public String selectPlace(String placeName) {
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
    public boolean checkDonorMedicalID(String donorId){

        DonorMedicalRecordsRepository donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        List<DonorMedicalRecords> donorMedicalList = donorMedicalRecordsRepository.getAllDonorMedicalRecords();

        for (DonorMedicalRecords donorMedicalRecords : donorMedicalList) {
            if (donorMedicalRecords.getdonorID().equals(donorId)) {

                return true;
            }
        }

        return false;
    }

    public DonorMedicalRecords getDonorDetails(String donorId) {

        DonorMedicalRecordsRepository donorMedicalRecordsRepository = new DonorMedicalRecordsRepository();
        List<DonorMedicalRecords> donorMedicalList = donorMedicalRecordsRepository.getAllDonorMedicalRecords();

        for (DonorMedicalRecords donorMedicalRecords : donorMedicalList) {
            if (donorMedicalRecords.getdonorID().equals(donorId)) {

                return donorMedicalRecords;

            }
        }

        return null;

    }
}
