public class Exams {
    
    private int examId;
    private String stdId,cName,tMarks,obtMarks,date,startTime,endTime,examTime,status;

    public Exams() {
    }

    public Exams(int examId, String stdId,String cName, String tMarks, String obtMarks, String date, String startTime, String endTime, String examTime, String status) {
        this.setExamId(examId);
        this.setStdId(stdId);
        this.cName=cName;
        this.settMarks(tMarks);
        this.setObtMarks(obtMarks);
        this.setDate(date);
        this.setStartTime(startTime);
        this.setEndTime(endTime);
        this.setExamTime(examTime);
        this.setStatus(status);
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    

    public int getExamId() {
        return examId;
    }

    public void setExamId(int examId) {
        this.examId = examId;
    }

    public String getStdId() {
        return stdId;
    }

    public void setStdId(String stdId) {
        this.stdId = stdId;
    }

    public String gettMarks() {
        return tMarks;
    }

    public void settMarks(String tMarks) {
        this.tMarks = tMarks;
    }

    public String getObtMarks() {
        return obtMarks;
    }

    public void setObtMarks(String obtMarks) {
        this.obtMarks = obtMarks;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getExamTime() {
        return examTime;
    }

    public void setExamTime(String examTime) {
        this.examTime = examTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
}
