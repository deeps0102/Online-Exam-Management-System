import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class User {
   private int userid;
   private String userName,email,password,usertype,mobNo,gender;
   private Date dob, createddt, modifieddt;

   public User(){
       
   }
    public User(int userid, String userName, String email, String password, String usertype, String mobNo, String gender, Date dob, Date createddt, Date modifieddt) {
        this.setUserId(userId);
        this.setUserName(userName);
        this.setEmail(email);
        this.setPassword(password);
        this.setType(usertype);
        this.setContact(mobNo);
        this.setgender(gender);
        this.setdob(dob);
        this.setcreateddt(createddt);
        this.setmodifieddt(modifieddt);
    }

    public int getUserId() {
        return this.userid;
    }

    public void setUserId(int userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getType() {
        return this.usertype;
    }

    public void setType(String usertype) {
        this.usertype = usertype;
    }

    public String getContact() {
        return this.mobNo;
    }

    public void setContact(String mobNo) {
        this.mobNo = mobNo;
    }

    public String getgender() {
        return this.gender;
    }

    public void setgender(String gender) {
        this.gender = gender;
    }

    public Date getcreateddt() {
        return this.createddt;
    }

    public void setcreateddt(Date createddt) {
        this.createddt = createddt;
    }

    public Date getmodifieddt() {
        return this.modifieddt;
    }

    public void setmodifieddt(Date modifieddt) {
        this.modifieddt = modifieddt;
    }
}
