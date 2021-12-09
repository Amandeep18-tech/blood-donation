package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.constants.BloodDonationStatus;
import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.constants.BloodReqOrgStatus;
import com.dalhousie.bloodDonation.model.BloodDonatedDetail;
import com.dalhousie.bloodDonation.model.BloodRequestOrganisation;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BloodRequestOrganisationRepository {

    
    public List<BloodRequestOrganisation> getAllRecords() {
        List<BloodRequestOrganisation> bloodRequestOrganisations = new ArrayList<>();
        try {
            Connection conn= DBUtils.getInstance().getConnection();
            
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM blood_request_organisation");
            while (resultSet.next()){
                BloodRequestOrganisation bloodRequestOrganisation = new BloodRequestOrganisation();
                bloodRequestOrganisation.setId(resultSet.getInt("id"));
                bloodRequestOrganisation.setOrgId(resultSet.getString("org_id"));
                bloodRequestOrganisation.setReceiverOrgId(resultSet.getString("receiver_org_id"));
                bloodRequestOrganisation.setBloodGroup(BloodGroup.valueOf(resultSet.getString("blood_group")));
                bloodRequestOrganisation.setStatus(BloodReqOrgStatus.valueOf(resultSet.getString("status")));
                bloodRequestOrganisation.setUnitsRequired(resultSet.getInt("units_required"));
                bloodRequestOrganisation.setTimestamp(resultSet.getString("timestamp"));
                bloodRequestOrganisations.add(bloodRequestOrganisation);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bloodRequestOrganisations;
    }

    public void updateRecord(BloodRequestOrganisation bloodRequestOrganisation) {
        try{
            Connection connection= DBUtils.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE blood_request_organisation SET status = ? WHERE id = ?");
            preparedStatement.setString(1, bloodRequestOrganisation.getStatus().toString());
            preparedStatement.setInt(2, bloodRequestOrganisation.getId());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void save(BloodRequestOrganisation bloodRequestOrganisation) {
        try {
            Connection conn= DBUtils.getInstance().getConnection();
            Statement stmt = conn.createStatement();
            String query = "INSERT INTO blood_request_organisation(org_id,receiver_org_id,units_required,status,blood_group,timestamp)\n" +
                    "VALUES\n" +
                    "('"
                    +bloodRequestOrganisation.getOrgId()+"','"
                    +bloodRequestOrganisation.getReceiverOrgId()+"','"
                    +bloodRequestOrganisation.getUnitsRequired()+"','"
                    +bloodRequestOrganisation.getStatus()+"','"
                    +bloodRequestOrganisation.getBloodGroup()+"','"
                    +bloodRequestOrganisation.getTimestamp()
                    +"')";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
