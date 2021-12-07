package com.dalhousie.bloodDonation.service;

import com.dalhousie.bloodDonation.model.Notification;
import com.dalhousie.bloodDonation.model.User;
import com.dalhousie.bloodDonation.repos.NotificationRepository;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.sql.SQLException;
import java.util.Properties;

public class NotificationServiceImpl implements NotificationService{
   NotificationRepository notificationRepository = new NotificationRepository();
   User user;
    @Override
    public boolean sendMailToSingleUser(String userName, String priority, String message_keyword) throws SQLException, ClassNotFoundException {
        final String sender = "janhavisonawane33@gmail.com";
        final String password = "onsgratwlvpddlim";
        Notification notification = new Notification();
              notification= notificationRepository.fetchData(priority);
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sender, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(notification.getSendTo())
            );
            message.setSubject("Testing Gmail SSL");
            message.setText("Hello " + notification.getUserName() + notification.getMessage()

                    );

            Transport.send(message);

            System.out.println("Done");
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean sendMailToMultipleUser() {
        final String sender = "janhavisonawane33@gmail.com";
        final String password = "onsgratwlvpddlim";
        //Notification notification = new Notification();
       // notification= notificationRepository.fetchData(priority);
        Properties prop = new Properties();
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");

        Session session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(sender, password);
                    }
                });

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sender));
            message.setHeader("X-Priority", "1");
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse("janhavisonawane33@gmail.com,vivek.r.patel1998@gmail.com,karthikkannan.nc@gmail.com,amansingh78622@gmail.com")
            );
//            message.addRecipients(Message.RecipientType.CC,
//                    InternetAddress.parse("vivek.r.patel1998@gmail.com,karthikkannan.nc@gmail.com,amansingh78622@gmail.com"));

            message.setSubject("Testing Gmail SSL");
            message.setText("Hello Database ki assignment karni hai"
            );

            Transport.send(message);

            System.out.println("Done");
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
        }
        return true;
    }
}
