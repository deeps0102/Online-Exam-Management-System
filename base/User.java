import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class User 
{
    private String userid,userName,emailid,password,usertype,mobNo,gender,dob;
    private Date createddt, modifieddt;

    public User(){}

    public User(String userid, String userName, String emailid, String password, String usertype, String mobNo, String gender, String dob, Date createddt, Date modifieddt)
    {
        this.setUserId(userId);
        this.setUserName(userName);
        this.setEmail(emailid);
        this.setPassword(password);
        this.setType(usertype);
        this.setContact(mobNo);
        this.setgender(gender);
        this.setdob(dob);
        this.setcreateddt(createddt);
        this.setmodifieddt(modifieddt);
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
        this.emailid = emailid;
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
        return this.gender;
    }

    public void setdob(String dob) {
        this.dob = dob;
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
