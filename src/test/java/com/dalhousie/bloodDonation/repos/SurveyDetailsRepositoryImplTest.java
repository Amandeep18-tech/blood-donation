package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.repos.common.SurveyDetailsRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurveyDetailsRepositoryImplTest {
    private static SurveyDetailsRepositoryImpl surveyDetailsRepository;

    @BeforeEach
    void setUp() {
        surveyDetailsRepository = new SurveyDetailsRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
        surveyDetailsRepository = null;
    }

    @Test
    void testClassExist() {
        assertNotNull(surveyDetailsRepository, "Class Exist");
    }
}