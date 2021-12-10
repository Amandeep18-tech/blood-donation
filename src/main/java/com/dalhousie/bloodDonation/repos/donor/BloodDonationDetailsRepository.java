package com.dalhousie.bloodDonation.repos.donor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dalhousie.bloodDonation.model.donor.BloodDonationDetails;
import com.dalhousie.bloodDonation.utils.DBUtils;

public class BloodDonationDetailsRepository {
    
    public List<BloodDonationDetails> getAllDonorAppointment() {
        String query="SELECT * FROM blood_donation_details";
        List<BloodDonationDetails> donorSlotList = new ArrayList();
        try{
        Connection conn= DBUtils.getInstance().getConnection();
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            BloodDonationDetails bloodDonationDetails = new BloodDonationDetails();
            bloodDonationDetails.setId(rs.getString("id"));
            bloodDonationDetails.setOrganisationID(rs.getString("organisation_id"));
            bloodDonationDetails.setDonationTime(rs.getTime("donation_time"));
            bloodDonationDetails.setSlotNumber(rs.getInt("slot_number"));
            
            donorSlotList.add(bloodDonationDetails);
        }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return donorSlotList;
        
        
    }
}
