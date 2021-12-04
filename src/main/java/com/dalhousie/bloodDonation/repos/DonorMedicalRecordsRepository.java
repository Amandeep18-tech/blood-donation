package com.dalhousie.bloodDonation.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.dalhousie.bloodDonation.model.DonorMedicalRecords;
import com.dalhousie.bloodDonation.utils.DBUtils;

public class DonorMedicalRecordsRepository {
    Connection conn;
    private int executeUpdate;

    public DonorMedicalRecordsRepository() throws SQLException {
        DBUtils dbUtils = new DBUtils();
        conn = dbUtils.getConnection();
    }

    public boolean addNewMedicalRecord(DonorMedicalRecords donorMedicalRecords) throws SQLException{
        String query = "INSERT INTO donor_medical_records(id, "+"donor_id," + "hepatitis_B," + "hepatitis_C,"+"HIV_flag,"+"hemoglobin_level,"+"hemochromatosis) VALUES (?, ?, ?,?,?,?,?)";
        
        PreparedStatement ps = conn.prepareStatement(query);
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        ps.setString(1, uuidAsString);
        ps.setString(2,donorMedicalRecords.getDonor_id());
        ps.setInt(3,donorMedicalRecords.getHepatitis_B());
        ps.setInt(4,donorMedicalRecords.getHepatitis_C());
        ps.setInt(5,donorMedicalRecords.getHIV_flag());
        ps.setInt(6,donorMedicalRecords.getHemoglobin_level());
        ps.setInt(7,donorMedicalRecords.getHemochromatosis());
        
        executeUpdate = ps.executeUpdate();
        return true;
    }

    public List<DonorMedicalRecords> getAllDonorMedicalRecords() throws SQLException{
        String query="SELECT * FROM donor_medical_records";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<DonorMedicalRecords> medicalRecordList = new ArrayList();
        while (rs.next()){
            DonorMedicalRecords donorMedicalRecords= new DonorMedicalRecords();
            donorMedicalRecords.setDonor_id(rs.getString("donor_id"));
            donorMedicalRecords.setHIV_flag(rs.getInt("HIV_flag"));
            donorMedicalRecords.setHepatitis_B(rs.getInt("hepatitis_B"));
            donorMedicalRecords.setHepatitis_C(rs.getInt("hepatitis_C"));
            donorMedicalRecords.setHemochromatosis(rs.getInt("hemochromatosis"));
            donorMedicalRecords.setId(rs.getString("id"));
            donorMedicalRecords.setHemoglobin_level(rs.getInt("hemoglobin_level"));
            
            medicalRecordList.add(donorMedicalRecords);
        }
        return medicalRecordList;
        
        
    }

    public boolean updateMedicalRecord(DonorMedicalRecords donorMedicalRecords,String donorID) throws SQLException{
        
        String query = "UPDATE donor_medical_records SET HIV_flag= ?,hepatitis_B=?,hepatitis_C=?,hemochromatosis=?,hemoglobin_level=? WHERE donor_id = ?";
        
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,donorMedicalRecords.getHIV_flag());
        ps.setInt(2,donorMedicalRecords.getHepatitis_B());
        ps.setInt(3,donorMedicalRecords.getHepatitis_C());
        ps.setInt(4,donorMedicalRecords.getHemochromatosis());
        ps.setInt(5,donorMedicalRecords.getHemoglobin_level());
        ps.setString(6,donorID);
        
        
        executeUpdate = ps.executeUpdate();
        return true;
    }

    
}
