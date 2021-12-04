package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.SurveyDetails;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SurveyDetailsRepositoryImpl implements SurveyDetailsRepository {
    Connection conn;

    public SurveyDetailsRepositoryImpl() throws SQLException {
        DBUtils dbUtils = new DBUtils();
        conn = dbUtils.getConnection();
    }

    @Override
    public void add(SurveyDetails surveyDetails) throws SQLException {
        String query = "INSERT INTO survey_details (survey_question_id, " + "survey_answer) VALUES (?, ?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, surveyDetails.getSurveyQuestionId());
        ps.setString(2, surveyDetails.getSurveyAnswer());
        ps.executeUpdate();
    }
}
