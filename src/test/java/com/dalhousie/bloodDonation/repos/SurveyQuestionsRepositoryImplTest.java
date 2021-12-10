package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.common.SurveyQuestions;
import com.dalhousie.bloodDonation.repos.common.SurveyQuestionsRepositoryImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SurveyQuestionsRepositoryImplTest {
    private static SurveyQuestionsRepositoryImpl surveyQuestionsRepository;

    @BeforeEach
    void setUp() {
        surveyQuestionsRepository = new SurveyQuestionsRepositoryImpl();
    }

    @AfterEach
    void tearDown() {
        surveyQuestionsRepository = null;
    }

    @Test
    void testClassExist() {
        assertNotNull(surveyQuestionsRepository, "Class Exist");
    }

    @Test
    void testAdd() throws CustomException {
        SurveyQuestions surveyQuestions = new SurveyQuestions();
        surveyQuestions.setSurveyQuestion("q1");
        surveyQuestions.setSurveyMasterId(22);
        Boolean flag = surveyQuestionsRepository.add(surveyQuestions);
        assertTrue(flag);
    }

    @Test
    void testGetSurveyQuestion() throws CustomException {
        SurveyQuestions surveyQuestions1 = new SurveyQuestions();
        surveyQuestions1.setSurveyQuestion("q1");
        surveyQuestions1.setSurveyMasterId(22);
        SurveyQuestions surveyQuestions2 = surveyQuestionsRepository.getSurveyQuestion(22);
        assertNotEquals(surveyQuestions1.getSurveyQuestion(), surveyQuestions2.getSurveyQuestion());
    }

    @Test
    void testGetAllSurveyQuestions() throws CustomException {
        assertNotNull(surveyQuestionsRepository.getAllSurveyQuestions(22));
    }

    @Test
    void testUpdate() throws CustomException {
        SurveyQuestions surveyQuestions = new SurveyQuestions();
        surveyQuestions.setId(25);
        surveyQuestions.setSurveyMasterId(20);
        surveyQuestions.setSurveyQuestion("vv");
        assertTrue(surveyQuestionsRepository.update(surveyQuestions));
    }
}