import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

public class lol{
	static JFrame frame = new JFrame("FILL DETAILS");
	static JLabel lblFillDetails, lblCamera, lblVisitor, lblName, lblEmail, lblId, lblContact, lblTime, lblHostName, lblHostEmail, lblHost, lblIdType, lblVenue, lblStayingPlace, lblDays; 
	static JTextField txtName, txtEmail, txtId, txtContact, txtHostName, txtHostEmail, txtDays;
	static JComboBox txtIdType, txtStayingPlace;
	static JButton btnSubmit, btnCancel;
	static Color background = new Color(50, 50, 50);
	static Color foreground = new Color(65, 105, 225);
	static Color purple = new Color(115, 25, 170);
	static JPanel mainpanel = new JPanel(new BorderLayout(10,10));
	static JPanel panel = new JPanel(new GridLayout(15,2,6,10));
	static JPanel panel2 = new JPanel(new GridLayout(1,2,10,10));

	static JTextArea txtArea;
	static Border redline = BorderFactory.createLineBorder(Color.RED);
	static BufferedImage myPicture;

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

			txtName = new JTextField("Aviral", 60);
			txtEmail = new JTextField("guptaavi@gmail.com", 60);
			txtId = new JTextField("aaaaaaaaaa", 60);
			txtContact = new JTextField("9999999999",60);

			String txtIdTypeOptions[] = {"Aadhar card", "PAN card"};
			txtIdType = new JComboBox(txtIdTypeOptions);
			txtIdType.setSelectedIndex(0);

			txtName.setInputVerifier(new PassVerifier());
			txtEmail.setInputVerifier(new PassVerifier());
			txtContact.setInputVerifier(new PassVerifier());
			txtId.setInputVerifier(new PassVerifier());

			panel.add(new JLabel("<HTML><h3>VISITOR</h3></HTML>", JLabel.TRAILING));		
			panel.add(new JLabel("<HTML><h3>DETAILS</h3></HTML>", JLabel.LEADING));
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

			txtHostName = new JTextField("Avi", 60);
			txtHostEmail = new JTextField("iit2019157@iiita.ac.in", 60);

			txtHostName.setInputVerifier(new PassVerifier());
			txtHostEmail.setInputVerifier(new PassVerifier());
			
			panel.add(new JLabel("<HTML><h3>HOST</h3></HTML>", JLabel.TRAILING));		
			panel.add(new JLabel("<HTML><h3>DETAILS</h3></HTML>", JLabel.LEADING));
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

			txtDays.setInputVerifier(new PassVerifier());

			panel.add(new JLabel("<HTML><h3>VENUE</h3></HTML>", JLabel.TRAILING));		
			panel.add(new JLabel("<HTML><h3>DETAILS</h3></HTML>", JLabel.LEADING));
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

	static void frameSettings()
	{
		//**************************************************************************************************************	
		// FRAME SETTINGS
			panel.setBorder(BorderFactory.createLineBorder(Color.black));
	
			lblFillDetails = new JLabel("<HTML><h1><u>FILL DETAILS</u></h1></HTML>", JLabel.CENTER);
			lblFillDetails.setForeground(new Color(115, 25, 170));
			JLabel btn = new JLabel("<HTML><h2>.</h2></HTML>", JLabel.CENTER);
			btn.setBackground(new Color(45, 45, 45));

			panel.setBackground(new Color(65, 65, 65));
			panel2.add(panel);
			panel2.add(new JLabel("CAMERA", JLabel.CENTER));
			panel2.setBackground(new Color(65, 65, 65));

			mainpanel.setBackground(new Color(45, 45, 45));
			mainpanel.add(panel2, BorderLayout.CENTER);
			mainpanel.add(lblFillDetails, BorderLayout.NORTH);
			mainpanel.add(btnSubmit, BorderLayout.LINE_END);
			mainpanel.add(btnCancel, BorderLayout.LINE_START);
			mainpanel.add(btn, BorderLayout.SOUTH);

			frame.setContentPane(mainpanel);
			frame.setSize(1000,800);
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
			if(e.equals(btnSubmit))
			{
				JFrame f = new JFrame();
				mainpanel.add(panel);
				f.add(mainpanel);
				f.setSize(1000,800);
				f.getContentPane().setBackground(background);
				f.getContentPane().setForeground(foreground);
				f.setVisible(true);
				f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			}
			else if(e.equals(btnCancel))
			{
				// RETURN TO MAIN SCREEN
			}
			frame.dispose();
			frame.setVisible(true);
		}
	}
	public static void main(String []args)
	{
		try
		{
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		lol obj = new lol();
		obj.user_details();
		obj.host_details();
		obj.venue_details();
		obj.submit_and_cancel();
		obj.frameSettings();
	}
}