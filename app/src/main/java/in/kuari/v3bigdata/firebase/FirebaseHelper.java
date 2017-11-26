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
import android.view.View;
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
import java.util.List;

import in.kuari.v3bigdata.R;
import in.kuari.v3bigdata.model.NavMenu;

/**
 * Created by ketan on 25/11/17.
 */

public class FirebaseHelper {
    FirebaseDatabase database;

    private TextView tView;
    static String val;
    private Context context;
    public FirebaseHelper(Context context){
        database=FirebaseDatabase.getInstance();
        database.setPersistenceEnabled(true);
        this.context=context;


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


    /*private void writeNewPost(String userId, String username, String title, String body) {
        // Create new post at /user-posts/$userid/$postid and at
        // /posts/$postid simultaneously
        String key = mDatabase.child("posts").push().getKey();
        Post post = new Post(userId, username, title, body);
        Map<String, Object> postValues = post.toMap();

        Map<String, Object> childUpdates = new HashMap<>();
        childUpdates.put("/posts/" + key, postValues);
        childUpdates.put("/user-posts/" + userId + "/" + key, postValues);

        mDatabase.updateChildren(childUpdates);
    }
*/

}
