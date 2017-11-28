package in.kuari.v3bigdata.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import in.kuari.v3bigdata.R;
import in.kuari.v3bigdata.model.Answer;
import in.kuari.v3bigdata.model.Post;
import in.kuari.v3bigdata.model.Question;
import in.kuari.v3bigdata.model.SubjAnswer;

public class FullPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent=getIntent();
        Post post= (Post) intent.getSerializableExtra("obj");
        setLayout(post);

    }

    void setLayout(Post post){

        if(post instanceof Question){
            Question question= (Question) post;
            Answer answer=question.getAnswer();
            if(answer instanceof SubjAnswer){
                setSubjAnswerQuesView(question);


            }
        }




        Toast.makeText(this,"POST "+post.toString(),Toast.LENGTH_LONG).show();



    }

    private void setSubjAnswerQuesView(Question question) {
        setContentView(R.layout.activity_full_post);

        TextView postText = findViewById(R.id.postTitle);
        postText.setText(question.getQuestion());
        TextView answer = findViewById(R.id.answer);
        answer.setText(((SubjAnswer)question.getAnswer()).getAnswerText());

    }
}