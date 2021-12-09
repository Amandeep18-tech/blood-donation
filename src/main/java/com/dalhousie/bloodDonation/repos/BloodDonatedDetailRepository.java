package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.constants.BloodDonationStatus;
import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.model.BloodDonatedDetail;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BloodDonatedDetailRepository {
    
    public List<BloodDonatedDetail> getAllRecords() {
        List<BloodDonatedDetail> bloodDonatedDetails = new ArrayList<>();
        try {
            Connection conn= DBUtils.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM blood_donated_details");
            while (resultSet.next()){
                BloodDonatedDetail bloodDonatedDetail = new BloodDonatedDetail();
                bloodDonatedDetail.setBloodGroup(BloodGroup.valueOf(resultSet.getString("blood_group")));
                bloodDonatedDetail.setDonorID(resultSet.getString("donor_id"));
                bloodDonatedDetail.setDonatedAt(resultSet.getString("donated_at"));
                bloodDonatedDetail.setOrgId(resultSet.getString("org_id"));
                bloodDonatedDetail.setStatus(BloodDonationStatus.valueOf(resultSet.getString("status")));
                bloodDonatedDetails.add(bloodDonatedDetail);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bloodDonatedDetails;
    }

    public void update(BloodDonatedDetail bloodDonatedDetail) {
        try{
            Connection conn= DBUtils.getInstance().getConnection();
            PreparedStatement preparedStatement = conn.prepareStatement("UPDATE blood_donated_details SET status = ?, org_id = ? WHERE donor_id = ?");
            preparedStatement.setString(1, bloodDonatedDetail.getStatus().toString());
            preparedStatement.setString(2, bloodDonatedDetail.getOrgId());
            preparedStatement.setString(3, bloodDonatedDetail.getDonorID());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }
}
