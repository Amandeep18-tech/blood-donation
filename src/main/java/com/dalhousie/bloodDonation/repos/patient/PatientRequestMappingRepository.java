package com.dalhousie.bloodDonation.repos.patient;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.dalhousie.bloodDonation.model.patient.PatientRequestMapping;
import com.dalhousie.bloodDonation.utils.DBUtils;

public class PatientRequestMappingRepository {
    
    private int executeUpdate;

    
    public List<PatientRequestMapping> getAllDonorRequests(){
        List<PatientRequestMapping> allPatientMapping = new ArrayList();
        try{
            Connection conn= DBUtils.getInstance().getConnection();
            String query="SELECT * FROM patient_request_mapping";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                PatientRequestMapping patientRequestMapping = new PatientRequestMapping();
                patientRequestMapping.setPatientBloodRequestID(rs.getString("patient_blood_request_id"));
                patientRequestMapping.setDonorOrOrganisationID(rs.getString("donor_or_organisation_id"));
                patientRequestMapping.setAcceptFlag(rs.getInt("accept_flag"));
                
                
                allPatientMapping.add(patientRequestMapping);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return allPatientMapping;
        
        
    }

    public boolean updateRequest(String donorID, Integer acceptFlag){
        try{
        Connection conn= DBUtils.getInstance().getConnection();
        String query = "UPDATE patient_request_mapping SET accept_flag=? WHERE donor_or_organisation_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,acceptFlag);
        ps.setString(2,donorID);
        executeUpdate = ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public boolean addPatientDonation(String patientId, String donorID){
        String query = "INSERT INTO patient_request_mapping (id, " + "patient_blood_request_id, " + "donor_or_organisation_id,"+"accept_flag) VALUES (?, ?, ?,?)";
        
        try{
        Connection conn= DBUtils.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        ps.setString(1, uuidAsString);
        ps.setString(2,patientId);
        ps.setString(3,donorID);
        ps.setInt(4,-1);
        
        int executeUpdate = ps.executeUpdate();
        }
        catch(SQLException e)
        {
           e.printStackTrace();
        }
        return true;

    }

}
