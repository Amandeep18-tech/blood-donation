package com.dalhousie.bloodDonation.model;

public class SurveyDetails {
    private int id;
    private int surveyQuestionId;
    private String userId;
    private String surveyAnswer;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getId() {
        return id;
    }

    public int getSurveyQuestionId() {
        return surveyQuestionId;
    }

    public String getSurveyAnswer() {
        return surveyAnswer;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setQuestionId(int surveyQuestionId) {
        this.surveyQuestionId = surveyQuestionId;
    }

    public void setSurveyAnswer(String surveyAnswer) {
        this.surveyAnswer = surveyAnswer;
    }

    @Override
    public String toString() {
        return "survey_details [survey_question_id=" + surveyQuestionId + ", survey_answer=" + surveyAnswer + "]";
    }
}
