package base;

import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class User 
{
    public String userid,userName,emailid,password,usertype,mobNo,gender,dob,createddt;

    public User(){}

    public User(String userid, String userName, String emailid, String password, String usertype, String mobNo, String gender, String dob, String createddt)
    {
        this.setUserId(userid);
        this.setUserName(userName);
        this.setEmail(emailid);
        this.setPassword(password);
        this.setType(usertype);
        this.setContact(mobNo);
        this.setgender(gender);
        this.setdob(dob);
        this.setcreateddt(createddt);
    }

    public String getUserId() {
        return this.userid;
    }

    public void setUserId(String userid) {
        this.userid = userid;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return this.emailid;
    }

    public void setEmail(String email) {
        this.emailid = email;
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

    public String getdob() {
        return this.dob;
    }

    public void setdob(String dob) {
        this.dob = dob;
    }

    public String getcreateddt() {
        return this.createddt;
    }

    public void setcreateddt(String createddt) {
        this.createddt = createddt;
    }
}
