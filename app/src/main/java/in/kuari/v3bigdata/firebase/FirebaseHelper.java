package in.kuari.v3bigdata.firebase;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import in.kuari.v3bigdata.R;
import in.kuari.v3bigdata.model.NavMenu;
import in.kuari.v3bigdata.model.Post;
import in.kuari.v3bigdata.model.Question;
import in.kuari.v3bigdata.model.SubjAnswer;
import in.kuari.v3bigdata.model.Topic;
import in.kuari.v3bigdata.utils.Constants;

/**
 * Created by ketan on 25/11/17.
 */

public class FirebaseHelper {
    static String val;
    FirebaseDatabase database;
    private TextView tView;
    private Context context;

    public FirebaseHelper(Context context) {
        this.context = context;


    }

    public void main(TextView tv) {
        DatabaseReference dbRef = database.getReference("data");
        dbRef.keepSynced(true);

        tView = tv;

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                val = dataSnapshot.getValue(String.class);
                Log.d("DbValues", val);
                tView.setText(val);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Error", databaseError.getMessage());
            }
        });
    }

    void populateMenu(NavigationView navigationView, List<NavMenu> menus) {
        Menu menu = navigationView.getMenu();
        for (NavMenu navMenu : menus) {

            final MenuItem menuItem = menu.add(R.id.topicList, Menu.NONE, Menu.NONE, "");

            menuItem.setTitle(navMenu.getTitle());
            menuItem.setActionView(R.layout.checkbox);
            //set id for each checkbox
            //  menuItem.getActionView().setId(navMenu.getId());

            String ImageURL = navMenu.getIcon();


            Picasso.with(context)
                    .load(ImageURL)
                    .into(new Target() {
                        @Override
                        public void onBitmapLoaded(Bitmap bitmap, Picasso.LoadedFrom from) {
                            Drawable d = new BitmapDrawable(context.getResources(), bitmap);
                            menuItem.setIcon(d);
                        }

                        @Override
                        public void onBitmapFailed(Drawable errorDrawable) {

                        }

                        @Override
                        public void onPrepareLoad(Drawable placeHolderDrawable) {

                        }
                    });

        }

    }

    public void getNavMenuList(final NavigationView navigationView, final ProgressDialog dialog) {
        DatabaseReference dbRef = FireBaseInstances.getNavMenuList();
        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<NavMenu> navMenus = new ArrayList<>();
                for (DataSnapshot data : dataSnapshot.getChildren()) {
                    NavMenu navMenu = data.getValue(NavMenu.class);
                    //System.out.println(navMenu.toString());
                    navMenus.add(navMenu);

                }
                populateMenu(navigationView, navMenus);
                setMenuChecked(navigationView, navMenus);
                dialog.hide();


                //TODO Write some data in posts key and filter is based on selected options from menu
                //TODO Create view for posts...


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }
    private int i=0;

    private void setMenuChecked(NavigationView navigationView, List<NavMenu> navMenu) {

        SharedPreferences sp = context.getSharedPreferences(Constants.NavMenuPref, Context.MODE_PRIVATE);
        Set<String> chekcedItems = sp.getStringSet("LIST", new TreeSet<>());
        Log.v("CheckdItems are", chekcedItems.toString());
        for (String itemid : chekcedItems) {
            int i = navMenu.indexOf(new NavMenu(itemid));
            CheckBox view = (CheckBox) navigationView.getMenu().getItem(i).getActionView();
            view.setChecked(true);

        }
        for(i=0;i<navigationView.getMenu().size();i++){
            CheckBox view = (CheckBox) navigationView.getMenu().getItem(i).getActionView();
            view.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                //final int pos=i;
                @Override
                public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                    Log.v("Check","Clicked");
                    Set<String> chekcedItems = sp.getStringSet("LIST", new TreeSet<>());
                    Log.v("Compound id",view.getId()+"--");
                    String itemid=navMenu.get(i-1).getId();
                    if (b) {
                        Log.v("ItemChekedId", itemid);
                        chekcedItems.add(itemid);

                    } else {
                        Log.v("ItemUnChekedId", itemid);

                        chekcedItems.remove(itemid);
                    }
                    sp.edit().putStringSet("LIST",chekcedItems).apply();

                }
            });
        }
    }

    public void getListOfPost(final List<Question> posts, final ProgressDialog dialog, final RecyclerView.Adapter adp) {

        DatabaseReference db = FireBaseInstances.getQuestions();
        db.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot dd : dataSnapshot.getChildren()) {
                    try {
                        Log.v("Question Received", dd.getValue().toString());


                        GenericTypeIndicator<Question<SubjAnswer>> genericTypeIndicator = new GenericTypeIndicator<Question<SubjAnswer>>() {
                        };
                        Question<SubjAnswer> qq = dd.getValue(genericTypeIndicator);

                        Log.v("Parsed Question", qq.toString());

                        posts.add(qq);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Collections.sort(posts, new Comparator<Question>() {
                    @Override
                    public int compare(Question ques1, Question ques2) {
                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        try {
                            long post1on = sdf.parse(ques1.getPostedOn()).getTime();
                            long post2on = sdf.parse(ques2.getPostedOn()).getTime();
                           // Log.v("P=="+ques1.toString()+"||"+ques2.toString(),post1on+"--"+post2on+"=="+(post2on-post1on));
                            return (post2on-post1on)>0?1:-1;

                        } catch (ParseException e) {
                            e.printStackTrace();
                            return 0;
                        }
                    }
                });
                adp.notifyDataSetChanged();
                if (dialog != null)
                    dialog.hide();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

    }

    public void getTopicList(final ArrayAdapter<String> adp) {

        DatabaseReference ref = FireBaseInstances.getTopics();

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Topic topic = ds.getValue(Topic.class);
                    //   topics.add(topic.getName());

                    Log.v("topics", topic.toString());
                }
                //notify adpater that data changed
                adp.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }


    public void writeNewPost(/*String userId, String username, String title, String body*/) {


        DatabaseReference mDatabase = FireBaseInstances.getTopics();
        String key = mDatabase.push().getKey();
        Topic topic = new Topic("12", "sample");


        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/topics/" + key, topic);
        //  childUpdates.put("/user-posts/" + userId + "/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }


}
