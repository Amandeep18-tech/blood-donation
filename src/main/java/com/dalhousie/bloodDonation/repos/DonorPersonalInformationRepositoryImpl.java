package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.DonorInformation;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DonorPersonalInformationRepositoryImpl implements DonorPersonalInformationRepository {
    private static DonorPersonalInformationRepository donorPersonalInformationRepository = null;

    public static DonorPersonalInformationRepository getInstance() {
        if (donorPersonalInformationRepository == null) {
            donorPersonalInformationRepository = new DonorPersonalInformationRepositoryImpl();
        }
        return donorPersonalInformationRepository;
    }

    @Override
    public List<DonorInformation> getAllMatchingBloodTypeDonors(String bloodGroup) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try (Connection conn = dbUtils.getConnection()) {
            String query = "SELECT * FROM Person WHERE blood_group= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, bloodGroup);
            ResultSet rs = ps.executeQuery();
            List<DonorInformation> donorListByMatchedBloodGroup = new ArrayList<>();

            while (rs.next()) {
                DonorInformation donorPersonalInfo = new DonorInformation();
                donorPersonalInfo.setDonorId(rs.getString("person_id"));
                donorPersonalInfo.setDonorFirstName(rs.getString("person_first_name"));
                donorPersonalInfo.setDonorLastName(rs.getString("person_last_name"));
                donorPersonalInfo.setDonorContactNumber(rs.getString("contact_number"));
                donorPersonalInfo.setDonorBloodGroup(rs.getString("blood_group"));
                donorListByMatchedBloodGroup.add(donorPersonalInfo);
            }
            return donorListByMatchedBloodGroup;
        } catch (SQLException e) {
            throw new CustomException("Error: Unable To Find Any Matching Donor");
        }
    }
}
