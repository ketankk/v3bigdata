/*
package in.kuari.v3bigdata.activities;

import android.content.Context;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Comparator;
import java.util.List;

import in.kuari.v3bigdata.model.ExampleModel;
import in.kuari.v3bigdata.model.ExampleViewHolder;

*/
/**
 * Created by ketan on 6/12/17.
 *//*

public class ExampleAdapter extends SortedListAdapter<ExampleModel> {

    private final SortedList<ExampleModel> mSortedList = new SortedList<>(ExampleModel.class, new SortedList.Callback<ExampleModel>() {
        @Override
        public int compare(ExampleModel a, ExampleModel b) {
            return mComparator.compare(a, b);
        }

        @Override
        public void onInserted(int position, int count) {
            notifyItemRangeInserted(position, count);
        }

        @Override
        public void onRemoved(int position, int count) {
            notifyItemRangeRemoved(position, count);
        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {
            notifyItemMoved(fromPosition, toPosition);
        }

        @Override
        public void onChanged(int position, int count) {
            notifyItemRangeChanged(position, count);
        }

        @Override
        public boolean areContentsTheSame(ExampleModel oldItem, ExampleModel newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areItemsTheSame(ExampleModel item1, ExampleModel item2) {
            return item1 == item2;
        }
    });

    private final Comparator<ExampleModel> mComparator;
    private final LayoutInflater mInflater;

    public ExampleAdapter(Context context, Comparator<ExampleModel> comparator) {
        mInflater = LayoutInflater.from(context);
        mComparator = comparator;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final ItemExampleBinding binding = ItemExampleBinding.inflate(mInflater, parent, false);
        return new ExampleViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, int position) {
        final ExampleModel model = mSortedList.get(position);
        holder.bind(model);
    }

    public void add(ExampleModel model) {
        mSortedList.add(model);
    }

    public void remove(ExampleModel model) {
        mSortedList.remove(model);
    }

    public void add(List<ExampleModel> models) {
        mSortedList.addAll(models);
    }

    public void remove(List<ExampleModel> models) {
        mSortedList.beginBatchedUpdates();
        for (ExampleModel model : models) {
            mSortedList.remove(model);
        }
        mSortedList.endBatchedUpdates();
    }

    public void replaceAll(List<ExampleModel> models) {
        mSortedList.beginBatchedUpdates();
        for (int i = mSortedList.size() - 1; i >= 0; i--) {
            final ExampleModel model = mSortedList.get(i);
            if (!models.contains(model)) {
                mSortedList.remove(model);
            }
        }
        mSortedList.addAll(models);
        mSortedList.endBatchedUpdates();
    }

    @Override
    public int getItemCount() {
        return mSortedList.size();
    }
}*/
