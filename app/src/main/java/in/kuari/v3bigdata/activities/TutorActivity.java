package in.kuari.v3bigdata.activities;

import android.database.DataSetObserver;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import in.kuari.v3bigdata.R;
import in.kuari.v3bigdata.firebase.FireBaseInstances;
import in.kuari.v3bigdata.model.Question;
import in.kuari.v3bigdata.model.SubjAnswer;
import in.kuari.v3bigdata.model.User;

public class TutorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor);

        Spinner spinner = findViewById(R.id.topicList);

        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"hekk", "ww", ""});
        spinner.setAdapter(adp);

        Button submit = findViewById(R.id.submit);


        EditText title = findViewById(R.id.titlePo);
        final Editable quesTitle = title.getText();

        EditText answer = findViewById(R.id.answer);
        final Editable quesAns = answer.getText();

        EditText tags = findViewById(R.id.tags);
        final Editable quesTags = tags.getText();
        final Object seleItem = spinner.getSelectedItem();


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                savedata(quesTitle.toString(), quesAns.toString(), quesTags.toString(), seleItem.toString());
            }
        });


    }

    private void savedata(String quesTitle, String quesAns, String quesTags, String topic) {

        DatabaseReference mDatabase = FireBaseInstances.getQuestions();
        String key = mDatabase.push().getKey();

        Question ques = getPost(quesTitle, quesAns, quesTags, topic);


        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/questions/" + key, ques);
        //  childUpdates.put("/user-posts/" + userId + "/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
        Toast.makeText(this, "Data saved " + ques.toString(), Toast.LENGTH_LONG).show();


    }

    private Question getPost(String quesTitle, String quesAns, String quesTags, String topic) {

        Question ques = new Question();

        SubjAnswer ans = new SubjAnswer();
        ans.setAnswerText(quesAns);

        ques.setAnswer(ans);
        ques.setTags(Arrays.asList(quesTags.split(",")));
        ques.setQuestion(quesTitle);
        ques.setPostedBy(new User("VJ"));
        ques.setTopic(topic);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timeStamp=System.currentTimeMillis();
        ques.setPostedOn( sdf.format(timeStamp));

        return ques;
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long timeStamp=System.currentTimeMillis();
        System.out.print(sdf.format(timeStamp));

    }
    void getList(Adapter adp) {
        adp.registerDataSetObserver(new DataSetObserver() {
        });
    }


}