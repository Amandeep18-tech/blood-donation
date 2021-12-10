package com.dalhousie.bloodDonation.model;

import com.dalhousie.bloodDonation.model.common.Survey;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SurveyTest {
    private static Survey survey;

    @BeforeEach
    void setUp() {
        survey = new Survey();
    }

    @AfterEach
    void tearDown() {
        survey = null;
    }

    @Test
    @DisplayName("Check If Survey Class Exist")
    void testSurveyClassExist() {
        assertNotNull(survey, "Survey Class Exist");
    }

    @Test
    void testGetId() {
        int expectedId = 5;
        survey.setId(expectedId);
        int actualId = survey.getId();
        assertEquals(expectedId, actualId, "getId Method Returns Correct Value");
    }

    @Test
    void testGetSurveyTitle() {
        String expectedTitle = "Post Donation Survey";
        survey.setSurveyTitle(expectedTitle);
        String actualTitle = survey.getSurveyTitle();
        assertEquals(expectedTitle, actualTitle, "getSurveyTitle Method Returns Correct Value");
    }

    @Test
    void testGetSurveyDesc() {
        String expectedSurveyDesc = "Survey Description";
        survey.setSurveyDesc(expectedSurveyDesc);
        String actualSurveyDesc = survey.getSurveyDesc();
        assertEquals(expectedSurveyDesc, actualSurveyDesc, "getSurveyDesc Method Returns Correct Value");
    }

    @Test
    void testGetSurveyType() {
        String expectedSurveyType = "Frequent";
        survey.setSurveyType(expectedSurveyType);
        String actualSurveyType = survey.getSurveyType();
        assertEquals(expectedSurveyType, actualSurveyType, "getSurveyType Method Returns Correct Value");
    }

    @Test
    void testSetId() {
        int expectedId = 6;
        survey.setId(expectedId);
        int actualId = survey.getId();
        assertEquals(expectedId, actualId, "setId Method Sets Correct Value");
    }

    @Test
    void testSetSurveyTitle() {
        String expectedTitle = "Pre Donation Survey";
        survey.setSurveyTitle(expectedTitle);
        String actualTitle = survey.getSurveyTitle();
        assertEquals(expectedTitle, actualTitle, "setSurveyTitle Method Sets Correct Value");
    }

    @Test
    void testSetSurveyDesc() {
        String expectedSurveyDesc = "Survey Desc";
        survey.setSurveyDesc(expectedSurveyDesc);
        String actualSurveyDesc = survey.getSurveyDesc();
        assertEquals(expectedSurveyDesc, actualSurveyDesc, "setSurveyDesc Method Sets Correct Value");
    }

    @Test
    void testSetSurveyType() {
        String expectedSurveyType = "Regular";
        survey.setSurveyType(expectedSurveyType);
        String actualSurveyType = survey.getSurveyType();
        assertEquals(expectedSurveyType, actualSurveyType, "setSurveyType Method Sets Correct Value");
    }
}