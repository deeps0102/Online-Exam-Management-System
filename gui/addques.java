package gui;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import base.Connect;
import base.Database;
import base.Questions;

public class addques extends JFrame implements ActionListener
{
    private JFrame frame;
    private JLabel examname,question,op1,op2,op3,op4,ans;
    private JPanel panel;
    private JTextField examnameb,questionb,op1b,op2b,op3b,op4b,ansb;
    private JButton submit, logoutbutton, dash;
    private String userID;
    private Database obj = new Database();
    private Connect con = new Connect();
    private Questions myques = new Questions();

    public addques(String userId)
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
        
        examname=new JLabel("EXAM NAME");
        examname.setBounds(260,200,200,35);
        examname.setForeground(new Color(0, 0, 0));
        examname.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(examname);
        examnameb=new JTextField();
        examnameb.setBounds(520,200,200,30);
        panel.add(examnameb);

        question=new JLabel("QUESTION");
        question.setBounds(260,260,200,35);
        question.setForeground(new Color(0, 0, 0));
        question.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(question);
        questionb=new JTextField();
        questionb.setBounds(520,260,200,30);
        panel.add(questionb);

        op1=new JLabel("OPTION 1");
        op1.setBounds(260,320,200,35);
        op1.setForeground(new Color(0, 0, 0));
        op1.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(op1);
        op1b=new JTextField();
        op1b.setBounds(520,320,200,30);
        panel.add(op1b);

        op2=new JLabel("OPTION 2");
        op2.setBounds(260,380,200,35);
        op2.setForeground(new Color(0, 0, 0));
        op2.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(op2);
        op2b=new JTextField();
        op2b.setBounds(520,380,200,30);
        panel.add(op2b);

        op3=new JLabel("OPTION 3");
        op3.setBounds(260,440,200,35);
        op3.setForeground(new Color(0, 0, 0));
        op3.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(op3);
        op3b=new JTextField();
        op3b.setBounds(520,440,200,30);
        panel.add(op3b);

        op4=new JLabel("OPTION 4");
        op4.setBounds(260,500,200,35);
        op4.setForeground(new Color(0, 0, 0));
        op4.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(op4);
        op4b=new JTextField();
        op4b.setBounds(520,500,200,30);
        panel.add(op4b);

        ans=new JLabel("CORRECT ANSWER");
        ans.setBounds(260,560,220,35);
        ans.setForeground(new Color(0, 0, 0));
        ans.setFont(new Font("Times New Roman",  Font.BOLD,18));
        panel.add(ans);
        ansb=new JTextField();
        ansb.setBounds(520,560,200,30);
        panel.add(ansb);

        submit = new JButton("SUBMIT");
        submit.setBounds(450, 650,110,30);
        submit. setBackground(Color.BLACK);
        submit.setForeground(new Color(255,255,255));
        submit.setFont(new Font("Times New Roman", Font.PLAIN,15));
        panel.add(submit);
        submit.addActionListener(this);

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
            new admin(userID);
            frame.dispose();
        }
        else if(e.getSource()==submit)
        {
            myques.setQuestion(questionb.getText());
            myques.setOpt1(op1b.getText());
            myques.setOpt2(op2b.getText());
            myques.setOpt3(op3b.getText());
            myques.setOpt4(op4b.getText());
            myques.setAns(ansb.getText());
            myques.setexamName(examnameb.getText());

            String date = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
            myques.setcreateddt(date);

            boolean b = true;
            if(questionb.getText().equals("") || op1b.getText().equals("") || op2b.getText().equals("") || op3b.getText().equals("") || op4b.getText().equals("") || ansb.getText().equals("") || examnameb.getText().equals(""))
                b=false;

            if(b)
            {
                JOptionPane.showMessageDialog(panel,"QUESTION ADDED SUCCESSFULLY !");
                con.add_question(userID,myques);
            }
            else
                JOptionPane.showMessageDialog(panel,"COULD NOT ADD QUESTION !\n INVALID INFORMATION ENTERED");
        }
        
    }
}
