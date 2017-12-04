package in.kuari.v3bigdata.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import in.kuari.v3bigdata.R;

/**
 * Created by ketan on 3/12/17.
 */

public class TagsAdapter extends RecyclerView.Adapter<TagsAdapter.TagsViewHolder>{
    List<String> tagList;
    public TagsAdapter(List<String> tagList){
        this.tagList=tagList;
    }
    @Override
    public TagsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.tags,parent,false);
        return new TagsViewHolder(view);    }

    @Override
    public void onBindViewHolder(TagsViewHolder holder, int position) {
        holder.tagText.setText(tagList.get(position));

    }

    @Override
    public int getItemCount() {
        return tagList.size();
    }

    static class TagsViewHolder extends RecyclerView.ViewHolder{
        private TextView tagText;
        public TagsViewHolder(View itemView) {
            super(itemView);
            tagText=itemView.findViewById(R.id.tagtext);
        }
    }


}
