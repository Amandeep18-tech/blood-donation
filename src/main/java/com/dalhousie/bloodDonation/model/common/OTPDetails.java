package com.dalhousie.bloodDonation.model.common;

public class OTPDetails {
    String otpCode;
    long issueTime;

    public OTPDetails(String otpCode, long issueTime) {
        this.otpCode = otpCode;
        this.issueTime = issueTime;
    }

    public String getOtpCode() {
        return otpCode;
    }

    public void setOtpCode(String otpCode) {
        this.otpCode = otpCode;
    }

    public long getIssueTime() {
        return issueTime;
    }

    public void setIssueTime(long issueTime) {
        this.issueTime = issueTime;
    }
}
