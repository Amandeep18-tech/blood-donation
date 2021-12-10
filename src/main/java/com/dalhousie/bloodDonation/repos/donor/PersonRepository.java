package com.dalhousie.bloodDonation.repos.donor;
import com.dalhousie.bloodDonation.model.donor.Person;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    
    public List<Person> getPerson(){
        List<Person> personDetail = new ArrayList();
        try{
        Connection conn= DBUtils.getInstance().getConnection();
        String query="SELECT * FROM Person" ;
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            Person person = new Person();
            person.setName(rs.getString("person_first_name")); 
            person.setpersonId(rs.getString("person_id"));
            person.setbloodGroup(rs.getString("blood_group"));
            person.setcontactNumber(rs.getString("contact_number"));
            person.setPinCode(rs.getString("pin_code"));
            personDetail.add(person);
        }
        }catch(SQLException e){
            e.printStackTrace();
        }
        return personDetail;
    }
    public void updatePersonStatus() {
        try{
        Connection conn= DBUtils.getInstance().getConnection();
        String query = "UPDATE Person SET appointment_attended_flag= ? WHERE person_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setInt(1,1);
        
        ps.setString(2,"5c256da3-3d82-11ec-917b-e2ed2ce588f5");
        ps.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
}
