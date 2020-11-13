package vms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// Import class files
//import vms.code;
import vms.lol;
import vms.update_details;
public class user_login_2
{
    static JFrame user_frame;
    static JPanel panel = new JPanel(new GridLayout(7,1)), panel1=new JPanel(new GridLayout(1,1)), mp = new JPanel(new GridLayout(1,2));
    static JLabel lblWelcome, lblPass;
    static JTextField txtUser;
    static JPasswordField txtPass;
    static JButton btnLogin, btnAdmin, btnSecurity;
    static JCheckBox show_pass;

    user_login_2()
    {
        //masterframe = new JFrame("master");
        
        user_frame = new JFrame("USER LOGIN");
        
        lblWelcome = new JLabel("<HTML><h2>Enter your contact number for verification</h2></HTML>", JLabel.CENTER);
        lblPass = new JLabel("<HTML><h3>Contact Number:</h3></HTML>");
        txtPass = new JPasswordField(60);
        txtPass.setEchoChar('*');

//        show_pass = new JCheckBox("Show password");
//        show_pass.setBackground(new Color(45,45,45));
//        show_pass.setForeground(new Color(52,119,235));
//        show_pass.addItemListener(new ItemListener(){
//            public void itemStateChanged(ItemEvent e){
//                if (e.getStateChange() == ItemEvent.SELECTED){
//                    txtPass.setEchoChar((char)0);
//                }
//                else{
//                    txtPass.setEchoChar('*');
//                }
//            }
//        });

        lblWelcome.setForeground(new Color(52,119,235));
        lblPass.setForeground(new Color(52,119,235));

        btnLogin = new JButton("View Details");
        btnLogin.setBackground(new Color(52,119,235));
        btnLogin.addActionListener(new CustomActionListener());

        panel.add(lblWelcome);
        panel.add(lblPass);
        panel.add(txtPass);
        //panel.add(show_pass);
        panel.add(btnLogin);

        panel.setBackground(new Color(45,45,45));
        user_frame.add(panel);
        user_frame.setSize(550,350);
        user_frame.setVisible(true);
        
        //admin_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    static class CustomActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String password = txtPass.getText();
            
            if (password.equals(lol.contact)){
                //JOptionPane.showMessageDialog(null, "Welcome");
                viewpage.init();
                user_frame.setVisible(false);
            }
            else{
                JOptionPane.showMessageDialog(null, "Invalid contact number");
            }
        }
    }
    
    public static void init(){
        user_login_2 obj = new user_login_2();
        //obj.user_login();

    }
    public static void main(String []args)
    {
        init();
//        new user_login().user_frame.setVisible(true);
    }
}