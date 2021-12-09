package com.dalhousie.bloodDonation.model;

public class Organisation {
    private String organisationID;
    private String organisationName;
    private String location;
    private String organisationType;
    private String password;
    public String getorganisationID() {
        return organisationID;
    }
    public void setorganisationID(String organisationID) {
        this.organisationID = organisationID;
    }
    public String getorganisationName() {
        return organisationName;
    }
    public void setorganisationName(String organisationName) {
        this.organisationName = organisationName;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getorganisationType() {
        return organisationType;
    }
    public void setorganisationType(String organisationType) {
        this.organisationType = organisationType;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public String getSlots_available() {
        return slots_available;
    }
    public void setSlots_available(String slots_available) {
        this.slots_available = slots_available;
    }
    private String slots_available;
    
}
