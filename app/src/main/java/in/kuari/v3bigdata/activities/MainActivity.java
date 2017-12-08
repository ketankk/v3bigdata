package in.kuari.v3bigdata.activities;

import android.app.ProgressDialog;
import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import in.kuari.v3bigdata.R;
import in.kuari.v3bigdata.adapter.PostsFeedAdapter;
import in.kuari.v3bigdata.firebase.FirebaseHelper;
import in.kuari.v3bigdata.model.Question;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    PostsFeedAdapter postFeedAdapter;
    List<Question> posts = new ArrayList<>();
    private ProgressDialog dialog;
    private ListView mListView;
    private ArrayList<String> lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //   TextView tv=findViewById(R.id.tv);
        // NavigationView navigationView = setDrawer(toolbar);
        FirebaseHelper helper = new FirebaseHelper(this);

        dialog = ProgressDialog.show(this, "", "Loading...", true, false);
        //  helper.getNavMenuList(navigationView, dialog);

        setRecycler(helper);


    }

    private void setRecycler(FirebaseHelper helper) {
        RecyclerView rv = findViewById(R.id.allpost);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(layoutManager);
        if (dialog != null)
            dialog.show();

        postFeedAdapter = new PostsFeedAdapter(this, posts);
        helper.getListOfPost(posts, dialog, postFeedAdapter);

        rv.setAdapter(postFeedAdapter);
        // helper.writeNewPost();
    }

    private NavigationView setDrawer(Toolbar toolbar) {

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        return navigationView;

    }

    @Override
    protected void onPause() {
        super.onPause();
        if (dialog != null)
            dialog.dismiss();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    //settings button
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchManager searchManager = (SearchManager) MainActivity.this.getSystemService(Context.SEARCH_SERVICE);

        SearchView searchView = null;
        if (searchItem != null) {
            searchView = (SearchView) searchItem.getActionView();
        }
        if (searchView != null) {
            searchView.setSearchableInfo(searchManager.getSearchableInfo(MainActivity.this.getComponentName()));

            List<Question> filter = new ArrayList<>();

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String newText) {
                    Log.v("Query", newText);
                    if (!TextUtils.isEmpty(newText)) {
                        filter.addAll(posts);

                        posts.clear();

                        for(Question question:filter){
                            question.contains(newText);
                            posts.add(question);

                        }

                    }else
                        posts.addAll(filter);
                    postFeedAdapter.notifyDataSetChanged();
                    return false;
                }
            });

        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
