Package base;
import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class Exams 
{
    public String examName, createdby, createddt;
    public Date examDate;

    public Exams() {}

    public Exams(String examName, Date examDate, String createdby, String createddt) 
    {
        this.setexamName(examName);
        this.setexamDate(examDate);
        this.setcreatedby(createdby);
        this.setcreateddt(createddt);
    }

    public String getexamName() {
        return this.examName;
    }

    public void setexamName(String examName) {
        this.examName = examName;
    }

    public Date getexamDate() {
        return this.examDate;
    }

    public void setexamDate(Date examDate) {
        this.examDate = examDate;
    }

    public Date getcreateddt() {
        return this.examDate;
    }

    public void setcreateddt(String createddt) {
        this.createddt = createddt;
    }
    
    public String getcreatedby() {
        return this.createdby;
    }

    public void setcreatedby(String createdby) {
        this.createdby = createdby;
    }
}
