package gui;

import java.io.*; 
import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import base.Database;
import base.Connect;

public class aboutus extends JFrame implements ActionListener
{
    private JFrame frame;
    private JPanel panel;
    private String userID;
    private JButton logoutbutton,dash;
    private int role;
    private Database obj = new Database();  
    private Connect con = new Connect();

    public aboutus(String userId)
    {
        userID = userId;
        frame=new JFrame("ONLINE EXAM MANAGEMENT");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(1000,800);
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                obj.drop();
                frame.dispose();
            }
        });

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        JLabel head = new JLabel("ABOUT US");
        head.setBounds(130,120,500,80);
        head.setForeground(new Color(0,49,82));
        head.setFont(new Font("Times New Roman",  Font.BOLD,60));
        panel.add(head);

        JLabel examsl=new JLabel("This is an online exam \nmanagement system interface");
        examsl.setBounds(110,180,500,500);
        examsl.setForeground(new Color(41,86,143));
        examsl.setFont(new Font("Times New Roman",  Font.PLAIN,25));
        panel.add(examsl);

        logoutbutton = new JButton("Logout");
        logoutbutton.setBounds(870,0,130,39);
        logoutbutton. setBackground(new Color(0,49,82));
        logoutbutton.setForeground(new Color(255,255,255));
        logoutbutton.setFont(new Font("Times New Roman", Font.PLAIN,20));
        panel.add(logoutbutton);
        logoutbutton.addActionListener(this);

        dash = new JButton("Back");
        dash.setBounds(0,0,100,39);
        dash. setBackground(new Color(0,49,82));
        dash.setForeground(new Color(255,255,255));
        dash.setFont(new Font("Times New Roman", Font.PLAIN,18));
        panel.add(dash);
        dash.addActionListener(this);

        ImageIcon img = new ImageIcon("./gui/png/about.png");

        JLabel background = new JLabel();
        background.setIcon(img);
        background.setBounds(0,0,1000,800);
        panel.add(background);

        frame.setVisible(true);
    }

     public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==logoutbutton)
        {
            new loginpage();
            frame.dispose();
        }
        else if(e.getSource()==dash)
        {
            role = con.check_role(userID);
            if(role==1)
                new admin(userID);
            else if(role==0)
                new student(userID);
            frame.dispose();
        }
    }
}
