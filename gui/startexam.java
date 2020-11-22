package gui;
import java.util.*;
import java.io.*; 
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import base.Connect;
import base.Database;

public class startexam extends JFrame implements ActionListener
{
    private JFrame frame;
    private JPanel panel;
    private String userID,examName;
    private JButton logoutbutton,dash,submit;
    private JLabel select;
    private JComboBox selectb;
    Object[] arr;
    private Database obj = new Database();
    private Connect con = new Connect();

    public startexam(String userId)
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

        JLabel head = new JLabel("START EXAM");
        head.setBounds(400,260,300,50);
        head.setForeground(Color.BLACK);
        head.setFont(new Font("Times New Roman",  Font.BOLD,30));
        panel.add(head);

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

        ArrayList<String> data = con.allexams();
        /*ArrayList<String> data = new ArrayList<String>();
        data.add("cse");
        data.add("java");
        data.add("cp");*/

        arr = data.toArray();
        
        select=new JLabel("Select Exam");
        select.setBounds(320,400,200,35);
        select.setForeground(new Color(0,65,89));
        select.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(select);
        selectb = new JComboBox(arr);
        selectb.setBounds(510,400,180,30);
        selectb.setForeground(new Color(0,65,89));
        panel.add(selectb);
        selectb.addActionListener(this);

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
            new student(userID);
            frame.dispose();
        }
        else if(e.getSource()==selectb)
        {
        	int i=selectb.getSelectedIndex();
        	examName = String.valueOf(arr[i]);
        }
        else if(e.getSource()==submit)
        {
        	int size = arr.length;
        	Boolean[] boolarr = new Boolean[size];
        	Arrays.fill(boolarr, false);
        	new attemptexam(userID,examName,boolarr);
        	frame.dispose();
        }
    }

}
