package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.Survey;

import java.sql.SQLException;
import java.util.List;

public interface SurveyRepository {
    int add(Survey survey) throws SQLException;

    void delete(int id) throws SQLException;

    Survey getSurvey(int id) throws SQLException;

    List<Survey> getAllSurvey() throws SQLException;

    void update(Survey survey) throws SQLException;
}
