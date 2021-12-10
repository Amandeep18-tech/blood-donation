package com.dalhousie.bloodDonation.model.organisation;

import com.dalhousie.bloodDonation.constants.BloodGroup;
import com.dalhousie.bloodDonation.constants.BloodReqOrgStatus;

public class BloodRequestOrganisation {
    private int id;
    private String orgId;
    private String receiverOrgId;
    private int unitsRequired;
    private BloodReqOrgStatus status;
    private BloodGroup bloodGroup;
    private String timestamp;

    public BloodGroup getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(BloodGroup bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrgId() {
        return orgId;
    }

    public void setOrgId(String orgId) {
        this.orgId = orgId;
    }

    public String getReceiverOrgId() {
        return receiverOrgId;
    }

    public void setReceiverOrgId(String receiverOrgId) {
        this.receiverOrgId = receiverOrgId;
    }

    public int getUnitsRequired() {
        return unitsRequired;
    }

    public void setUnitsRequired(int unitsRequired) {
        this.unitsRequired = unitsRequired;
    }

    public BloodReqOrgStatus getStatus() {
        return status;
    }

    public void setStatus(BloodReqOrgStatus status) {
        this.status = status;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
