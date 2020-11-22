package base;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
 
public class Database {
    
    // Database URLs
    public static final String url1 = "jdbc:mysql://localhost:3306/";
    public static final String url2 = "jdbc:mysql://localhost:3306/exam_system";

    // Database credentials

    /* 
     *  Replace user with root
     *  And password with your password
     */

    public static final String user = "root";
    public static final String password = "password";

    // init() function for creating Database
    public static void init()
    {
        System.out.println("Welcome to Online Exam  Management System\n");

        Connection con1 = null, con2 = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.println("Connecting to DATABASE\n");
            con1 = DriverManager.getConnection(url1, user, password);

            System.out.println("Creating DATABASE\n");
            stmt=con1.createStatement();
            stmt.executeUpdate("create database exam_system");
            con1.close();
            con2 = DriverManager.getConnection(url2, user, password);
            stmt=con2.createStatement();

            System.out.println("DATABASE created successfully\n");
            stmt.executeUpdate("use exam_system");

            System.out.println("Creating TABLES\n");
            
            stmt.executeUpdate("create table exams(examName varchar(30) primary key, examDate varchar(20), createdby varchar(30), createddt varchar(20))");
            stmt.executeUpdate("create table users(userid varchar(30) primary key, userName varchar(30), emailid varchar(30), password varchar(30), mobNo varchar(11), dob varchar(11), gender varchar(10), createddt varchar(20), usertype varchar(10))");
            stmt.executeUpdate("create table results(examName varchar(30), userid varchar(30), totmarks varchar(5), userstatus varchar(30), examDate varchar(20), foreign key(userid) references users(userid), foreign key(examName) references exams(examName))");
            stmt.executeUpdate("create table questions(queid varchar(30) primary key, examName varchar(10), question varchar(100), opt1 varchar(50), opt2 varchar(50), opt3 varchar(50), opt4 varchar(50), ans varchar(50), createdby varchar(30), createddt varchar(20), foreign key(examName) references exams(examName))");
            stmt.executeUpdate("insert into users values('1', 'Nirmay Dhruv', 'ab1@gmail.com', 'abcxyz', '6320331881', '05-03-2002', 'Male', '2020-11-11 13:23:44', 'Student')");
            stmt.executeUpdate("insert into users values('2', 'Mauli Dhruv', 'ab2@gmail.com', 'abcxyz', '8325331882', '05-03-2002', 'Female', '2020-11-11 13:23:44', 'Student')");
            stmt.executeUpdate("insert into users values('3', 'Akshat Dixit', 'ab3@gmail.com', 'abcxyz', '7320341881', '05-03-2002', 'Male', '2020-11-11 13:23:44', 'Student')");
            stmt.executeUpdate("insert into users values('4', 'Deepali Garg', 'ab4@gmail.com', 'abcxyz', '8320331880', '05-03-2002', 'Female', '2020-11-11 13:23:44', 'Student')");
            stmt.executeUpdate("insert into users values('5', 'Kanika Didwania', 'ab5@gmail.com', 'abcxyz', '9220331881', '05-03-2002', 'Female', '2020-11-11 13:23:44', 'Student')");
            stmt.executeUpdate("insert into users values('6', 'Mehul Bhandari', 'ab6@gmail.com', 'abcxyz', '8320334881', '05-03-2002', 'Male', '2020-11-11 13:23:44', 'Student')");
            stmt.executeUpdate("insert into users values('7', 'Daksh Khandelwal', 'ab7@gmail.com', 'abcxyz', '9320331881', '05-03-2002', 'Male', '2020-11-11 13:23:44', 'Student')");
            stmt.executeUpdate("insert into users values('8', 'Utkarsh Mathur', 'ab8@gmail.com', 'abcxyz', '8372335881', '05-03-2002', 'Male', '2020-11-11 13:23:44', 'Student')");
            stmt.executeUpdate("insert into users values('9', 'Rupali Upadhyay', 'ab9@gmail.com', 'abcxyz', '8311131971', '05-03-2002', 'Female', '2020-11-11 13:23:44', 'Student')");
            stmt.executeUpdate("insert into users values('10', 'Sidhi Agarwal', 'ab10@gmail.com', 'abcxyz', '8320341681', '05-03-2002', 'Female', '2020-11-11 13:23:44', 'Student')");
            stmt.executeUpdate("insert into users values('11', 'Admin1 xx1', 'xy1@gmail.com', 'xxyyzz', '9060534903', '16-09-2001', 'Female', '2020-11-11 13:23:44', 'Admin')");
            stmt.executeUpdate("insert into users values('12', 'Admin2 xx2', 'xy2@gmail.com', 'xxyyzz', '8100531100', '16-09-2001', 'Male', '2020-11-11 13:23:44', 'Admin')");
            stmt.executeUpdate("insert into users values('13', 'Admin3 xx3', 'xy3@gmail.com', 'xxyyzz', '7130531194', '16-09-2001', 'Male', '2020-11-11 13:23:44', 'Admin')");
            stmt.executeUpdate("insert into exams values('Java', '12-03-2021', 'Admin1 xx1', '16-09-2020')");
            stmt.executeUpdate("insert into questions values('Java123', 'Java', 'Question 1 of Java', 'opt(a)Q1Java', 'opt(b)Q1Java', 'opt(c)Q1Java', 'opt(d)Q1Java', 'opt(b)Q1Java', 'Admin1 xx1', '16-09-2020')");
            stmt.executeUpdate("insert into questions values('Java111', 'Java', 'Question 2 of Java', 'opt(a)Q2Java', 'opt(b)Q2Java', 'opt(c)Q2Java', 'opt(d)Q2Java', 'opt(c)Q2Java', 'Admin1 xx1', '16-09-2020')");
            stmt.executeUpdate("insert into exams values('M3', '10-03-2021', 'Admin2 xx2', '16-09-2020')");
            stmt.executeUpdate("insert into questions values('M3111', 'M3', 'Question 1 of M3', 'opt(a)Q1M3', 'opt(b)Q1M3', 'opt(c)Q1M3', 'opt(d)Q1M3', 'opt(b)Q1M3', 'Admin2 xx2', '16-09-2020')");
            stmt.executeUpdate("insert into questions values('M3124', 'M3', 'Question 2 of M3', 'opt(a)Q2M3', 'opt(b)Q2M3', 'opt(c)Q2M3', 'opt(d)Q2M3', 'opt(c)Q2M3', 'Admin2 xx2', '16-09-2020')");
            con2.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("DATABASE names exam_system created successfully\n");

    }


    public static void drop()
    {
        Connection con = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url2, user, password);
            stmt=con.createStatement();
            stmt.executeUpdate("drop database exam_system");
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
