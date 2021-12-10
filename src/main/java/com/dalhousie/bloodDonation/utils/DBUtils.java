package com.dalhousie.bloodDonation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

// Singleton Design Pattern is followed
public class DBUtils {

    private static DBUtils dbUtilsInstance = null;
    private String dbUserName;
    private String dbPassword;
    private String dbName;

    private DBUtils() {
        Properties properties = EnvironmentalProperties.getProperties("environment.properties");
        this.dbUserName = properties.getProperty("db.username");
        this.dbPassword = properties.getProperty("db.password");
        this.dbName = properties.getProperty("db.dbname");
    }

    public static DBUtils getInstance(){
        if(dbUtilsInstance == null){
            dbUtilsInstance = new DBUtils();
        }
        return dbUtilsInstance;
    }

    public Connection getConnection() throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://db-5308.cs.dal.ca:3306/" + this.dbName
                , this.dbUserName, this.dbPassword);
        return connection;
    }
}
