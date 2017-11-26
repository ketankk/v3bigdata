package in.kuari.v3bigdata.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import in.kuari.v3bigdata.R;

public class FullPostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_post);

        Intent intent=getIntent();
        long postId=intent.getLongExtra("postId",-1);

        Toast.makeText(this,"POSTID "+postId,Toast.LENGTH_LONG).show();

    }
}
