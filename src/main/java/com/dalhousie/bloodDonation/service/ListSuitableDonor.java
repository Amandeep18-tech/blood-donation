package com.dalhousie.bloodDonation.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import com.dalhousie.bloodDonation.model.DonorMedicalRecords;
import com.mysql.cj.result.SqlDateValueFactory;


public interface ListSuitableDonor {

    public List<String> getSuitableDonorID(String bloodType) throws SQLException;
    public DonorMedicalRecords getSuitableDonor(String donorId) throws SQLException;
    public String getDonorDetails(String donorId) throws SQLException;
    public String getBloodTypeId(String bloodType) throws SQLException;
}
