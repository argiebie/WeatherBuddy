package com.wb.android.weatherbuddy;

/**
 * Created by RB on 2017-05-04.
 */

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TodayForecast extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.todayforecast, container, false);
        return rootView;
    }

    public class MyActivity extends Activity {
        private RecyclerView mRecyclerView;
        private RecyclerView.Adapter mAdapter;
        private RecyclerView.LayoutManager mLayoutManager;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.my_activity);
            mRecyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);

            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            mRecyclerView.setHasFixedSize(true);

            // use a linear layout manager
            mLayoutManager = new LinearLayoutManager(this);
            mRecyclerView.setLayoutManager(mLayoutManager);

            // specify an adapter (see also next example)
            mAdapter = new MyAdapter(myDataset);
            mRecyclerView.setAdapter(mAdapter);
        }

        public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
            private String[] mDataset;

            // Provide a reference to the views for each data item
            // Complex data items may need more than one view per item, and
            // you provide access to all the views for a data item in a view holder
            public static class ViewHolder extends RecyclerView.ViewHolder {
                // each data item is just a string in this case
                public TextView mTextView;

                public ViewHolder(TextView v) {
                    super(v);
                    mTextView = v;
                }
            }

            // Provide a suitable constructor (depends on the kind of dataset)
            public MyAdapter(String[] myDataset) {
                mDataset = myDataset;
            }

            // Create new views (invoked by the layout manager)
            @Override
            public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                           int viewType) {
                // create a new view
                TextView v = (TextView) LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.my_text_view, parent, false);
                // set the view's size, margins, paddings and layout parameters
        ...
                ViewHolder vh = new ViewHolder(v);
                return vh;
            }

            // Replace the contents of a view (invoked by the layout manager)
            @Override
            public void onBindViewHolder(ViewHolder holder, int position) {
                // - get element from your dataset at this position
                // - replace the contents of the view with that element
                holder.mTextView.setText(mDataset[position]);

            }

            // Return the size of your dataset (invoked by the layout manager)
            @Override
            public int getItemCount() {
                return mDataset.length;
            }
        }


    }
}
