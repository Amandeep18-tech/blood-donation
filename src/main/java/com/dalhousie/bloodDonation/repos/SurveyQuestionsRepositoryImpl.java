package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.SurveyQuestions;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SurveyQuestionsRepositoryImpl implements SurveyQuestionsRepository {

    @Override
    public void add(SurveyQuestions surveyQuestion) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try(Connection conn = dbUtils.getConnection()) {
            String query = "INSERT INTO survey_questions (survey_master_id, " + "survey_question) VALUES (?, ?)";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, surveyQuestion.getSurveyMasterId());
            ps.setString(2, surveyQuestion.getSurveyQuestion());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new CustomException("");
        }
    }

    @Override
    public void delete(int id) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try(Connection conn = dbUtils.getConnection()) {
            String query = "DELETE FROM survey_questions WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
        }catch (SQLException e){
            throw new CustomException("");
        }
    }

    @Override
    public SurveyQuestions getSurveyQuestion(int id) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try(Connection conn = dbUtils.getConnection()) {
            String query = "SELECT * FROM survey_questions WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, id);
            SurveyQuestions surveyQuestion = new SurveyQuestions();
            ResultSet rs = ps.executeQuery();
            boolean check = false;
            while (rs.next()) {
                check = true;
                surveyQuestion.setId(rs.getInt("id"));
                surveyQuestion.setSurveyMasterId(rs.getInt("survey_master_id"));
                surveyQuestion.setSurveyQuestion(rs.getString("survey_question"));
            }
            if (check) {
                return surveyQuestion;
            } else {
                return null;
            }
        }catch (SQLException e){
            throw new CustomException("");
        }
    }


    @Override
    public List<SurveyQuestions> getAllSurveyQuestions(int surveyMasterId) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try(Connection conn = dbUtils.getConnection()) {
            String query = "SELECT * FROM survey_questions WHERE survey_master_id = ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setInt(1, surveyMasterId);
            ResultSet rs = ps.executeQuery();
            List<SurveyQuestions> questionList = new ArrayList<>();
            while (rs.next()) {
                SurveyQuestions surveyQuestion = new SurveyQuestions();
                surveyQuestion.setId(rs.getInt("id"));
                surveyQuestion.setSurveyMasterId(rs.getInt("survey_master_id"));
                surveyQuestion.setSurveyQuestion(rs.getString("survey_question"));
                questionList.add(surveyQuestion);
            }
            return questionList;
        }catch (SQLException e){
            throw new CustomException("");
        }
    }

    @Override
    public void update(SurveyQuestions surveyQuestion) throws CustomException {
        DBUtils dbUtils = new DBUtils();
        try(Connection conn = dbUtils.getConnection()) {
            String query = "UPDATE survey_questions SET survey_question= ? " + "WHERE id= ?";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, surveyQuestion.getSurveyQuestion());
            ps.setInt(2, surveyQuestion.getId());
            ps.executeUpdate();
        }catch (SQLException e){
            throw new CustomException("");
        }
    }
}
