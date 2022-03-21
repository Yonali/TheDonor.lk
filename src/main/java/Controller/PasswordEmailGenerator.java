package Controller;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.RandomStringUtils;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class PasswordEmailGenerator {

    public PasswordEmailGenerator() {}

    public String generatePassword() {
        String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        String pass = RandomStringUtils.random( 8, characters);
        String hash_pwd = DigestUtils.sha256Hex(pass);

        return pass;
    }

    public String generateOTP() {
        String characters = "0123456789";
        String pass = RandomStringUtils.random( 4, characters);
        String hash_pwd = DigestUtils.sha256Hex(pass);

        return pass;
    }

    public void sendMail(String email, String subject, String msg) {

        final String username = "2019cs043@stu.ucsc.cmb.ac.lk";
        final String password = "xrgnikgsbycxaqrv";

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
            message.setFrom(new InternetAddress("2019cs043@stu.ucsc.cmb.ac.lk"));
            message.setRecipients(
                    Message.RecipientType.TO,
                    InternetAddress.parse(email)
            );
            message.setSubject(subject);
            message.setText(msg);
            //"Dear Mail Crawler,"
            //+ "\n\n Please do not spam my email!"

            Transport.send(message);
            System.out.println("Mail Sent Successfully");

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}