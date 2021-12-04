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

    public PatientBloodRequestRepository() throws SQLException {
        DBUtils dbUtils = new DBUtils();
        conn = dbUtils.getConnection();
    }

    public List<PatientBloodRequest> getAllDonorRequests() throws SQLException{
        String query="SELECT * FROM patient_blood_request";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<PatientBloodRequest> allDonorRequests = new ArrayList();
        while (rs.next()){
            PatientBloodRequest patientBloodRequest = new PatientBloodRequest();
            patientBloodRequest.setId(rs.getString("id"));
            patientBloodRequest.setAppointmentDate(rs.getDate("appointment_date"));
            patientBloodRequest.setAppointmentTime(rs.getTime("appointment_time"));
            patientBloodRequest.setStatus(rs.getString("status"));
            
            allDonorRequests.add(patientBloodRequest);
        }
        return allDonorRequests;
        
        
    }
}
