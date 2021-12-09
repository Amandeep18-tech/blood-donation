package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.Survey;

import java.sql.SQLException;
import java.util.List;

public interface SurveyRepository {
    int add(Survey survey) throws SQLException, CustomException;

    void delete(int id) throws SQLException, CustomException;

    Survey getSurvey(int id) throws SQLException, CustomException;

    List<Survey> getAllSurvey() throws SQLException, CustomException;

    Boolean update(Survey survey) throws SQLException, CustomException;
}
