package vms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;
import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.swing.table.*;

// Importing classes
import vms.lol;
import vms.update_details;
public class adminpage
{
	static JFrame frame;
	static JPanel panel, panel1, panel2, mainpanel;
	static JLabel lblVisitor, lblGroup, lblEnRoll;
	static JButton btnBack;
	static JTable table;
        static Map <String, ArrayList<String>> hashmap = new <String, ArrayList<String>> HashMap();
        static String key_contact = lol.contact;
        static DefaultTableModel model;
        
	static void display()
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
			btnBack.setBackground(new Color(52,119,235));
			btnBack.addActionListener(new CustomActionListener());

			mainpanel.add(lblVisitor, BorderLayout.NORTH);
			mainpanel.add(btnBack, BorderLayout.LINE_START);

			mainpanel.setBackground(new Color(45, 45, 45));
		//**************************************************************************************************************

		//**************************************************************************************************************
		// ADDING ALL THE DETAILS
			model = new DefaultTableModel();
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
                
                
                if(update_details.flag == 0){
                    hashmap = lol.hmUser_data;
                    for(int i=0; i<hashmap.size(); i+=1)
                             model.addRow(new Object[]{lol.hmUser_data.get(key_contact).get(4),
                                                                              lol.hmUser_data.get(key_contact).get(0),
                                                                              lol.hmUser_data.get(key_contact).get(1),
                                                                              lol.hmUser_data.get(key_contact).get(7),
                                                                              lol.hmUser_data.get(key_contact).get(2),
                                                                              lol.hmUser_data.get(key_contact).get(3),
                                                                              lol.hmUser_data.get(key_contact).get(4),
                                                                              lol.hmUser_data.get(key_contact).get(5),
                                                                              lol.hmUser_data.get(key_contact).get(6),
                                                                              lol.hmUser_data.get(key_contact).get(8),
                                                                              });
                }
                else{
                    hashmap = update_details.hmUser_data;
                    for(int i=0; i<hashmap.size(); i+=1)
                             model.addRow(new Object[]{update_details.hmUser_data.get(key_contact).get(4),
                                                                              update_details.hmUser_data.get(key_contact).get(0),
                                                                              update_details.hmUser_data.get(key_contact).get(1),
                                                                              update_details.hmUser_data.get(key_contact).get(7),
                                                                              update_details.hmUser_data.get(key_contact).get(2),
                                                                              update_details.hmUser_data.get(key_contact).get(3),
                                                                              update_details.hmUser_data.get(key_contact).get(4),
                                                                              update_details.hmUser_data.get(key_contact).get(5),
                                                                              update_details.hmUser_data.get(key_contact).get(6),
                                                                              update_details.hmUser_data.get(key_contact).get(8),
                                                                              });
                }
	        table = new JTable(model);
	        mainpanel.add(new JScrollPane(table), BorderLayout.CENTER);
			
		//**************************************************************************************************************
		
		frame.add(mainpanel);
		frame.setSize(1920,1080);
		frame.setVisible(true);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	static class CustomActionListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			Object msg = e.getSource();
                        if(msg.equals(btnBack)){
                            frame.setVisible(false);
                        }
		}
	}
        public static void init(){
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

	public static void main(String []args)
	{
            init();
        }	
}