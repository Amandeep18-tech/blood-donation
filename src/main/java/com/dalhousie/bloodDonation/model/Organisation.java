package com.dalhousie.bloodDonation.model;

public class Organisation {
    private String organisationID;
    private String organisation_name;
    private String location;
    private String organisation_type;
    private String password;
    public String getorganisationID() {
        return organisationID;
    }
    public void setorganisationID(String organisationID) {
        this.organisationID = organisationID;
    }
    public String getOrganisation_name() {
        return organisation_name;
    }
    public void setOrganisation_name(String organisation_name) {
        this.organisation_name = organisation_name;
    }
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
    public String getOrganisation_type() {
        return organisation_type;
    }
    public void setOrganisation_type(String organisation_type) {
        this.organisation_type = organisation_type;
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
