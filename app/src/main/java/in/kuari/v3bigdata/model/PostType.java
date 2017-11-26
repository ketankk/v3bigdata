package in.kuari.v3bigdata.model;

/**
 * Created by ketan on 26/11/17.
 */

public class PostType{
    public static final int QUESTION_SUB=2;
    public static final int QUESTION_MCQ=1;
    public static final int OTHER_POST=0;
    //THEORY,ANNOUNCEMENT;
}
class MCQQuestion extends Question{

}

enum QuestionType{
    MCQ,PARAGRAPH
}