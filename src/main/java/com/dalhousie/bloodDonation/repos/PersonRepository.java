package com.dalhousie.bloodDonation.repos;
import com.dalhousie.bloodDonation.model.Person;
import com.dalhousie.bloodDonation.utils.DBUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PersonRepository {
    Connection conn;

    public PersonRepository() throws SQLException {
        DBUtils dbUtils = new DBUtils();
        conn = dbUtils.getConnection();
    }
    public List<Person> getPerson() throws SQLException{
    String query="SELECT * FROM Person" ;
        PreparedStatement ps = conn.prepareStatement(query);
        ResultSet rs = ps.executeQuery();
        List<Person> personDetail = new ArrayList();
        while (rs.next()){
            Person person = new Person();
            person.setName(rs.getString("person_first_name")); 
            person.setPerson_id(rs.getString("person_id"));
            person.setBlood_group(rs.getString("blood_group"));
            person.setName(rs.getString("person_first_name"));
            person.setPerson_id(rs.getString("person_id"));
            personDetail.add(person);
        }
        return personDetail;
    }
    public void updatePersonStatus() throws SQLException{
    String query = "UPDATE Person SET appointment_attended_flag= ? WHERE person_id = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        
        ps.setInt(1,1);
        
        ps.setString(2,"5c256da3-3d82-11ec-917b-e2ed2ce588f5");
        ps.executeUpdate();

    }
}
