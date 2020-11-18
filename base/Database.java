import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
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
            stmt.executeUpdate("exam_system");
            stmt.executeUpdate("create table answers(answer_id int(11) primary key,question varchar(45), answer varchar(45), correct_answer varchar(45), status varchar(45), foreign key(exam_id) refrences exams(exam_id)");
            stmt.executeUpdate("create table courses(course_name varchar(25), total_marks int(11), time varchar(45))");
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
