package com.dalhousie.bloodDonation.repos.organisation;

import com.dalhousie.bloodDonation.model.organisation.Organisation;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrganizationRepository {
    
    public List<Organisation> getAllPlaces(){
        List<Organisation> organisationList = new ArrayList();
        try{
            Connection conn= DBUtils.getInstance().getConnection();
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
