package com.dalhousie.bloodDonation.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dalhousie.bloodDonation.constants.BloodDonationStatus;
import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.model.BloodDonatedDetail;
import com.dalhousie.bloodDonation.model.BloodDonationDetails;
import com.dalhousie.bloodDonation.model.BloodRequestOrganisation;
import com.dalhousie.bloodDonation.utils.DBUtils;

public class BloodDonationDetailsRepository {
    Connection conn;

    public BloodDonationDetailsRepository(){
        DBUtils dbUtils = new DBUtils();
        try {
            conn = dbUtils.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public List<BloodDonationDetails> getAllDonorAppointment() {
        String query="SELECT * FROM blood_donation_details";
        List<BloodDonationDetails> donorSlotList = new ArrayList();
        try{
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
