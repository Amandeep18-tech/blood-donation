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

    public PatientRequestMappingRepository() throws SQLException {
        DBUtils dbUtils = new DBUtils();
        conn = dbUtils.getConnection();
    }

    public List<PatientRequestMapping> getAllDonorRequests() throws SQLException{
        String query="SELECT * FROM patient_request_mapping";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<PatientRequestMapping> allPatientMapping = new ArrayList();
        while (rs.next()){
            PatientRequestMapping patientRequestMapping = new PatientRequestMapping();
            patientRequestMapping.setPatientBloodRequestID(rs.getString("patient_blood_request_id"));
            patientRequestMapping.setDonorOrOrganisationID(rs.getString("donor_or_organisation_id"));
            patientRequestMapping.setAcceptFlag(rs.getInt("accept_flag"));
            
            
            allPatientMapping.add(patientRequestMapping);
        }
        return allPatientMapping;
        
        
    }

    public boolean updateRequest(String donorID, Integer acceptFlag) throws SQLException{
        
        String query = "UPDATE patient_request_mapping SET accept_flag=? WHERE donor_or_organisation_id = ?";
        
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setInt(1,acceptFlag);
        ps.setString(2,donorID);
        
        
        executeUpdate = ps.executeUpdate();
        return true;
    }

}
