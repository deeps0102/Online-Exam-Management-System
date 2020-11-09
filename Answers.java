public class Answers {
    String question,answer,correctAns,status;

    public Answers() {
    }

    public Answers(String question, String answer, String correctAns, String status) {
        this.setQuestion(question);
        this.setAnswer(answer);
        this.setCorrectAns(correctAns);
        this.setStatus(status);
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getCorrectAns() {
        return correctAns;
    }

    public void setCorrectAns(String correctAns) {
        this.correctAns = correctAns;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    
}
