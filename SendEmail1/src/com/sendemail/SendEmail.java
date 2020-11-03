package com.sendemail;

import java.util.Properties;
import java.io.FileOutputStream;

//com.lowagie...   old version
//com.itextpdf...  recent version
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

public class SendEmail {
   public static void main(String[] args) {
      // Recipient's email ID needs to be mentioned.
      String to = "xyz@gmail.com";//change accordingly

      // Sender's email ID needs to be mentioned
      String from = "abc@gmail.com";//change accordingly
      final String username = "abc@gmail.com";//change accordingly
      final String password = "******";//change accordingly

      // Assuming you are sending email through relay.jangosmtp.net
      String host = "smtp.gmail.com";

      Properties props = new Properties();
      props.put("mail.smtp.auth", "true");
      props.put("mail.smtp.starttls.enable", "true");
      props.put("mail.smtp.host", host);
      props.put("mail.smtp.port", "587");

      // Get the Session object.
      Session session = Session.getInstance(props,
      new javax.mail.Authenticator() {
         protected PasswordAuthentication getPasswordAuthentication() {
            return new PasswordAuthentication(username, password);
         }
      });
      Document document = new Document();
      String input = "path\\to\\image\\file"; // .gif and .jpg are ok too!
      String output = "file\\to\\save\\into";

      try {
    	  FileOutputStream fos = new FileOutputStream(output);
          PdfWriter writer = PdfWriter.getInstance(document, fos);
          writer.open();
          document.open();
          document.add(Image.getInstance(input));
          document.close();
          writer.close();
          
    	  // Create a default MimeMessage object.
          Message message = new MimeMessage(session);

          // Set From: header field of the header.
          message.setFrom(new InternetAddress(from));

          // Set To: header field of the header.
          message.setRecipients(Message.RecipientType.TO,
             InternetAddress.parse(to));

          // Set Subject: header field
          message.setSubject("Image->PDF->gmail");

          // Create the message part
          BodyPart messageBodyPart = new MimeBodyPart();

          // Now set the actual message
          messageBodyPart.setText("sent pdf of image captured via java");

          // Create a multipart message
          Multipart multipart = new MimeMultipart();

          // Set text message part
          multipart.addBodyPart(messageBodyPart);

          // Part two is attachment
          messageBodyPart = new MimeBodyPart();
          String filename = "file\\to\\save\\into";
          DataSource source = new FileDataSource(filename);
          messageBodyPart.setDataHandler(new DataHandler(source));
          messageBodyPart.setFileName(filename);
          multipart.addBodyPart(messageBodyPart);

          // Send the complete message parts
          message.setContent(multipart);

          // Send message
          Transport.send(message);

          System.out.println("Sent message successfully....");

      } catch (MessagingException e) {
            throw new RuntimeException(e);
            
      }
      catch (Exception e) {
          e.printStackTrace();
        }
   }
}