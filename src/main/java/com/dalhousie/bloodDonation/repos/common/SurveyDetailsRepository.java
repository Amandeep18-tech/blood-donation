package com.dalhousie.bloodDonation.repos.common;

import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.common.SurveyDetails;

public interface SurveyDetailsRepository {
    void add(SurveyDetails surveyDetails) throws CustomException;
}