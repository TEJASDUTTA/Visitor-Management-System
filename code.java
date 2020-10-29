import javax.swing.*;
class mainpage{
	public void display()
	{
		JFrame frame = new JFrame("FILL DETAILS");
		JLabel lblName, lblEmail, lblId, lblContact, lblTime, lblHostName, lblHostEmail, lblHost, lblIdType, lblVenue, lblStayingPlace, lblDays; 
		JTextField txtName, txtEmail, txtId, txtContact, txtHostName, txtHostEmail, txtDays;
		JComboBox txtIdType, txtStayingPlace;

		//**************************************************************************************************************
		// USER DETAILS
			lblName = 	new JLabel("Name: ");
			lblEmail = 	new JLabel("Email: ");
			lblIdType = new JLabel("ID Type:");
			lblId = new JLabel("ID: ");
			lblContact = new JLabel("Contact no.: ");
			lblTime = new JLabel("Choose hours of stay: ");		

			txtName = new JTextField(60);
			txtEmail = new JTextField("abc@iiita.ac.in", 60);
			txtId = new JTextField(60);
			txtContact = new JTextField(60);

			String txtIdTypeOptions[] = {"Aadhar card", "PAN card", "Passport"};
			txtIdType = new JComboBox(txtIdTypeOptions);
			txtIdType.setSelectedIndex(0);

			int x=30, y=30, height=30, width=150;
			lblName.setBounds(x,y,width,height);				txtName.setBounds(x+160,y,width+100,height);
			lblEmail.setBounds(x,y+40,width,height);			txtEmail.setBounds(x+160,y+40,width+100,height);
			lblIdType.setBounds(x,y+80,width,height);			txtIdType.setBounds(x+160,y+80,width+100,height);
			lblId.setBounds(x,y+120,width,height);				txtId.setBounds(x+160,y+120,width+100,height);
			lblContact.setBounds(x,y+160,width,height);			txtContact.setBounds(x+160,y+160,width+100,height);
			
			frame.add(lblName);			frame.add(txtName);
			frame.add(lblEmail);		frame.add(txtEmail);
			frame.add(lblIdType);		frame.add(txtIdType);	
			frame.add(lblId);			frame.add(txtId);
			frame.add(lblContact);		frame.add(txtContact);
		//**************************************************************************************************************
		
		//**************************************************************************************************************
		// HOST DETAILS
			lblHost = new JLabel("Host Details");
			lblHostName = new JLabel("Host Name: ");
			lblHostEmail = new JLabel("Host Email: ");

			txtHostName = new JTextField(60);
			txtHostEmail = new JTextField(60);
			
			lblHost.setBounds(x, y+210, width, height);
			lblHostName.setBounds(x,y+240,width,height);		txtHostName.setBounds(x+160,y+240,width+100,height);
			lblHostEmail.setBounds(x,y+280,width,height);		txtHostEmail.setBounds(x+160,y+280,width+100,height);
			
			frame.add(lblHost);
			frame.add(lblHostName);		frame.add(txtHostName);
			frame.add(lblHostEmail);	frame.add(txtHostEmail);
		//**************************************************************************************************************
		
		//**************************************************************************************************************
		// VENUE DETAILS
			lblVenue = new JLabel("Venue Details");
			lblStayingPlace = new JLabel("Staying Place: ");
			lblDays = new JLabel("For How Many Days?");

			String txtAllPlaces[] = {"BH-1,2", "BH-3,4", "BH-5", "GH-1,2,3"};
			txtStayingPlace = new JComboBox(txtAllPlaces);
			txtStayingPlace.setSelectedIndex(2);
			txtDays = new JTextField(60);

			lblVenue.setBounds(x, y+330, width, height);
			lblStayingPlace.setBounds(x, y+360, width, height);		txtStayingPlace.setBounds(x+160, y+360, width+100, height);
			lblDays.setBounds(x, y+400, width, height);			txtDays.setBounds(x+160, y+400, width+100, height);

			frame.add(lblVenue);
			frame.add(lblStayingPlace);		frame.add(txtStayingPlace);
			frame.add(lblDays);				frame.add(txtDays);
		//**************************************************************************************************************	

		Webcam buildin = Webcam.getWebcams().get(0);
		frame.setSize(400,500);//400 width and 500 height  
		frame.setLayout(null);//using no layout managers  
		frame.setVisible(true);//making the frame visible
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
	TextArea txtArea;
	Label lblName, lblEmail, lblId, lblContact, lblTime, lblHostName, lblHostEmail, lblHost, lblIdType; 
	Checkbox onehour, fivehour, tenhour, other;
	CheckboxGroup txtTime;
	Button submit;
	Color background = new Color(50, 50, 50);
	Color foreground = new Color(65, 105, 225);
	Color purple = new Color(115, 25, 150);
	Choice txtIdType;
	Font font = new Font("Arial", Font.BOLD, 12);
	public void init()
	{
		setBackground(background);
		setForeground(foreground);
		


		//
		lblTime.setBounds(x,y+320,width,height);
		txtTime=new CheckboxGroup();

		onehour = new Checkbox("1", true, txtTime);
	   	fivehour = new Checkbox("5", false, txtTime);
	   	tenhour = new Checkbox("10", false, txtTime);
	   	other = new Checkbox(">10", false, txtTime);

	   	onehour.setBounds(200, 350, 50, 30);
	   	fivehour.setBounds(250, 350, 50, 30);
	   	tenhour.setBounds(300, 350, 50, 30);
	   	other.setBounds(x+320, 350, 50, 30);

	   	submit = new Button("Submit");
	   	submit.setBackground(purple);
	   	submit.setForeground(Color.white);
	   	submit.setBounds(200, 400, 100, 40);

	   	txtArea = new TextArea(400,400);
	   	txtArea.setBounds(0, 440, 600, 160);

		
		frame.add(lblTime);		frame.add(onehour);		frame.add(fivehour);		frame.add(tenhour);		frame.add(other);
		
		frame.add(submit);
		frame.add(txtArea);
		setSize(600,600);  
        setLayout(null);  
        setVisible(true);  

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
