package com.dalhousie.bloodDonation.model;

public class PatientPersonalInformation {
    private int id;
    private String patientName;
    private String dateOfBirth;
    private int age;
    private String address;
    private String contactNumber;
    private String emailId;

    public int getId() {
        return id;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getDOB() {
        return dateOfBirth;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setId(int id) { this.id = id; }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public void setDOB(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    @Override
    public String toString() {
        return "patient_personal_information [patient_name=" + patientName + ", date_of_birth=" + dateOfBirth + ", age=" + age + ", address=" + address + ", contact_number=" + contactNumber + ", email_id=" + emailId + "]";
    }
}
