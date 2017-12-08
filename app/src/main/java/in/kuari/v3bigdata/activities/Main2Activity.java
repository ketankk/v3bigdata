/*
package in.kuari.v3bigdata.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import in.kuari.v3bigdata.R;

import static java.util.Collections.addAll;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        ListView mListView = findViewById(R.id.list);
       // mListView.setAdapter(android.R.layout.activity_list_item);

    }
}
class ListViewAdapter extends BaseAdapter {

    // Declare Variables

    Context mContext;
    LayoutInflater inflater;
    private ArrayList<String> arraylist;

    public ListViewAdapter(Context context ) {
        mContext = context;
        inflater = LayoutInflater.from(mContext);
        this.arraylist = new ArrayList<String>();
        arraylist.add("hello1");
        arraylist.add("hello2");
        arraylist.add("hello3");
    }

    public class ViewHolder {
        TextView name;
    }

    @Override
    public int getCount() {
        return arraylist.size();
    }

    @Override
    public String getItem(int position) {
        return arraylist.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(final int position, View view, ViewGroup parent) {
        final ViewHolder holder;
        if (view == null) {
            holder = new ViewHolder();
            view = inflater.inflate(R.layout.listview, null);
            // Locate the TextViews in listview_item.xml
            holder.name = (TextView) view.findViewById(R.id.name);
            view.setTag(holder);
        } else {
            holder = (ViewHolder) view.getTag();
        }
        // Set the results into TextViews
        holder.name.setText(arraylist.get(position));
        return view;
    }

    List<String> filtered=new ArrayList<>();
    // Filter Class
    public void filter(String charText) {
        charText = charText.toLowerCase(Locale.getDefault());
        filtered.clear();
        if (charText.length() == 0) {
            filtered.addAll(arraylist);
        } else {
            for (String wp : arraylist) {
                if (wp.toLowerCase(Locale.getDefault()).contains(charText)) {
                    filtered.add(wp);
                }
            }
        }
        notifyDataSetChanged();
    }

}*/
