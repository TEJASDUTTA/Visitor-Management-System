import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;

class mainpage
{
	static JFrame frame;
	static JPanel panel, panel1, panel2, mainpanel;
	static JLabel lblvms, lblGroup, lblEnRoll;
	static JButton quit, admin_login, update_details, fill_details, view_details;

	public static void display()
	{
		//**************************************************************************************************************
			frame = new JFrame("Main Screen");
			panel = new JPanel(new BorderLayout(10,10));
			panel1 = new JPanel(new GridLayout(7,2));
			panel2 = new JPanel(new GridLayout(2,1,10,10));
			mainpanel = new JPanel(new GridLayout(2,1,10,10));
		//**************************************************************************************************************

		//**************************************************************************************************************
		// ADD BUTTONS AND LABELS
			lblvms = new JLabel("<HTML><h1><u>Visitor Management System</u></h1></HTML>", JLabel.CENTER);
			lblvms.setForeground(new Color(115, 25, 170));
			quit = new JButton("<HTML><h2>Quit</h2></HTML>");
			admin_login = new JButton("<HTML><h2>Admin Login</h2></HTML>");
			update_details = new JButton("<HTML><h2>Update Details</h2></HTML>");
			fill_details = new JButton("<HTML><h2>Fill Details</h2></HTML>");
			view_details = new JButton("<HTML><h2>View Details</h2></HTML>");

			quit.setBackground(new Color(209,26,42));
			quit.addActionListener(new CustomActionListener());

			panel2.add(fill_details);
			panel2.add(view_details);

			panel.add(panel2,BorderLayout.CENTER);
			panel.add(admin_login,BorderLayout.LINE_START); 
			panel.add(update_details,BorderLayout.LINE_END);
			panel.add(lblvms,BorderLayout.NORTH); 
			panel.add(quit,BorderLayout.SOUTH);
			panel.setBackground(new Color(45, 45, 45));
			panel1.setBackground(new Color(45, 45, 45));
			panel2.setBackground(new Color(45, 45, 45));
		//**************************************************************************************************************

		//**************************************************************************************************************
		// ADDING NAMES AND ROLLNO.S
			lblGroup = new JLabel("<HTML><h2><u>GROUP MEMBER</u></h2></HTML>", JLabel.CENTER);
			lblEnRoll = new JLabel("<HTML><h2><u>ENROLLMENT NUMBER</u></h2></HTML>", JLabel.CENTER);
			lblGroup.setForeground(new Color(195,195,195));
			lblEnRoll.setForeground(new Color(195,195,195));

			panel1.add(lblGroup);
			panel1.add(lblEnRoll);

			String members[] = {"Bhupesh Sardana", "Aviral Gupta", "Aryan Dhakad", "Hafiz Ali", "Tejas Dutta"};
			String roll[] = {"IIT2019156", "IIT2019157", "IIT2019158", "IIT2019159", "IIT2019160"};
			
			for(int i=0; i<5; i++)
			{
				JLabel lblname = new JLabel("<HTML><h3>" + members[i] + "</h3></HTML>", JLabel.CENTER);
				JLabel lblroll = new JLabel("<HTML><h3>" + roll[i] + "</h3></HTML>", JLabel.CENTER);
				lblname.setForeground(new Color(215, 114, 44));
				lblroll.setForeground(new Color(215, 114, 44));
				lblname.setBorder(BorderFactory.createLineBorder(Color.gray));
				lblroll.setBorder(BorderFactory.createLineBorder(Color.gray));
				panel1.add(lblname);
				panel1.add(lblroll);
			}
		//**************************************************************************************************************
		
		mainpanel.add(panel);
		mainpanel.add(panel1);
		frame.add(mainpanel);
		frame.setSize(1800,1000);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	static class CustomActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			frame.dispose();
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
		mainpage obj = new mainpage();
		obj.display();
	}
}
