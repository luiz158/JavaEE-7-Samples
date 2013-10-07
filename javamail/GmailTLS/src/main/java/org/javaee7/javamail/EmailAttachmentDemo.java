package org.javaee7.javamail;

import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Date;
import java.util.Properties;

public class EmailAttachmentDemo {

    public static void main(String[] args) {
        EmailAttachmentDemo demo = new EmailAttachmentDemo();
        demo.sendEmail();
    }

    public void sendEmail() {
        String subject = "Important Message";
        String bodyText = "<b>This is a important message with attachment</b>";
        String filename = "src/main/resources/data.txt";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        
          Session session = Session.getInstance(props,
                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                        return new PasswordAuthentication(Constants.USER_NAME, Constants.PASSWORD);
                    }
                });
        
//        Properties properties = new Properties();
//        properties.put("mail.smtp.host", "smtp.example.com");
//        properties.put("mail.smtp.port", "25");
//        Session session = Session.getDefaultInstance(props, null);
        try {
            MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(Constants.MAIL_FROM));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(Constants.MAIL_TO));
            message.setSubject(subject);
            message.setSentDate(new Date());
            //
            // Set the email message text.
            //
            MimeBodyPart messagePart = new MimeBodyPart();
            messagePart.setContent(bodyText, "text/html; charset=utf-8");// For HTML mail
//            messagePart.setText(bodyText);
            //
            // Set the email attachment file
            //
            MimeBodyPart attachmentPart = new MimeBodyPart();
            FileDataSource fileDataSource = new FileDataSource(filename) {
                @Override
                public String getContentType() {
                    return "application/octet-stream";
                }
            };
            attachmentPart.setDataHandler(new DataHandler(fileDataSource));
            attachmentPart.setFileName(fileDataSource.getName());
            Multipart multipart = new MimeMultipart();
            multipart.addBodyPart(messagePart);
            multipart.addBodyPart(attachmentPart);
            message.setContent(multipart);
            Transport.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
