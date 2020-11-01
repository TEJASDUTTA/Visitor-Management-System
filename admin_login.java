import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class admin_login extends JFrame implements ActionListener{

    JFrame f;
    JLabel lblPass;
    JTextField t1;
    JPasswordField txtPass;
    JButton btnLogin,b2;

    admin_login(){

        super("Admin Login");

        setBackground(Color.white);
        setLayout(null);
        
        // Password Label
        lblPass = new JLabel("Password");
        lblPass.setBounds(40,70,100,30);
        add(lblPass);
 
        // Password Field
        txtPass=new JPasswordField();
        txtPass.setBounds(150,70,150,30);
        add(txtPass);
        
        // Inserting image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("vms.jpeg"));
        Image i2 = i1.getImage().getScaledInstance(170,170,Image.SCALE_DEFAULT);
        ImageIcon i3 =  new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(350,20,150,150);
        add(l3);

        // Login Button
        btnLogin = new JButton("Login");
        btnLogin.setBounds(140,180,120,30);
        btnLogin.setFont(new Font("serif",Font.BOLD,15));
        btnLogin.addActionListener(this);
        btnLogin.setBackground(Color.BLACK);
        btnLogin.setForeground(Color.WHITE);
        add(btnLogin);

        // Show password
        JCheckBox show_pass = new JCheckBox("Show password");
        show_pass.setBounds(40,120,200,30);
        add(show_pass);

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
        
        getContentPane().setBackground(Color.WHITE);

        setVisible(true);
        setSize(600,300);
        setLocation(500,300);

    }
    // Password checking
    public void actionPerformed(ActionEvent ae){
        String password = txtPass.getText();
        if (password.trim().equals("pass")){
            JOptionPane.showMessageDialog(null, "Login successful");
        }
        else{
            JOptionPane.showMessageDialog(null, "Incorrect Password");
            //setVisible(false);
        }
        
    }
    public static void main(String[] arg){
        admin_login l = new admin_login();
    }
}