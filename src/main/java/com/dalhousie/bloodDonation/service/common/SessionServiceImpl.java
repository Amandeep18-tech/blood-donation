package com.dalhousie.bloodDonation.service.common;

import com.dalhousie.bloodDonation.constants.UserType;

import java.util.HashMap;

import static com.dalhousie.bloodDonation.constants.BloodDonationConstants.USER_ID;
import static com.dalhousie.bloodDonation.constants.BloodDonationConstants.USER_TYPE;

public class SessionServiceImpl implements SessionService{

    public static final HashMap<String,String> session = new HashMap<>();

    @Override
    public boolean isLoggedIn() {
        return !session.isEmpty();
    }

    @Override
    public String getUserId() {
        return session.get(USER_ID);
    }

    @Override
    public UserType getUserType() {
        return UserType.valueOf(session.get(USER_TYPE));
    }

    @Override
    public void setSession(String userId, UserType userType) {
        session.put(USER_ID, userId);
        session.put(USER_TYPE, userType.toString());
    }
}
