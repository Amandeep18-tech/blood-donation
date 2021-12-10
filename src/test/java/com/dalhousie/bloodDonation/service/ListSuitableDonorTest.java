package com.dalhousie.bloodDonation.service;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.BloodDonationDetaisHistory;
import com.dalhousie.bloodDonation.model.PatientBloodRequest;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ListSuitableDonorTest {
    
    private ListSuitableDonor listSuitableDonor;
    
    @BeforeEach
    void setUp() throws Exception {
        listSuitableDonor= new ListSuitableDonorImpl();
    }

   
}