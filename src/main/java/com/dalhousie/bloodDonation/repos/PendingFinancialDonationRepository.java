package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.constants.DonationType;
import com.dalhousie.bloodDonation.model.PendingFinancialDonation;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PendingFinancialDonationRepository {

    public List<PendingFinancialDonation> getAllPendingFinancialDonations() {
        List<PendingFinancialDonation> pendingFinancialDonations = new ArrayList<>();
        try (Connection conn = DBUtils.getInstance().getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM pending_financial_donations");
            while (resultSet.next()) {
                PendingFinancialDonation pendingFinancialDonation = new PendingFinancialDonation();
                pendingFinancialDonation.setAmount(resultSet.getDouble(2));
                pendingFinancialDonation.setDonationType(DonationType.valueOf(resultSet.getString(4)));
                pendingFinancialDonation.setTpRefNum(resultSet.getString(3));
                pendingFinancialDonations.add(pendingFinancialDonation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pendingFinancialDonations;
    }
}
