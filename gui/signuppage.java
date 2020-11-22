package gui;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import base.Connect;
import base.Database;
import base.User;

public class signuppage extends JFrame implements ActionListener
{
    private JFrame frame;
    private JLabel user,password,cpassword,userid,email,mobnumber,dateob,gender,rolename;
    private JPanel panel;
    private JTextField userb,useridb,emailb,mobnumberb,dateobb,genderb;
    private JPasswordField passwordb,cpasswordb;
    private JButton home,submit;
    private String[] arr={"Admin","Student"};
    private JComboBox combobox;
    private User newUser = new User();
    private Connect con = new Connect();
    private Database obj = new Database();

    public signuppage()
    {
        newUser.setType("admin");
    
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
        
        user=new JLabel("USERNAME");
        user.setBounds(250,100,200,35);
        user.setForeground(new Color(0, 0, 0));
        user.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(user);
        userb=new JTextField();
        userb.setBounds(520,100,200,30);
        panel.add(userb);

        userid=new JLabel("ROLL NUMBER");
        userid.setBounds(250,155,200,35);
        userid.setForeground(new Color(0, 0, 0));
        userid.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(userid);
        useridb=new JTextField();
        useridb.setBounds(520,155,200,30);
        panel.add(useridb);

        email=new JLabel("EMAIL");
        email.setBounds(250,210,200,35);
        email.setForeground(new Color(0, 0, 0));
        email.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(email);
        emailb=new JTextField();
        emailb.setBounds(520,210,200,30);
        panel.add(emailb);

        mobnumber=new JLabel("MOBILE NUMBER");
        mobnumber.setBounds(250,265,200,35);
        mobnumber.setForeground(new Color(0, 0, 0));
        mobnumber.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(mobnumber);
        mobnumberb=new JTextField();
        mobnumberb.setBounds(520,265,200,30);
        panel.add(mobnumberb);

        dateob=new JLabel("DATE OF BIRTH");
        dateob.setBounds(250,320,200,35);
        dateob.setForeground(new Color(0, 0, 0));
        dateob.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(dateob);
        dateobb=new JTextField();
        dateobb.setBounds(520,320,200,30);
        panel.add(dateobb);

        gender=new JLabel("GENDER");
        gender.setBounds(250,375,200,35);
        gender.setForeground(new Color(0, 0, 0));
        gender.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(gender);
        genderb=new JTextField();
        genderb.setBounds(520,375,200,30);
        panel.add(genderb);

        rolename=new JLabel("ROLE NAME");
        rolename.setBounds(250,430,200,35);
        rolename.setForeground(new Color(0, 0, 0));
        rolename.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(rolename);
        combobox = new JComboBox(arr);
        combobox.setBounds(520,430,200,30);
        panel.add(combobox);
        combobox.addActionListener(this);

        password=new JLabel("SET PASSWORD");
        password.setBounds(250,485,200,35);
        password.setForeground(new Color(0, 0, 0));
        password.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(password);
        passwordb=new JPasswordField();
        passwordb.setBounds(520,485,200,30);
        panel.add(passwordb);

        cpassword=new JLabel("CONFIRM PASSWORD");
        cpassword.setBounds(250,540,220,35);
        cpassword.setForeground(new Color(0, 0, 0));
        cpassword.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(cpassword);
        cpasswordb=new JPasswordField();
        cpasswordb.setBounds(520,540,200,30);
        panel.add(cpasswordb);

        submit = new JButton("Sign Up");
        submit.setBounds(430, 630,110,30);
        submit. setBackground(Color.BLACK);
        submit.setForeground(new Color(255,255,255));
        submit.setFont(new Font("Times New Roman", Font.PLAIN,15));
        panel.add(submit);
        submit.addActionListener(this);

        home = new JButton("Home");
        home.setBounds(870,0,130,40);
        home. setBackground(Color.BLACK);
        home.setForeground(new Color(255,255,255));
        home.setFont(new Font("Times New Roman", Font.PLAIN,25));
        panel.add(home);
        home.addActionListener(this);

        ImageIcon img = new ImageIcon("./gui/png/signupBG.png");

        JLabel background = new JLabel();
        background.setIcon(img);
        background.setBounds(0,0,1000,800);
        panel.add(background);

        frame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==home)
        {
            loginpage p=new loginpage();
            frame.dispose();
        }
        
        if(e.getSource()==combobox)
        {
            newUser.setType(String.valueOf(combobox.getSelectedItem()));
            
        }
        if(e.getSource()==submit)
        {
            
            newUser.setUserName(userb.getText());
            newUser.setUserId(useridb.getText());
            newUser.setEmail(new String(emailb.getText()));
            newUser.setContact(mobnumberb.getText());
            newUser.setdob(dateobb.getText());
            newUser.setgender(genderb.getText());
            newUser.setPassword(String.valueOf(passwordb.getPassword()));
            
            String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            newUser.setcreateddt(date);
            
            boolean b=true;
            
            
            if(String.valueOf(passwordb.getPassword()).equals(String.valueOf(cpasswordb.getPassword())) && emailb.getText().endsWith(".com") && emailb.getText().contains("@") && (!emailb.getText().startsWith("@")))
                b=true;
            else
                b=false;
            
            
            if(userb.getText().equals("") || useridb.getText().equals("") || emailb.getText().equals("") || mobnumberb.getText().equals("") || dateobb.getText().equals("") || genderb.getText().equals("") || String.valueOf(passwordb.getPassword()).equals("")  )               
                b=false;
            
            if(con.checkunique(useridb.getText(), emailb.getText())==false)
                b=false;

            if(b)
            {
                JOptionPane.showMessageDialog(panel,"SIGN UP SUCCESSFUL !");
                con.add_user(newUser);
            }
            else
            {
                JOptionPane.showMessageDialog(panel,"SIGN UP UNSUCCESSFUL !\n INVALID CREDENTIALS ENTERED");
            }

        }
        
        
    }

}
