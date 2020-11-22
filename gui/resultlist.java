package gui;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.border.TitledBorder;
import base.Connect;
import base.Database;

public class resultlist extends JFrame implements ActionListener
{
    private JFrame frame;
    private JPanel panel;
    private JButton logoutbutton, dash;
    private String userID;
    private JTable tab;
    private Database obj = new Database();
    private Connect con = new Connect();

    public resultlist(String userId)
    {
        userID = userId;
        frame=new JFrame("Online Exam Management");
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
        panel.setLayout(new BorderLayout());
        panel.setBackground(Color.BLACK);

        ArrayList<ArrayList<String>> data = con.get_result(userID);

        DefaultTableModel model = new DefaultTableModel();
        JTable tab = new JTable(model);
        tab.setBounds(100,350,800,300);
        tab.setLocation(100,350);
        tab.setBackground(new Color(51,204,204));
        tab.setForeground(new Color(0,0,0));
        tab.setRowHeight(40);
        tab.setSelectionBackground(new Color(51,204,204));
        tab.setSelectionForeground(new Color(0,0,0));
        tab.setFont(new Font("Times New Roman", Font.PLAIN,13));
        model.addColumn("Subject");
        model.addColumn("Exam Date");
        model.addColumn("Total Marks");
        model.addColumn("Status");
        JTableHeader tableHeader = tab.getTableHeader();
        tableHeader.setBackground(new Color(0,65,89));
        tableHeader.setForeground(new Color(255,255,255));
        Font headerFont = new Font("Verdana", Font.BOLD, 20);
        tableHeader.setFont(headerFont);

        for(int i=0;i<data.size();i++)
        {
            model.insertRow(0,new Object[]{data.get(i).get(0),  data.get(i).get(4), data.get(i).get(2), data.get(i).get(3)} );
        }
        JScrollPane sp = new JScrollPane(tab);
        panel.add(sp,BorderLayout.SOUTH);
        

        JLabel head = new JLabel("               RESULT LIST");
        head.setBounds(0,0,360,60);
        head.setBackground(new Color(204,255,255));
        head.setForeground(new Color(0,51,102));
        head.setOpaque(true);
        head.setFont(new Font("Times New Roman",  Font.BOLD,50));
        panel.add(head,BorderLayout.CENTER);

        logoutbutton = new JButton("Logout");
        logoutbutton.setBounds(870,0,130,40);
        logoutbutton. setBackground(new Color(0,51,102));
        logoutbutton.setForeground(new Color(204,255,255));
        logoutbutton.setFont(new Font("Times New Roman", Font.PLAIN,20));
        panel.add(logoutbutton,BorderLayout.EAST);
        logoutbutton.addActionListener(this);

        dash = new JButton("Back");
        dash.setBounds(870,40,100,44);
        dash. setBackground(new Color(0,51,102));
        dash.setForeground(new Color(204,255,255));
        dash.setFont(new Font("Times New Roman", Font.PLAIN,20));
        panel.add(dash,BorderLayout.WEST);
        dash.addActionListener(this);
        
        frame.add(panel);

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
    }
    /*public static void main(String Args[])
    {
        new resultlist("array");
    }*/
}




