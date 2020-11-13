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
			lblName = new JLabel("<HTML><h3>Name: </h3></HTML>", JLabel.TRAILING);
			lblEmail = new JLabel("<HTML><h3>Email: </h3></HTML>", JLabel.TRAILING);
			lblIdType = new JLabel("<HTML><h3>ID Type: </h3></HTML>", JLabel.TRAILING);
			lblId = new JLabel("<HTML><h3>ID: </h3></HTML>", JLabel.TRAILING);
			lblContact = new JLabel("<HTML><h3>Contact no.: </h3></HTML>", JLabel.TRAILING);

			lblName.setForeground(new Color(215,215,215));
			lblEmail.setForeground(new Color(215,215,215));
			lblIdType.setForeground(new Color(215,215,215));
			lblId.setForeground(new Color(215,215,215));
			lblContact.setForeground(new Color(215,215,215));

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
			lblHostName = new JLabel("<HTML><h3>Host Name: </h3></HTML>", JLabel.TRAILING);
			lblHostEmail = new JLabel("<HTML><h3>Host Email: </h3></HTML>", JLabel.TRAILING);

			lblHostName.setForeground(new Color(215,215,215));
			lblHostEmail.setForeground(new Color(215,215,215));

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
			lblStayingPlace = new JLabel("<HTML><h3>Staying Place: </h3></HTML>", JLabel.TRAILING);
			lblDays = new JLabel("<HTML><h3>For How Many Days?</h3></HTML>", JLabel.TRAILING);

			lblStayingPlace.setForeground(new Color(215,215,215));
			lblDays.setForeground(new Color(215,215,215));

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
		lblCam_heading.setFont(new Font("Courier New",Font.BOLD,26));
		lblCam_heading.setBackground(new Color(65,65,65));
		
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
			
			panel3.add(empty_panel);
			panel3.add(btnPrev_img);
			panel3.add(btnCamera);
			panel3.add(btnConfirm_img);
			panel2.add(panel);
			panel2.add(panel3);
			
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
				((JTextField) input).setBorder(BorderFactory.createTitledBorder(redline, "Uppercase and Lowercase letters only."));
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
				((JTextField) input).setBorder(BorderFactory.createTitledBorder(redline, "Invalid Email."));
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
				((JTextField) input).setBorder(BorderFactory.createTitledBorder(redline, "Invalid Contact."));
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
				((JTextField) input).setBorder(BorderFactory.createTitledBorder(redline, "Invalid Number."));
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
				// Storing information in hashmap
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

				
				hmUser_data.put(contact, listUser_data);
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
