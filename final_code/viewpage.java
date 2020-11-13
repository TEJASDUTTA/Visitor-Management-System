package vms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Importing class
import vms.lol;
import vms.update_details;
import vms.SendEmailVisitor;
import vms.SendEmailHost;
class viewpage
{
	static JFrame frame;
	static JPanel mainpanel, panel, panel1, panel2, panel3;
	static JLabel lblVisPass, img;
	static JButton btnOk;
	static JTable table;
        
        // Storing details
        static String name, email, id, contact, host_name, host_email, days, id_type, staying_place;
        static Map <String, ArrayList<String>> hmUser_data = new <String, ArrayList<String>> HashMap();
        static ArrayList <String> listUser_data = new ArrayList<String> ();
        
        static String key_contact = lol.contact;
        
	public static BufferedImage getScreenShot(Component component) {
	BufferedImage image = new BufferedImage(
	component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
	
	component.paint(image.getGraphics()); // alternately use .printAll(..)
	return image;
  	}
        
        // Getting details (from hashmap)
        static void get_details(){
            //System.out.println(code.hmUser_data.get(key_contact));
            if(update_details.flag == 0){
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
            else{
                name = update_details.hmUser_data.get(key_contact).get(0); 
                email = update_details.hmUser_data.get(key_contact).get(1);
                id = update_details.hmUser_data.get(key_contact).get(2);
                contact = update_details.hmUser_data.get(key_contact).get(3);
                host_name = update_details.hmUser_data.get(key_contact).get(4);
                host_email = update_details.hmUser_data.get(key_contact).get(5);
                days = update_details.hmUser_data.get(key_contact).get(6);
                id_type = update_details.hmUser_data.get(key_contact).get(7);
                staying_place = update_details.hmUser_data.get(key_contact).get(8);
            }
        }
	public static void display()
	{
		//**************************************************************************************************************
			frame = new JFrame("VIEW RECORDS");
			mainpanel = new JPanel(new BorderLayout(10,10));
			panel = new JPanel(new GridLayout(1,3));
			panel1 = new JPanel(new GridLayout(10,1));
			panel2 = new JPanel(new GridLayout(10,1));
			panel3 = new JPanel(new GridLayout(1,1));
		//**************************************************************************************************************

		//**************************************************************************************************************
		// ADD BUTTONS AND LABELS
			lblVisPass = new JLabel("<HTML><h1><u>Visitors Pass</u></h1></HTML>", JLabel.CENTER);
			lblVisPass.setForeground(new Color(52,119,235));

			btnOk = new JButton("<HTML><h2>GET YOUR VISITOR ID PASS</h2></HTML>");
			btnOk.setBackground(new Color(52,119,235));
			btnOk.addActionListener(new CustomActionListener());

			String a[] = {"Visitor ID: ", "Name: ", "Email: ", "ID Type: ", "ID: ", "Contact: ", "Host Name: ", "Host Email: ", "Days of Stay: ", "Staying Place: "};
			for(int i=0; i<10; i+=1)
			{
				JLabel lbl = new JLabel("<HTML><h3>" + a[i] + "</h3></HTML>", JLabel.CENTER);
				lbl.setBorder(BorderFactory.createLineBorder(Color.gray));
				lbl.setForeground(new Color(35,35,35));
				panel1.add(lbl);				
			}

			String b[] = {contact, name, email, id_type, id, contact, host_name, host_email, days, staying_place};
			for(int i=0; i<10; i+=1)
			{
				JLabel lbl = new JLabel("<HTML><h3>" + b[i] + "</h3></HTML>", JLabel.CENTER);
				lbl.setBorder(BorderFactory.createLineBorder(Color.gray));
				lbl.setForeground(new Color(35,35,35));
				panel2.add(lbl);				
			}
                        //System.out.println(name);

			img = new JLabel("", JLabel.CENTER);
			BufferedImage image = null;
			try 
			{
				image = ImageIO.read(new File("C:\\Users\\91905\\Documents\\NetBeansProjects\\visitor_management_system\\user_image.jpg"));

			} catch (Exception e) 
			{
				e.printStackTrace();
			}

			ImageIcon imageIcon = new ImageIcon(fitimage(image, 180, 220));
			img.setIcon(imageIcon);
			panel3.add(img);

		
		panel.add(panel1);
		panel.add(panel2);
		panel.add(panel3);
		
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel3.setBorder(BorderFactory.createLineBorder(Color.black));

		mainpanel.add(lblVisPass, BorderLayout.NORTH);
		mainpanel.add(panel, BorderLayout.CENTER);
		mainpanel.add(btnOk, BorderLayout.SOUTH);
		mainpanel.setBackground(new Color(45, 45, 45));

		frame.add(mainpanel);
		frame.setSize(500,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	}

	static class CustomActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton o = (JButton)e.getSource();
			if(o.equals(btnOk))
			{
                                JOptionPane.showMessageDialog(null, "Please wait for the window to close on its own.");
				BufferedImage img = getScreenShot(frame.getContentPane());
//				JOptionPane.showMessageDialog(null, 
//				new JLabel(new ImageIcon(img.getScaledInstance(img.getWidth(null)/2,img.getHeight(null)/2,Image.SCALE_SMOOTH))));
				  
				try {
					ImageIO.write(img,"jpg", new File("C:\\Users\\91905\\Documents\\NetBeansProjects\\visitor_management_system\\visitor_pass.jpg"));
                                        SendEmailVisitor.init();
                                        SendEmailHost.init();
                                        frame.setVisible(false);
				} 
				catch(Exception ae) {
					ae.printStackTrace();
				}
			}
		}
	}
	static Image fitimage(Image img , int w , int h)
	{
	    BufferedImage resizedimage = new BufferedImage(w,h,BufferedImage.TYPE_INT_RGB);
	    Graphics2D g2 = resizedimage.createGraphics();
	    g2.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
	    g2.drawImage(img, 0, 0,w,h,null);
	    g2.dispose();
	    return resizedimage;
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
		viewpage obj = new viewpage();
                obj.get_details();
		obj.display();
        }

	public static void main(String []args)
	{
		init();
	}
}