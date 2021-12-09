package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.DonorInformation;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DonorMedicalInformationRepositoryImpl implements DonorMedicalInformationRepository {
    
    @Override
    public DonorInformation getMatchingBloodTypeDonorMedicalInformation(DonorInformation donorInfo) throws CustomException {
        
        try (Connection conn= DBUtils.getInstance().getConnection();) {
            String query = "SELECT * FROM donor_medical_records WHERE donor_id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, donorInfo.getDonorId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                donorInfo.setHasHepatitisB(rs.getInt("hepatitis_B"));
                donorInfo.setHasHepatitisC(rs.getInt("hepatitis_C"));
                donorInfo.setHasHIV(rs.getInt("HIV_flag"));
                donorInfo.setHasHemochromatosis(rs.getInt("hemochromatosis"));
                donorInfo.setHemoglobinLevel(rs.getInt("hemoglobin_level"));
                donorInfo.setRbcCount(rs.getInt("rbc_count"));
                donorInfo.setPlateletCount(rs.getInt("platelet_count"));
            }
            return donorInfo;
        } catch (SQLException e) {
            throw new CustomException("Error: Unable To Find Information For Matching Donor");
        }
    }
}
