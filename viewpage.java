import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.table.*;
import javax.swing.event.*;
import java.awt.image.BufferedImage;

class viewpage
{
	static JFrame frame;
	static JPanel mainpanel, panel, panel1, panel2, panel3;
	static JLabel lblVisPass, img;
	static JButton btnOk;
	static JTable table;
	public static BufferedImage getScreenShot(Component component) {
	BufferedImage image = new BufferedImage(
	component.getWidth(), component.getHeight(), BufferedImage.TYPE_INT_RGB);
	
	component.paint(image.getGraphics()); // alternately use .printAll(..)
	return image;
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

			btnOk = new JButton("<HTML><h2>BACK TO MAIN SCREEN</h2></HTML>");
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

			String b[] = {"t0mbstone ", "Aviral ", "iit2019157@iiita.ac.in", "Aadhar Card", "0000 0000 0000", "9546986542 ", "Aviral", "iit2019157@iiita.ac.in", "5", "BH-5"};
			for(int i=0; i<10; i+=1)
			{
				JLabel lbl = new JLabel("<HTML><h3>" + b[i] + "</h3></HTML>", JLabel.CENTER);
				lbl.setBorder(BorderFactory.createLineBorder(Color.gray));
				lbl.setForeground(new Color(35,35,35));
				panel2.add(lbl);				
			}

			img = new JLabel("", JLabel.CENTER);
			BufferedImage image = null;
			try 
			{
				image = ImageIO.read(new File("img.jpeg"));

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
		frame.setSize(700,400);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	static class CustomActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			JButton o = (JButton)e.getSource();
			if(o.equals(btnOk))
			{
				BufferedImage img = getScreenShot(frame.getContentPane());
				JOptionPane.showMessageDialog(null, 
				new JLabel(new ImageIcon(img.getScaledInstance(img.getWidth(null)/2,img.getHeight(null)/2,Image.SCALE_SMOOTH))));
				  
				try {
					ImageIO.write(img,"png", new File("screenshot.png"));
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
		viewpage obj = new viewpage();
		obj.display();
	}
}