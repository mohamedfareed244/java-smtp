package javaapplication9;

import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {
   
   
   public static void sendMail(String sender, String pass, String recepient, String subject, String text) throws Exception {
       try{
       System.out.println("Preparing to send email");
       Properties properties = new Properties();

       // Enable authentication
       properties.put("mail.smtp.auth", "true");
       // Set TLS encryption enabled
       properties.put("mail.smtp.starttls.enable", "true");
       // Set SMTP host
       properties.put("mail.smtp.host", "smtp.gmail.com");
       // Set smtp port
       properties.put("mail.smtp.port", "587");
       properties.put("mail.smtp.ssl.trust", "*");
       properties.put("mail.smtp.ssl.protocols", "TLSv1.2");

       // Your gmail address
       String myAccountEmail = sender;
       // Your gmail password
       String password = pass;

       // Create a session with account credentials
       Session session = Session.getInstance(properties, new Authenticator() {
           @Override
           protected PasswordAuthentication getPasswordAuthentication() {
               return new PasswordAuthentication(myAccountEmail, password);
           }
       });

       // Prepare email message
       Message message = prepareMessage(session, myAccountEmail, recepient, subject, text);

       // Send mail
       Transport.send(message);
       System.out.println("Message sent successfully");
       }catch (Exception e){
           System.out.println("there are an error with the type  : "+e.getMessage());
           System.out.println("please check your inputs ");
       }  
   }
   

   private static Message prepareMessage(Session session, String myAccountEmail, String recepient, String subject, String text) {
       try {
           Message message = new MimeMessage(session);
           message.setFrom(new InternetAddress(myAccountEmail));
           message.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
           message.setSubject(subject);
           message.setContent(text, "text/html");
           return message;
       } catch (Exception ex) {
           System.out.println("Error in preparing the message");
       }
       return null;
   }
}
