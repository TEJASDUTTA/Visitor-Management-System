import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class admin_login
{
    static JFrame frame;
    static JPanel panel = new JPanel(new GridLayout(7,1)), panel1=new JPanel(new GridLayout(1,1)), mp = new JPanel(new GridLayout(1,2));
    static JLabel lblWelcome, lblPass;
    static JTextField txtUser;
    static JPasswordField txtPass;
    static JButton btnLogin, btnAdmin, btnSecurity;
    static JCheckBox show_pass;

    static void display()
    {
        //masterframe = new JFrame("master");
        frame = new JFrame("ADMIN LOGIN");
        lblWelcome = new JLabel("<HTML><h2>Welcome Back!</h2></HTML>", JLabel.CENTER);
        lblPass = new JLabel("<HTML><h3>Enter Admin Password:</h3></HTML>");
        txtPass = new JPasswordField(60);

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
        frame.add(panel);
        frame.setSize(550,350);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    static class CustomActionListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            String password = txtPass.getText();
            if (password.trim().equals("pass")){
                JOptionPane.showMessageDialog(null, "Login successful");
            }
            else{
                JOptionPane.showMessageDialog(null, "Incorrect Password");
            }
        }
    }   
    public static void main(String []args)
    {
        admin_login obj = new admin_login();
        obj.display();
    }
}