/*
package in.kuari.v3bigdata.model;

import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;

import java.util.List;
import java.util.Optional;

*/
/**
 * Created by ketan on 6/12/17.
 *//*


public class ExampleViewHolder extends RecyclerView.ViewHolder {

    private final ItemExampleBinding mBinding;

    public ExampleViewHolder(ItemExampleBinding binding) {
        super(binding.getRoot());
        mBinding = binding;
    }

    public void bind(ExampleModel item) {
        mBinding.setModel(item);
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

    private final SortedList<ExampleModel> mSortedList = new SortedList<>(ExampleModel.class, new SortedList.Callback<ExampleModel>() {
        @Override
        public void onInserted(int position, int count) {

        }

        @Override
        public void onRemoved(int position, int count) {

        }

        @Override
        public void onMoved(int fromPosition, int toPosition) {

        }

        @Override
        public int compare(ExampleModel o1, ExampleModel o2) {

            Optional sbc = null;
            // sbc.ifPresent(System.out::print);

            return 0;
        }

        @Override
        public void onChanged(int position, int count) {

        }

        @Override
        public boolean areContentsTheSame(ExampleModel oldItem, ExampleModel newItem) {
            return false;
        }

        @Override
        public boolean areItemsTheSame(ExampleModel item1, ExampleModel item2) {
            return false;
        }

    });


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

}
*/
