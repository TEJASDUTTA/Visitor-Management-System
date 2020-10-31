import javax.swing.*;
import java.awt.*;
class mainpage{
	public void display()
	{
		JFrame frame = new JFrame("FILL DETAILS");
		JLabel lblVisitor, lblName, lblEmail, lblId, lblContact, lblTime, lblHostName, lblHostEmail, lblHost, lblIdType, lblVenue, lblStayingPlace, lblDays; 
		JTextField txtName, txtEmail, txtId, txtContact, txtHostName, txtHostEmail, txtDays;
		JComboBox txtIdType, txtStayingPlace;
		JButton btnSubmit, btnCancel;
		Color background = new Color(50, 50, 50);
		Color foreground = new Color(65, 105, 225);
		Color purple = new Color(115, 25, 150);
		JPanel mainpanel = new JPanel(new GridLayout(1,2,10,20));

		//**************************************************************************************************************
		// USER DETAILS
			JPanel panel = new JPanel(new GridLayout(15,2,10,10));
			lblVisitor = new JLabel("VISITOR DETAILS", JLabel.CENTER);
			lblVisitor.setFont(new Font("Courier New", Font.BOLD, 16));
			lblName = new JLabel("Name: ", JLabel.TRAILING);
			lblEmail = new JLabel("Email: ", JLabel.TRAILING);
			lblIdType = new JLabel("ID Type:", JLabel.TRAILING);
			lblId = new JLabel("ID: ", JLabel.TRAILING);
			lblContact = new JLabel("Contact no.: ", JLabel.TRAILING);
			lblTime = new JLabel("Choose hours of stay: ", JLabel.TRAILING);		

			txtName = new JTextField(60);
			txtEmail = new JTextField("@iiita.ac.in", 60);
			txtId = new JTextField(60);
			txtContact = new JTextField(60);

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
		
		//**************************************************************************************************************
		// HOST DETAILS
			lblHost = new JLabel("HOST DETAILS", JLabel.CENTER);
			lblHost.setFont(new Font("Arial", Font.BOLD, 16));
			lblHostName = new JLabel("Host Name: ", JLabel.TRAILING);
			lblHostEmail = new JLabel("Host Email: ", JLabel.TRAILING);

			txtHostName = new JTextField(60);
			txtHostEmail = new JTextField("@gmail.com", 60);
			
			panel.add(lblHost);				panel.add(new Label("	"));
			panel.add(lblHostName);			panel.add(txtHostName);
			panel.add(lblHostEmail);		panel.add(txtHostEmail);
		//**************************************************************************************************************
		
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

			panel.add(lblVenue);				panel.add(new Label("	"));
			panel.add(lblStayingPlace);			panel.add(txtStayingPlace);
			panel.add(lblDays);					panel.add(txtDays);
		//**************************************************************************************************************	

		//**************************************************************************************************************	
		// SUBMIT AND CANCEL BUTTON
			JPanel panel2 = new JPanel(new GridLayout(1,2,0,0));
			btnCancel = new JButton("Cancel");
			btnCancel.setBackground(new Color(0xf6, 0xef, 0xd0));

			btnSubmit = new JButton("Submit");
			btnSubmit.setBackground(purple);
			btnSubmit.setForeground(Color.white);
		
			panel2.add(btnCancel);			panel2.add(btnSubmit);
			panel.add(new JLabel(" "));		panel.add(panel2);
			panel.setBackground(new Color(219,207,92));
		//**************************************************************************************************************	
		
		//**************************************************************************************************************	
		// CAMERA
			JPanel panel1 = new JPanel(new GridLayout(1,1));
			panel1.setBackground(new Color(48,25,52));
			JLabel lblCamera = new JLabel("CAMERA");
			lblCamera.setForeground(new Color(219,207,92));
			panel1.add(lblCamera);

		//**************************************************************************************************************	
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

public class code{
	public static void main(String []args){
		mainpage obj = new mainpage();
		obj.display();
	}
}
			
/*
public class code implements ActionListener,ItemListener
{
	public void init()
	{
		submit.frame.addActionListener(this);
	}

	public void actionPerformed(ActionEvent ae)
	{
		if( isName(txtName.getText())		&& 
			isEmail(txtEmail.getText())		&&
			isContact(txtContact.getText()))
		{
			txtArea.setText("NAME: "+txtName.getText()+"\n"+"E-MAIL: "+txtEmail.getText()+"\n"+"ID: "+txtId.getText()+"\n"+"CONTACT: "+txtContact.getText());	
		}
		else
		{
			JOptionPane.showMessageDialog(null, "Invalid Input");
		}
	}
	public static boolean isName(String input)
	{
		return true;
		//return Pattern.matches("^[A-Za-z] [A-Za-z]$", input);
	}
	public static boolean isContact(String input)
	{
		return true;
		//return Pattern.matches("^[A-Za-z] [A-Za-z]$", input);
	}
	public static boolean isEmail(String input)
	{
		return true;
		//return Pattern.matches("??????????@iiita.ac.in$", input);
	}

	public void itemStateChanged(ItemEvent ie)
	{

	}
}
*/
