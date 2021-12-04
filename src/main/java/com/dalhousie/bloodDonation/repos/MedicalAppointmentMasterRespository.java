package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.MedicalAppointmentMaster;

import com.dalhousie.bloodDonation.utils.DBUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List; 

public class MedicalAppointmentMasterRespository{
    Connection conn;

    public MedicalAppointmentMasterRespository() throws SQLException {
        DBUtils dbUtils = new DBUtils();
        conn = dbUtils.getConnection();
    }

    
    public List<MedicalAppointmentMaster> getAllAppointment() throws SQLException{
        String query="SELECT * FROM medical_appointment_master";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<MedicalAppointmentMaster> appointmentList = new ArrayList();
        while (rs.next()){
            MedicalAppointmentMaster medical_appointment_available = new MedicalAppointmentMaster();
            medical_appointment_available.setmedicalAppointmentMasterID(rs.getString("medical_appointment_master_id"));
            medical_appointment_available.setorganisationID(rs.getString("organisation_id"));
            medical_appointment_available.setslotEndTime(rs.getTime("slot_end_time"));
            medical_appointment_available.setslotNumber(rs.getInt("slot_number"));
            medical_appointment_available.setslotStartTime(rs.getTime("slot_start_time"));
            
            appointmentList.add(medical_appointment_available);
        }
        return appointmentList;
        
        
    }


    


}

    

