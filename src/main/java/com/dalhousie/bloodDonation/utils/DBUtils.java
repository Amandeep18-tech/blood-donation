package com.dalhousie.bloodDonation.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private String dbUserName;
    private String dbPassword;
    private String dbName;

    public DBUtils() {
        Properties properties = EnvironmentalProperties.getProperties("environment.properties");
        this.dbUserName = properties.getProperty("db.username");
        this.dbPassword = properties.getProperty("db.password");
        this.dbName = properties.getProperty("db.dbname");
    }

    public Connection getConnection() throws SQLException {
        System.out.println(this.dbName);
        Connection connection = DriverManager.getConnection("jdbc:mysql://db-5308.cs.dal.ca:3306/" + this.dbName
                , this.dbUserName, this.dbPassword);
        return connection;
    }
}
