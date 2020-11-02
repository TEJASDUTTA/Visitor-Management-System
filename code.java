import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class code{
	static JFrame frame = new JFrame("FILL DETAILS");
	static JLabel lblCamera, lblVisitor, lblName, lblEmail, lblId, lblContact, lblTime, lblHostName, lblHostEmail, lblHost, lblIdType, lblVenue, lblStayingPlace, lblDays; 
	static JTextField txtName, txtEmail, txtId, txtContact, txtHostName, txtHostEmail, txtDays;
	static JComboBox txtIdType, txtStayingPlace;
	static JButton btnSubmit, btnCancel;
	static Color background = new Color(50, 50, 50);
	static Color foreground = new Color(65, 105, 225);
	static Color purple = new Color(115, 25, 150);
	static JPanel mainpanel = new JPanel(new GridLayout(1,2,10,20));
	static JPanel panel = new JPanel(new GridLayout(15,2,10,10));
	static JPanel panel1 = new JPanel(new GridLayout(1,1));
	static JPanel panel2 = new JPanel(new GridLayout(1,2,0,0));
	static JTextArea txtArea;
	static Border redline = BorderFactory.createLineBorder(Color.RED);

	static void user_details()
	{
		//**************************************************************************************************************
		// USER DETAILS
			lblVisitor = new JLabel("VISITOR DETAILS", JLabel.CENTER);
			lblVisitor.setFont(new Font("Courier New", Font.BOLD, 16));
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

			txtName.setInputVerifier(new PassVerifier());
			txtEmail.setInputVerifier(new PassVerifier());
			txtContact.setInputVerifier(new PassVerifier());

			String txtIdTypeOptions[] = {"Aadhar card", "PAN card", "Passport"};
			txtIdType = new JComboBox(txtIdTypeOptions);
			txtIdType.setSelectedIndex(0);

			panel.add(lblVisitor);		panel.add(new JLabel("	"));
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
			lblHost = new JLabel("HOST DETAILS", JLabel.CENTER);
			lblHost.setFont(new Font("Arial", Font.BOLD, 16));
			lblHostName = new JLabel("Host Name: ", JLabel.TRAILING);
			lblHostEmail = new JLabel("Host Email: ", JLabel.TRAILING);

			txtHostName = new JTextField("Avi", 60);
			txtHostEmail = new JTextField("iit2019157@iiita.ac.in", 60);

			txtHostName.setInputVerifier(new PassVerifier());
			txtHostEmail.setInputVerifier(new PassVerifier());
			
			panel.add(lblHost);				panel.add(new Label("	"));
			panel.add(lblHostName);			panel.add(txtHostName);
			panel.add(lblHostEmail);		panel.add(txtHostEmail);
		//**************************************************************************************************************
	}
	static void venue_details()
	{
		//**************************************************************************************************************
		// VENUE DETAILS
			lblVenue = new JLabel("VENUE DETAILS", JLabel.CENTER);
			lblVenue.setFont(new Font("", Font.BOLD, 16));
			lblStayingPlace = new JLabel("Staying Place: ", JLabel.TRAILING);
			lblDays = new JLabel("For How Many Days?", JLabel.TRAILING);

			String txtAllPlaces[] = {"BH-1,2", "BH-3,4", "BH-5", "GH-1,2,3"};
			txtStayingPlace = new JComboBox(txtAllPlaces);
			txtStayingPlace.setSelectedIndex(2);
			txtDays = new JTextField(60);

			txtDays.setInputVerifier(new PassVerifier());

			panel.add(lblVenue);				panel.add(new Label("	"));
			panel.add(lblStayingPlace);			panel.add(txtStayingPlace);
			panel.add(lblDays);					panel.add(txtDays);
		//**************************************************************************************************************	
	}
	static void submit_and_cancel()
	{
		//**************************************************************************************************************	
		// SUBMIT AND CANCEL BUTTON
			btnCancel = new JButton("Cancel");
			btnCancel.setBackground(new Color(0xf6, 0xef, 0xd0));

			btnSubmit = new JButton("Submit");
			btnSubmit.setBackground(purple);
			btnSubmit.setForeground(Color.white);
			
			btnCancel.addActionListener(new CustomActionListener());
			btnSubmit.addActionListener(new CustomActionListener());
			//btnCancel.addActionListener(new CustomActionListener());
			panel2.add(btnCancel);			panel2.add(btnSubmit);
			panel.add(new JLabel(" "));		panel.add(panel2);
			panel.setBackground(new Color(219,207,92));
		//**************************************************************************************************************	
	}
	static void camera()
	{
		//**************************************************************************************************************	
		// CAMERA
			txtArea = new JTextArea();
			panel1.setBackground(new Color(48,25,52));
			lblCamera = new JLabel("CAMERA");
			lblCamera.setForeground(new Color(219,207,92));
			panel1.add(lblCamera);
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
			return true;
		}
	}
	static class CustomActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			if(e.equals(btnSubmit))
			{

			}
			else if(e.equals(btnCancel))
			{

			}
			frame.dispose();
			/*JFrame f = new JFrame();
			f.add(new Label("Hi Aviral"));
			f.setSize(600,600);//400 width and 500 height  
			f.getContentPane().setBackground(background);
			f.getContentPane().setForeground(foreground);
			f.setVisible(true);//making the frame visible
			f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			*/
			frame.setVisible(true);
		}
	}

	public static void main(String []args)
	{
		code obj = new code();
		obj.user_details();
		obj.host_details();
		obj.venue_details();
		obj.submit_and_cancel();
		obj.camera();

		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel1.setBorder(BorderFactory.createLineBorder(Color.black));
		panel2.setBorder(BorderFactory.createLineBorder(Color.gray));

		mainpanel.add(panel);
		mainpanel.add(panel1);
		frame.add(mainpanel);
		frame.setSize(600,600);//400 width and 500 height  
		frame.getContentPane().setBackground(background);
		frame.getContentPane().setForeground(foreground);
		frame.setVisible(true);//making the frame visible
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}
	
}
