package com.dalhousie.bloodDonation.service.donor;

import com.dalhousie.bloodDonation.exception.CustomException;

import java.util.ArrayList;

public interface DonorMedicalRecord {
    public ArrayList<String> getTodayMedicalRecord() throws CustomException;
}
