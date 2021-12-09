package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.PatientMedicalInformation;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PatientMedicalInformationRepositoryImpl implements PatientMedicalInformationRepository {
    
    @Override
    public void addPatientMedicalInformation(PatientMedicalInformation patientMedicalInfo) throws CustomException {
        
        try (Connection conn= DBUtils.getInstance().getConnection();) {
            String query = "INSERT INTO patient_medical_information (patient_id, " + "blood_group, " + "current_location, " + "dr_reference, " + "requirement_reason, " + "priority, " + "has_hepatitis_B, " + "has_hepatitis_C," + "has_HIV, " + "has_hemochromatosis, " + "hemoglobin_level, " + "rbc_count, " + "platelet_count) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, patientMedicalInfo.getPatientId());
            ps.setString(2, patientMedicalInfo.getBloodGroup());
            ps.setString(3, patientMedicalInfo.getCurrentLocation());
            ps.setString(4, patientMedicalInfo.getDrReference());
            ps.setString(5, patientMedicalInfo.getRequirementReason());
            ps.setString(6, patientMedicalInfo.getPriority());
            ps.setInt(7, patientMedicalInfo.getHasHepatitisB());
            ps.setInt(8, patientMedicalInfo.getHasHepatitisC());
            ps.setInt(9, patientMedicalInfo.getHasHIV());
            ps.setInt(10, patientMedicalInfo.getHasHemochromatosis());
            ps.setInt(11, patientMedicalInfo.getHemoglobinLevel());
            ps.setInt(12, patientMedicalInfo.getRbcCount());
            ps.setInt(13, patientMedicalInfo.getPlateletCount());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new CustomException("Error: Unable To Store Patient Medical Information");
        }
    }

    @Override
    public void delete(int patientId) throws CustomException {
        
        try (Connection conn= DBUtils.getInstance().getConnection();) {
            String query = "DELETE FROM patient_medical_information WHERE patient_id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, patientId);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new CustomException("Error: Unable To Delete Patient Medical Information");
        }
    }

    @Override
    public PatientMedicalInformation getPatientMedicalInformation(int patientId) throws CustomException {
        
        try (Connection conn= DBUtils.getInstance().getConnection();) {
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
                patientMedicalInfo.setHasHepatitisB(rs.getInt("has_hepatitis_B"));
                patientMedicalInfo.setHasHepatitisC(rs.getInt("has_hepatitis_C"));
                patientMedicalInfo.setHasHIV(rs.getInt("has_HIV"));
                patientMedicalInfo.setHasHemochromatosis(rs.getInt("has_hemochromatosis"));
                patientMedicalInfo.setHemoglobinLevel(rs.getInt("hemoglobin_level"));
                patientMedicalInfo.setRbcCount(rs.getInt("rbc_count"));
                patientMedicalInfo.setPlateletCount(rs.getInt("platelet_count"));
            }
            if (check) {
                return patientMedicalInfo;
            } else {
                return null;
            }
        } catch (SQLException e) {
            throw new CustomException("Error: Unable To Find Patient Medical Information");
        }
    }

    @Override
    public void update(PatientMedicalInformation patientMedicalInfo) throws CustomException {
        
        try (Connection conn= DBUtils.getInstance().getConnection();) {
            String query = "UPDATE patient_medical_information SET blood_group= ?, " + "current_location= ?, " + "dr_reference= ?, " + "requirement_reason= ?, " + "priority= ?, " + "has_hepatitis_B= ?," + "has_hepatitis_C= ?," + "has_HIV= ?," + "hemoglobin_level= ?," + "has_hemochromatosis= ?," + "rbc_count= ?," + "platelet_count= ? " + "WHERE patient_id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, patientMedicalInfo.getBloodGroup());
            ps.setString(2, patientMedicalInfo.getCurrentLocation());
            ps.setString(3, patientMedicalInfo.getDrReference());
            ps.setString(4, patientMedicalInfo.getRequirementReason());
            ps.setString(5, patientMedicalInfo.getPriority());
            ps.setInt(6, patientMedicalInfo.getHasHepatitisB());
            ps.setInt(7, patientMedicalInfo.getHasHepatitisC());
            ps.setInt(8, patientMedicalInfo.getHasHIV());
            ps.setInt(9, patientMedicalInfo.getHemoglobinLevel());
            ps.setInt(10, patientMedicalInfo.getHasHemochromatosis());
            ps.setInt(11, patientMedicalInfo.getRbcCount());
            ps.setInt(12, patientMedicalInfo.getPlateletCount());
            ps.setInt(13, patientMedicalInfo.getPatientId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new CustomException("Error: Unable To Update Patient Medical Information");
        }
    }
}
