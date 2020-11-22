package gui;

import java.io.*; 
import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import base.Connect;
import base.Database;
import base.Exams;

public class addexam extends JFrame implements ActionListener
{
    private JFrame frame;
    private JPanel panel;
    private String userID;
    private JButton logoutbutton,dash,submit;
    private JTextField examslb,dateslb;
    private Database obj = new Database();
    private Connect con = new Connect();
    private Exams myexam = new Exams();

    public addexam(String userId)
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

        JLabel head = new JLabel("ADD EXAM");
        head.setBounds(400,260,300,50);
        head.setForeground(Color.BLACK);
        head.setFont(new Font("Times New Roman",  Font.BOLD,30));
        panel.add(head);

        JLabel examsl=new JLabel("Exam Name");
        examsl.setBounds(320,370,150,35);
        examsl.setForeground(new Color(0, 0, 0));
        examsl.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(examsl);
        examslb=new JTextField();
        examslb.setBounds(520,370,150,30);
        panel.add(examslb);

        JLabel datesl=new JLabel("Exam Date");
        datesl.setBounds(320,420,150,35);
        datesl.setForeground(new Color(0, 0, 0));
        datesl.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(datesl);
        dateslb=new JTextField();
        dateslb.setBounds(520,420,150,30);
        panel.add(dateslb);

        logoutbutton = new JButton("Logout");
        logoutbutton.setBounds(870,0,130,39);
        logoutbutton. setBackground(new Color(0,0,0));
        logoutbutton.setForeground(new Color(255,255,255));
        logoutbutton.setFont(new Font("Times New Roman", Font.PLAIN,20));
        panel.add(logoutbutton);
        logoutbutton.addActionListener(this);

        dash = new JButton("Back");
        dash.setBounds(0,0,100,39);
        dash. setBackground(new Color(0,0,0));
        dash.setForeground(new Color(255,255,255));
        dash.setFont(new Font("Times New Roman", Font.PLAIN,18));
        panel.add(dash);
        dash.addActionListener(this);

        submit = new JButton("Submit");
        submit.setBounds(450,520,100,38);
        submit. setBackground(new Color(0,173,206));
        submit.setForeground(new Color(255,255,255));
        submit.setFont(new Font("Times New Roman", Font.PLAIN,18));
        panel.add(submit);
        submit.addActionListener(this);

        ImageIcon img = new ImageIcon("./gui/png/examBG.png");

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
            new admin(userID);
            frame.dispose();
        }
        else if(e.getSource()==submit)
        {
            myexam.setexamName(examslb.getText());
            myexam.setexamDate(dateslb.getText());

            String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            myexam.setcreateddt(date);

            boolean b = true;

            if(examslb.getText().equals("") || dateslb.getText().equals(""))
                b=false;

            if(b)
            {
                JOptionPane.showMessageDialog(panel,"EXAM ADDED SUCCESSFULLY !");
                con.add_exam(userID,myexam);
            }
            else
                JOptionPane.showMessageDialog(panel,"COULD NOT ADD EXAM !\n INVALID DETAILS ENTERED");
            
        }
    }
}
