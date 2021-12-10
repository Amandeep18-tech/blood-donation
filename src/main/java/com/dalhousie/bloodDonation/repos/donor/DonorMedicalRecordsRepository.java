package com.dalhousie.bloodDonation.repos.donor;

import com.dalhousie.bloodDonation.model.donor.DonorMedicalRecords;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class DonorMedicalRecordsRepository {


    public boolean addNewMedicalRecord(DonorMedicalRecords donorMedicalRecords) {
        try {
            Connection conn = DBUtils.getInstance().getConnection();
            String query = "INSERT INTO donor_medical_records(id, " + "donor_id," + "hepatitis_B," + "hepatitis_C," + "HIV_flag," + "hemoglobin_level," + "hemochromatosis," + "rbc_count," + "platelet_count) VALUES (?, ?, ?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            ps.setString(1, uuidAsString);
            ps.setString(2, donorMedicalRecords.getdonorID());
            ps.setInt(3, donorMedicalRecords.gethepatitisB());
            ps.setInt(4, donorMedicalRecords.gethepatitisC());
            ps.setInt(5, donorMedicalRecords.getHIVFlag());
            ps.setInt(6, donorMedicalRecords.gethemoglobinLevel());
            ps.setInt(7, donorMedicalRecords.getHemochromatosis());
            ps.setInt(8, donorMedicalRecords.getRbcCount());
            ps.setInt(9, donorMedicalRecords.getPlateletCount());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }

    public List<DonorMedicalRecords> getAllDonorMedicalRecords() {
        List<DonorMedicalRecords> medicalRecordList = new ArrayList();
        try {
            Connection conn = DBUtils.getInstance().getConnection();
            String query = "SELECT * FROM donor_medical_records";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                DonorMedicalRecords donorMedicalRecords = new DonorMedicalRecords();
                donorMedicalRecords.setdonorID(rs.getString("donor_id"));
                donorMedicalRecords.setHIVFlag(rs.getInt("HIV_flag"));
                donorMedicalRecords.sethepatitisB(rs.getInt("hepatitis_B"));
                donorMedicalRecords.sethepatitisC(rs.getInt("hepatitis_C"));
                donorMedicalRecords.setHemochromatosis(rs.getInt("hemochromatosis"));
                donorMedicalRecords.setId(rs.getString("id"));
                donorMedicalRecords.sethemoglobinLevel(rs.getInt("hemoglobin_level"));
                donorMedicalRecords.setRbcCount(rs.getInt("rbc_count"));
                donorMedicalRecords.setPlateletCount(rs.getInt("platelet_count"));
                medicalRecordList.add(donorMedicalRecords);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return medicalRecordList;
    }

    public boolean updateMedicalRecord(DonorMedicalRecords donorMedicalRecords, String donorID) {
        try {
            Connection conn = DBUtils.getInstance().getConnection();
            String query = "UPDATE donor_medical_records SET HIV_flag= ?,hepatitis_B=?,hepatitis_C=?,hemochromatosis=?,hemoglobin_level=?,rbc_count=?,platelet_count=? WHERE donor_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, donorMedicalRecords.getHIVFlag());
            ps.setInt(2, donorMedicalRecords.gethepatitisB());
            ps.setInt(3, donorMedicalRecords.gethepatitisC());
            ps.setInt(4, donorMedicalRecords.getHemochromatosis());
            ps.setInt(5, donorMedicalRecords.gethemoglobinLevel());
            ps.setInt(6, donorMedicalRecords.getRbcCount());
            ps.setInt(7, donorMedicalRecords.getPlateletCount());
            ps.setString(8, donorID);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
