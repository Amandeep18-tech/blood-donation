package com.dalhousie.bloodDonation.repos;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import com.dalhousie.bloodDonation.constants.BloodDonationStatus;
import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.model.BloodDonatedDetail;
import com.dalhousie.bloodDonation.utils.DBUtils;

public class BloodDonatedDetailsRepository {

    public List<BloodDonatedDetail> getAllRecords() {
        List<BloodDonatedDetail> bloodDonatedDetails = new ArrayList<>();
        try (Connection conn = DBUtils.getInstance().getConnection()) {
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery("SELECT * FROM blood_donated_details");
            while (resultSet.next()) {
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
        try (Connection connection = DBUtils.getInstance().getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE blood_donated_details SET status = ?, org_id = ? WHERE donor_id = ?");
            preparedStatement.setString(1, bloodDonatedDetail.getStatus().toString());
            preparedStatement.setString(2, bloodDonatedDetail.getOrgId());
            preparedStatement.setString(3, bloodDonatedDetail.getDonorID());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public boolean confirmDonation(String organisationId, String donorId) {
        try (Connection conn = DBUtils.getInstance().getConnection()) {
            String query = "INSERT INTO blood_donated_details (id, " + "donor_id, " + "blood_group," + "donated_at," + "status," + "org_id) VALUES (?, ?, ?,?,?,?)";
            Date today = Calendar.getInstance().getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
            String todayToString = simpleDateFormat.format(today);

            PreparedStatement ps = conn.prepareStatement(query);
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            ps.setString(1, uuidAsString);
            ps.setString(2, donorId);
            ps.setString(3, BloodGroup.ABNeg.name());
            ps.setString(4, todayToString);
            ps.setString(5, BloodDonationStatus.unused.name());
            ps.setString(6, organisationId);
            int executeUpdate = ps.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error in Blood Donated Details");
        }
        return true;
    }
}
