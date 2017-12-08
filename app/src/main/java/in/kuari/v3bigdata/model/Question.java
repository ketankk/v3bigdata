package in.kuari.v3bigdata.model;

import android.text.TextUtils;

/**
 * Created by ketan on 26/11/17.
 */

public class Question<T extends Answer> extends Post{
    private String question;
    private T answer;

    public Question() {
    }

    public Question(long postId,String question,  T answer,String postedBy,String postedOn) {
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

    public void setAnswer(T answer) {
        this.answer = answer;
    }

    public boolean contains(String text){
        if(TextUtils.isEmpty(text))
            return false;
        return getPostTitle().contains(text) || getPostedBy().getName().contains(text);
    }
    @Override
    public String toString() {
        return "Question{" +
                "question='" + question + '\'' +
                ", answer=" + answer +
                "} " + super.toString();
    }
}
