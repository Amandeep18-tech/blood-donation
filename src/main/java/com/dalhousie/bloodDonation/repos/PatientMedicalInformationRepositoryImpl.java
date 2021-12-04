package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.PatientMedicalInformation;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientMedicalInformationRepositoryImpl implements PatientMedicalInformationRepository {
    Connection conn;

    public PatientMedicalInformationRepositoryImpl() throws SQLException {
        DBUtils dbUtils = new DBUtils();
        conn = dbUtils.getConnection();
    }

    @Override
    public void addPatientMedicalInformation(PatientMedicalInformation patientMedicalInfo) throws SQLException {
        String query = "INSERT INTO patient_medical_information (patient_id, " + "blood_group, " + "current_location, " + "dr_reference, " + "requirement_reason, " + "priority) VALUES (?, ?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, patientMedicalInfo.getPatientId());
        ps.setString(2, patientMedicalInfo.getBloodGroup());
        ps.setString(3, patientMedicalInfo.getCurrentLocation());
        ps.setString(4, patientMedicalInfo.getDrReference());
        ps.setString(5, patientMedicalInfo.getRequirementReason());
        ps.setString(6, patientMedicalInfo.getPriority());
        ps.executeUpdate();
    }

    @Override
    public void delete(int patientId) throws SQLException {
        String query = "DELETE FROM patient_medical_information WHERE patient_id= ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, patientId);
        ps.executeUpdate();
    }

    @Override
    public PatientMedicalInformation getPatientMedicalInformation(int patientId) throws SQLException {
        String query = "SELECT * FROM patient_medical_information WHERE patient_id= ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, patientId);
        ResultSet rs = ps.executeQuery();
        boolean check = false;
        PatientMedicalInformation patientMedicalInfo = new PatientMedicalInformation();
        while (rs.next()) {
            check = true;
            patientMedicalInfo.setId(rs.getInt("id"));
            patientMedicalInfo.setPatientId(rs.getInt("patient_id"));
            patientMedicalInfo.setBloodGroup(rs.getString("blood_group"));
            patientMedicalInfo.setCurrentLocation(rs.getString("current_location"));
            patientMedicalInfo.setDrReference(rs.getString("dr_reference"));
            patientMedicalInfo.setRequirementReason(rs.getString("requirement_reason"));
            patientMedicalInfo.setPriority(rs.getString("priority"));
        }
        if (check) {
            return patientMedicalInfo;
        } else {
            return null;
        }
    }

    @Override
    public void update(PatientMedicalInformation patientMedicalInfo) throws SQLException {
        String query = "UPDATE patient_medical_information SET blood_group= ?, " + "current_location= ?, " + "dr_reference= ?, " + "requirement_reason= ?, " + "priority= ? " + "WHERE patient_id= ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, patientMedicalInfo.getBloodGroup());
        ps.setString(2, patientMedicalInfo.getCurrentLocation());
        ps.setString(3, patientMedicalInfo.getDrReference());
        ps.setString(4, patientMedicalInfo.getRequirementReason());
        ps.setString(5, patientMedicalInfo.getPriority());
        ps.setInt(6, patientMedicalInfo.getPatientId());
        ps.executeUpdate();
    }
}
