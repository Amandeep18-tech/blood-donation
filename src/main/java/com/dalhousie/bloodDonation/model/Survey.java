package com.dalhousie.bloodDonation.model;

public class Survey {
    private int id;
    private String surveyTitle;
    private String surveyDescription;
    private String surveyType;

    public int getId() {
        return id;
    }

    public String getSurveyTitle() {
        return surveyTitle;
    }

    public String getSurveyDesc() {
        return surveyDescription;
    }

    public String getSurveyType() {
        return surveyType;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setSurveyTitle(String surveyTitle) { this.surveyTitle = surveyTitle; }

    public void setSurveyDesc(String surveyDescription) {
        this.surveyDescription = surveyDescription;
    }

    public void setSurveyType(String surveyType) {
        this.surveyType = surveyType;
    }

    @Override
    public String toString() {
        return "survey_master [survey_title=" + surveyTitle + ", survey_desc=" + surveyDescription + ",survey_type=" + surveyType + "]";
    }
}
