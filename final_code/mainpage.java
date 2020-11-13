package vms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

// Importing project classes
import vms.code;
import vms.admin_login;
import vms.update_details;
import vms.user_login;
import vms.lol;
import vms.adminpage;
import vms.viewpage;
import vms.user_login_2;
class mainpage
{
	static JFrame frame;
	static JPanel panel, panel1, panel2, mainpanel;
	static JLabel lblvms;
	static JButton quit, admin_panel, update_details, fill_details, view_details;

	public static void display()
	{
		frame = new JFrame("Main Screen");
		panel = new JPanel(new BorderLayout(10,10));
		panel1 = new JPanel(new GridLayout(7,2));
		panel2 = new JPanel(new GridLayout(2,1,10,10));
		mainpanel = new JPanel(new GridLayout(1,1,10,10));
		lblvms = new JLabel("<HTML><h1><u>Visitor Management System</u></h1></HTML>", JLabel.CENTER);
		lblvms.setForeground(new Color(115, 25, 170));

		quit = new JButton("<HTML><h2>Quit</h2></HTML>");
					 
		admin_panel = new JButton("<HTML><h2>Admin Panel</h2></HTML>");
		
		update_details = new JButton("<HTML><h2>Update Existing ID</h2></HTML>");
		fill_details = new JButton("<HTML><h2>New Visitor</h2></HTML>");
		view_details = new JButton("<HTML><h2>Print Existing ID</h2></HTML>");

		admin_panel.setBackground(new Color(192,192,192));
		admin_panel.addActionListener(new CustomActionListener());
					 
		quit.setBackground(new Color(209,26,42));
		quit.addActionListener(new CustomActionListener());
					 
		fill_details.addActionListener(new CustomActionListener());
		view_details.addActionListener(new CustomActionListener());
		update_details.addActionListener(new CustomActionListener());

		panel2.add(fill_details);
		panel2.add(view_details);
					 

		panel.add(panel2,BorderLayout.CENTER);
		panel.add(admin_panel,BorderLayout.LINE_START); 
		panel.add(update_details,BorderLayout.LINE_END);
		panel.add(lblvms,BorderLayout.NORTH); 
		panel.add(quit,BorderLayout.SOUTH);

		panel.setBackground(new Color(45, 45, 45));
		panel1.setBackground(new Color(45, 45, 45));
		panel2.setBackground(new Color(45, 45, 45));

		mainpanel.add(panel);
		
		frame.add(mainpanel);
		frame.setSize(1920,1080);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	static class CustomActionListener implements ActionListener{
		public void actionPerformed(ActionEvent ae) {
			Object source = ae.getSource();

			if(source == admin_panel){
				admin_login.init();
				//new admin_login().f.setVisible(true);
			}
			else if(source == fill_details){
				//code.init();
				lol.init();
			}
			else if(source == update_details){
				user_login.init();
				//new user_login().user_frame.setVisible(true);
			}
			else if(source == view_details){
				//user_login_2.init();
				viewpage.init();
			}
			else if(source == quit){
				System.exit(0);
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
		mainpage obj = new mainpage();
		obj.display();
	}

	public static void main(String []args)
	{
				init();
	}
}
