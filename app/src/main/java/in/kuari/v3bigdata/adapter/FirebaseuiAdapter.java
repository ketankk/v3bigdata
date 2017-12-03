package in.kuari.v3bigdata.adapter;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseListAdapter;
import com.firebase.ui.database.FirebaseListOptions;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import java.util.List;

import in.kuari.v3bigdata.R;
import in.kuari.v3bigdata.model.Answer;
import in.kuari.v3bigdata.model.Post;
import in.kuari.v3bigdata.model.Question;
import in.kuari.v3bigdata.model.SubjAnswer;
import in.kuari.v3bigdata.model.Topic;

/**
 * Created by ketan on 2/12/17.
 */

public class FirebaseuiAdapter {

    static public void firebaseui(){
        FirebaseDatabase dbref = FirebaseDatabase.getInstance();
      //  dbref.setPersistenceEnabled(true);
        Query query = dbref
                .getReference("data").child("topics")
                .limitToLast(50);

        FirebaseListOptions<Topic> options=new FirebaseListOptions.Builder<Topic>()
                .setQuery(query,Topic.class).build();



        FirebaseListAdapter<Topic> adp=new FirebaseListAdapter<Topic>(options) {
            @Override
            protected void populateView(View v, Topic model, int position) {
                Log.v("topics",model.getName());
            }
        };


        final FirebaseRecyclerOptions<Topic> options2 = new FirebaseRecyclerOptions.Builder<Topic>().setQuery(query, Topic.class).build();

       /* FirebaseRecyclerAdapter adp=new FirebaseRecyclerAdapter<Post,FirebaseuiAdapter.PostFeedHolder>(options) {

            @Override
            public FirebaseuiAdapter.PostFeedHolder onCreateViewHolder(ViewGroup parent, int viewType) {

               *//* View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts, parent, false);
                FirebaseuiAdapter.PostFeedHolder vh = new FirebaseuiAdapter.PostFeedHolder(view);
                *//*return null;

            }

            @Override
            protected void onBindViewHolder(FirebaseuiAdapter.PostFeedHolder holder, int position, Post model) {
                *//*List<Post> posts=options.getSnapshots();
                final Post post = posts.get(position);
                holder.postedBy.setText(post.getPostedBy().getName());
                holder.postedOn.setText(post.getPostedOn());
                Question question= (Question) post;

                holder.postTitle.setText(question.getQuestion());

                Answer answer=question.getAnswer();
                SubjAnswer subjAnswer = (SubjAnswer) answer;
                holder.postText.setText(subjAnswer.getAnswerText());
*//*
            }
        };*/


    }


    static class PostFeedHolder extends RecyclerView.ViewHolder{

        private TextView postTitle;
        private TextView postText;
        private TextView postedBy;
        private TextView postedOn;





        public PostFeedHolder(View itemView) {
            super(itemView);
            postTitle=itemView.findViewById(R.id.postTitle);
            postText=itemView.findViewById(R.id.postText);
            postedBy=itemView.findViewById(R.id.postedBy);
            postedOn=itemView.findViewById(R.id.postedOn);
        }


    }
}
