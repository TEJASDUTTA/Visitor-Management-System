//package vms;
//
//import com.github.sarxos.webcam.Webcam;
//import javax.swing.*;
//import java.awt.*;
////import java.util.*;
//import java.awt.event.*;
//import java.awt.image.BufferedImage;
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.FileWriter;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.Map;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import javax.imageio.ImageIO;
//import javax.swing.border.Border;
//
//// Import class fles
////import vms.code;
//import vms.lol;
//
//public class update_details{
//	static JFrame details_frame = new JFrame("FILL DETAILS");
//        static JFrame prev_img;
//	static JLabel lblCamera, lblVisitor, lblName, lblEmail, lblId, lblContact, lblTime, lblHostName, lblHostEmail, lblHost, lblIdType, lblVenue, lblStayingPlace, lblDays; 
//	static JTextField txtName, txtEmail, txtId, txtContact, txtHostName, txtHostEmail, txtDays;
//	static JComboBox txtIdType, txtStayingPlace;
//	static JButton btnSubmit, btnCancel, btnCamera, btnPrev_img, btnConfirm_img;
//	static Color background = new Color(50, 50, 50);
//	static Color foreground = new Color(65, 105, 225);
//	static Color purple = new Color(115, 25, 150);
//	static JPanel mainpanel = new JPanel(new GridLayout(1,2,10,20));
//	static JPanel panel = new JPanel(new GridLayout(15,2,10,10));
//	static JPanel panel1 = new JPanel(new GridLayout(10,1));
//	static JPanel panel2 = new JPanel(new GridLayout(1,2,0,0));
//	static JTextArea txtArea;
//	static Border redline = BorderFactory.createLineBorder(Color.RED);
//        
//        // Storing details
//        static String name, email, id, contact, host_name, host_email, days, id_type, staying_place;
//        static Map <String, ArrayList<String>> hmUser_data = new <String, ArrayList<String>> HashMap();
//        static ArrayList <String> listUser_data = new ArrayList<String> ();
//        
//        static String key_contact = lol.contact;
//        
//	static void user_details()
//	{
//		//**************************************************************************************************************
//		// USER DETAILS
//			lblVisitor = new JLabel("UPDATE VISITOR DETAILS", JLabel.CENTER);
//			lblVisitor.setFont(new Font("Courier New", Font.BOLD, 16));
//			lblName = new JLabel("Name: ", JLabel.TRAILING);
//			lblEmail = new JLabel("Email: ", JLabel.TRAILING);
//			lblIdType = new JLabel("ID Type:", JLabel.TRAILING);
//			lblId = new JLabel("ID: ", JLabel.TRAILING);
//			lblContact = new JLabel("Contact no.: ", JLabel.TRAILING);
//			lblTime = new JLabel("Choose hours of stay: ", JLabel.TRAILING);		
//                        
//                        
//                        
//                        
//			txtName = new JTextField(60);
//			txtEmail = new JTextField(60);
//			txtId = new JTextField(60);
//			txtContact = new JTextField(60);
//
//			txtName.setInputVerifier(new PassVerifier());
//			txtEmail.setInputVerifier(new PassVerifier());
//			txtContact.setInputVerifier(new PassVerifier());
//
//			String txtIdTypeOptions[] = {"Aadhar card", "PAN card", "Passport"};
//			txtIdType = new JComboBox(txtIdTypeOptions);
//			txtIdType.setSelectedIndex(0);
//                        
//                        // Setting up details in fields
//                        txtName.setText(name);
//                        txtEmail.setText(email);
//                        txtId.setText(id);
//                        txtContact.setText(contact);
//                        txtIdType.setSelectedItem(id_type);
//                        
//			panel.add(lblVisitor);		panel.add(new JLabel("	"));
//			panel.add(lblName);			panel.add(txtName);
//			panel.add(lblEmail);		panel.add(txtEmail);
//			panel.add(lblIdType);		panel.add(txtIdType);	
//			panel.add(lblId);			panel.add(txtId);
//			panel.add(lblContact);		panel.add(txtContact);
//		//**************************************************************************************************************
//	}
//	static void host_details()
//	{
//		//**************************************************************************************************************
//		// HOST DETAILS
//			lblHost = new JLabel("HOST DETAILS", JLabel.CENTER);
//			lblHost.setFont(new Font("Arial", Font.BOLD, 16));
//			lblHostName = new JLabel("Host Name: ", JLabel.TRAILING);
//			lblHostEmail = new JLabel("Host Email: ", JLabel.TRAILING);
//                        
//			txtHostName = new JTextField(60);
//			txtHostEmail = new JTextField(60);
//                        
//                        // Setting up details in fields
//                        txtHostName.setText(host_name);
//                        txtHostEmail.setText(host_email);
//
//			txtHostName.setInputVerifier(new PassVerifier());
//			txtHostEmail.setInputVerifier(new PassVerifier());
//			
//			panel.add(lblHost);				panel.add(new Label("	"));
//			panel.add(lblHostName);			panel.add(txtHostName);
//			panel.add(lblHostEmail);		panel.add(txtHostEmail);
//		//**************************************************************************************************************
//	}
//	static void venue_details()
//	{
//		//**************************************************************************************************************
//		// VENUE DETAILS
//			lblVenue = new JLabel("VENUE DETAILS", JLabel.CENTER);
//			lblVenue.setFont(new Font("", Font.BOLD, 16));
//			lblStayingPlace = new JLabel("Staying Place: ", JLabel.TRAILING);
//			lblDays = new JLabel("For How Many Days?", JLabel.TRAILING);
//
//			String txtAllPlaces[] = {"BH-1,2", "BH-3,4", "BH-5", "GH-1,2,3"};
//			txtStayingPlace = new JComboBox(txtAllPlaces);
//			txtStayingPlace.setSelectedIndex(2);
//			txtDays = new JTextField(60);
//                        
//                        // Setting up details in field
//                        txtDays.setText(days);
//                        txtStayingPlace.setSelectedItem(staying_place);
//
//			txtDays.setInputVerifier(new PassVerifier());
//
//			panel.add(lblVenue);				panel.add(new Label("	"));
//			panel.add(lblStayingPlace);			panel.add(txtStayingPlace);
//			panel.add(lblDays);					panel.add(txtDays);
//		//**************************************************************************************************************	
//	}
//	static void submit_and_cancel()
//	{
//		//**************************************************************************************************************	
//		// SUBMIT AND CANCEL BUTTON
//			btnCancel = new JButton("Cancel");
//			btnCancel.setBackground(new Color(0xf6, 0xef, 0xd0));
//
//			btnSubmit = new JButton("Submit");
//			btnSubmit.setBackground(purple);
//			btnSubmit.setForeground(Color.white);
//			
//			btnCancel.addActionListener(new CustomActionListener());
//			btnSubmit.addActionListener(new CustomActionListener());
//			//btnCancel.addActionListener(new CustomActionListener());
//			panel2.add(btnCancel);			panel2.add(btnSubmit);
//			panel.add(new JLabel(" "));		panel.add(panel2);
//			panel.setBackground(new Color(219,207,92));
//		//**************************************************************************************************************	
//	}
//	static void camera()
//	{
//		//**************************************************************************************************************	
//		// CAMERA
////			txtArea = new JTextArea();
////			panel1.setBackground(new Color(48,25,52));
////			lblCamera = new JLabel("CAMERA");
////			lblCamera.setForeground(new Color(219,207,92));
////			panel1.add(lblCamera);
//                        // Heading
//                        JLabel lblCam_heading = new JLabel("Update ID pass image");
//                        lblCam_heading.setFont(new Font("Courier New",Font.BOLD,26));
//                        lblCam_heading.setBackground(purple);
//                        lblCam_heading.setForeground(Color.black);
//                        
//                        // Take a picture
//                        btnCamera = new JButton("Take a picture");
//                        btnCamera.setBackground(new Color(0xf6, 0xef, 0xd0));
//                        btnCamera.addActionListener(new CustomActionListener());
//                        
//                        // Preview Image
//                        btnPrev_img = new JButton("Preview image");
//                        btnPrev_img.setBackground(new Color(0xf6, 0xef, 0xd0));
//                        btnPrev_img.addActionListener(new CustomActionListener());
//                        
//                        // Confirm Image
//                        btnConfirm_img = new JButton("Confirm image");
//                        btnConfirm_img.setBackground(new Color(0xf6, 0xef, 0xd0));
//                        btnConfirm_img.addActionListener(new CustomActionListener());
//                        
//                        JPanel empty_panel = new JPanel();
//                        
//                        empty_panel.add(lblCam_heading);
//                        //empty_panel.add(btnCamera);
//                        panel1.add(empty_panel);
//                        panel1.add(btnCamera);
//                        panel1.add(btnPrev_img);
//                        panel1.add(btnConfirm_img);
//		//**************************************************************************************************************	
//	}
//        // Getting details (file method)
////        static void get_details() throws FileNotFoundException, IOException{
////            BufferedReader reader;
////                reader = new BufferedReader(new FileReader("C:\\Users\\91905\\Documents\\NetBeansProjects\\visitor_management_system\\user_details.txt"));
////                name = reader.readLine();
////                email = reader.readLine();
////                id = reader.readLine();
////                contact = reader.readLine();
////                host_name = reader.readLine();
////                host_email = reader.readLine();
////                days = reader.readLine();
////                id_type = reader.readLine();
////                staying_place = reader.readLine();
////                
////                reader.close();
////                }
//        // Getting details (from hashmap)
//        static void get_details(){
//            //System.out.println(code.hmUser_data.get(key_contact));
//            name = lol.hmUser_data.get(key_contact).get(0); 
//            email = lol.hmUser_data.get(key_contact).get(1);
//            id = lol.hmUser_data.get(key_contact).get(2);
//            contact = lol.hmUser_data.get(key_contact).get(3);
//            host_name = lol.hmUser_data.get(key_contact).get(4);
//            host_email = lol.hmUser_data.get(key_contact).get(5);
//            days = lol.hmUser_data.get(key_contact).get(6);
//            id_type = lol.hmUser_data.get(key_contact).get(7);
//            staying_place = lol.hmUser_data.get(key_contact).get(8);
//        }
//        
////        static void set_up_user_image(){
////            File file = new File("C:\\Users\\91905\\Documents\\NetBeansProjects\\visitor_management_system\\user_image.jpg");
////            BufferedImage image = null;
////            try {
////                image = ImageIO.read(file);
////            } catch (IOException ex) {
////                Logger.getLogger(code.class.getName()).log(Level.SEVERE, null, ex);
////            }
////                //prev_img = new JFrame();
////                JLabel img_label = new JLabel(new ImageIcon(image));
////                img_label.setPreferredSize(new Dimension(640, 480));
////                //prev_img.getContentPane().add(img_label, BorderLayout.CENTER);
////                //prev_img.pack();
////                //prev_img.setVisible(true);
////                JPanel empty_panel1 = new JPanel();
////                panel1.add(empty_panel1);
////                panel1.add(img_label);
////        }
//
//	static class PassVerifier extends InputVerifier {
//		public boolean verify(JComponent input)
//		{
//			if(input.equals(txtName) || input.equals(txtHostName)) 
//			{
//				String text = ((JTextField) input).getText();
//				if (text.matches("[a-zA-Z ]+")) // Reads: "Any of a-z or A-Z or space one or more times (together, not each)" ---> blank field or field containing anything other than those will return false.
//				{
//					((JTextField) input).setBorder(BorderFactory.createLineBorder(Color.GRAY));
//					return true;
//				}
//				((JTextField) input).setBorder(BorderFactory.createTitledBorder(redline, "Uppercase and Lowercase letters only"));
//				return false;
//			}
//			else if(input.equals(txtEmail) || input.equals(txtHostEmail))
//			{
//				String text = ((JTextField) input).getText();
//				if (text.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
//				{
//					((JTextField) input).setBorder(BorderFactory.createLineBorder(Color.GRAY));
//					return true;
//				}
//				((JTextField) input).setBorder(BorderFactory.createTitledBorder(redline, "Is that an email-id?"));
//				return false;
//			}
//			else if(input.equals(txtContact))
//			{
//				String text = ((JTextField) input).getText();
//				if (text.matches("^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$"))
//				{
//					((JTextField) input).setBorder(BorderFactory.createLineBorder(Color.GRAY));
//					return true;
//				}
//				((JTextField) input).setBorder(BorderFactory.createTitledBorder(redline, "LOL. Can't contact this."));
//				return false;
//			}
//			else if(input.equals(txtDays))
//			{
//				String text = ((JTextField) input).getText();
//				if (text.matches("[0-9]+"))
//				{
//					((JTextField) input).setBorder(BorderFactory.createLineBorder(Color.GRAY));
//					return true;
//				}
//				((JTextField) input).setBorder(BorderFactory.createTitledBorder(redline, "Is that a NoneDay?"));
//				return false;
//			}
//			return true;
//		}
//	}
//	static class CustomActionListener implements ActionListener{
//		public void actionPerformed(ActionEvent e) {
//                        Object msg = e.getSource();
//                        if(msg.equals(btnSubmit)){
//                            name = txtName.getText(); 
//                            email = txtEmail.getText();
//                            id = txtId.getText();
//                            contact = txtContact.getText();
//                            host_name = txtHostName.getText();
//                            host_email = txtHostEmail.getText();
//                            days = txtDays.getText();
//                            id_type = txtIdType.getSelectedItem() + "";
//                            staying_place = txtStayingPlace.getSelectedItem() + "";
//                            
//                            // Store details in hashmap
//                            listUser_data.add(name);
//                            listUser_data.add(email);
//                            listUser_data.add(id);
//                            listUser_data.add(contact);
//                            listUser_data.add(host_name);
//                            listUser_data.add(host_email);
//                            listUser_data.add(days);
//                            listUser_data.add(id_type);
//                            listUser_data.add(staying_place);
//                            
//                            hmUser_data.put(contact, listUser_data);
////                            try {
////                                FileWriter w = new FileWriter("user_details.txt", true);
////                                
////                                w.write(name + "\n");
////                                w.write(email + "\n");
////                                w.write(id + "\n");
////                                w.write(contact + "\n");
////                                w.write(host_name + "\n");
////                                w.write(host_email + "\n");
////                                w.write(days + "\n");
////                                w.write(id_type + "\n");
////                                w.write(staying_place + "\n");
////                                w.close();
////                            } catch (IOException ex) {
////                                Logger.getLogger(code.class.getName()).log(Level.SEVERE, null, ex);
////                            }
//                            
//                            JOptionPane.showMessageDialog(null, "User information saved successfully");
//                           
//                        }
//                        else if(msg.equals(btnCancel)){
//                            
//                        }
//                        else if(msg.equals(btnCamera)){
//                            Webcam webcam = Webcam.getDefault();
//                            webcam.setViewSize(new Dimension(640, 480));
//                            webcam.open();
//                            try {
//                                ImageIO.write(webcam.getImage(), "JPG", new File("user_image.jpg"));
//                            } catch (IOException ex) {
//                                Logger.getLogger(code.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                            webcam.close();
//                        }
//                        else if(msg.equals(btnPrev_img)){
//                            File file = new File("C:\\Users\\91905\\Documents\\NetBeansProjects\\visitor_management_system\\user_image.jpg");
//                            BufferedImage image = null;
//                            try {
//                                image = ImageIO.read(file);
//                            } catch (IOException ex) {
//                                Logger.getLogger(code.class.getName()).log(Level.SEVERE, null, ex);
//                            }
//                            prev_img = new JFrame();
//                            JLabel img_label = new JLabel(new ImageIcon(image));
//                            prev_img.getContentPane().add(img_label, BorderLayout.CENTER);
//                            prev_img.pack();
//                            prev_img.setVisible(true);
//                        }
//                        else if(msg.equals(btnConfirm_img)){
//                            JOptionPane.showMessageDialog(null, "Image saved successfully");
//                            //set_up_user_image();
//                        }
//                    }
//			
//			/*JFrame f = new JFrame();
//			f.add(new Label("Hi Aviral"));
//			f.setSize(600,600);//400 width and 500 height  
//			f.getContentPane().setBackground(background);
//			f.getContentPane().setForeground(foreground);
//			f.setVisible(true);//making the frame visible
//			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			*/
//			//frame.setVisible(true);
//		}
//        
//        public static void init(){
//                update_details obj = new update_details();
//                obj.get_details();
//		obj.user_details();
//		obj.host_details();
//		obj.venue_details();
//		obj.submit_and_cancel();
//		obj.camera();
//                //obj.set_up_user_image();
//                
//		panel.setBorder(BorderFactory.createLineBorder(Color.black));
//		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
//		panel2.setBorder(BorderFactory.createLineBorder(Color.gray));
//
//		mainpanel.add(panel);
//		mainpanel.add(panel1);
//		details_frame.add(mainpanel);
//		details_frame.setSize(1920,1080);//400 width and 500 height  
//		details_frame.getContentPane().setBackground(background);
//		details_frame.getContentPane().setForeground(foreground);
//		details_frame.setVisible(true);//making the frame visible
//		details_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
//        }
//	public static void main(String []args)
//	{
//            init();
//            
//	}
//	
//}

package vms;


import com.github.sarxos.webcam.Webcam;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class update_details{
	static JFrame frame = new JFrame("UPDATE DETAILS");
        static JFrame prev_img;
	static JLabel lblFillDetails, lblCamera, lblVisitor, lblName, lblEmail, lblId, lblContact, lblTime, lblHostName, lblHostEmail, lblHost, lblIdType, lblVenue, lblStayingPlace, lblDays; 
	static JTextField txtName, txtEmail, txtId, txtContact, txtHostName, txtHostEmail, txtDays;
	static JComboBox txtIdType, txtStayingPlace;
	static JButton btnSubmit, btnCancel, btnCamera,btnPrev_img, btnConfirm_img;
	static Color background = new Color(50, 50, 50);
	static Color foreground = new Color(65, 105, 225);
	static Color purple = new Color(115, 25, 170);
	static JPanel mainpanel = new JPanel(new BorderLayout(10,10));
	static JPanel panel = new JPanel(new GridLayout(15,2,6,10));
	static JPanel panel2 = new JPanel(new GridLayout(1,2,10,10));
        static JPanel panel3 = new JPanel(new GridLayout(10,1));

	static JTextArea txtArea;
	static Border redline = BorderFactory.createLineBorder(Color.RED);
	static BufferedImage myPicture;        
        
        
        // Storing details
        static String name, email, id, contact, host_name, host_email, days, id_type, staying_place;
        static Map <String, ArrayList<String>> hmUser_data = new <String, ArrayList<String>> HashMap();
        static ArrayList <String> listUser_data = new ArrayList<String> ();
        static String key_contact = lol.contact;
        
        static JLabel lblCam_heading;
        
        static int flag = 0;
        
	static void user_details()
	{
		//**************************************************************************************************************
		// USER DETAILS
			lblName = new JLabel("Name: ", JLabel.TRAILING);
			lblEmail = new JLabel("Email: ", JLabel.TRAILING);
			lblIdType = new JLabel("ID Type:", JLabel.TRAILING);
			lblId = new JLabel("ID: ", JLabel.TRAILING);
			lblContact = new JLabel("Contact no.: ", JLabel.TRAILING);
			lblTime = new JLabel("Choose hours of stay: ", JLabel.TRAILING);		

			txtName = new JTextField(60);
			txtEmail = new JTextField(60);
			txtId = new JTextField(60);
			txtContact = new JTextField(60);

			String txtIdTypeOptions[] = {"Aadhar card", "PAN card"};
			txtIdType = new JComboBox(txtIdTypeOptions);
			txtIdType.setSelectedIndex(0);

			txtName.setInputVerifier(new PassVerifier());
			txtEmail.setInputVerifier(new PassVerifier());
			txtContact.setInputVerifier(new PassVerifier());
			txtId.setInputVerifier(new PassVerifier());
                        
                        // Setting up details in fields
                        txtName.setText(name);
                        txtEmail.setText(email);
                        txtId.setText(id);
                        txtContact.setText(contact);
                        txtIdType.setSelectedItem(id_type);
                        
			panel.add(new JLabel("<HTML><h2>UPDATE VISITOR</h2></HTML>", JLabel.TRAILING));		
			panel.add(new JLabel("<HTML><h2>DETAILS</h2></HTML>", JLabel.LEADING));
			panel.add(lblName);			panel.add(txtName);
			panel.add(lblEmail);		panel.add(txtEmail);
			panel.add(lblIdType);		panel.add(txtIdType);	
			panel.add(lblId);			panel.add(txtId);
			panel.add(lblContact);		panel.add(txtContact);
		//**************************************************************************************************************
	}
	static void host_details()
	{
		//**************************************************************************************************************
		// HOST DETAILS
			lblHostName = new JLabel("Host Name: ", JLabel.TRAILING);
			lblHostEmail = new JLabel("Host Email: ", JLabel.TRAILING);

			txtHostName = new JTextField(60);
			txtHostEmail = new JTextField(60);
                        
                        // Setting up details in fields
                        txtHostName.setText(host_name);
                        txtHostEmail.setText(host_email);
                        
			txtHostName.setInputVerifier(new PassVerifier());
			txtHostEmail.setInputVerifier(new PassVerifier());
			
			panel.add(new JLabel("<HTML><h2>UPDATE HOST</h2></HTML>", JLabel.TRAILING));		
			panel.add(new JLabel("<HTML><h2>DETAILS</h2></HTML>", JLabel.LEADING));
			panel.add(lblHostName);			panel.add(txtHostName);
			panel.add(lblHostEmail);		panel.add(txtHostEmail);
		//**************************************************************************************************************
	}
	static void venue_details()
	{
		//**************************************************************************************************************
		// VENUE DETAILS
			lblStayingPlace = new JLabel("Staying Place: ", JLabel.TRAILING);
			lblDays = new JLabel("For How Many Days?", JLabel.TRAILING);

			String txtAllPlaces[] = {"BH-1,2", "BH-3,4", "BH-5", "GH-1,2,3"};
			txtStayingPlace = new JComboBox(txtAllPlaces);
			txtStayingPlace.setSelectedIndex(2);
			txtDays = new JTextField(60);
                        
                        // Setting up details in field
                        txtDays.setText(days);
                        txtStayingPlace.setSelectedItem(staying_place);
                        
			txtDays.setInputVerifier(new PassVerifier());

			panel.add(new JLabel("<HTML><h2>UPDATE VENUE</h2></HTML>", JLabel.TRAILING));		
			panel.add(new JLabel("<HTML><h2>DETAILS</h2></HTML>", JLabel.LEADING));
			panel.add(lblStayingPlace);			panel.add(txtStayingPlace);
			panel.add(lblDays);					panel.add(txtDays);
		//**************************************************************************************************************	
	}
	static void submit_and_cancel()
	{
		//**************************************************************************************************************	
		// SUBMIT AND CANCEL BUTTON
			btnCancel = new JButton("<HTML><h3>Cancel</h3></HTML>");
			btnCancel.setBackground(new Color(209,26,42));

			btnSubmit = new JButton("<HTML><h3>Submit</h3></HTML>");
			btnSubmit.setBackground(purple);
			
			btnCancel.addActionListener(new CustomActionListener());
			btnSubmit.addActionListener(new CustomActionListener());
		//**************************************************************************************************************	
	}
        
        static void camera(){
                        lblCam_heading = new JLabel("Update your picture");
                        //lblCam_heading.setBorder(BorderFactory.createLineBorder(Color.black));
                        lblCam_heading.setFont(new Font("Courier New",Font.BOLD,26));
                        lblCam_heading.setBackground(new Color(65,65,65));
                        //lblCam_heading.setForeground(Color.black);                        
                        
                        // Preview Image
                        btnPrev_img = new JButton("Preview picture");
                        btnPrev_img.setBackground(new Color(0xf6, 0xef, 0xd0));
                        btnPrev_img.addActionListener(new CustomActionListener());
                        
                        // Take a picture
                        btnCamera = new JButton("Take a new picture");
                        btnCamera.setBackground(new Color(0xf6, 0xef, 0xd0));
                        btnCamera.addActionListener(new CustomActionListener());
                        
                        // Confirm Image
                        btnConfirm_img = new JButton("Confirm image");
                        btnConfirm_img.setBackground(new Color(0xf6, 0xef, 0xd0));
                        btnConfirm_img.addActionListener(new CustomActionListener());
                        
                        
        }
        
        // Getting details (file method)
////        static void get_details() throws FileNotFoundException, IOException{
////            BufferedReader reader;
////                reader = new BufferedReader(new FileReader("C:\\Users\\91905\\Documents\\NetBeansProjects\\visitor_management_system\\user_details.txt"));
////                name = reader.readLine();
////                email = reader.readLine();
////                id = reader.readLine();
////                contact = reader.readLine();
////                host_name = reader.readLine();
////                host_email = reader.readLine();
////                days = reader.readLine();
////                id_type = reader.readLine();
////                staying_place = reader.readLine();
////                
////                reader.close();
////                }
        // Getting details (from hashmap)
        static void get_details(){
            //System.out.println(code.hmUser_data.get(key_contact));
            name = lol.hmUser_data.get(key_contact).get(0); 
            email = lol.hmUser_data.get(key_contact).get(1);
            id = lol.hmUser_data.get(key_contact).get(2);
            contact = lol.hmUser_data.get(key_contact).get(3);
            host_name = lol.hmUser_data.get(key_contact).get(4);
            host_email = lol.hmUser_data.get(key_contact).get(5);
            days = lol.hmUser_data.get(key_contact).get(6);
            id_type = lol.hmUser_data.get(key_contact).get(7);
            staying_place = lol.hmUser_data.get(key_contact).get(8);
        }

	static void frameSettings()
	{
		//**************************************************************************************************************	
		// FRAME SETTINGS
			panel3.setBorder(BorderFactory.createLineBorder(Color.black));
                        panel.setBorder(BorderFactory.createLineBorder(Color.black));
	
			lblFillDetails = new JLabel("<HTML><h1><u>UPDATE DETAILS</u></h1></HTML>", JLabel.CENTER);
			lblFillDetails.setForeground(new Color(115, 25, 170));
			JLabel btn = new JLabel("<HTML><h2>.</h2></HTML>", JLabel.CENTER);
			btn.setBackground(new Color(45, 45, 45));

			panel3.setBackground(new Color(65, 65, 65));
                        panel.setBackground(new Color(65, 65, 65));
                        JPanel empty_panel = new JPanel();
                        empty_panel.setBackground(new Color(65,65,65));
                        empty_panel.add(lblCam_heading);
                        //empty_panel.add(btnCamera);
                        panel3.add(empty_panel);
                        panel3.add(btnPrev_img);
                        panel3.add(btnCamera);                        
                        panel3.add(btnConfirm_img);
			panel2.add(panel);
                        panel2.add(panel3);
			//panel2.add(new JLabel("CAMERA", JLabel.CENTER));
			panel2.setBackground(new Color(65, 65, 65));

			mainpanel.setBackground(new Color(45, 45, 45));
			mainpanel.add(panel2, BorderLayout.CENTER);
			mainpanel.add(lblFillDetails, BorderLayout.NORTH);
			mainpanel.add(btnSubmit, BorderLayout.LINE_END);
			mainpanel.add(btnCancel, BorderLayout.LINE_START);
			mainpanel.add(btn, BorderLayout.SOUTH);

			frame.setContentPane(mainpanel);
			frame.setSize(1920,1080);
			frame.setVisible(true);
			frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                       
		//**************************************************************************************************************	
	}

	static class PassVerifier extends InputVerifier {
		public boolean verify(JComponent input)
		{
			if(input.equals(txtName) || input.equals(txtHostName)) 
			{
				String text = ((JTextField) input).getText();
				if (text.matches("[a-zA-Z ]+")) // Reads: "Any of a-z or A-Z or space one or more times (together, not each)" ---> blank field or field containing anything other than those will return false.
				{
					((JTextField) input).setBorder(BorderFactory.createLineBorder(Color.GRAY));
					return true;
				}
				((JTextField) input).setBorder(BorderFactory.createTitledBorder(redline, "Uppercase and Lowercase letters only"));
				return false;
			}
			else if(input.equals(txtEmail) || input.equals(txtHostEmail))
			{
				String text = ((JTextField) input).getText();
				if (text.matches("^[\\w-\\.]+@([\\w-]+\\.)+[\\w-]{2,4}$"))
				{
					((JTextField) input).setBorder(BorderFactory.createLineBorder(Color.GRAY));
					return true;
				}
				((JTextField) input).setBorder(BorderFactory.createTitledBorder(redline, "Is that an email-id?"));
				return false;
			}
			else if(input.equals(txtContact))
			{
				String text = ((JTextField) input).getText();
				if (text.matches("^(\\+91[\\-\\s]?)?[0]?(91)?[789]\\d{9}$"))
				{
					((JTextField) input).setBorder(BorderFactory.createLineBorder(Color.GRAY));
					return true;
				}
				((JTextField) input).setBorder(BorderFactory.createTitledBorder(redline, "LOL. Can't contact this."));
				return false;
			}
			else if(input.equals(txtDays))
			{
				String text = ((JTextField) input).getText();
				if (text.matches("[0-9]+"))
				{
					((JTextField) input).setBorder(BorderFactory.createLineBorder(Color.GRAY));
					return true;
				}
				((JTextField) input).setBorder(BorderFactory.createTitledBorder(redline, "Is that a NoneDay?"));
				return false;
			}
			else if(input.equals(txtId))
			{
				String type = txtIdType.getSelectedItem().toString();
				if (type=="Aadhar card")
				{
					String text = ((JTextField) input).getText();
					if (text.matches("\\d{4}\\s\\d{4}\\s\\d{4}$"))
					{
						((JTextField) input).setBorder(BorderFactory.createLineBorder(Color.GRAY));
						return true;
					}
					((JTextField) input).setBorder(BorderFactory.createTitledBorder(redline, "Ex: 0000 0000 0000"));
					return false;
				}
				else if(type=="PAN card")
				{
					String text = ((JTextField) input).getText();
					if (text.matches("[A-Z]{5}[0-9]{4}[A-Z]{1}"))
					{
						((JTextField) input).setBorder(BorderFactory.createLineBorder(Color.GRAY));
						return true;
					}
					((JTextField) input).setBorder(BorderFactory.createTitledBorder(redline, "Invalid PAN no."));
					return false;
				}
			}
			return true;
		}
	}
	static class CustomActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
                        Object source = e.getSource();
			if(source.equals(btnSubmit))
			{
                            flag = 1;
//				 // Storing information in hashmap
                            name = txtName.getText(); 
                            email = txtEmail.getText();
                            id = txtId.getText();
                            contact = txtContact.getText();
                            host_name = txtHostName.getText();
                            host_email = txtHostEmail.getText();
                            days = txtDays.getText();
                            id_type = txtIdType.getSelectedItem() + "";
                            staying_place = txtStayingPlace.getSelectedItem() + "";
                           
                            
                            listUser_data.add(name);
                            listUser_data.add(email);
                            listUser_data.add(id);
                            listUser_data.add(contact);
                            listUser_data.add(host_name);
                            listUser_data.add(host_email);
                            listUser_data.add(days);
                            listUser_data.add(id_type);
                            listUser_data.add(staying_place);
                            //listUser_data.add(uniqueID);
                            
                            hmUser_data.put(contact, listUser_data);
                            // Storing information into a file
//                            try {
//                                FileWriter w = new FileWriter("user_details.txt", true);
//                                
//                                w.write(name + "\n");
//                                w.write(email + "\n");
//                                w.write(id + "\n");
//                                w.write(contact + "\n");
//                                w.write(host_name + "\n");
//                                w.write(host_email + "\n");
//                                w.write(days + "\n");
//                                w.write(id_type + "\n");
//                                w.write(staying_place + "\n");
//                                w.close();
//                            } catch (IOException ex) {
//                                Logger.getLogger(code.class.getName()).log(Level.SEVERE, null, ex);
//                            }
                            
                            //JOptionPane.showMessageDialog(null, "User information saved successfully");
                            frame.setVisible(false);
                            
                            
			}
                        else if(source.equals(btnCancel)){
                            frame.setVisible(false);
                        }
                        else if(source.equals(btnPrev_img)){
                            File file = new File("C:\\Users\\91905\\Documents\\NetBeansProjects\\visitor_management_system\\user_image.jpg");
                            BufferedImage image = null;
                            try {
                                image = ImageIO.read(file);
                            } catch (IOException ex) {
                                Logger.getLogger(code.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            prev_img = new JFrame();
                            JLabel img_label = new JLabel(new ImageIcon(image));
                            prev_img.getContentPane().add(img_label, BorderLayout.CENTER);
                            prev_img.pack();
                            prev_img.setVisible(true);
                        }
			else if(source.equals(btnCamera))
			{
                            Webcam webcam = Webcam.getDefault();
                            webcam.setViewSize(new Dimension(640, 480));
                            webcam.open();
                            try {
                                ImageIO.write(webcam.getImage(), "JPG", new File("user_image.jpg"));
                            } catch (IOException ex) {
                                Logger.getLogger(code.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            webcam.close();
			}
//			frame.dispose();
//			frame.setVisible(true);
                        else if(source.equals(btnPrev_img)){
                            File file = new File("C:\\Users\\91905\\Documents\\NetBeansProjects\\visitor_management_system\\user_image.jpg");
                            BufferedImage image = null;
                            try {
                                image = ImageIO.read(file);
                            } catch (IOException ex) {
                                Logger.getLogger(code.class.getName()).log(Level.SEVERE, null, ex);
                            }
                            prev_img = new JFrame();
                            JLabel img_label = new JLabel(new ImageIcon(image));
                            prev_img.getContentPane().add(img_label, BorderLayout.CENTER);
                            prev_img.pack();
                            prev_img.setVisible(true);
                        }
                        else if(source.equals(btnConfirm_img)){
                            JOptionPane.showMessageDialog(null, "Image saved successfully");
                        }
		}
	}
        
        static void init(){
            try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		update_details obj = new update_details();
                obj.get_details();
		obj.user_details();
		obj.host_details();
		obj.venue_details();
		obj.submit_and_cancel();
                obj.camera();
		obj.frameSettings();
        }
	public static void main(String []args)
	{
		init();
	}
}
