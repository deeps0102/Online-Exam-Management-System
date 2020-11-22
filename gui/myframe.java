package gui;

import javax.swing.*;
import java.awt.event.*; 
import java.awt.*; 
import java.io.*;
import gui.loginpage;
import base.Database;

public class myframe extends JFrame implements ActionListener
{
    private JFrame frame;
    private JPanel panel;
    private JButton loginbutton;
    private static Database obj = new Database();

    public myframe()
    {
        frame = new JFrame("ONLINE EXAM MANAGEMENT");
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

        loginbutton = new JButton("Login");
        loginbutton.setBounds(870,0,130,40);
        loginbutton. setBackground(Color.BLACK);
        loginbutton.setForeground(new Color(255,255,255));
        loginbutton.setFont(new Font("Times New Roman", Font.PLAIN,25));
        panel.add(loginbutton);
        loginbutton.addActionListener(this);

        ImageIcon img = new ImageIcon("./gui/png/front.png");

        JLabel background = new JLabel();
        background.setIcon(img);
        background.setBounds(0,0,1000,800);
        panel.add(background);

        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==loginbutton)
        {
            loginpage p=new loginpage();
            frame.dispose();
        }

    }

    public static void main(String Args[])
    {
        obj.init();
        new myframe();
    }

}
