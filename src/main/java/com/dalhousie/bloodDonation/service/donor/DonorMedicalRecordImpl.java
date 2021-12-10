package com.dalhousie.bloodDonation.service.donor;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.donor.MedicalAppointmentDetails;
import com.dalhousie.bloodDonation.repos.donor.MedicalAppointmentDetailRepository;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DonorMedicalRecordImpl implements DonorMedicalRecord {

    @Override
    public ArrayList<String> getTodayMedicalRecord() throws CustomException {
        MedicalAppointmentDetailRepository medicalAppointmentDetailRepository = new MedicalAppointmentDetailRepository();
        List<MedicalAppointmentDetails> medicalAppointmentDetailsList = medicalAppointmentDetailRepository.getAllDetails();
        ArrayList<String> medicalAppointmentId = new ArrayList<String>();
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String todayToString = simpleDateFormat.format(today);
        for (MedicalAppointmentDetails medicalAppointmentDetails : medicalAppointmentDetailsList) {
            String donorDate = simpleDateFormat.format(medicalAppointmentDetails.getslotDate());
            if (donorDate.equals(todayToString)) {
                medicalAppointmentId.add(medicalAppointmentDetails.getpatientID());
            }
        }
        if (medicalAppointmentId.size() == 0) {
            throw new CustomException("No appointment for today");
        }
        return medicalAppointmentId;
    }
}
