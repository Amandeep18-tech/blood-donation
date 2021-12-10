package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.common.Survey;
import com.dalhousie.bloodDonation.repos.common.SurveyRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurveyRepositoryImplTest {
    private static SurveyRepositoryImpl surveyRepository;

    @BeforeEach
    void setUp() {
        surveyRepository = new SurveyRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
        surveyRepository = null;
    }

    @Test
    @DisplayName("Check If SurveyRepositoryImpl Class Exist")
    void testSurveyRepositoryImplClassExist() {
        assertNotNull(surveyRepository, "SurveyRepositoryImpl Class Exist");
    }

    @Test
    void testAdd() {
        Survey expectedSurvey = new Survey();
        expectedSurvey.setSurveyTitle("Post Donation Survey");
        expectedSurvey.setSurveyDesc("Survey Desc");
        expectedSurvey.setSurveyType("Frequent");
        try {
            int id = surveyRepository.add(expectedSurvey);
            Survey actualSurvey = surveyRepository.getSurvey(id);
            assertEquals(expectedSurvey.getSurveyTitle(), actualSurvey.getSurveyTitle(), "Add Survey Method Works Perfectly");
        } catch (CustomException e) {
            e.printStackTrace();
        }
    }

    @Test
    void testGetSurvey() throws CustomException {
        Survey expectedSurvey = new Survey();
        expectedSurvey.setId(22);
        expectedSurvey.setSurveyTitle("fff");
        expectedSurvey.setSurveyDesc("ddd");
        expectedSurvey.setSurveyType("ggg");
        Survey actualSurvey = surveyRepository.getSurvey(22);
        assertEquals(expectedSurvey.getSurveyTitle(), actualSurvey.getSurveyTitle());
    }

    @Test
    void testGetAllSurvey() throws CustomException {
        assertNotNull(surveyRepository.getAllSurvey());
    }

    @Test
    void testUpdate() throws CustomException {
        Survey expectedSurvey = new Survey();
        expectedSurvey.setId(22);
        expectedSurvey.setSurveyTitle("fff");
        expectedSurvey.setSurveyDesc("ddd");
        expectedSurvey.setSurveyType("ggg");
        Boolean flag = surveyRepository.update(expectedSurvey);
        assertTrue(flag);
    }
}