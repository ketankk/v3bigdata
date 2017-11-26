package in.kuari.v3bigdata.model;

/**
 * Created by ketan on 26/11/17.
 */

public class Question extends Post{
    private String question;
    private Answer answer;

    public Question() {
    }

    public Question(long postId,String question,  Answer answer,String postedBy,String postedOn) {
        super(postId,postedBy,postedOn);
        this.question = question;
        this.answer = answer;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }


    public Answer getAnswer() {
        return answer;
    }

    public void setAnswer(Answer answer) {
        this.answer = answer;
    }
}
