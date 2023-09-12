package hospitalmanagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class adminlogin extends JFrame implements ActionListener {

    JButton lgin = new JButton("LOGIN");
    JTextField id;
    JPasswordField pass;

    adminlogin() {

        JLabel admid = new JLabel("ADMN ID :");
        admid.setBounds(40, 40, 1200, 60);
        admid.setFont(new Font("Sanserif", Font.PLAIN, 18));
        admid.setForeground(Color.black);
        add(admid);

        id = new JTextField();
        id.setBounds(130, 60, 130, 20);
        add(id);
        id.setFont(new Font("Acme", Font.BOLD, 16));
        id.addActionListener(this);

        JLabel admpass = new JLabel("PASSWORD :");
        admpass.setBounds(10, 80, 1200, 60);
        admpass.setFont(new Font("Sanserif", Font.PLAIN, 18));
        admpass.setForeground(Color.black);
        add(admpass);

        pass = new JPasswordField();
        pass.setBounds(130, 100, 130, 20);
        add(pass);
        pass.addActionListener(this);

        lgin.setBounds(150, 150, 70, 30);
        lgin.setForeground(Color.black);
        lgin.setBackground(Color.green);
        lgin.setFocusable(false);
        add(lgin);
        
        lgin.addActionListener(this);

        //JButton clr = new JButton("CLEAR");
        //clr.setBounds(180, 150, 80, 30);
        //clr.setForeground(Color.white);
        //clr.setBackground(Color.red);
        //clr.setFocusable(false);
        //add(clr);
        setTitle("ADMIN LOGIN");
        setLayout(null);
        setSize(400, 300);
        setLocation(400, 250);
        setVisible(true);
        //setForeground(Color.black);
        
    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            String username = id.getText();
            String password = pass.getText();
            conn c = new conn();
            String query = "select * from userlogin where username='" + username + "' and password='" + password + "'";
            ResultSet rs = c.s.executeQuery(query);

            if (rs.next()) {
                setVisible(false);
                new management();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                //
                setVisible(false);
                new adminlogin();
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public static void main(String args[]) {
        new adminlogin();
    }
}
