import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
 
class Database {
 
    public static final String url1 = "jdbc:mysql://localhost:3306/";
    public static final String url2 = "jdbc:mysql://localhost:3306/exam_system";
    public static final String user = "root";
    public static final String password = "pswrd";

    public static void init()
    {
        Connection con1 = null, con2 = null;
        Statement stmt = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            con1 = DriverManager.getConnection(url1, user, password);
            stmt=con1.createStatement();
            stmt.executeUpdate("create database exam_system");
            con1.close();
            con2 = DriverManager.getConnection(url2, user, password);
            stmt=con2.createStatement();
            stmt.executeUpdate("use exam_system");
            stmt.executeUpdate("create table exams(examName varchar(30) primary key, examDate datetime, createdby varchar(30), modifiedby varchar(30), createddt datetime, modifieddt datetime);");
            stmt.executeUpdate("create table users(userid varchar(30) primary key, userName varchar(30), emailid varchar(30), password varchar(30), mobNo varchar(11), dob varchar(11), gender varchar(10), createddt datetime, modifieddt datetime, usertype varchar(10))");
            stmt.executeUpdate("create table results(examName varchar(30) primary key, userName varchar(30), totmarks int, userstatus varchar(30), examDate datetime, foreign key(examDate) references exams(examDate), foreign key(userName) references users(userName), foreign key(examName) references exams(examName))");
            stmt.executeUpdate("create table questions(queid varchar(30) primary key, examName varchar(10), question varchar(100), opt1 varchar(50), opt2 varchar(50), opt3 varchar(50), opt4 varchar(50), ans varchar(50), createdby varchar(30), modifiedby varchar(30), createddt datetime, modifieddt datetime, foreign key(examName) references exams(examName))");
            stmt.executeUpdate("insert into users values('1', 'X A', 'abc@gmail.com', 'abcxyz', '8320331881', '05-03-2002', 'Male', '2020-11-11 13:23:44', '2020-11-11 13:23:44', 'Student')")
            stmt.executeUpdate("insert into users values('2', 'Y B', 'xyz@gmail.com', 'xxyyzz', '8000531100', '16-09-2001', 'Female', '2020-11-11 13:23:44', '2020-11-11 13:23:44', 'Admin')")
            con2.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
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
