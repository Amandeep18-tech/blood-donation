package com.dalhousie.bloodDonation.model;

public class Person {

    private String first_name;
    private int age;
    private String person_id;
    private String person_type;
    private Integer appointment_attended_flag;
    private String person_status;
    private String appointment_date_and_time;
    private String contact_number;
    public Integer getAppointment_attended_flag() {
        return appointment_attended_flag;
    }

    public void setAppointment_attended_flag(Integer appointment_attended_flag) {
        this.appointment_attended_flag = appointment_attended_flag;
    }
    
    public String getPerson_status() {
        return person_status;
    }

    public void setPerson_status(String person_status) {
        this.person_status = person_status;
    }

    public String getAppointment_date_and_time() {
        return appointment_date_and_time;
    }

    public void setAppointment_date_and_time(String appointment_date_and_time) {
        this.appointment_date_and_time = appointment_date_and_time;
    }

    public String getContact_number() {
        return contact_number;
    }

    public void setContact_number(String contact_number) {
        this.contact_number = contact_number;
    }

    public String getBlood_group() {
        return blood_group;
    }

    public void setBlood_group(String blood_group) {
        this.blood_group = blood_group;
    }

    private String blood_group;


    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }

    public String getPerson_type() {
        return person_type;
    }

    public void setPerson_type(String person_type) {
        this.person_type = person_type;
    }

    


    public String getName() {
        return first_name;
    }

    public int getAge() {
        return age;
    }

    public void setName(String first_name) {
        this.first_name = first_name;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

