package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.constants.BloodDonationConstants;
import com.dalhousie.bloodDonation.model.Cache;
import com.dalhousie.bloodDonation.model.OTPDetails;
import com.dalhousie.bloodDonation.model.User;
import com.dalhousie.bloodDonation.repos.LoginRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;


import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

public class LoginServiceImpl implements LoginService{

    private Object NullPointerException;
    private LoginRepository loginRepository;
    public JavaMailSender mailSender;
    Scanner sc = new Scanner(System.in);

    public LoginServiceImpl(){
        loginRepository = new LoginRepository();
        mailSender = new JavaMailSenderImpl();

    }

    @Override
    public void userLogin(String userName,String password) throws Exception {
    if(userName.isEmpty() || password.isEmpty()){
        throw new NullPointerException();
    }
    if(!userName.isEmpty() && !password.isEmpty()){
        loginRepository.checkExistingUser(userName,password);
    }

    }

    @Override
    public void userSignup(User user) throws Exception {
           loginRepository.addUser(user);

    }

    @Override
    public void forgetPass(String username) throws Exception {
        User user = loginRepository.forgetPass(username);
        System.out.println("" + user.getFirstname());
        generateAndSendOtp(user);
        }

        public void generateAndSendOtp(User user) throws MessagingException, UnsupportedEncodingException {
            String OTP = RandomString.make(8);
            long issueTime = Instant.now().getEpochSecond();
            OTPDetails otpDetails = new OTPDetails(OTP,issueTime);
            Cache.getOtpMap().put(user.getUserName(),otpDetails);

            boolean check = sendVerificationEmail(user,OTP);
            while(check){
                System.out.println("Enter your OTP:-");
                String otpInput = sc.next();
                if(!OTP.equals(otpInput)) {
                    System.out.println("Invalid OTP!");
                    continue;
                }
                if(validateOTP(user.getUserName(), otpInput)) {
                    System.out.println("OTP Validated");
                    while(true) {
                        try {
                            System.out.println("Enter New Password");
                            String newpass = sc.next();
                            System.out.println("Re-enter new password");
                            String confirmpass = sc.next();
                            if(newpass.equals(confirmpass)){
                                System.out.println("Both password matches");
                                loginRepository.updatePass(user.getUserName(),confirmpass,OTP);
                                break;
                            }
                        } catch(Exception e) {
                            e.printStackTrace();
                        }

                    }
                    break;

                }
                else{
                    System.out.println("OTP Expired!");
                    System.out.println("Do you want to continue:");
                    System.out.println("Enter 1 to resend otp or any key to exit");
                    int userInput = sc.nextInt();
                    if(userInput == 1)
                    generateAndSendOtp(user);

                    break;

                    //Exit;
                }
            }
        }

        private boolean validateOTP(String username, String otp) {
          OTPDetails otpDetails = Cache.getOtpMap().get(username);
          if(otpDetails == null) {
              System.out.println("User Invalid!");
              return false;
          }
             long currTime =  Instant.now().getEpochSecond();
             if((currTime - otpDetails.getIssueTime()) < BloodDonationConstants.OTPTIMEOUT) {
                 return true;
             }
          return false;

        }



    @Override
    public boolean sendVerificationEmail(User user, String OTP)
            throws MessagingException, UnsupportedEncodingException {
        final String username = "janhavisonawane33@gmail.com";
        final String password = "onsgratwlvpddlim";

        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(user.getUserName())
            );
            message.setSubject("Testing Gmail SSL");
            message.setContent("Hello " + user.getFirstname() +",<br>"+
                    " to reset your password, you're required to use the following "
                    + "One Time Password to login: "
                    + "<strong>"+OTP+"</strong>" , "text/html" );
//            message.setText();

            Transport.send(message);

            System.out.println("Done");
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }

}
