package com.dalhousie.bloodDonation.service.common;

import com.dalhousie.bloodDonation.exception.CustomException;

import java.sql.SQLException;

public interface SurveyDetailsService {
    void fillSurvey() throws SQLException, CustomException;
}
