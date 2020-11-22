package gui;

import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import base.Connect;
import base.Database;

public class loginpage extends JFrame implements ActionListener
{
    private JFrame frame;
    private JPanel panel;
    private JButton signin,signup;
    
    private JTextField usertext;
    private JPasswordField passwordtext;
    
    private String userID,password;
    private Database obj = new Database();

    public loginpage()
    {
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

        JLabel userlabel=new JLabel("USER ID");
        userlabel.setBounds(320,390,150,35);
        userlabel.setForeground(new Color(0, 0, 0));
        userlabel.setFont(new Font("Times New Roman",  Font.BOLD,25));
        panel.add(userlabel);

        JLabel passwordlabel=new JLabel("PASSWORD");
        passwordlabel.setBounds(320,470,180,35);
        passwordlabel.setForeground(new Color(0, 0, 0));
        passwordlabel.setFont(new Font("Times New Roman",  Font.BOLD,25));
        panel.add(passwordlabel);

        usertext=new JTextField();
        usertext.setBounds(520,380,150,40);
        panel.add(usertext);
        
        passwordtext=new JPasswordField();
        passwordtext.setBounds(520,460,150,40);
        panel.add(passwordtext);

        signin=new JButton("Sign In");
        signin.setBounds(320,550,120,40);
        signin. setBackground(Color.BLACK);
        signin.setForeground(new Color(255,255,255));
        signin.setFont(new Font("Times New Roman", Font.PLAIN,20));
        panel.add(signin);
        signin.addActionListener(this);

        signup=new JButton("Sign Up");
        signup.setBounds(540,550,120,40);
        signup. setBackground(new Color(0,0,0));
        signup.setForeground(new Color(255,255,255));
        signup.setFont(new Font("Times New Roman", Font.PLAIN,20));
        panel.add(signup);
        signup.addActionListener(this);

        ImageIcon img = new ImageIcon("./gui/png/loginBG.png");

        JLabel background = new JLabel();
        background.setIcon(img);
        background.setBounds(0,0,1000,800);
        panel.add(background);

        frame.setVisible(true);

    }
    public void actionPerformed(ActionEvent e)
    {
    
        if(e.getSource()==signin)
        {
            Connect con = new Connect();
            userID=usertext.getText();     //string variable to check in database the id entered s correct or not.
            password=String.valueOf(passwordtext.getPassword());       // string variable to check in database, the value entered is correct or not
            int valid = con.check_registered(userID,password);
            if(valid==-1)
            {
                JOptionPane.showMessageDialog(panel,"INVALID CREDENTIALS");
                new loginpage();
            }
            else if(valid==0)
                new admin(userID);
            else if(valid==1)
                new student(userID);
            frame.dispose();
        }
        if(e.getSource()==signup)
        {
            signuppage s = new signuppage();
            frame.dispose();
        }      
    }
}
