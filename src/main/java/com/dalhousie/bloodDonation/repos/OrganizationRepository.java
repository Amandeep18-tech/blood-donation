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

    public OrganizationRepository()  {
        DBUtils dbUtils = new DBUtils();
        try{
        conn = dbUtils.getConnection();
        }
        catch(SQLException e){
            e.printStackTrace();
        }
    }

    
    public List<Organisation> getAllPlaces(){
        List<Organisation> organisationList = new ArrayList();
        try{
            String query="SELECT * FROM organisation";
            PreparedStatement ps = conn.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Organisation organisationDetails = new Organisation();
                organisationDetails.setLocation(rs.getString("location"));
                organisationDetails.setorganisationName(rs.getString("organisation_name"));
                organisationDetails.setEmail(rs.getString("email"));
                organisationDetails.setPinCode(rs.getString("pin_code"));
                organisationDetails.setorganisationID(rs.getString("organisation_id"));
                
                organisationList.add(organisationDetails);
            }
        }
        catch(SQLException e){
            e.printStackTrace();
        }
        return organisationList;
        
        
    }
}
