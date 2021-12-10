package com.dalhousie.bloodDonation.constants;

public class QueryConstants {
    public final static String USER_TABLE = "select * from user;";
    public final static String PATIENT_TABLE = "select * from patient_login;";
    public final static String ORGANISATION_TABLE = "select * from organisation;";
    public final static String FORGETPASSWORD_USERTABLE = "select * from user where userName=?;";
    public final static String UPDATETABLE_USERTABLE = "update user set password=? where userName=?";
}
