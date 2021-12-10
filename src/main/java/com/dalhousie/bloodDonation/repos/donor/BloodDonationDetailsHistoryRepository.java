package com.dalhousie.bloodDonation.repos.donor;

import com.dalhousie.bloodDonation.model.donor.BloodDonationDetaisHistory;
import com.dalhousie.bloodDonation.service.common.SessionService;
import com.dalhousie.bloodDonation.service.common.SessionServiceImpl;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class BloodDonationDetailsHistoryRepository {
    private final SessionService sessionService;

    public BloodDonationDetailsHistoryRepository() {
        sessionService = new SessionServiceImpl();
    }

    public List<BloodDonationDetaisHistory> getAllDetails() {
        String query = "SELECT * FROM blood_donation_details_history";
        List<BloodDonationDetaisHistory> allDonationDetails = new ArrayList();
        try {
            Connection conn = DBUtils.getInstance().getConnection();
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BloodDonationDetaisHistory bloodDonationDetaisHistory = new BloodDonationDetaisHistory();
                bloodDonationDetaisHistory.setDonorId(rs.getString("donor_id"));
                bloodDonationDetaisHistory.setSlotDate(rs.getDate("slot_date"));
                bloodDonationDetaisHistory.setId(rs.getString("id"));
                bloodDonationDetaisHistory.setSlotId(rs.getString("slot_id"));
                allDonationDetails.add(bloodDonationDetaisHistory);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return allDonationDetails;
    }

    public boolean saveDonationDate(BloodDonationDetaisHistory bloodDonationDetaisHistory, String slotId, String dateInput) {
        try {
            int executeUpdate;
            Connection conn = DBUtils.getInstance().getConnection();
            String query = "INSERT INTO blood_donation_details_history (id, " + "donor_id, " + "slot_id," + "slot_date) VALUES (?, ?, ?,?)";

            PreparedStatement ps = conn.prepareStatement(query);
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            ps.setString(1, uuidAsString);
            ps.setString(2, sessionService.getUserId());
            ps.setString(3, slotId);
            ps.setString(4, dateInput);

            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
}
