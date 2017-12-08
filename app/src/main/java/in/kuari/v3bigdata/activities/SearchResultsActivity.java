/*
package in.kuari.v3bigdata.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import in.kuari.v3bigdata.R;
import in.kuari.v3bigdata.model.ExampleModel;
import in.kuari.v3bigdata.model.Question;

*/
/**
 * Created by ketan on 4/12/17.
 *//*


public class SearchResultsActivity extends AppCompatActivity implements SearchView.OnQueryTextListener{

    private static final String[] MOVIES = new String[]{

    };

    private static final Comparator<ExampleModel> ALPHABETICAL_COMPARATOR = new Comparator<ExampleModel>() {
        @Override
        public int compare(ExampleModel a, ExampleModel b) {
            return a.getText().compareTo(b.getText());
        }
    };

    private ExampleAdapter mAdapter;
    private List<ExampleModel> mModels;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
     //   mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        mAdapter = new ExampleAdapter(this, ALPHABETICAL_COMPARATOR);

       // mBinding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        //mBinding.recyclerView.setAdapter(mAdapter);

        mModels = new ArrayList<>();
        for (String movie : MOVIES) {
          //  mModels.add(new ExampleModel(movie));
        }
        mAdapter.add(mModels);
    }


    @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        */
/*final List<Question> filteredModelList = filter(mModels, query);
        postFeedAdapter.replaceAll(filteredModelList);
        postFeedAdapter.recyclerView.scrollToPosition(0);
       *//*

        Toast.makeText(this,"Text"+newText,Toast.LENGTH_LONG).show();
        return true;
    }


    private static List<ExampleModel> filter(List<ExampleModel> models, String query) {
        final String lowerCaseQuery = query.toLowerCase();

        final List<ExampleModel> filteredModelList = new ArrayList<>();
        for (ExampleModel model : models) {
            final String text = model.getText().toLowerCase();
            if (text.contains(lowerCaseQuery)) {
                filteredModelList.add(model);
            }
        }
        return filteredModelList;
    }
}
*/
