package com.dalhousie.bloodDonation.repos;

import com.dalhousie.bloodDonation.controller.RewardsController;
import net.bytebuddy.utility.RandomString;
import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class RewardsRepository {
    Scanner sc = new Scanner(System.in);
//    RewardsController rewardsController = new RewardsController();
    public void rewards(int donorId){
       try{
           Class.forName("com.mysql.cj.jdbc.Driver");
           Connection con= DriverManager.getConnection(
                   "jdbc:mysql://localhost:3306/blooddonationdb","root","123456789");
           String sql = "select * from rewards where donor_id=?";
           PreparedStatement stmt = con.prepareStatement(sql);
           stmt.setInt(1, donorId);
           ResultSet rs = stmt.executeQuery();
           int rewardPoints = 0;
           Date expiryDate = null;
           Date couponGeneratedDate = null;
           String couponcode = null;
           String status = null;
           while (rs.next()){
               rewardPoints = rs.getInt(3);
               expiryDate = rs.getDate(4);
               couponGeneratedDate = rs.getDate(5);
               couponcode = rs.getString(6);
               status = rs.getString(7);
           }
           System.out.println(rewardPoints);
           int data=50;
           if(rewardPoints == 0){
               String sql1 = "update rewards set reward_points=? where donor_id=?";
               stmt = con.prepareStatement(sql1);
               stmt.setInt(1,data);
               stmt.setInt(2, donorId);
               stmt.executeUpdate();
           }

           else{
               String sql12 = "update rewards set reward_points=? where donor_id=?";
               stmt = con.prepareStatement(sql12);
               stmt.setInt(1,rewardPoints=rewardPoints+50);
               stmt.setInt(2, donorId);
               stmt.executeUpdate();
           }

           if(rewardPoints == 500){
               String couponCode = RandomString.make(20);
               System.out.println(couponCode);
               LocalDate today = LocalDate.now();
               String updateCoupon = "update rewards set coupon_code=?,coupon_generated_date=?,expiry_date_point=? where donor_id=?";
               stmt = con.prepareStatement(updateCoupon);
               stmt.setString(1,couponCode);
               stmt.setDate(2, Date.valueOf(today));
               stmt.setDate(3, Date.valueOf(today.plusDays(10)));
               stmt.setInt(4,donorId);
               stmt.executeUpdate();
           }

       }catch (Exception e){
           System.out.println("Something went wrong!");
       }
    }
    public void displayCoupon(int donorId) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con= DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/blooddonationdb","root","123456789");
        String sql = "select coupon_code from rewards where donor_id=?";
        PreparedStatement stmt = con.prepareStatement(sql);
        stmt.setInt(1, donorId);
        ResultSet rs = stmt.executeQuery();
        String couponcode = null;
        while(rs.next()){
            couponcode = rs.getString(1);
        }
        System.out.println("*************************************");
        System.out.print("|");
        System.out.println("Your coupon code is:- " + couponcode + "|" );
        System.out.println("*************************************");
        System.out.println("Do you want to redeem/use this coupon?");
        System.out.println("Press 1 to continue and 0 to return to main menue:");
        int choice = sc.nextInt();
        if(choice == 1){
            //redeemCoupon(donorId);
            System.out.println("hhj");
        }
//        else{
//            rewardsController.menu();
//        }
    }
//    public void redeemCoupon(int donorId) throws Exception {
//
//        Class.forName("com.mysql.cj.jdbc.Driver");
//        Connection con= DriverManager.getConnection(
//                "jdbc:mysql://localhost:3306/blooddonationdb","root","123456789");
//        //String query = "update rewards set status = active where donorId = ?";
//        String query = "selct * from rewards where donorId=?";
//        PreparedStatement stmt = con.prepareStatement(query);
//        stmt.setInt(1,donorId);
//        stmt.executeUpdate();
//        System.out.println("Your coupon is successfully redeemed!!!");
//        rewardsController.menu();
//    }
}
