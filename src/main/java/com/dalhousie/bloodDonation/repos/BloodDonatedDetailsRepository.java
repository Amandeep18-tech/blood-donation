package com.dalhousie.bloodDonation.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import com.dalhousie.bloodDonation.constants.BloodDonationStatus;
import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.utils.DBUtils;

public class BloodDonatedDetailsRepository {
    Connection conn;
    

    public BloodDonatedDetailsRepository() {
        DBUtils dbUtils = new DBUtils();
        try {
            conn = dbUtils.getConnection();
        } catch (SQLException e) {
            
            e.printStackTrace();
        }
    }

    public boolean confirmDonation(String organisationId,String donorId)  {
        String query = "INSERT INTO blood_donated_details (id, " + "donor_id, " + "blood_group,"+"donated_at,"+"status,"+"org_id) VALUES (?, ?, ?,?,?,?)";
        Date today = Calendar.getInstance().getTime();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String todayToString = simpleDateFormat.format(today);
        try{
        PreparedStatement ps = conn.prepareStatement(query);
        UUID uuid = UUID.randomUUID();
        String uuidAsString = uuid.toString();
        ps.setString(1, uuidAsString);
        ps.setString(2,donorId);
        ps.setString(3,BloodGroup.ABNeg.name());
        ps.setString(4,todayToString);
        ps.setString(5,BloodDonationStatus.unused.name());
        ps.setString(6, organisationId);
        int executeUpdate = ps.executeUpdate();
        }
        catch(SQLException e)
        {
            System.out.println("Error in Blood Donated Details");
        }
        return true;
    }

    
}
