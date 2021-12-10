package com.dalhousie.bloodDonation.model.common;

public class SurveyQuestions {
    private int id;
    private int surveyMasterId;
    private String surveyQuestion;

    public int getId() {
        return id;
    }

    public int getSurveyMasterId() {
        return surveyMasterId;
    }

    public String getSurveyQuestion() {
        return surveyQuestion;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurveyMasterId(int surveyMasterId) {
        this.surveyMasterId = surveyMasterId;
    }

    public void setSurveyQuestion(String surveyQuestion) {
        this.surveyQuestion = surveyQuestion;
    }

    @Override
    public String toString() {
        return "survey_questions [survey_master_id=" + surveyMasterId + ", survey_question=" + surveyQuestion + "]";
    }
}
