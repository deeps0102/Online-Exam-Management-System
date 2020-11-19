import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class Results {
    String userName, examName, userstatus;
    int totmarks;
    Date examDate;

    public Results() {}

    public Results(String userName, String examName, String userstatus, int totmarks, Date examDate) {
        this.setUserName(userName);
        this.setexamName(examName);
        this.setuserstatus(userstatus);
        this.setexamDate(examDate);
        this.setresultid(resultid);
        this.settotmarks(totmarks);
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getexamName() {
        return this.examName;
    }

    public void setexamName(String examName) {
        this.examName = examName;
    }

    public String getuserstatus() {
        return this.userstatus;
    }

    public void setuserstatus(String userstatus) {
        this.userstatus = userstatus;
    }

    public Date getexamDate() {
        return this.examDate;
    }

    public void setexamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Date getotmarks() {
        return this.totmarks;
    }

    public void settotmarks(Date examDate) {
        this.totmarks = totmarks;
    }
}
