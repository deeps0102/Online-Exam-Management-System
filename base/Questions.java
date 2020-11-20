import java.util.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.time.LocalDate;

public class Questions
{
    public String queid, question, opt1, opt2, opt3, opt4, ans, examName, createdby, modifiedby;
    public Date createddt, modifieddt;

    public Questions() {}

    public Questions(String queid, String question, String opt1, String opt2, String opt3, String opt4, String ans, String examName, String createdby, String modifiedby, Date createddt, Date modifieddt) 
    {
        this.setQuestionId(queid);
        this.setQuestion(question);
        this.setOpt1(opt1);
        this.setOpt2(opt2);
        this.setOpt3(opt3);
        this.setOpt4(opt4);
        this.setAns(ans);
        this.setexamName(examName);
        this.setcreatedby(createdby);
        this.setmodifiedby(modifiedby);
        this.setcreateddt(createddt);
        this.setmodifieddt(modifieddt);
    }

    public String getQuestionId() {
        return this.queid;
    }

    public void setQuestionId(String queid) {
        this.queid = queid;
    }

    public String getQuestion() {
        return this.question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getOpt1() {
        return this.opt1;
    }

    public void setOpt1(String opt1) {
        this.opt1 = opt1;
    }

    public String getOpt2() {
        return this.opt2;
    }

    public void setOpt2(String opt2) {
        this.opt2 = opt2;
    }

    public String getOpt3() {
        return this.opt3;
    }

    public void setOpt3(String opt3) {
        this.opt3 = opt3;
    }

    public String getOpt4() {
        return this.opt4;
    }

    public void setOpt4(String opt4) {
        this.opt4 = opt4;
    }

    public String getAns() {
        return this.ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public String getexamName() {
        return this.examName;
    }

    public void setexamName(String examName) {
        this.examName = examName;
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
