package com.dalhousie.bloodDonation.repos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.dalhousie.bloodDonation.model.PatientBloodRequest;
import com.dalhousie.bloodDonation.utils.DBUtils;

import org.springframework.beans.propertyeditors.PathEditor;

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
                patientBloodRequest.setPatientID(rs.getString("patient_id"));
                patientBloodRequest.setAppointmentDate(rs.getDate("appointment_date"));
                patientBloodRequest.setAppointmentTime(rs.getTime("appointment_time"));
                patientBloodRequest.setStatus(rs.getInt("status"));
                
                allDonorRequests.add(patientBloodRequest);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }      
        return allDonorRequests;
        
        
    }

    public boolean addNewDonation(String patientID,Date appointmentDate, Time appointmentTime)  {
        String query = "INSERT INTO patient_blood_request (id, " + "patient_id, " + "priority,"+"appointment_date,"+"appointment_time,"+"status) VALUES (?, ?, ?,?,?,?)";
        
        try{
        PreparedStatement ps = conn.prepareStatement(query);
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        ps.setString(1, uuidAsString);
        ps.setString(2,patientID);
        ps.setInt(3,1);
        ps.setDate(4,appointmentDate);
        ps.setTime(5,appointmentTime);
        ps.setInt(6, 0);
        int executeUpdate = ps.executeUpdate();
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        return true;
    }

    public boolean addUpdateDonation(String patientID,Integer status)  {
        try{
            String query = "UPDATE patient_blood_request SET status=? WHERE patient_id=? ";
            PreparedStatement ps = conn.prepareStatement(query);
            
            ps.setInt(1, status);
            ps.setString(2, patientID);
            executeUpdate = ps.executeUpdate();
            
            }
            catch(SQLException e){
                e.printStackTrace();
            }
            return true;
        }
}