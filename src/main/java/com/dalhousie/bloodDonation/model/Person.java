package com.dalhousie.bloodDonation.model;

public class Person {

    private String name;
    private int age;
    private String person_id;
    private String blood_group;
    private String contact_number;
   
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPerson_id() {
        return person_id;
    }

    public void setPerson_id(String person_id) {
        this.person_id = person_id;
    }


    

    public int getAge() {
        return age;
    }

    

    public void setAge(int age) {
        this.age = age;
    }
}

