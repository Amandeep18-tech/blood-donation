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

    public DonorMedicalRecordsRepository(){
        DBUtils dbUtils = new DBUtils();
        try {
            conn = dbUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean addNewMedicalRecord(DonorMedicalRecords donorMedicalRecords) {
        try{
        String query = "INSERT INTO donor_medical_records(id, "+"donor_id," + "hepatitis_B," + "hepatitis_C,"+"HIV_flag,"+"hemoglobin_level,"+"hemochromatosis,"+"rbc_count,"+"platelet_count) VALUES (?, ?, ?,?,?,?,?,?,?)";
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
        ps.setInt(8,donorMedicalRecords.getRbcCount());
        ps.setInt(9,donorMedicalRecords.getPlateletCount());
        executeUpdate = ps.executeUpdate();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    public List<DonorMedicalRecords> getAllDonorMedicalRecords(){
        List<DonorMedicalRecords> medicalRecordList = new ArrayList();
        try{
        String query="SELECT * FROM donor_medical_records";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            DonorMedicalRecords donorMedicalRecords= new DonorMedicalRecords();
            donorMedicalRecords.setDonor_id(rs.getString("donor_id"));
            donorMedicalRecords.setHIV_flag(rs.getInt("HIV_flag"));
            donorMedicalRecords.setHepatitis_B(rs.getInt("hepatitis_B"));
            donorMedicalRecords.setHepatitis_C(rs.getInt("hepatitis_C"));
            donorMedicalRecords.setHemochromatosis(rs.getInt("hemochromatosis"));
            donorMedicalRecords.setId(rs.getString("id"));
            donorMedicalRecords.setHemoglobin_level(rs.getInt("hemoglobin_level"));
            donorMedicalRecords.setRbcCount(rs.getInt("rbc_count"));
            donorMedicalRecords.setPlateletCount(rs.getInt("platelet_count"));
            medicalRecordList.add(donorMedicalRecords);
        }
        
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return medicalRecordList;
        
        
    }

    public boolean updateMedicalRecord(DonorMedicalRecords donorMedicalRecords,String donorID){
        try{
        String query = "UPDATE donor_medical_records SET HIV_flag= ?,hepatitis_B=?,hepatitis_C=?,hemochromatosis=?,hemoglobin_level=?,rbc_count=?,platelet_count=? WHERE donor_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1,donorMedicalRecords.getHIV_flag());
        ps.setInt(2,donorMedicalRecords.getHepatitis_B());
        ps.setInt(3,donorMedicalRecords.getHepatitis_C());
        ps.setInt(4,donorMedicalRecords.getHemochromatosis());
        ps.setInt(5,donorMedicalRecords.getHemoglobin_level());
        ps.setInt(6,donorMedicalRecords.getRbcCount());
        ps.setInt(7,donorMedicalRecords.getHemoglobin_level());
        ps.setString(8,donorID);
        
        
        executeUpdate = ps.executeUpdate();
        
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return true;
    }

    
}
