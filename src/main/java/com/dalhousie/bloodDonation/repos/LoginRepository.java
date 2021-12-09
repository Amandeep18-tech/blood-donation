package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.constants.UserType;
import com.dalhousie.bloodDonation.controller.LoginController;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.Organisation;
import com.dalhousie.bloodDonation.model.SessionManagement;
import com.dalhousie.bloodDonation.model.User;
import com.dalhousie.bloodDonation.service.SessionService;
import com.dalhousie.bloodDonation.service.SessionServiceImpl;
import com.dalhousie.bloodDonation.utils.DBUtils;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.Scanner;
import java.util.UUID;

public class LoginRepository {
    User user;
    String username;
    String pass;
    int patient_id;
    int flag=0;
    PatientMedicalInformationRepository patientMedicalInformationRepository;
    LoginController loginController;
    SessionManagement session = new SessionManagement();
    Scanner sc = new Scanner(System.in);
    public void checkExistingUser(String userName,String password){
        try {
            String resetpass;
            DBUtils dbUtils = new DBUtils();
            Connection con = dbUtils.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            while(rs.next()){
                username = rs.getString(2);
                pass = rs.getString(3);
                if(userName.equals(username) && password.equals(pass)  ){
                    //  password.equals(pass)
                    System.out.println("Welcome: "+userName);
                    //session.getSessionMap().put(userName,user);
                   // session.getSessionMap().put(Constant.)
                    SessionService sessionService = new SessionServiceImpl();
                    sessionService.setSession(rs.getString("userId"),UserType.valueOf(rs.getString("userType")));
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                System.out.println("Invalid UserName or Password:");
            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void checkExistingPatient(String userName,String password){
        try {
            String resetpass;
            DBUtils dbUtils = new DBUtils();
            Connection con = dbUtils.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from patient_login");
            while(rs.next()){
                patient_id = rs.getInt(1);
                if(userName.equals(username) && password.equals(pass)  ){
                    System.out.println("Welcome Patient: "+userName);
                    //session.setPatientId(patient_id);
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                System.out.println("Invalid UserName or Password:");
            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void checkExistingOrgansation(String userName,String password){
        try {
            DBUtils dbUtils = new DBUtils();
            Connection con = dbUtils.getConnection();
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from organisation");
            while(rs.next()){
                String organisationName = rs.getString(1);
                String organisationPassword = rs.getString(2);
                if(userName.equals(organisationName) && password.equals(organisationPassword)  ){
                    System.out.println("Welcome Organisation: "+userName);
                    flag=1;
                    break;
                }
            }
            if(flag==0){
                System.out.println("Invalid UserName or Password:");
            }
            con.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void addUser(User user){
        try {
            //DBUtils dbUtils = new DBUtils();
            //Connection con = dbUtils.getConnection();
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/blooddonationdb","root","123456789");
            Statement st = con.createStatement();
            st.execute("INSERT INTO user(username,password,firstname,lastname,bloodgroup) VALUES('"+ user.getUserName()+"','"+ user.getPassword()+"','"+ user.getFirstname()+"','"+ user.getLastname()+"','"+ user.getBloodGroup()+"')");
            System.out.println("SignUp successfull");
        }catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addOrganization(Organisation organisation) throws CustomException {
        try {
            DBUtils dbUtils = new DBUtils();
            Connection con = dbUtils.getConnection();
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            Statement st = con.createStatement();
            st.execute("INSERT INTO organisation(organisation_id,organisation_name,location,organisation_type,password,slots_available,pin_code,email) " +
                    "VALUES('"+ uuidAsString +"','"+ organisation.getorganisationName()+"','"+ organisation.getLocation()+"','"+ organisation
                    .getorganisationType()+"','"+ organisation.getPassword()+"','"+ organisation.getSlots_available()+"','"+ organisation.getPinCode()+"','"+ organisation.getEmail()+"')");
            st.execute("Insert into user(username,password,firstname,userId,userType) values ('"+organisation.getEmail()+"','"+organisation.getPassword()+"','"+organisation.getorganisationName()+"','"+uuidAsString+"','"+UserType.ORGANIZATION+"')");
            System.out.println("SignUp successful");
        }catch (SQLException e) {
            e.printStackTrace();
            throw new CustomException("something went wrong");
        }
    }

    public User forgetPass(String username) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blooddonationdb","root","123456789");
        String sql = "select * from user where userName=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        String uname = null;
        String pass = null;
        String fname = null;
        String lname = null;
        String bgroup = null;
        while(rs.next()){
            uname = rs.getString(1);
             pass = rs.getString(2);
             fname = rs.getString(3);
             lname = rs.getString(4);
             bgroup = rs.getString(5);

        }
        User user = new User();
        user.setFirstname(fname);
        user.setUserName(uname);
        user.setPassword(pass);
        user.setLastname(lname);
        user.setBloodGroup(bgroup);
        return user;
    }
    public void updatePass(String username,String pwd,String OTP) throws Exception {
        loginController = new LoginController();
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con=DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blooddonationdb","root","123456789");

        String sql = "update user set password=? where userName=?";
        PreparedStatement stmt = con.prepareStatement(sql);
      String hashpw=BCrypt.hashpw(pwd, BCrypt.gensalt());
            stmt.setString(1, hashpw);
            stmt.setString(2, username);
            stmt.executeUpdate();
        System.out.println("Password Updated Successfully");
        loginController.menu();
    }

    public void addPerson(String contactNo, User user, String pinCode){
        try {
            DBUtils dbUtils = new DBUtils();
            Connection con = dbUtils.getConnection();
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            Statement st = con.createStatement();
            st.execute("INSERT INTO Person(person_id,person_first_name,person_last_name,contact_number,blood_group,pin_code) VALUES('"+ uuidAsString+"','"+ user.getFirstname()+"','"+ user.getLastname()+"','"+ contactNo+"','"+ user.getBloodGroup()+"','"+ pinCode +"')");
            st.execute("Insert into user (userId,username,password,firstname,lastname,bloodgroup,userType) values('"+uuidAsString+"','"+user.getUserName()+"','"+user.getPassword()+"','"+user.getFirstname()+"','"+user.getLastname()+"','"+user.getBloodGroup()+"','"+ UserType.DONOR.toString() +"')");
            System.out.println("SignUp successfull");
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
