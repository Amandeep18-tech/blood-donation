package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.FinancialDonation;
import com.dalhousie.bloodDonation.model.PendingFinancialDonation;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FinancialDonationRepository {

    public void save(FinancialDonation financialDonation) {
        try {
            Connection conn= DBUtils.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO financial_donation(donor_id,amount,donation_type,trans_ref_number)\n" +
                    "VALUES\n" +
                    "('"
                    + financialDonation.getDonorId() + "','"
                    + financialDonation.getAmount() + "','"
                    + financialDonation.getDonationType().type + "','"
                    + financialDonation.getTransRefNumber()
                    + "')";
            System.out.println(query);
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
