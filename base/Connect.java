import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;
import static java.lang.Math.abs;
 
class Connect {
 
    public static final String url = "jdbc:mysql://localhost:3306/exam_system";
 
    public static final String user = "root";
 
    public static final String password = "Asdf1@2jkl";

    //checks if user already has an account or not
    //-1 for not registered, 0->registered student and 1->registered admin
    public static int check_registered(String user_id, String password)
    {
        String realpass = new String();
        String type = new String();
        boolean f=-1;
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
        if(realpass.equals(password))
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
            String query="insert into users values('"+new_user.userid+"', '"+new_user.userName+"', '"+new_user.emailid+"', '"+new_user.password+"', '"+new_user.mobNo+"', '"+new_user.dob+"', '"+new_user.gender+"', '"+new_user.createddt.toString()+"', '"+new_user.modifieddt.toString()+"', '"+new_user.usertype+"')";
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //admin can add exam through this
    public static void add_exam(Exam new_exam)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="insert into exams values('"+new_exam.examName+"', '"+new_exam.examDate+"', '"+new_exam.createdby+"', '"+new_exam.modifiedby+"', '"+new_exam.createddt.toString()+"', '"+new_exam.modifieddt.toString()+"')";
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //admin can add question in any particular using through this
    public static void add_question(Question new_que)
    {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="insert into questions values('"+new_que.queid+"', '"+new_que.examName+"', '"+new_que.question+"', '"+new_exam.opt1+"', '"+new_exam.opt2+"', '"+new_exam.opt3+"', '"+new_exam.opt4+"', '"+new_exam.ans+"', '"+new_exam.createdby+"', '"+new_exam.modifiedby+"', '"+new_exam.createddt.toString()+"', '"+new_exam.modifieddt.toString()+"')";
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //returns an array list of result of a particular student
    public static ArrayList<Results> get_result(String username) 
    {
        ArrayList<Results> arr = new ArrayList<Results>();
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select * from results where userName='"+username+"'";
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next())
            {
                Results obj = new Results();
                obj.examName=rs.getString(1);
                obj.userName=rs.getString(2);
                obj.totmarks=rs.getInt(3);
                obj.userstatus=rs.getString(4);
                obj.examDate=rs.getDate(5);
                arr.add(obj);
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
            String query="update users set userName='"+obj.userName+"', emailid='"+obj.emailid+"', password='"+obj.password+"', mobNo='"+obj.mobNo+"', dob='"+obj.dob+"', gender='"+obj.gender+"', modifieddt='"+obj.modifieddt+"' where userid='"+obj.userid+"'";
            stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return arr;
    }
}