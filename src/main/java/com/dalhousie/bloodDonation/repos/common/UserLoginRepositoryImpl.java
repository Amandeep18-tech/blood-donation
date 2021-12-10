package com.dalhousie.bloodDonation.repos.common;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.patient.PatientLoginInformation;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserLoginRepositoryImpl implements UserLoginRepository {
    @Override
    public void storeUserLoginInformationInDB(PatientLoginInformation patientLoginInfo) throws CustomException {
        try (Connection conn = DBUtils.getInstance().getConnection()) {
            String query = "INSERT INTO user (username, " + "password," + "firstname, " + "lastname, " + "userId) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, patientLoginInfo.getUsername());
            ps.setString(2, patientLoginInfo.getPassword());
            List<String> nameToken = new ArrayList<>(Arrays.asList(patientLoginInfo.getPatientName().split(" ")));
            ps.setString(3, nameToken.get(0));
            ps.setString(4, nameToken.get(1));
            ps.setInt(5, patientLoginInfo.getPatientId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new CustomException("Error: Unable To Store Patient Credentials");
        }
    }
}
