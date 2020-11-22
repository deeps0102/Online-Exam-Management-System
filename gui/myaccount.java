package gui;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.border.Border;
import base.Connect;
import base.User;
import base.Database;

public class myaccount extends JFrame implements ActionListener
{
    private JFrame frame;
    private JLabel user,userid,role,email,mobnumber,dateob,gender,userb,emailb,mobnumberb,dateobb,genderb,useridb, roleb;
    private JPanel panel;
    private JButton logoutbutton, dash;
    private String userID;
    private int type;
    private User myUser;
    private Connect con = new Connect();
    private Database obj = new Database();

    public myaccount(String userId)
    {
        userID = userId;
        myUser = con.get_user(userID);

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

        Border blackline = BorderFactory.createLineBorder(Color.black);

        logoutbutton = new JButton("Logout");
        logoutbutton.setBounds(870,0,130,38);
        logoutbutton. setBackground(new Color(0,0,0));
        logoutbutton.setForeground(new Color(255,255,255));
        logoutbutton.setFont(new Font("Times New Roman", Font.PLAIN,20));
        panel.add(logoutbutton);
        logoutbutton.addActionListener(this);
        
        user=new JLabel("NAME");
        user.setBounds(260,200,200,35);
        user.setForeground(new Color(0, 0, 0));
        user.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(user);
        userb=new JLabel("    " + String.valueOf(myUser.getUserName()));
        userb.setBounds(520,200,200,30);
        userb.setForeground(new Color(0, 0, 0));
        userb.setBackground(new Color(192,192,192));
        userb.setOpaque(true);
        userb.setBorder(blackline);
        userb.setFont(new Font("Times New Roman",  Font.BOLD,15));
        panel.add(userb);
       
        userid=new JLabel("ROLL NUMBER");
        userid.setBounds(260,260,200,35);
        userid.setForeground(new Color(0, 0, 0));
        userid.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(userid);
        useridb=new JLabel("    " + String.valueOf(myUser.getUserId()));
        useridb.setBounds(520,260,200,30);
        useridb.setForeground(new Color(0, 0, 0));
        useridb.setBackground(new Color(192,192,192));
        useridb.setOpaque(true);
        useridb.setBorder(blackline);
        useridb.setFont(new Font("Times New Roman",  Font.BOLD,15));
        panel.add(useridb);
    
        mobnumber=new JLabel("MOBILE NUMBER");
        mobnumber.setBounds(260,320,200,35);
        mobnumber.setForeground(new Color(0, 0, 0));
        mobnumber.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(mobnumber);
        mobnumberb=new JLabel("    " + String.valueOf(myUser.getContact()));
        mobnumberb.setBounds(520,320,200,30);
        mobnumberb.setForeground(new Color(0, 0, 0));
        mobnumberb.setBackground(new Color(192,192,192));
        mobnumberb.setOpaque(true);
        mobnumberb.setBorder(blackline);
        mobnumberb.setFont(new Font("Times New Roman",  Font.BOLD,15));
        panel.add(mobnumberb);
       
        dateob=new JLabel("DATE OF BIRTH");
        dateob.setBounds(260,380,200,35);
        dateob.setForeground(new Color(0, 0, 0));
        dateob.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(dateob);
        dateobb=new JLabel("    " + String.valueOf(myUser.getdob()));
        dateobb.setBounds(520,380,200,30);
        dateobb.setForeground(new Color(0, 0, 0));
        dateobb.setBackground(new Color(192,192,192));
        dateobb.setOpaque(true);
        dateobb.setBorder(blackline);
        dateobb.setFont(new Font("Times New Roman",  Font.BOLD,15));
        panel.add(dateobb);

        gender=new JLabel("GENDER");
        gender.setBounds(260,440,200,35);
        gender.setForeground(new Color(0, 0, 0));
        gender.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(gender);
        genderb=new JLabel("    " + String.valueOf(myUser.getgender()));
        genderb.setBounds(520,440,200,30);
        genderb.setForeground(new Color(0, 0, 0));
        genderb.setBackground(new Color(192,192,192));
        genderb.setOpaque(true);
        genderb.setBorder(blackline);
        genderb.setFont(new Font("Times New Roman",  Font.BOLD,15));
        panel.add(genderb);
       
        email=new JLabel("EMAIL");
        email.setBounds(260,500,200,35);
        email.setForeground(new Color(0, 0, 0));
        email.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(email);
        emailb=new JLabel("    " + String.valueOf(myUser.getEmail()));
        emailb.setBounds(520,500,200,30);
        emailb.setForeground(new Color(0, 0, 0));
        emailb.setBackground(new Color(192,192,192));
        emailb.setOpaque(true);
        emailb.setBorder(blackline);
        emailb.setFont(new Font("Times New Roman",  Font.BOLD,15));
        panel.add(emailb);

        role=new JLabel("USER TYPE");
        role.setBounds(260,560,220,35);
        role.setForeground(new Color(0, 0, 0));
        role.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(role);
        roleb=new JLabel("    " + String.valueOf(myUser.getType()));
        roleb.setBounds(520,560,200,30);
        roleb.setForeground(new Color(0, 0, 0));
        roleb.setBackground(new Color(192,192,192));
        roleb.setOpaque(true);
        roleb.setBorder(blackline);
        roleb.setFont(new Font("Times New Roman",  Font.BOLD,15));
        panel.add(roleb);

        dash = new JButton("Back");
        dash.setBounds(0,0,100,38);
        dash. setBackground(new Color(0,0,0));
        dash.setForeground(new Color(255,255,255));
        dash.setFont(new Font("Times New Roman", Font.PLAIN,18));
        panel.add(dash);
        dash.addActionListener(this);

        ImageIcon img = new ImageIcon("./gui/png/editpro.png");

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
            type = con.check_role(userID);
            if(type==1)
                new admin(userID);
            else if(type==0)
                new student(userID);
            frame.dispose();
        }
        
    }


}
