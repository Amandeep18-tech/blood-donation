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

    public BloodDonationDetailsRepository() throws SQLException {
        DBUtils dbUtils = new DBUtils();
        conn = dbUtils.getConnection();
    }

    
    public List<BloodDonationDetails> getAllDonorAppointment() throws SQLException{
        String query="SELECT * FROM blood_donation_details";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<BloodDonationDetails> donorSlotList = new ArrayList();
        while (rs.next()){
            BloodDonationDetails bloodDonationDetails = new BloodDonationDetails();
            bloodDonationDetails.setId(rs.getString("id"));
            bloodDonationDetails.setOrganisationID(rs.getString("organisation_id"));
            bloodDonationDetails.setDonationTime(rs.getTime("donation_time"));
            bloodDonationDetails.setSlotNumber(rs.getInt("slot_number"));
            
            donorSlotList.add(bloodDonationDetails);
        }
        return donorSlotList;
        
        
    }
    public List<BloodDonatedDetail> getAllRecords() {
        List<BloodDonatedDetail> bloodDonationDetails = new ArrayList<>();
        BloodDonatedDetail bloodDonationDetail = new BloodDonatedDetail();
        bloodDonationDetail.setBloodGroup(BloodGroup.ABNeg);
        bloodDonationDetail.setDonorID("D001");
        bloodDonationDetail.setDonatedAt("21/05/2021");
        bloodDonationDetail.setOrgId("O001");
        bloodDonationDetail.setStatus(BloodDonationStatus.unused);
        bloodDonationDetails.add(bloodDonationDetail);
        BloodDonatedDetail bloodDonationDetail2 = new BloodDonatedDetail();
        bloodDonationDetail2.setBloodGroup(BloodGroup.BPos);
        bloodDonationDetail2.setDonorID("D002");
        bloodDonationDetail2.setDonatedAt("21/05/2021");
        bloodDonationDetail2.setOrgId("O001");
        bloodDonationDetail2.setStatus(BloodDonationStatus.unused);
        bloodDonationDetails.add(bloodDonationDetail2);
        return bloodDonationDetails;
    }

    public void update(BloodDonatedDetail bloodDonationDetail) {
    }

    public void save(BloodDonatedDetail bloodRequestOrganisation) {
    }


    public void save(BloodRequestOrganisation bloodRequestOrganisation) {
    }
}
