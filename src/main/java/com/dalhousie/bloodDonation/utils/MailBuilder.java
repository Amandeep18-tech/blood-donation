package com.dalhousie.bloodDonation.utils;

import com.dalhousie.bloodDonation.exception.CustomException;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

class MailUtils {
    private String username;
    private String password;
    private Session session;
    private static Properties prop = new Properties();
    static {

        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "465");
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.socketFactory.port", "465");
        prop.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    }

    MailUtils() {
        this.username = "janhavisonawane33@gmail.com";
        this.password = "onsgratwlvpddlim";
        this.session = Session.getInstance(prop,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(username, password);
                    }
                });
    }

    public boolean sendMail(String recipient, String subject, String content) throws CustomException {
        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(username));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(recipient)
            );
            message.setSubject(subject);
            message.setContent(content , "text/html" );
            Transport.send(message);
            System.out.println("Mail Sent!");
            return true;

        } catch (MessagingException e) {
            e.printStackTrace();
            throw new CustomException("Error in sending Verification mail");
        }

    }
}

public class MailBuilder {

    private MailUtils mailUtils;
    private String recipient;
    private String subject;
    private String content;

    private MailBuilder() {
        this.mailUtils = new MailUtils();
    }
    public static MailBuilder getMailInstance() {
        return new MailBuilder();
    }

    public  MailBuilder recipient(String recipient) {
        this.recipient = recipient;
        return this;
    }
    public MailBuilder subject(String subject) {
        this.subject = subject;
        return this;
    }
    public MailBuilder content(String content) {
        this.content = content;
        return this;
    }

    public void send() throws CustomException {
        this.mailUtils.sendMail(recipient, subject, content);
    }

}
