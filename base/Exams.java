import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class Exams 
{
    public String examName, createdby, modifiedby;
    public Date examDate, createddt, modifieddt;

    public Exams() {}

    public Exams(String examName, Date examDate, String createdby, String modifiedby, Date createddt, Date modifieddt) 
    {
        this.setexamName(examName);
        this.setexamDate(examDate);
        this.setcreatedby(createdby);
        this.setmodifiedby(modifiedby);
        this.setcreateddt(createddt);
        this.setmodifieddt(modifieddt);
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

    public void setcreateddt(Date createddt) {
        this.createddt = createddt;
    }

    public Date getmodifieddt() {
        return this.examDate;
    }

    public void setmodifieddt(Date modifieddt) {
        this.modifieddt = modifieddt;
    }
    
    public String getcreatedby() {
        return this.createdby;
    }

    public void setcreatedby(String createdby) {
        this.createdby = createdby;
    }

    public String getmodifiedby() {
        return this.modifiedby;
    }

    public void setmodifiedby(String modifiedby) {
        this.modifiedby = modifiedby;
    }
}
