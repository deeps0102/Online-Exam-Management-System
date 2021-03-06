package base;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import static java.lang.Math.abs;
import java.text.SimpleDateFormat;
import java.util.concurrent.ThreadLocalRandom;
 
public class Connect {
 
    public static final String url = "jdbc:mysql://localhost:3306/exam_system";
 
    public static final String user = "root";
 
    public static final String password = "password";

    //checks if user already has an account or not
    //-1 for not registered, 0->registered student and 1->registered admin
    public static int check_registered(String user_id, String passw)
    {
        String realpass = new String();
        String type = new String();
        int f=-1;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select password,usertype from users where userid='"+user_id+"'";
            ResultSet rs=stmt.executeQuery(query);
            while(rs.next())
            {
                realpass=rs.getString(1);
                type=rs.getString(2);
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        if(realpass.equals(passw))
        {
            if(type.equals("Admin"))
            {
                f=0;
            }
            else if(type.equals("Student"))
            {
                f=1;
            }
        }
        return f;
    }

    //adds new user
    public static void add_user(User new_user)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="insert into users values('"+new_user.userid+"', '"+new_user.userName+"', '"+new_user.emailid+"', '"+new_user.password+"', '"+new_user.mobNo+"', '"+new_user.dob+"', '"+new_user.gender+"', '"+new_user.createddt+"', '"+new_user.usertype+"')";
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //admin can add exam through this
    public static void add_exam(String userid, Exams new_exam)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select userName from users where userid='"+userid+"'";
            ResultSet rs = stmt.executeQuery(query);
            String usernm=new String();
            while(rs.next())
            {
                usernm=rs.getString(1);
            }
            query="insert into exams values('"+new_exam.examName+"', '"+new_exam.examDate+"', '"+usernm+"', '"+new_exam.createddt+"')";
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //admin can add question in any particular using through this
    public static void add_question(String userid, Questions new_que)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select userName from users where userid='"+userid+"'";
            ResultSet rs = stmt.executeQuery(query);
            String usernm=new String();
            long v = ThreadLocalRandom.current().nextLong(100,1000);
            new_que.queid = new_que.examName + String.valueOf(v);
            while(rs.next())
            {
                usernm=rs.getString(1);
            }
            query="insert into questions values('"+new_que.queid+"', '"+new_que.examName+"', '"+new_que.question+"', '"+new_que.opt1+"', '"+new_que.opt2+"', '"+new_que.opt3+"', '"+new_que.opt4+"', '"+new_que.ans+"', '"+usernm+"', '"+new_que.createddt+"')";
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void add_result(String userid, String examName, int marks)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String temp = new String();
            temp=Integer.toString(marks);
            String userName=new String();
            String examDate = new String();
            String userstatus = new String();
            String query="select userName from users where userid='"+userid+"'";
            ResultSet rs1 = stmt.executeQuery(query);
            while(rs1.next())
            {
                userName = rs1.getString(1);
            }
            query = "select examDate from exams where examName='"+examName+"'";
            ResultSet rs2 = stmt.executeQuery(query);
            while(rs2.next())
            {
                examDate = rs2.getString(1);
            }
            int totmarks = ques_count(examName);
            if(totmarks*0.3<marks)
            {
                userstatus = "Pass";
            }
            else
            {
                userstatus = "Fail";
            }

            query = "insert into results values('"+examName+"','"+userid+"','"+temp+"','"+userstatus+"','"+examDate+"')";
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //returns an array list of result of a particular student
    public static ArrayList<ArrayList<String>> get_result(String userid) 
    {
        ArrayList<ArrayList<String>> arr = new ArrayList<ArrayList<String>>();
        String username = new String();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select * from results where userid='"+userid+"'";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                ArrayList<String> temp = new ArrayList<String>();
                temp.add(rs.getString(1));
                temp.add(rs.getString(2));
                temp.add(rs.getString(3));
                temp.add(rs.getString(4));
                temp.add(rs.getString(5));
                arr.add(temp);
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return arr;
    }

    //returns all current exams
    public static ArrayList<String> allexams()
    {
        ArrayList<String> arr = new ArrayList<String>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select examName from exams";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                String temp = new String();
                temp = rs.getString(1);
                arr.add(temp);
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return arr;
    }

    //return no. of questions in a particular exam
    public static int ques_count(String exam_name)
    {
        int count=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select count(queid) from questions where examName='"+exam_name+"'";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                count=rs.getInt(1);
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return count;
    }

    //checks role of the user (admin or student)
    public static int check_role(String user_id)
    {
        int f=0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select usertype from users where userid='"+user_id+"'";
            ResultSet rs = stmt.executeQuery(query);
            String temp = new String();
            while(rs.next())
            {
                temp=rs.getString(1);
            }
            if(temp.equals("Admin"))
            {
                f=1;
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }

    //updates the data edited by user
    public static void update_user(User obj)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="update users set userName='"+obj.userName+"', emailid='"+obj.emailid+"', password='"+obj.password+"', mobNo='"+obj.mobNo+"', dob='"+obj.dob+"', gender='"+obj.gender+"' where userid='"+obj.userid+"'";
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    public static String[][] allquestions(String examName)
    {
        int questions = ques_count(examName);
        String[][]ques = new String[7][questions];
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select queid,question,opt1,opt2,opt3,opt4,ans from questions where examName='"+examName+"'";
            ResultSet rs = stmt.executeQuery(query);
            int i=0;
            while(rs.next())
            {
                String[] arr = new String[7];
                arr[0]=rs.getString(1);
                arr[1]=rs.getString(2);
                arr[2]=rs.getString(3);
                arr[3]=rs.getString(4);
                arr[4]=rs.getString(5);
                arr[5]=rs.getString(6);
                arr[6]=rs.getString(7);
                ques[i]=arr;
                i=i+1;
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return ques;
    }

    public static User get_user(String userid)
    {
        User obj = new User();// obj ka address = lets say 1000
        //
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select * from users where userid='"+userid+"'";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                obj.userid=rs.getString(1);
                obj.userName=rs.getString(2);
                obj.emailid=rs.getString(3);
                obj.password=rs.getString(4);
                obj.mobNo=rs.getString(5);
                obj.dob=rs.getString(6);
                obj.gender=rs.getString(7);
                obj.createddt=rs.getString(8);
                obj.usertype=rs.getString(9);
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return obj;
    }

    public static boolean checkunique(String userid, String emailid)
    {
        int c1=0;
        boolean f = true;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select count(userid) from users where userid='"+userid+"' or emailid='"+emailid+"'";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                c1=rs.getInt(1);
            }
            if(c1>0)
            {
                f=false;
            }
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return f;
    }
}
