package in.kuari.v3bigdata.firebase;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.design.widget.NavigationView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import in.kuari.v3bigdata.R;
import in.kuari.v3bigdata.model.NavMenu;
import in.kuari.v3bigdata.model.Topic;

/**
 * Created by ketan on 25/11/17.
 */

public class FirebaseHelper {
    FirebaseDatabase database;

    private TextView tView;
    static String val;
    private Context context;
    public FirebaseHelper(Context context){
         this.context=context;
         database=FireBaseDB.getInstance();


    }
    public  void main(TextView tv) {
        DatabaseReference dbRef = database.getReference("data");
        dbRef.keepSynced(true);

        tView=tv;

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                val = dataSnapshot.getValue(String.class);
                Log.d("DbValues",val);
                tView.setText(val);


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.e("Error",databaseError.getMessage());
            }
        });
    }

    void populateMenu(NavigationView navigationView, List<NavMenu> menus){
        Menu menu = navigationView.getMenu();
        for(NavMenu navMenu:menus) {

            final MenuItem menuItem = menu.add(R.id.topicList, Menu.NONE, Menu.NONE, "");

            menuItem.setTitle(navMenu.getTitle());
            menuItem.setActionView(R.layout.checkbox);
            //set id for each checkbox
            menuItem.getActionView().setId(navMenu.getId());

            String ImageURL=navMenu.getIcon();


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

    public void getMenuList(final NavigationView navigationView,final ProgressDialog dialog){
        DatabaseReference dbRef=database.getReference("view").child("navmenulist");
        dbRef.keepSynced(true);

        dbRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                List<NavMenu> navMenus=new ArrayList<>();
                for(DataSnapshot data:dataSnapshot.getChildren()){
                    NavMenu navMenu=data.getValue(NavMenu.class);
                    //System.out.println(navMenu.toString());
                    navMenus.add(navMenu);

                }
                populateMenu( navigationView,navMenus);
                CheckBox view = (CheckBox) navigationView.getMenu().getItem(2).getActionView();
                view.setChecked(true);

                dialog.hide();



                //TODO Write some data in posts key and filter is based on selected options from menu
                //TODO Create view for posts...


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }

    void getTopicList( final ArrayAdapter<String> adp){

        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("data").child("topics");
        ref.keepSynced(true);
        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds:dataSnapshot.getChildren()){
                    Topic topic = ds.getValue(Topic.class);
                    //   topics.add(topic.getName());

                    Log.v("topics",topic.toString());
                }
                //notify adpater that data changed
                adp.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


    }



    public   void writeNewPost(/*String userId, String username, String title, String body*/) {


        DatabaseReference mDatabase=database.getReference("data");
        String key = mDatabase.child("topics").push().getKey();
        Topic topic=new Topic("12","sample");


        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/topics/" + key, topic);
      //  childUpdates.put("/user-posts/" + userId + "/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }


}
