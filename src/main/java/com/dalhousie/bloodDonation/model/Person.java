package com.dalhousie.bloodDonation.model;

public class Person {

    private String name;
    private int age;
    private String personId;
    private String bloodGroup;
    private String contactNumber;
   
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getcontactNumber() {
        return contactNumber;
    }

    public void setcontactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getbloodGroup() {
        return bloodGroup;
    }

    public void setbloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getpersonId() {
        return personId;
    }

    public void setpersonId(String personId) {
        this.personId = personId;
    }


    

    public int getAge() {
        return age;
    }

    

    public void setAge(int age) {
        this.age = age;
    }
}

