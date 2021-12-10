package com.dalhousie.bloodDonation.repos.common;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.common.SurveyDetails;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SurveyDetailsRepositoryImpl implements SurveyDetailsRepository {
    @Override
    public void add(SurveyDetails surveyDetails) throws CustomException {
        try (Connection conn = DBUtils.getInstance().getConnection()) {
            String query = "INSERT INTO survey_details (survey_question_id, " + "user_id ," + "survey_answer) VALUES (?, ?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, surveyDetails.getSurveyQuestionId());
            ps.setString(2, surveyDetails.getUserId());
            ps.setString(3, surveyDetails.getSurveyAnswer());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new CustomException("Error: Unable To Fill The Survey");
        }
    }
}
