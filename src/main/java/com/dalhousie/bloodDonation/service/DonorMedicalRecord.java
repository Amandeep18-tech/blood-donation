package com.dalhousie.bloodDonation.service;

import java.sql.SQLException;
import java.util.ArrayList;

import com.dalhousie.bloodDonation.exception.CustomException;

public interface DonorMedicalRecord {
    public ArrayList<String> getTodayMedicalRecord() throws CustomException;
}
