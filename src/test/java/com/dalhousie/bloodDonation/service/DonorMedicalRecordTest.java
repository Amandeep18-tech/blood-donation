package com.dalhousie.bloodDonation.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.dalhousie.bloodDonation.service.donor.DonorMedicalRecord;
import com.dalhousie.bloodDonation.service.donor.DonorMedicalRecordImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DonorMedicalRecordTest {
    
    private DonorMedicalRecord donorMedicalRecord;
    
    @BeforeEach
    void setUp() throws Exception {
        donorMedicalRecord= new DonorMedicalRecordImpl();
    }
    @Test
    @DisplayName("Not null test for  Donor Donation Class")
    void DonorDonationBookingImplNotNull() {
       
        assertNotNull(donorMedicalRecord, "Donor Donation class Exist class exist");
    }


}
