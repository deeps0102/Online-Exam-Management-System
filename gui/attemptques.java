package gui;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.border.TitledBorder;
import base.Connect;
import base.Database;

public class attemptques extends JFrame implements ActionListener
{
    private JFrame frame;
    private JPanel panel;
    private JButton logoutbutton, submit;
    private String userID,examName;
    private int index;
    private JTable tab;
    private String[] data;
    private Boolean[] boolarray;
    private Database obj = new Database();
    private Connect con = new Connect();

    public attemptques(String userId, String examname, int num, String[] arr, Boolean[] boolarr)
    {
        userID = userId;
        examName=examname;
        index=num;
        boolarray = boolarr;
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

        data = arr;
        //String data[] = {"cse1","what is java?", "a programming language", "something shit", "too much shit", "biggest shit", "biggest shit"};

        DefaultTableModel model = new DefaultTableModel();
        JTable tab = new JTable(model);
        tab.setBounds(100,450,800,300);
        tab.setLocation(100,350);
        tab.setBackground(new Color(205,192,204));
        tab.setForeground(new Color(77,0,75));
        tab.setRowHeight(99);
        tab.setSelectionBackground(new Color(160,127,158));
        tab.setSelectionForeground(new Color(0,0,0));
        tab.setFont(new Font("Times New Roman", Font.PLAIN,18));
        model.addColumn(data[0]);
        model.addColumn(data[1]);
        JTableHeader tableHeader = tab.getTableHeader();
        tableHeader.setBackground(new Color(131,55,127));
        tableHeader.setForeground(new Color(255,255,255));
        Font headerFont = new Font("Verdana", Font.PLAIN, 25);
        tableHeader.setPreferredSize(new Dimension(170,170));
        tableHeader.setFont(headerFont);
        
        for(int i=0;i<4;i++)
        {
            model.insertRow(i,new Object[]{"      " + String.valueOf(i+1) + "-",data[i+2]});
        }

        tab.getColumnModel().getColumn(0).setPreferredWidth(110);
        tab.getColumnModel().getColumn(1).setPreferredWidth(900);
        tab.setDefaultEditor(Object.class, null);
        tab.setCellSelectionEnabled(true);
        ListSelectionModel cellSelectionModel = tab.getSelectionModel();
    	cellSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

    	cellSelectionModel.addListSelectionListener(new ListSelectionListener() {
      		public void valueChanged(ListSelectionEvent e) 
      		{
		        String selectedData = null;

		        int[] selectedRow = tab.getSelectedRows();
		        int[] selectedColumns = tab.getSelectedColumns();

		        for (int i = 0; i < selectedRow.length; i++) 
		        {
		          	for (int j = 0; j < selectedColumns.length; j++) 
		          	{
		            	selectedData = (String) tab.getValueAt(selectedRow[i], selectedColumns[j]);
		          	}
	        	}
	        	if(selectedData.equals(data[6]))
	        	{
	        		boolarray[index] = true;
	        	}
	        	else
	        		boolarray[index] = false;
      		}

    	});


        JScrollPane sp = new JScrollPane(tab);
        panel.add(sp,BorderLayout.SOUTH);

        JLabel head = new JLabel("              QUESTION - " + String.valueOf(index+1));
        head.setBounds(0,0,360,60);
        head.setBackground(new Color(205,192,204));
        head.setForeground(new Color(77,0,75));
        head.setOpaque(true);
        head.setFont(new Font("Times New Roman",  Font.BOLD,40));
        panel.add(head,BorderLayout.CENTER);

        logoutbutton = new JButton("Logout");
        logoutbutton.setBounds(870,0,130,40);
        logoutbutton. setBackground(new Color(77,0,75));
        logoutbutton.setForeground(new Color(205,192,204));
        logoutbutton.setFont(new Font("Times New Roman", Font.PLAIN,20));
        panel.add(logoutbutton,BorderLayout.EAST);
        logoutbutton.addActionListener(this);

        submit = new JButton("Submit");
        submit.setBounds(870,40,90,44);
        submit. setBackground(new Color(77,0,75));
        submit.setForeground(new Color(205,192,204));
        submit.setFont(new Font("Times New Roman", Font.PLAIN,20));
        panel.add(submit,BorderLayout.WEST);
        submit.addActionListener(this);
        
        /*int row = tab.getSelectedRow();
        selected_ans  = tab.getModel().getValueAt(row, 1).toString();*/
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
        else if(e.getSource()==submit)
        {
            new attemptexam(userID,examName,boolarray);
            frame.dispose();
        }
    }
}

