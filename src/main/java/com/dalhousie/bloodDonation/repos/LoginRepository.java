package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.controller.LoginController;
import com.dalhousie.bloodDonation.model.User;
import com.dalhousie.bloodDonation.utils.DBUtils;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.Scanner;

public class LoginRepository {
    User user;
    String username;
    String pass;
    int flag=0;
    LoginController loginController;
    Scanner sc = new Scanner(System.in);
    public void checkExistingUser(String userName,String password){
        try {
            String resetpass;
            DBUtils dbUtils = new DBUtils();
            Connection con = dbUtils.getConnection();
            //Class.forName("com.mysql.cj.jdbc.Driver");
//            Connection con=DriverManager.getConnection(
//                    "jdbc:mysql://localhost:3306/blooddonationdb","root","123456789");
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from user");
            while(rs.next()){
                username = rs.getString(1);
                pass = rs.getString(2);
                if(userName.equals(username) && BCrypt.checkpw(password, pass)  ){
                    //  password.equals(pass)
                    System.out.println("Welcome: "+userName);
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
}
