public class Courses {
    
   private String cName;
   private int tMarks;
   private String time;

    public Courses(String cName, int tMarks, String time) {
        this.setcName(cName);
        this.settMarks(tMarks);
        this.setTime(time);
    }

    public Courses(String cName, int tMarks) {
        this.cName = cName;
        this.tMarks = tMarks;
    }

    public Courses() {
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public int gettMarks() {
        return tMarks;
    }

    public void settMarks(int tMarks) {
        this.tMarks = tMarks;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }    
}
