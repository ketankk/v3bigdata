package in.kuari.v3bigdata.model;

import java.util.List;

/**
 * Created by ketan on 25/11/17.
 */

public class PostData {

    private User postedBy;
    private POST_TYPE postType;


}
enum POST_TYPE{
    QUESTION,THEORY,ANNOUNCEMENT
}
class Question{
    private String question;
    private QUESTION_TYPE questionType;
    private List<Answer> answers;
}
enum QUESTION_TYPE{
    MCQ,PARAGRAPH
}
class User{
    private String name;
}
class Answer{
    private long answerId;
    private String answerText;
}