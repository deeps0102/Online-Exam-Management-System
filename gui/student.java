package gui;

import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import java.io.*;
import gui.loginpage;
import base.Database;

public class student extends JFrame implements ActionListener
{
    private JFrame frame;
    private JPanel panel;
    private JButton myaccount,logoutbutton, editprofile, resultlist, startexam, contactus,aboutus ;
    private String userID;
    private Database obj = new Database();

    public student(String userid)
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
        editprofile.setBounds(0, 38,130,38);
        editprofile. setBackground(new Color(128,128,128));
        editprofile.setForeground(new Color(0,0,0));
        editprofile.setFont(new Font("Times New Roman", Font.PLAIN,17));
        panel.add(editprofile);
        editprofile.addActionListener(this);

        startexam = new JButton("Start Exam");
        startexam.setBounds(130, 38,130,38);
        startexam. setBackground(new Color(128,128,128));
        startexam.setForeground(new Color(0,0,0));
        startexam.setFont(new Font("Times New Roman", Font.PLAIN,17));
        panel.add(startexam);
        startexam.addActionListener(this);

        resultlist = new JButton("Result List");
        resultlist.setBounds(260, 38,130,38);
        resultlist. setBackground(new Color(128,128,128));
        resultlist.setForeground(new Color(0,0,0));
        resultlist.setFont(new Font("Times New Roman", Font.PLAIN,17));
        panel.add(resultlist);
        resultlist.addActionListener(this);

        contactus = new JButton("Contact Us");
        contactus.setBounds(390, 38,130,38);
        contactus. setBackground(new Color(128,128,128));
        contactus.setForeground(new Color(0,0,0));
        contactus.setFont(new Font("Times New Roman", Font.PLAIN,17));
        panel.add(contactus);
        contactus.addActionListener(this);

        aboutus = new JButton("About Us");
        aboutus.setBounds(520, 38,130,38);
        aboutus. setBackground(new Color(128,128,128));
        aboutus.setForeground(new Color(0,0,0));
        aboutus.setFont(new Font("Times New Roman", Font.PLAIN,17));
        panel.add(aboutus);
        aboutus.addActionListener(this);

        ImageIcon img = new ImageIcon("./gui/png/studentBG.png");

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
        else if(e.getSource()==resultlist)
        {
            new resultlist(userID);
            frame.dispose();
        }
        else if(e.getSource()==startexam)
        {
            new startexam(userID);
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

}
