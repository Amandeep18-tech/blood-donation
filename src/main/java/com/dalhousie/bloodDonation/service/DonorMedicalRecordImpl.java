package com.dalhousie.bloodDonation.service;

import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.dalhousie.bloodDonation.model.MedicalAppointmentDetails;
import com.dalhousie.bloodDonation.repos.MedicalAppointmentDetailRepository;

public class DonorMedicalRecordImpl implements DonorMedicalRecord{
    
    @Override
    public ArrayList<String> GetTodayMedicalRecord(){
        MedicalAppointmentDetailRepository medicalAppointmentDetailRepository = new MedicalAppointmentDetailRepository();
        List<MedicalAppointmentDetails> medicalAppointmentDetailsList = medicalAppointmentDetailRepository.getAllDetails();
        ArrayList<String> medicalAppointmentId= new ArrayList<String>();
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String todayToString = simpleDateFormat.format(today);
        for(MedicalAppointmentDetails medicalAppointmentDetails:medicalAppointmentDetailsList){
            
            String  donorDate = simpleDateFormat.format(medicalAppointmentDetails.getslotDate());
            if(donorDate.equals(todayToString)){
                
                medicalAppointmentId.add(medicalAppointmentDetails.getpatientID());
            }
        }
        return medicalAppointmentId;
    }
}
