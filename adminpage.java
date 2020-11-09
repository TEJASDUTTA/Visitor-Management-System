import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.imageio.ImageIO;
import java.io.File;
import javax.swing.table.*;

class adminpage
{
	static JFrame frame;
	static JPanel panel, panel1, panel2, mainpanel;
	static JLabel lblVisitor, lblGroup, lblEnRoll;
	static JButton btnBack, btnSave;
	static JTable table;

	public static void display()
	{
		//**************************************************************************************************************
			frame = new JFrame("VIEW ALL RECORDS");
			mainpanel = new JPanel(new BorderLayout(10,10));
		//**************************************************************************************************************

		//**************************************************************************************************************
		// ADD BUTTONS AND LABELS
			lblVisitor = new JLabel("<HTML><h1><u>Visitors List</u></h1></HTML>", JLabel.CENTER);
			lblVisitor.setForeground(new Color(52,119,235));

			btnBack = new JButton("<HTML><h2>Back</h2></HTML>");
			btnBack.setBackground(new Color(209,26,42));
			btnBack.addActionListener(new CustomActionListener());

			btnSave = new JButton("<HTML><h2>Save</h2></HTML>");
			btnSave.setBackground(new Color(52,119,235));
			btnSave.addActionListener(new CustomActionListener());

			mainpanel.add(lblVisitor, BorderLayout.NORTH);
			mainpanel.add(btnBack, BorderLayout.LINE_START);
			mainpanel.add(btnSave, BorderLayout.LINE_END);

			mainpanel.setBackground(new Color(45, 45, 45));
		//**************************************************************************************************************

		//**************************************************************************************************************
		// ADDING ALL THE DETAILS
			DefaultTableModel model = new DefaultTableModel();
			model.addColumn("<HTML><h3>Visitor ID</h3></HTML>");
			model.addColumn("<HTML><h3>Name</h3></HTML>");
			model.addColumn("<HTML><h3>Email</h3></HTML>");
			model.addColumn("<HTML><h3>ID Type</h3></HTML>");
			model.addColumn("<HTML><h3>ID</h3></HTML>");
			model.addColumn("<HTML><h3>Contact</h3></HTML>");
			model.addColumn("<HTML><h3>Host Name</h3></HTML>");
			model.addColumn("<HTML><h3>Host Email</h3></HTML>");
			model.addColumn("<HTML><h3>Days of Stay</h3></HTML>");
			model.addColumn("<HTML><h3>Staying Place</h3></HTML>");

			//for(int i=0; i<hashmap.length(); i+=1)
				// model.addRow(new Object[]{code.hmUser_data.get(key_contact).get(0),
				// 						  code.hmUser_data.get(key_contact).get(1),
				// 						  code.hmUser_data.get(key_contact).get(7),
				// 						  code.hmUser_data.get(key_contact).get(2),
				// 						  code.hmUser_data.get(key_contact).get(3),
				// 						  code.hmUser_data.get(key_contact).get(4),
				// 						  code.hmUser_data.get(key_contact).get(5),
				// 						  code.hmUser_data.get(key_contact).get(6),
				// 						  code.hmUser_data.get(key_contact).get(8),
				// 						  });
			model.addRow(new Object[]{"abcdef", "Aniket Gupta", "aniketgupta@gmail.com", "Aadhar Card", "0000 0000 0000", "7192848288", "Aviral Gupta", "iit2019157@iiita.ac.in", "5", "BH-5"});
			table = new JTable(model);
			mainpanel.add(new JScrollPane(table), BorderLayout.CENTER);
			
		//**************************************************************************************************************
		
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
		adminpage obj = new adminpage();
		obj.display();
	}
}
