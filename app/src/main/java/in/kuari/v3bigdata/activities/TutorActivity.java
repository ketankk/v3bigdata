package in.kuari.v3bigdata.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

import in.kuari.v3bigdata.R;

public class TutorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tutor);

        Spinner spinner=findViewById(R.id.topicList);
        List<String> topics=getTopicList();
        ArrayAdapter<String> adp=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,topics);
        spinner.setAdapter(adp);
    }

    List<String> getTopicList(){
        List<String> topics=new ArrayList<>();
        topics.add("Kafka");
        topics.add("Zookeeper");
        topics.add("MapReduce");
        topics.add("Yarn");
        return topics;
    }
}
