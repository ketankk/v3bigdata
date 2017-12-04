package in.kuari.v3bigdata.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import in.kuari.v3bigdata.R;
import in.kuari.v3bigdata.activities.FullPostActivity;
import in.kuari.v3bigdata.model.Answer;
import in.kuari.v3bigdata.model.MCQAnswer;
import in.kuari.v3bigdata.model.Post;
import in.kuari.v3bigdata.model.PostType;
import in.kuari.v3bigdata.model.Question;
import in.kuari.v3bigdata.model.SubjAnswer;
import in.kuari.v3bigdata.utils.Utility;

/**
 * Created by ketan on 26/11/17.
 */

public class PostsFeedAdapter extends RecyclerView.Adapter<PostsFeedAdapter.PostFeedHolder> {




    private List<? extends Post> posts=new ArrayList<>();
    private Context context;
    public PostsFeedAdapter(Context context,List<? extends Post> posts){
        this.context=context;
        this.posts=posts;

    }
    @Override
    public PostFeedHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case PostType.QUESTION_SUB:
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts, parent, false);
                PostFeedHolder vh = new PostFeedHolder(view);
                return vh;
            default:
                View view2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.posts, parent, false);
                PostFeedHolder vh2 = new PostFeedHolder(view2);

                return vh2;
        }
    }

    @Override
    public int getItemViewType(int position) {
        Post post = posts.get(position);
        if (post instanceof Question){

            if( ((Question)post).getAnswer() instanceof  MCQAnswer)
                return PostType.QUESTION_MCQ;
            else
            if( ((Question)post).getAnswer() instanceof  SubjAnswer)
                return PostType.QUESTION_SUB;

            return super.getItemViewType(position);
        }
        else return PostType.OTHER_POST;
    }

    @Override
    public void onBindViewHolder(PostFeedHolder holder, int position) {
        try {


            final Post post = posts.get(position);
            holder.postedBy.setText(post.getPostedBy().getName());
            holder.postedOn.setText(Utility.timeAgo(post.getPostedOn()));

            LinearLayoutManager lm=new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            holder.tags.setLayoutManager(lm);

            holder.tags.setAdapter(new TagsAdapter(post.getTags()));

            if (post instanceof Question) {
                Question question = (Question) post;

                holder.postTitle.setText(question.getQuestion());

                Answer answer = question.getAnswer();
                if (answer instanceof SubjAnswer) {
                    SubjAnswer subjAnswer = (SubjAnswer) answer;
                    holder.postText.setText(subjAnswer.getAnswerText());
                } else if (answer instanceof MCQAnswer) {
                    MCQAnswer mcqAnswer = (MCQAnswer) answer;
                }


            }
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openPostPage(post);
                }
            });
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void openPostPage(Post post) {
        Intent intent=new Intent(context, FullPostActivity.class);
        intent.putExtra("postId",post.getPostId());

        intent.putExtra("obj",post);
        context.startActivity(intent);
    }

    @Override
    public int getItemCount() {
        return posts.size();
    }
    //Todo multiple types of post..Questions with MCQ or Subjective
    static class PostFeedHolder extends RecyclerView.ViewHolder{
        private TextView postTitle;
        private TextView postText;
        private TextView postedBy;
        private TextView postedOn;
        private RecyclerView tags;

        public PostFeedHolder(View itemView) {
            super(itemView);
            tags=itemView.findViewById(R.id.tags);

            postTitle=itemView.findViewById(R.id.postTitle);
            postText=itemView.findViewById(R.id.postText);
            postedBy=itemView.findViewById(R.id.postedBy);
            postedOn=itemView.findViewById(R.id.postedOn);
        }
    }
}


