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
            stmt.executeUpdate("create table exams(examid int primary key, examName varchar(10), examDate Date, createdby varchar(30), modifiedby varchar(30), createddt datetime, modifieddt datetime)");
            stmt.executeUpdate("create table users(userid int primary key, userName varchar(30), emailid varchar(30), password varchar(20), mobNo varchar(11), dob Date, gender varchar(10), createddt datetime, modifieddt datetime, usertype varchar(10))");
            stmt.executeUpdate("create table results(resultid int primary key, userName varchar(30), examName varchar(10), totmarks int, userstatus varchar(10), examDate datetime, foreign key(examDate) references exams(examDate), foreign key(userName) references users(userName), foreign key(examName) references exams(examName))");
            stmt.executeUpdate("create table questions(queid int primary key, examName varchar(10), question varchar(100), opt1 varchar(50), opt2 varchar(50), opt3 varchar(50), opt4 varchar(50), ans varchar(50), createdby varchar(30), modifiedby varchar(30), createddt datetime, modifieddt datetime, foreign key(examName) references exams(examName))");
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
