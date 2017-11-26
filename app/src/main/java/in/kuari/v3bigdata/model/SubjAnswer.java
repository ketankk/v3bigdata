package in.kuari.v3bigdata.model;

/**
 * Created by ketan on 26/11/17.
 */

public class SubjAnswer extends Answer {
    private long answerId;
    private String answerText;

    public SubjAnswer() {
    }

    public SubjAnswer(long answerId, String answerText) {
        this.answerId = answerId;
        this.answerText = answerText;
    }

    public long getAnswerId() {
        return answerId;
    }

    public void setAnswerId(long answerId) {
        this.answerId = answerId;
    }

    public String getAnswerText() {
        return answerText;
    }

    public void setAnswerText(String answerText) {
        this.answerText = answerText;
    }
}