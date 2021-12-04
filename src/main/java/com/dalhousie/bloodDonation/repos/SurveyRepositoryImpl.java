package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.Survey;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SurveyRepositoryImpl implements SurveyRepository {
    Connection conn;

    public SurveyRepositoryImpl() throws SQLException {
        DBUtils dbUtils = new DBUtils();
        conn = dbUtils.getConnection();
    }

    @Override
    public int add(Survey survey) throws SQLException {
        String query = "INSERT INTO survey_master (survey_title, " + "survey_desc, " + "survey_type) VALUES (?, ?, ?)";
        PreparedStatement ps = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, survey.getSurveyTitle());
        ps.setString(2, survey.getSurveyDesc());
        ps.setString(3, survey.getSurveyType());
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        int surveyMasterId = 0;
        while ((rs.next())) {
            surveyMasterId = rs.getInt(1);
        }
        System.out.println("Survey Master ID: " + surveyMasterId);

        return surveyMasterId;
    }

    @Override
    public void delete(int id) throws SQLException {
        String query = "DELETE FROM survey_master WHERE id= ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        ps.executeUpdate();
    }

    @Override
    public Survey getSurvey(int id) throws SQLException {
        String query = "SELECT * FROM survey_master WHERE id= ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setInt(1, id);
        Survey survey = new Survey();
        ResultSet rs = ps.executeQuery();
        boolean check = false;

        while (rs.next()) {
            check = true;
            survey.setId(rs.getInt("id"));
            survey.setSurveyTitle(rs.getString("survey_title"));
            survey.setSurveyDesc(rs.getString("survey_desc"));
            survey.setSurveyType(rs.getString("survey_type"));
        }

        if (check) {
            return survey;
        } else {
            return null;
        }
    }

    @Override
    public List<Survey> getAllSurvey() throws SQLException {
        String query = "SELECT * FROM survey_master";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Survey> surveyList = new ArrayList<>();

        while (rs.next()) {
            Survey survey = new Survey();
            survey.setId(rs.getInt("id"));
            survey.setSurveyTitle(rs.getString("survey_title"));
            survey.setSurveyDesc(rs.getString("survey_desc"));
            survey.setSurveyType(rs.getString("survey_type"));
            surveyList.add(survey);
        }
        return surveyList;
    }

    @Override
    public void update(Survey survey) throws SQLException {
        String query = "UPDATE survey_master SET survey_title= ?, " + "survey_desc= ?, " + "survey_type= ?" + "WHERE id= ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, survey.getSurveyTitle());
        ps.setString(2, survey.getSurveyDesc());
        ps.setString(3, survey.getSurveyType());
        ps.setInt(4, survey.getId());
        ps.executeUpdate();
    }
}
