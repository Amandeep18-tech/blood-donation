package com.dalhousie.bloodDonation.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import com.dalhousie.bloodDonation.model.BloodDonationDetaisHistory;
import com.dalhousie.bloodDonation.utils.DBUtils;

public class BloodDonationDetailsHistoryRepository {
    Connection conn;
    private int executeUpdate;

    public BloodDonationDetailsHistoryRepository() throws SQLException {
        DBUtils dbUtils = new DBUtils();
        conn = dbUtils.getConnection();
    }

    public List<BloodDonationDetaisHistory> getAllDetails() throws SQLException{
        String query="SELECT * FROM blood_donation_details_history";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<BloodDonationDetaisHistory> allDonationDetails = new ArrayList();
        while (rs.next()){
            BloodDonationDetaisHistory bloodDonationDetaisHistory = new BloodDonationDetaisHistory();
            bloodDonationDetaisHistory.setDonorId(rs.getString("donor_id"));
            bloodDonationDetaisHistory.setSlotDate(rs.getDate("slot_date"));
            bloodDonationDetaisHistory.setId(rs.getString("id"));
            bloodDonationDetaisHistory.setSlotId(rs.getString("slot_id"));
            allDonationDetails.add(bloodDonationDetaisHistory);
        }
        return allDonationDetails;
        
        
    }
    public boolean saveDonationDate(BloodDonationDetaisHistory bloodDonationDetaisHistory,String slotId, String dateInput) throws SQLException{
        String query = "INSERT INTO blood_donation_details_history (id, " + "donor_id, " + "slot_id,"+"slot_date) VALUES (?, ?, ?,?)";
        
        PreparedStatement ps = conn.prepareStatement(query);
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        ps.setString(1, uuidAsString);
        ps.setString(2,"5c256da3-3d82-11ec-917b-e2ed2ce588f5");
        ps.setString(3,slotId );
        ps.setString(4,dateInput);
        executeUpdate = ps.executeUpdate();
        return true;
    }
    
}
