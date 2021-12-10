package com.dalhousie.bloodDonation.repos.donor;

import com.dalhousie.bloodDonation.model.donor.MedicalAppointmentMaster;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 

public class MedicalAppointmentMasterRespository{
    

    
    public List<MedicalAppointmentMaster> getAllAppointment(){
        List<MedicalAppointmentMaster> appointmentList = new ArrayList();
        try{
        Connection conn= DBUtils.getInstance().getConnection();
        String query="SELECT * FROM medical_appointment_master";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            MedicalAppointmentMaster medical_appointment_available = new MedicalAppointmentMaster();
            medical_appointment_available.setmedicalAppointmentMasterID(rs.getString("medical_appointment_master_id"));
            medical_appointment_available.setorganisationID(rs.getString("organisation_id"));
            medical_appointment_available.setslotEndTime(rs.getTime("slot_end_time"));
            medical_appointment_available.setslotNumber(rs.getInt("slot_number"));
            medical_appointment_available.setslotStartTime(rs.getTime("slot_start_time"));
            
            appointmentList.add(medical_appointment_available);
        }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return appointmentList;
        
        
    }


    


}

    

