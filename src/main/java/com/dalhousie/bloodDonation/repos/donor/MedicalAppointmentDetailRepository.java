package com.dalhousie.bloodDonation.repos.donor;

import com.dalhousie.bloodDonation.model.donor.MedicalAppointmentDetails;
import com.dalhousie.bloodDonation.service.common.SessionService;
import com.dalhousie.bloodDonation.service.common.SessionServiceImpl;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class MedicalAppointmentDetailRepository {
    private int executeUpdate;
    SessionService sessionService;

    public MedicalAppointmentDetailRepository(){
        sessionService = new SessionServiceImpl();
    }

    public List<MedicalAppointmentDetails> getAllDetails() {
        List<MedicalAppointmentDetails> allDateList = new ArrayList();
        try{
        Connection conn= DBUtils.getInstance().getConnection();
        String query="SELECT * FROM medical_appointment_details";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            MedicalAppointmentDetails medical_appointment_details = new MedicalAppointmentDetails();
            medical_appointment_details.setmedicalAppointmentDetailsID(rs.getString("medical_appointment_details_id"));
            medical_appointment_details.setpatientID(rs.getString("patient_id"));
            medical_appointment_details.setslotID(rs.getString("slot_id"));
            medical_appointment_details.setslotDate(rs.getDate("slot_date"));
            
            
            
            allDateList.add(medical_appointment_details);
        }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return allDateList;
        
        
    }

    public boolean saveDate(MedicalAppointmentDetails medicalAppointmentDetails,String slotId, String dateInput){
        try{
        Connection conn= DBUtils.getInstance().getConnection();
        String query = "INSERT INTO medical_appointment_details (medical_appointment_details_id, " + "patient_id, " + "slot_id,"+"slot_date) VALUES (?, ?, ?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        ps.setString(1, uuidAsString);
        ps.setString(2,sessionService.getUserId());
        ps.setString(3,slotId );
        ps.setString(4,dateInput);
        executeUpdate = ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }
    
}
