package com.dalhousie.bloodDonation.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dalhousie.bloodDonation.model.PatientBloodRequest;
import com.dalhousie.bloodDonation.utils.DBUtils;

public class PatientBloodRequestRepository {
    
    Connection conn;
    private int executeUpdate;

    public PatientBloodRequestRepository(){
        DBUtils dbUtils = new DBUtils();
        try {
            conn = dbUtils.getConnection();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public List<PatientBloodRequest> getAllDonorRequests(){
        List<PatientBloodRequest> allDonorRequests = new ArrayList();
        try{
            String query="SELECT * FROM patient_blood_request";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                PatientBloodRequest patientBloodRequest = new PatientBloodRequest();
                patientBloodRequest.setId(rs.getString("id"));
                patientBloodRequest.setAppointmentDate(rs.getDate("appointment_date"));
                patientBloodRequest.setAppointmentTime(rs.getTime("appointment_time"));
                patientBloodRequest.setStatus(rs.getString("status"));
                
                allDonorRequests.add(patientBloodRequest);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }      
        return allDonorRequests;
        
        
    }
}
