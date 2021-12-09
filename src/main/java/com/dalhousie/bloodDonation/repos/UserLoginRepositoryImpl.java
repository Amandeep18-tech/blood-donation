package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.PatientLoginInformation;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UserLoginRepositoryImpl implements UserLoginRepository {
    Connection conn;

    public UserLoginRepositoryImpl() throws SQLException {
        DBUtils dbUtils = new DBUtils();
        conn = dbUtils.getConnection();
    }

    @Override
    public void storeUserLoginInformationInDB(PatientLoginInformation patientLoginInfo) throws SQLException {
        String query = "INSERT INTO user (username, " + "password," + "firstname, " + "lastname, " + "userId) VALUES (?, ?, ?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, patientLoginInfo.getUsername());
        ps.setString(2, patientLoginInfo.getPassword());
        List<String> nameToken = new ArrayList<>(Arrays.asList(patientLoginInfo.getPatientName().split(" ")));
        ps.setString(3, nameToken.get(0));
        ps.setString(4, nameToken.get(1));
        ps.setInt(5, patientLoginInfo.getPatientId());
        ps.executeUpdate();
    }
}
