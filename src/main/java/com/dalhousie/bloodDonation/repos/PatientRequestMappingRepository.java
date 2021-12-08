package com.dalhousie.bloodDonation.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dalhousie.bloodDonation.model.PatientRequestMapping;
import com.dalhousie.bloodDonation.utils.DBUtils;

public class PatientRequestMappingRepository {
    Connection conn;
    private int executeUpdate;

    public PatientRequestMappingRepository() {
        DBUtils dbUtils = new DBUtils();
        try {
            conn = dbUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<PatientRequestMapping> getAllDonorRequests(){
        List<PatientRequestMapping> allPatientMapping = new ArrayList();
        try{
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

}
