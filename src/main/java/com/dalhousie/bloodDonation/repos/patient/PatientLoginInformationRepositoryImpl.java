package com.dalhousie.bloodDonation.repos.patient;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.patient.PatientLoginInformation;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientLoginInformationRepositoryImpl implements PatientLoginInformationRepository {
    @Override
    public void storePatientLoginInformationInDB(PatientLoginInformation patientLoginInfo) throws CustomException {
        try (Connection conn = DBUtils.getInstance().getConnection()) {
            String query = "INSERT INTO patient_login (patient_id, " + "patient_name," + "patient_email_id, " + "patient_username, " + "patient_password) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, patientLoginInfo.getPatientId());
            ps.setString(2, patientLoginInfo.getPatientName());
            ps.setString(3, patientLoginInfo.getPatientEmailID());
            ps.setString(4, patientLoginInfo.getUsername());
            ps.setString(5, patientLoginInfo.getPassword());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new CustomException("Error: Unable To Create The Patient");
        }
    }
}
