package com.dalhousie.bloodDonation.service.common;

import com.dalhousie.bloodDonation.constants.BloodDonationConstants;
import com.dalhousie.bloodDonation.exception.CustomException;
import com.dalhousie.bloodDonation.model.common.Cache;
import com.dalhousie.bloodDonation.model.common.OTPDetails;
import com.dalhousie.bloodDonation.model.common.SessionManagement;
import com.dalhousie.bloodDonation.model.common.User;
import com.dalhousie.bloodDonation.model.organisation.Organisation;
import com.dalhousie.bloodDonation.repos.common.LoginRepository;
import com.dalhousie.bloodDonation.utils.IOUtils;
import com.dalhousie.bloodDonation.utils.MailBuilder;
import net.bytebuddy.utility.RandomString;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.time.Instant;
import java.util.Scanner;

public class LoginServiceImpl implements LoginService {

    private Object NullPointerException;
    private LoginRepository loginRepository;
    public JavaMailSender mailSender;

    private final Scanner sc;

    public LoginServiceImpl() {
        loginRepository = new LoginRepository();
        mailSender = new JavaMailSenderImpl();
        sc = IOUtils.getInstance();
    }

    @Override
    public void userLogin(String userName, String password) throws CustomException {
        try {
            if (userName.isEmpty() || password.isEmpty()) {
                throw new NullPointerException();
            }
            if (!userName.isEmpty() && !password.isEmpty()) {
              boolean check =  loginRepository.checkExistingUser(userName, password);
                if(check){
                    System.out.println("login success");
                }
            }


        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException("Error caugh while loggingin");
        }
    }

    @Override
    public void addPerson(String contactNo, User user, String pinCode) {
        loginRepository.addPerson(contactNo, user, pinCode);
    }

    @Override
    public void organizationLogin(String userName, String password) throws Exception {
        try {
            if (userName.isEmpty() || password.isEmpty()) {
                throw new NullPointerException();
            }
            if (!userName.isEmpty() && !password.isEmpty()) {
                boolean check = loginRepository.checkExistingOrgansation(userName, password);
                if(check){
                    System.out.println("login success");
                }
            }
        } catch (Exception e) {
            throw new CustomException("Error caugh while loggingin");
        }
    }

    @Override
    public void patientLogin(String userName, String password) throws CustomException {
        try {
            if (userName.isEmpty() || password.isEmpty()) {
                throw new NullPointerException();
            }
            if (!userName.isEmpty() && !password.isEmpty()) {
                loginRepository.checkExistingPatient(userName, password);
            }
        } catch (Exception e) {
            throw new CustomException("Error caugh while patient is loggingin");
        }
    }


    @Override
    public void userSignup(User user) throws Exception {
        loginRepository.addUser(user);
    }

    @Override
    public void organizationSignup(Organisation organisation) throws Exception {
        loginRepository.addOrganization(organisation);
    }

    @Override
    public void forgetPass(String username) throws Exception {
        User user = loginRepository.forgetPass(username);
        System.out.println("" + user.getFirstname());
        generateAndSendOtp(user);
    }

    public void generateAndSendOtp(User user) throws  CustomException {
        String OTP = RandomString.make(8);
        long issueTime = Instant.now().getEpochSecond();
        OTPDetails otpDetails = new OTPDetails(OTP, issueTime);
        Cache.getOtpMap().put(user.getUserName(), otpDetails);

        boolean check = sendVerificationEmail(user, OTP);
        while (check) {
            System.out.println("Enter your OTP:-");
            String otpInput = sc.next();
            if (!OTP.equals(otpInput)) {
                System.out.println("Invalid OTP!");
                continue;
            }
            if (validateOTP(user.getUserName(), otpInput)) {
                System.out.println("OTP Validated");
                while (true) {
                    try {
                        System.out.println("Enter New Password");
                        String newpass = sc.next();
                        System.out.println("Re-enter new password");
                        String confirmpass = sc.next();
                        if (newpass.equals(confirmpass)) {
                            System.out.println("Both password matches");
                            int count = loginRepository.updatePass(user.getUserName(), confirmpass, OTP);
                            if (count > 0) {
                                System.out.println("Password Updated Successfully");
//                                    new LoginController().menu();
                            } else {
                                System.out.println("Error while updating password");
                            }
                            break;
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        throw new CustomException("Something wrong with password");
                    }
                }
            } else {
                System.out.println("OTP Expired!");
                System.out.println("Do you want to continue:");
                System.out.println("Enter 1 to resend otp or any key to exit");
                int userInput = sc.nextInt();
                sc.nextLine();
                if (userInput == 1)
                    generateAndSendOtp(user);
                break;
            }
        }
    }


    @Override
    public boolean validateOTP(String username, String otp) {
        OTPDetails otpDetails = Cache.getOtpMap().get(username);
        if (otpDetails == null) {
            System.out.println("User Invalid!");
            return false;
        }
        long currTime = Instant.now().getEpochSecond();
        if ((currTime - otpDetails.getIssueTime()) < BloodDonationConstants.OTPTIMEOUT) {
            return true;
        }
        return false;

    }

    @Override
    public boolean sendVerificationEmail(User user, String OTP) throws CustomException{
        try {
            MailBuilder.getMailInstance()
                        .recipient(user.getUserName())
                        .subject("Blood donation notification")
                        .content("<strong>"+OTP+"</strong>")
                        .send();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("Error in sending Verification mail");
        }

    }


    @Override
    public void userLogout() {
            SessionManagement session = new SessionManagement();
            session.getSessionMap().clear();
    }

}
