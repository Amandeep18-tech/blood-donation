package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.Survey;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SurveyRepositoryImpl implements SurveyRepository {

    @Override
    public int add(Survey survey) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try (Connection conn = dbUtils.getConnection()) {
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
            return surveyMasterId;
        } catch (SQLException e) {
            throw new CustomException("Error: Unable To Create Survey");
        }
    }

    @Override
    public void delete(int id) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try (Connection conn = dbUtils.getConnection()) {
            String query = "DELETE FROM survey_master WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new CustomException("Error: Unable To Delete Survey");
        }
    }

    @Override
    public Survey getSurvey(int id) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try (Connection conn = dbUtils.getConnection()) {

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
        } catch (SQLException e) {
            throw new CustomException("Error: Unable To Fetch Survey");
        }
    }

    @Override
    public List<Survey> getAllSurvey() throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try (Connection conn = dbUtils.getConnection()) {
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
        } catch (SQLException e) {
            throw new CustomException("Error: Unable To Fetch All Surveys");
        }
    }

    @Override
    public Boolean update(Survey survey) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try (Connection conn = dbUtils.getConnection()) {
            String query = "UPDATE survey_master SET survey_title= ?, " + "survey_desc= ?, " + "survey_type= ?" + "WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, survey.getSurveyTitle());
            ps.setString(2, survey.getSurveyDesc());
            ps.setString(3, survey.getSurveyType());
            ps.setInt(4, survey.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            throw new CustomException("Error: Unable To Update Survey");
        }
    }
}
