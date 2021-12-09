package com.dalhousie.bloodDonation.model;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SurveyDetailsTest {
    private static SurveyDetails surveyDetails;

    @BeforeEach
    void setUp() {
        surveyDetails = new SurveyDetails();
    }

    @AfterEach
    void tearDown() {
        surveyDetails = null;
    }

    @Test
    @DisplayName("Check If SurveyDetails Class Exist")
    void testSurveyDetailsClassExist() {
        assertNotNull(surveyDetails, "SurveyDetails Class Exist");
    }

    @Test
    void testGetId() {
        int expectedId = 7;
        surveyDetails.setId(expectedId);
        int actualId = surveyDetails.getId();
        assertEquals(expectedId, actualId, "getId Method Returns Correct Value");
    }

    @Test
    void testGetSurveyQuestionId() {
        int expectedQuestionId = 33;
        surveyDetails.setId(expectedQuestionId);
        int actualQuestionId = surveyDetails.getId();
        assertEquals(expectedQuestionId, actualQuestionId, "getSurveyQuestionId Method Returns Correct Value");
    }

    @Test
    void testGetUserId() {
        String expectedUserId = "5";
        surveyDetails.setUserId(expectedUserId);
        String actualUserId = surveyDetails.getUserId();
        assertEquals(expectedUserId, actualUserId, "getUserId Method Returns Correct Value");
    }

    @Test
    void testSetUserId() {
        String expectedUserId = "9";
        surveyDetails.setUserId(expectedUserId);
        String actualUserId = surveyDetails.getUserId();
        assertEquals(expectedUserId, actualUserId, "setUserId Method Sets Correct Value");
    }

    @Test
    void testGetSurveyAnswer() {
        String expectedAnswer = "23";
        surveyDetails.setSurveyAnswer(expectedAnswer);
        String actualAnswer = surveyDetails.getSurveyAnswer();
        assertEquals(expectedAnswer, actualAnswer, "getSurveyAnswer Method Returns Correct Value");
    }

    @Test
    void testSetId() {
        int expectedId = 4;
        surveyDetails.setId(expectedId);
        int actualId = surveyDetails.getId();
        assertEquals(expectedId, actualId, "getId Method Sets Correct Value");
    }

    @Test
    void testSetQuestionId() {
        int expectedQuestionId = 30;
        surveyDetails.setId(expectedQuestionId);
        int actualQuestionId = surveyDetails.getId();
        assertEquals(expectedQuestionId, actualQuestionId, "setSurveyQuestionId Method Sets Correct Value");
    }

    @Test
    void testSetSurveyAnswer() {
        String expectedAnswer = "Frequently";
        surveyDetails.setSurveyAnswer(expectedAnswer);
        String actualAnswer = surveyDetails.getSurveyAnswer();
        assertEquals(expectedAnswer, actualAnswer, "setSurveyAnswer Method Sets Correct Value");
    }
}