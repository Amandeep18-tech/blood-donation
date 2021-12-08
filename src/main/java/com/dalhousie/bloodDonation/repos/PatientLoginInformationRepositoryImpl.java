package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.PatientLoginInformation;
import com.dalhousie.bloodDonation.model.PatientPersonalInformation;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientLoginInformationRepositoryImpl implements PatientLoginInformationRepository {
    Connection conn;

    public PatientLoginInformationRepositoryImpl() throws SQLException {
        DBUtils dbUtils = new DBUtils();
        conn = dbUtils.getConnection();
    }

    @Override
    public void storePatientLoginInformationInDB(PatientLoginInformation patientLoginInfo) throws SQLException {
        String query = "INSERT INTO patient_login (patient_id, " + "patient_name," + "patient_email_id, " + "patient_username, " + "patient_password) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, patientLoginInfo.getPatientId());
        ps.setString(2, patientLoginInfo.getPatientName());
        ps.setString(3, patientLoginInfo.getPatientEmailID());
        ps.setString(4, patientLoginInfo.getUsername());
        ps.setString(5, patientLoginInfo.getPassword());
        ps.executeUpdate();
    }
}
