package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.model.LocationDetail;
import com.dalhousie.bloodDonation.model.LocationName;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class LocationRepository {

    private DBUtils dbUtils;

    public LocationRepository() {
        dbUtils = new DBUtils();
    }

    public List<LocationDetail> getAllRecordsLocationDistance() {
        List<LocationDetail> locationDetails = new ArrayList<>();
        try (Connection connection = dbUtils.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM location_distance_details");
            if (resultSet.next()) {
                LocationDetail locationDetail = new LocationDetail();
                locationDetail.setPinCode1(resultSet.getString("pin_code1"));
                locationDetail.setPinCode2(resultSet.getString("pin_code2"));
                locationDetail.setDistance(resultSet.getFloat("distance"));
                locationDetails.add(locationDetail);
            }
        } catch (SQLException sqlException) {
            //Todo
        }
        return locationDetails;
    }

    public List<LocationName> getAllRecordsLocationName() {
        List<LocationName> locationNames = new ArrayList<>();
        try (Connection connection = dbUtils.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM location_details");
            if (resultSet.next()) {
                LocationName locationName = new LocationName();
                locationName.setName(resultSet.getString("name"));
                locationName.setPinCode(resultSet.getString("pin_code"));
                locationNames.add(locationName);
            }
        } catch (SQLException sqlException) {
            //Todo
        }
        return locationNames;
    }
}
