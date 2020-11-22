package gui;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import base.Connect;
import base.User;
import base.Database;

public class editprofile extends JFrame implements ActionListener
{
    private JFrame frame;
    private JLabel user,password,cpassword,email,mobnumber,dateob,gender;
    private JPanel panel;
    private JTextField userb,emailb,mobnumberb,dateobb,genderb;
    private JPasswordField passwordb,cpasswordb;
    private JButton update, logoutbutton, dash;
    private String userID;
    private int role;
    private User myUser = new User();
    private Connect con = new Connect();
    private Database obj = new Database();

    public editprofile(String userId)
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

        logoutbutton = new JButton("Logout");
        logoutbutton.setBounds(870,0,130,38);
        logoutbutton. setBackground(new Color(0,0,0));
        logoutbutton.setForeground(new Color(255,255,255));
        logoutbutton.setFont(new Font("Times New Roman", Font.PLAIN,20));
        panel.add(logoutbutton);
        logoutbutton.addActionListener(this);
        
        user=new JLabel("USERNAME");
        user.setBounds(260,200,200,35);
        user.setForeground(new Color(0, 0, 0));
        user.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(user);
        userb=new JTextField();
        userb.setBounds(520,200,200,30);
        panel.add(userb);

        email=new JLabel("EMAIL");
        email.setBounds(260,260,200,35);
        email.setForeground(new Color(0, 0, 0));
        email.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(email);
        emailb=new JTextField();
        emailb.setBounds(520,260,200,30);
        panel.add(emailb);

        mobnumber=new JLabel("MOBILE NUMBER");
        mobnumber.setBounds(260,320,200,35);
        mobnumber.setForeground(new Color(0, 0, 0));
        mobnumber.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(mobnumber);
        mobnumberb=new JTextField();
        mobnumberb.setBounds(520,320,200,30);
        panel.add(mobnumberb);

        dateob=new JLabel("DATE OF BIRTH");
        dateob.setBounds(260,380,200,35);
        dateob.setForeground(new Color(0, 0, 0));
        dateob.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(dateob);
        dateobb=new JTextField();
        dateobb.setBounds(520,380,200,30);
        panel.add(dateobb);

        gender=new JLabel("GENDER");
        gender.setBounds(260,440,200,35);
        gender.setForeground(new Color(0, 0, 0));
        gender.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(gender);
        genderb=new JTextField();
        genderb.setBounds(520,440,200,30);
        panel.add(genderb);

        password=new JLabel("NEW PASSWORD");
        password.setBounds(260,500,200,35);
        password.setForeground(new Color(0, 0, 0));
        password.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(password);
        passwordb=new JPasswordField();
        passwordb.setBounds(520,500,200,30);
        panel.add(passwordb);

        cpassword=new JLabel("CONFIRM PASSWORD");
        cpassword.setBounds(260,560,220,35);
        cpassword.setForeground(new Color(0, 0, 0));
        cpassword.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(cpassword);
        cpasswordb=new JPasswordField();
        cpasswordb.setBounds(520,560,200,30);
        panel.add(cpasswordb);

        update = new JButton("Update");
        update.setBounds(450, 650,110,30);
        update. setBackground(Color.BLACK);
        update.setForeground(new Color(255,255,255));
        update.setFont(new Font("Times New Roman", Font.PLAIN,15));
        panel.add(update);
        update.addActionListener(this);

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
            role = con.check_role(userID);
            if(role==1)
                new admin(userID);
            else if(role==0)
                new student(userID);
            frame.dispose();
        }
        else if(e.getSource()==update)
        {
            if(role==1)
                myUser.setType("admin");
            else
                myUser.setType("student");
            myUser.setUserName(userb.getText());
            myUser.setUserId(userID);
            myUser.setEmail(emailb.getText());
            myUser.setContact(mobnumberb.getText());
            myUser.setdob(dateobb.getText());
            myUser.setgender(genderb.getText());
            myUser.setPassword(String.valueOf(passwordb.getPassword()));

            String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            myUser.setcreateddt(date);

            boolean b = true;

            if(String.valueOf(passwordb.getPassword()).equals(String.valueOf(cpasswordb.getPassword())) && emailb.getText().endsWith(".com") && emailb.getText().contains("@") && (!emailb.getText().startsWith("@")))
                b=true;
            else
                b=false;
            
            if(userb.getText().equals("") || emailb.getText().equals("") || mobnumberb.getText().equals("") || dateobb.getText().equals("") || genderb.getText().equals("") || String.valueOf(passwordb.getPassword()).equals("")  )               
                b=false;
            
            /*if(con.checkunique(, emailb.getText())==false)
                b=false;*/

            if(b)
            {
                JOptionPane.showMessageDialog(panel,"PROFILE UPDATED SUCCESSFULLY !");
                con.update_user(myUser);
            }
            else
                JOptionPane.showMessageDialog(panel,"COULD NOT UPDATE PROFILE !\n INVALID CREDENTIALS ENTERED");
        }
        
    }

}
