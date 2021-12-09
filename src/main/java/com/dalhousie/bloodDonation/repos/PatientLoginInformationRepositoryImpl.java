package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.PatientLoginInformation;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PatientLoginInformationRepositoryImpl implements PatientLoginInformationRepository {
    private static PatientLoginInformationRepository patientLoginInformationRepository = null;

    public static PatientLoginInformationRepository getInstance() {
        if (patientLoginInformationRepository == null) {
            patientLoginInformationRepository = new PatientLoginInformationRepositoryImpl();
        }
        return patientLoginInformationRepository;
    }

    @Override
    public void storePatientLoginInformationInDB(PatientLoginInformation patientLoginInfo) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try (Connection conn = dbUtils.getConnection()) {
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
