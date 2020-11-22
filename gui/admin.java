package gui;

import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import java.io.*;
import gui.loginpage;
import base.Database;

public class admin extends JFrame implements ActionListener
{
    private JFrame frame;
    private JPanel panel;
    private JButton myaccount, logoutbutton, editprofile, addques, addexam, contactus,aboutus ;
    private String userID;
    private Database obj = new Database();

    public admin(String userid)
    {
        userID = userid;
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

        logoutbutton = new JButton("Logout");
        logoutbutton.setBounds(870,0,130,38);
        logoutbutton. setBackground(new Color(0,0,0));
        logoutbutton.setForeground(new Color(255,255,255));
        logoutbutton.setFont(new Font("Times New Roman", Font.PLAIN,20));
        panel.add(logoutbutton);
        logoutbutton.addActionListener(this);

        myaccount = new JButton("My Account");
        myaccount.setBounds(720,0,150,38);
        myaccount. setBackground(new Color(0,0,0));
        myaccount.setForeground(new Color(255,255,255));
        myaccount.setFont(new Font("Times New Roman", Font.PLAIN,18));
        panel.add(myaccount);
        myaccount.addActionListener(this);

        editprofile = new JButton("Edit Profile");
        editprofile.setBounds(0, 39,130,38);
        editprofile. setBackground(new Color(128,128,128));
        editprofile.setForeground(new Color(0,0,0));
        editprofile.setFont(new Font("Times New Roman", Font.PLAIN,17));
        panel.add(editprofile);
        editprofile.addActionListener(this);

        addexam = new JButton("Add Exam");
        addexam.setBounds(130, 39,130,38);
        addexam. setBackground(new Color(128,128,128));
        addexam.setForeground(new Color(0,0,0));
        addexam.setFont(new Font("Times New Roman", Font.PLAIN,17));
        panel.add(addexam);
        addexam.addActionListener(this);

        addques = new JButton("Add Question");
        addques.setBounds(260, 39,150,38);
        addques. setBackground(new Color(128,128,128));
        addques.setForeground(new Color(0,0,0));
        addques.setFont(new Font("Times New Roman", Font.PLAIN,17));
        panel.add(addques);
        addques.addActionListener(this);

        contactus = new JButton("Contact Us");
        contactus.setBounds(410, 39,130,38);
        contactus. setBackground(new Color(128,128,128));
        contactus.setForeground(new Color(0,0,0));
        contactus.setFont(new Font("Times New Roman", Font.PLAIN,17));
        panel.add(contactus);
        contactus.addActionListener(this);

        aboutus = new JButton("About Us");
        aboutus.setBounds(540, 39,130,38);
        aboutus. setBackground(new Color(128,128,128));
        aboutus.setForeground(new Color(0,0,0));
        aboutus.setFont(new Font("Times New Roman", Font.PLAIN,17));
        panel.add(aboutus);
        aboutus.addActionListener(this);

        ImageIcon img = new ImageIcon("./gui/png/adminBG.png");

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
        if(e.getSource()==myaccount)
        {
            new myaccount(userID);
            frame.dispose();
        }
        else if(e.getSource()==editprofile)
        {
            new editprofile(userID);
            frame.dispose();
        }
        else if(e.getSource()==addexam)
        {
            new addexam(userID);
            frame.dispose();
        }
        else if(e.getSource()==addques)
        {
            new addques(userID);
            frame.dispose();
        }
        else if(e.getSource()==contactus)
        {
            new contactus(userID);
            frame.dispose();
        }
        else if(e.getSource()==aboutus)
        {
            new aboutus(userID);
            frame.dispose();
        }

    }

    public static void main(String Args[])
    {
        new admin("array");
    }
}
