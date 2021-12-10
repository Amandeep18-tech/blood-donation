package com.dalhousie.bloodDonation.model;

import com.dalhousie.bloodDonation.model.common.SurveyQuestions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class SurveyQuestionsTest {
    private static SurveyQuestions surveyQuestions;

    @BeforeEach
    void setUp() {
        surveyQuestions = new SurveyQuestions();
    }

    @AfterEach
    void tearDown() {
        surveyQuestions = null;
    }

    @Test
    @DisplayName("Check If SurveyQuestions Class Exist")
    void testSurveyQuestionsClassExist() {
        assertNotNull(surveyQuestions, "SurveyQuestions Class Exist");
    }

    @Test
    void testGetId() {
        int expectedId = 3;
        surveyQuestions.setId(expectedId);
        int actualId = surveyQuestions.getId();
        assertEquals(expectedId, actualId, "getId Method Returns Correct Value");
    }

    @Test
    void testGetSurveyMasterId() {
        int expectedMasterId = 6;
        surveyQuestions.setSurveyMasterId(expectedMasterId);
        int actualMasterId = surveyQuestions.getSurveyMasterId();
        assertEquals(expectedMasterId, actualMasterId, "getSurveyMasterId Method Returns Correct Value");
    }

    @Test
    void testGetSurveyQuestion() {
        String expectedSurveyQuestion = "What Is Your Age?";
        surveyQuestions.setSurveyQuestion(expectedSurveyQuestion);
        String actualSurveyQuestion = surveyQuestions.getSurveyQuestion();
        assertEquals(expectedSurveyQuestion, actualSurveyQuestion, "getSurveyQuestion Method Returns Correct Value");
    }

    @Test
    void testSetId() {
        int expectedId = 5;
        surveyQuestions.setId(expectedId);
        int actualId = surveyQuestions.getId();
        assertEquals(expectedId, actualId, "setId Method Sets Correct Value");
    }

    @Test
    void testSetSurveyMasterId() {
        int expectedMasterId = 4;
        surveyQuestions.setSurveyMasterId(expectedMasterId);
        int actualMasterId = surveyQuestions.getSurveyMasterId();
        assertEquals(expectedMasterId, actualMasterId, "setSurveyMasterId Method Sets Correct Value");
    }

    @Test
    void testSetSurveyQuestion() {
        String expectedSurveyQuestion = "How Often You Donate Blood?";
        surveyQuestions.setSurveyQuestion(expectedSurveyQuestion);
        String actualSurveyQuestion = surveyQuestions.getSurveyQuestion();
        assertEquals(expectedSurveyQuestion, actualSurveyQuestion, "setSurveyQuestion Method Sets Correct Value");
    }
}