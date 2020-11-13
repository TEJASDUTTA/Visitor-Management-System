//package vms;
//import java.awt.*;
//import javax.swing.*;
//import java.awt.event.*;
//
//public class admin_login extends JFrame implements ActionListener{
//
//    JFrame f;
//    JLabel lblPass;
//    JTextField t1;
//    JPasswordField txtPass;
//    JButton btnLogin,b2;
//
//    admin_login(){
//
//        super("Admin Login");
//
//        setBackground(new Color(96,96,96));
//        setLayout(null);
//
//        // Password Label
//        lblPass = new JLabel("Password");
//        lblPass.setFont(new Font("Courier New",Font.BOLD,15));
//        lblPass.setForeground(Color.black);
//        lblPass.setBounds(40,70,100,30);
//        add(lblPass);
//
//        // Password Field
//        txtPass=new JPasswordField();
//        txtPass.setEchoChar('*');
//        txtPass.setBounds(150,70,150,30);
//        add(txtPass);
//
//        // Inserting image
//        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("second.jpg"));
//        Image i2 = i1.getImage().getScaledInstance(170,170,Image.SCALE_DEFAULT);
//        ImageIcon i3 =  new ImageIcon(i2);
//        JLabel l3 = new JLabel(i3);
//        l3.setBounds(350,20,150,150);
//        add(l3);
//
//        // Login Button
//        btnLogin = new JButton("Login");
//        btnLogin.setBounds(140,180,120,30);
//        btnLogin.setFont(new Font("Courier New",Font.BOLD,15));
//        btnLogin.addActionListener(this);
//        btnLogin.setBackground(Color.BLACK);
//        btnLogin.setForeground(Color.WHITE);
//        add(btnLogin);
//
//        // Show password
//        JCheckBox show_pass = new JCheckBox("Show password");
//        show_pass.setBounds(40,120,200,30);
//        show_pass.setFont(new Font("Courier New",Font.BOLD,15));
//        show_pass.setForeground(Color.black);
//        show_pass.setBackground(new Color(96,96,96));
//        add(show_pass);
//
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
//
//        getContentPane().setBackground(new Color(96,96,96));
//
//        setVisible(true);
//        setSize(600,300);
//        setLocation(500,300);
//
//    }
//    // Password checking
//    public void actionPerformed(ActionEvent ae){
//        String password = txtPass.getText();
//        if (password.trim().equals("pass")){
//            JOptionPane.showMessageDialog(null, "Login successful");
//            setVisible(false);
//        }
//        else{
//            JOptionPane.showMessageDialog(null, "Incorrect Password");
//            //setVisible(false);
//        }
//
//    }
//    public static void main(String[] arg){
//          //admin_login l = new admin_login();
//          new admin_login().f.setVisible(true);
//    }
//}

package vms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import vms.adminpage;
public class admin_login
{
    static JFrame admin_frame;
    static JPanel panel = new JPanel(new GridLayout(7,1)), panel1=new JPanel(new GridLayout(1,1)), mp = new JPanel(new GridLayout(1,2));
    static JLabel lblWelcome, lblPass;
    static JTextField txtUser;
    static JPasswordField txtPass;
    static JButton btnLogin, btnAdmin, btnSecurity;
    static JCheckBox show_pass;

    admin_login()
    {
        //masterframe = new JFrame("master");
        admin_frame = null;
        admin_frame = new JFrame("ADMIN LOGIN");
        //admin_frame.getContentPane().setLayout(null);
        
        lblWelcome = new JLabel("<HTML><h2>Welcome Back!</h2></HTML>", JLabel.CENTER);
        lblPass = new JLabel("<HTML><h3>Enter Admin Password:</h3></HTML>");
        txtPass = new JPasswordField(60);
        txtPass.setEchoChar('*');

        show_pass = new JCheckBox("Show password");
        show_pass.setBackground(new Color(45,45,45));
        show_pass.setForeground(new Color(52,119,235));
        show_pass.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e){
                if (e.getStateChange() == ItemEvent.SELECTED){
                    txtPass.setEchoChar((char)0);
                }
                else{
                    txtPass.setEchoChar('*');
                }
            }
        });

        lblWelcome.setForeground(new Color(52,119,235));
        lblPass.setForeground(new Color(52,119,235));

        btnLogin = new JButton("Login");
        btnLogin.setBackground(new Color(52,119,235));
        btnLogin.addActionListener(new CustomActionListener());

        panel.add(lblWelcome);
        panel.add(lblPass);
        panel.add(txtPass);
        panel.add(show_pass);
        panel.add(btnLogin);

        panel.setBackground(new Color(45,45,45));
        admin_frame.add(panel);
        admin_frame.setSize(550,350);
        admin_frame.setVisible(true);
        
        admin_frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
    }
    static class CustomActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String password = txtPass.getText();
            if (password.trim().equals("pass")){
                JOptionPane.showMessageDialog(null, "Login successful");
                admin_frame.setVisible(false);
                //admin_frame = null;
                adminpage.init();
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect Password");
            }
        }
    }
    
    public static void init(){
        admin_login obj = new admin_login();
        //new admin_login().admin_frame.setVisible(true);
    }
    public static void main(String []args)
    {
        init();
        //new admin_login().admin_frame.setVisible(true);
//        admin_login l = new admin_login();
    }
}