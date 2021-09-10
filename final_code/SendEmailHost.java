package vms;

import com.itextpdf.text.BadElementException;
import java.util.Properties;
import java.io.FileOutputStream;

//com.lowagie...   old version
//com.itextpdf...  recent version
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Image;
import java.io.FileNotFoundException;
import java.io.IOException;

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

import vms.viewpage;
public class SendEmailHost {
    
    public static void SendEmailHost() throws FileNotFoundException, DocumentException, BadElementException, IOException{
        
        // Recipient's email ID needs to be mentioned.
        //String to = "bhupeshsardana01@gmail.com";//change accordingly
        String to = viewpage.host_email;

        // Sender's email ID needs to be mentioned
        //String from = "iit2019156@iiita.ac.in";//change accordingly
        //String to_2 = viewpage.host_email;
        String from = "****";
        
        //<editor-fold defaultstate="collapsed" desc="username">
            final String username = "****";
        //</editor-fold>
        
        //<editor-fold defaultstate="collapsed" desc="password">
            final String password = "****";
        //</editor-fold>
        
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
        String input = "C:\\Users\\91905\\Documents\\NetBeansProjects\\visitor_management_system\\visitor_pass.jpg"; // .gif and .jpg are ok too!
        String output = "C:\\Users\\91905\\Documents\\NetBeansProjects\\visitor_management_system\\visitor_pass.pdf";

        try {
            FileOutputStream fos = new FileOutputStream(output);
            PdfWriter writer = PdfWriter.getInstance(document, fos);
            writer.open();
            document.open();
            Image img = Image.getInstance(input);
            img.scaleToFit((float)550.0, (float)400.0);
            document.add(img);
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
            message.setSubject("Visitor ID Pass");

            // Create the message part
            BodyPart messageBodyPart = new MimeBodyPart();

            // Now set the actual message
            messageBodyPart.setText("Here is your visitor ID pass.");

            // Create a multipart message
            Multipart multipart = new MimeMultipart();

            // Set text message part
            multipart.addBodyPart(messageBodyPart);

            // Part two is attachment
            messageBodyPart = new MimeBodyPart();
            String filename = "visitor_pass.pdf";
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
    }
    
    public static void init() throws DocumentException, BadElementException, IOException{
        SendEmailHost obj = new SendEmailHost();
        obj.SendEmailHost();
    }
    public static void main(String[] args) throws DocumentException, BadElementException, IOException {
        init();
    }
}
