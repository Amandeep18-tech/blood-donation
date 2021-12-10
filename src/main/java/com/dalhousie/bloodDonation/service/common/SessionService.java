package com.dalhousie.bloodDonation.service.common;

import com.dalhousie.bloodDonation.constants.UserType;

public interface SessionService {
    boolean isLoggedIn();

    String getUserId();

    UserType getUserType();

    void setSession(String userId, UserType userType);
}
