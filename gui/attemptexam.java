package gui;

import java.io.*; 
import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import base.Connect;
import base.Database;

public class attemptexam extends JFrame implements ActionListener
{
    private JFrame frame;
    private JPanel panel;
    private String userID,examName;
    private JButton logoutbutton,submit,next,previous;
    private JLabel select;
    private JComboBox selectb;
    Boolean[] boolarray;
    String[] arr;
    String[][] questions;
    int number = 0 ;
    private Database obj = new Database();
    private Connect con = new Connect();

    public attemptexam(String userId, String examname, Boolean[] boolarr)
    {
        userID = userId;
        examName = examname;
        boolarray = boolarr;
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

        JLabel head = new JLabel("QUESTIONS");
        head.setBounds(310,240,500,100);
        head.setForeground(Color.BLACK);
        head.setFont(new Font("Times New Roman",  Font.BOLD,60));
        panel.add(head);

        logoutbutton = new JButton("Logout");
        logoutbutton.setBounds(870,0,130,42);
        logoutbutton. setBackground(new Color(0,0,0));
        logoutbutton.setForeground(new Color(255,255,255));
        logoutbutton.setFont(new Font("Times New Roman", Font.PLAIN,20));
        panel.add(logoutbutton);
        logoutbutton.addActionListener(this);

        int number = con.ques_count(examName);
        //number = 5; 

        arr = new String[number];
        questions = con.allquestions(examName);

        for(int i=0; i<number; i++)
            arr[i] = "Question " + String.valueOf(i+1);

        select=new JLabel("Select Question");
        select.setBounds(250,400,350,80);
        select.setForeground(new Color(0,65,89));
        select.setFont(new Font("Times New Roman",  Font.BOLD,25));
        panel.add(select);
        selectb = new JComboBox(arr);
        selectb.setBounds(540,415,200,40);
        selectb.setForeground(new Color(0,65,89));
        panel.add(selectb);
        selectb.addActionListener(this);

        submit = new JButton("Submit");
        submit.setBounds(460,550,100,38);
        submit. setBackground(new Color(0,173,206));
        submit.setForeground(new Color(255,255,255));
        submit.setFont(new Font("Times New Roman", Font.PLAIN,18));
        panel.add(submit);
        submit.addActionListener(this);

       

        ImageIcon img = new ImageIcon("./gui/png/questionBG.png");

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
        else if(e.getSource()==selectb)
        {
            int index=selectb.getSelectedIndex();
            new attemptques(userID,examName,index,questions[index],boolarray);
            frame.dispose();
        }
        else if(e.getSource()==submit)
        {
            int marks=0;
            for(int i=0; i<boolarray.length; i++)
            {
                if(boolarray[i]==true)
                    marks++;
            }
            con.add_result(userID,examName,marks);
            new student(userID);
            frame.dispose();
        }
    }

    /*public static void main(String Args[])
    {
        new attemptexam("array","cse");
    }*/
}
