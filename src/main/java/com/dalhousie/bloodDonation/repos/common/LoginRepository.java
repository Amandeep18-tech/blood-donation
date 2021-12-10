package com.dalhousie.bloodDonation.repos.common;

import com.dalhousie.bloodDonation.constants.UserType;
import com.dalhousie.bloodDonation.controller.common.LoginController;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.common.SessionManagement;
import com.dalhousie.bloodDonation.model.common.User;
import com.dalhousie.bloodDonation.model.organisation.Organisation;
import com.dalhousie.bloodDonation.repos.patient.PatientMedicalInformationRepository;
import com.dalhousie.bloodDonation.service.common.SessionService;
import com.dalhousie.bloodDonation.service.common.SessionServiceImpl;
import com.dalhousie.bloodDonation.utils.DBUtils;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.Locale;
import java.util.Scanner;
import java.util.UUID;

import static com.dalhousie.bloodDonation.constants.QueryConstants.*;

public class LoginRepository {
    String username;
    String pass;
    int patient_id;
    LoginController loginController;

    public boolean checkExistingUser(String userName, String password) throws CustomException {
        try(Connection con = DBUtils.getInstance().getConnection()) {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(USER_TABLE);
            while (rs.next()) {
                username = rs.getString(2);
                pass = rs.getString(3);

                if (userName.equals(username) && BCrypt.checkpw(password,pass)) {
                    System.out.println("Welcome: " + userName);
                    SessionService sessionService = new SessionServiceImpl();
                    sessionService.setSession(rs.getString("userId"), UserType.valueOf(rs.getString("userType").toUpperCase(Locale.ROOT)));
                    return true;
                }
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            throw new CustomException("Error with existing user!");
        }
    }

    public boolean checkExistingPatient(String userName, String password) throws CustomException {
        try (Connection con= DBUtils.getInstance().getConnection()){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(PATIENT_TABLE);
            while (rs.next()) {
                patient_id = rs.getInt(1);
                if (userName.equals(username) && password.equals(pass)) {
                    System.out.println("Welcome Patient: " + userName);
                    return true;
                }
            }
            return false;

        } catch (SQLException e) {
           throw new CustomException("Error while patient logging in");
        }

    }

    public boolean checkExistingOrgansation(String userName, String password) throws CustomException {
        try (Connection con= DBUtils.getInstance().getConnection()){
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(ORGANISATION_TABLE);
            while (rs.next()) {
                String organisationName = rs.getString(1);
                String organisationPassword = rs.getString(2);
                if (userName.equals(organisationName) && password.equals(organisationPassword)) {
                    System.out.println("Welcome Organisation: " + userName);
                    return true;
                }
            }
            return false;

        } catch (SQLException e) {
            throw new CustomException("Error while logging in organisation");
        }
    }

    public User addUser(User user) throws CustomException {
        try (Connection con= DBUtils.getInstance().getConnection()){
            Statement st = con.createStatement();
            st.execute("INSERT INTO user(username,password,firstname,lastname,bloodgroup) VALUES('" + user.getUserName() + "','" + user.getPassword() + "','" + user.getFirstname() + "','" + user.getLastname() + "','" + user.getBloodGroup() + "')");
            System.out.println("SignUp successfull");
            return user;
        } catch (SQLException e) {
            throw new CustomException("Error while adding user");
        }
    }

    public Organisation addOrganization(Organisation organisation) throws CustomException {
        try {
            Connection con= DBUtils.getInstance().getConnection();
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            Statement st = con.createStatement();
            st.execute("INSERT INTO organisation(organisation_id,organisation_name,location,password,slots_available) " +
                    "VALUES('"+ uuidAsString +"','"+ organisation.getorganisationName()+"','"+ organisation.getLocation()+"','"+ organisation.getPassword()+"','"+ organisation.getSlots_available()+"')");
            st.execute("Insert into user(username,password,firstname,userId,userType) values ('"+organisation.getEmail()+"','"+organisation.getPassword()+"','"+organisation.getorganisationName()+"','"+uuidAsString+"','"+UserType.ORGANIZATION+"')");
            System.out.println("SignUp successful");
            return organisation;
        } catch (SQLException e) {
            throw new CustomException("something went wrong while adding organisation");
        }
    }

    public User forgetPass(String username) throws SQLException {
        Connection con= DBUtils.getInstance().getConnection();
        String sql = FORGETPASSWORD_USERTABLE;
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setString(1, username);
        ResultSet rs = stmt.executeQuery();
        String uname = null;
        String pass = null;
        String fname = null;
        String lname = null;
        String bgroup = null;
        while (rs.next()) {
            uname = rs.getString(2);
            pass = rs.getString(3);
            fname = rs.getString(4);
            lname = rs.getString(5);
            bgroup = rs.getString(6);
        }
        User user = new User();
        user.setFirstname(fname);
        user.setUserName(uname);
        user.setPassword(pass);
        user.setLastname(lname);
        user.setBloodGroup(bgroup);
        return user;
    }

    public int updatePass(String username, String pwd, String OTP) throws Exception {
        loginController = new LoginController();
        Connection con= DBUtils.getInstance().getConnection();
        String sql = UPDATETABLE_USERTABLE;
        PreparedStatement stmt = con.prepareStatement(sql);
        String hashpw = BCrypt.hashpw(pwd, BCrypt.gensalt());
        stmt.setString(1, hashpw);
        stmt.setString(2, username);
        int count = stmt.executeUpdate();
        System.out.println("Password Updated Successfully");
        return count;

    }

    public void addPerson(String contactNo, User user, String pinCode) {
        try (Connection con= DBUtils.getInstance().getConnection()){
            UUID uuid = UUID.randomUUID();
            String uuidAsString = uuid.toString();
            Statement st = con.createStatement();
            st.execute("INSERT INTO Person(person_id,person_first_name,person_last_name,contact_number,blood_group) VALUES('" + uuidAsString + "','" + user.getFirstname() + "','" + user.getLastname() + "','" + contactNo + "','" + user.getBloodGroup() + "')");
            st.execute("Insert into user (userId,username,password,firstname,lastname,bloodgroup,userType) values('" + uuidAsString + "','" + user.getUserName() + "','" + user.getPassword() + "','" + user.getFirstname() + "','" + user.getLastname() + "','" + user.getBloodGroup() + "','" + UserType.DONOR.toString() + "')");
            System.out.println("SignUp successfull");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
