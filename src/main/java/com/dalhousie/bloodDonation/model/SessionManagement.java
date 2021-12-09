package com.dalhousie.bloodDonation.model;

import java.util.HashMap;
import java.util.Map;

public class SessionManagement {

    Map<String,User> sessionMap = new HashMap<>();

    public Map<String, User> getSessionMap() {
        return sessionMap;
    }

    public void setSessionMap(Map<String, User> sessionMap) {
        this.sessionMap = sessionMap;
    }
}
