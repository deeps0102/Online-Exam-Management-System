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
    //true for already having an account and vice-versa
    public static int check_registered(int user_id, String password)
    {
        String realpass = new String();
        String type = new String();
        boolean f=-1;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection(url, user, password);
            Statement stmt=con.createStatement();
            String query="select password,usertype from users where userid="+user_id;
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
            String query="insert into users values("+new_user.userid+", '"+new_user.userName+"', '"+new_user.emailid+"', '"+new_user.password+"', '"+new_user.mobNo+"', '"+new_user.dob.toString()+"', '"+new_user.gender+"', '"+new_user.createddt.toString()+"', '"+new_user.modifieddt.toString()+"', '"+new_user.usertype+"')";
            ResultSet rs=stmt.executeUpdate(query);
            con.close();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

    //admin can add exam through this
    public static void add_exam(Exam new_exam)
    {
        //
    }

    //admin can add question in any particular using through this
    public static void add_question(Question new_que)
    {
        //
    }
}