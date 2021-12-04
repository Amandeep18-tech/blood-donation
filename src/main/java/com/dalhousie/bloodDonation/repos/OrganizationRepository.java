package com.dalhousie.bloodDonation.repos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dalhousie.bloodDonation.utils.DBUtils;
import com.dalhousie.bloodDonation.model.Organisation;

public class OrganizationRepository {
    Connection conn;

    public OrganizationRepository() throws SQLException {
        DBUtils dbUtils = new DBUtils();
        conn = dbUtils.getConnection();
    }

    
    public List<Organisation> getAllPlaces() throws SQLException{
        String query="SELECT * FROM organisation";
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Organisation> organisationList = new ArrayList();
        while (rs.next()){
            Organisation organisationDetails = new Organisation();
            organisationDetails.setLocation(rs.getString("location"));
            organisationDetails.setOrganisation_name(rs.getString("organisation_name"));
            
    
            organisationDetails.setorganisationID(rs.getString("organisation_id"));
            
            organisationList.add(organisationDetails);
        }
        return organisationList;
        
        
    }
}
