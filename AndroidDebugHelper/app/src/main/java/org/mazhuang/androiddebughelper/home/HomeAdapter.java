package org.mazhuang.androiddebughelper.home;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.mazhuang.androiddebughelper.R;

/**
 * Created by mazhuang on 2017/8/1.
 */

class HomeAdapter extends android.support.v7.widget.RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    private static int[] mDataset = {
            R.string.open_debug_mode,
            R.string.wireless_connect
    };

    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_feature_view, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(HomeAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mDataset[position]);
    }

    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ViewHolder(View v) {
            super(v);
            mTextView  = v.findViewById(R.id.title);

            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (getLayoutPosition()) {
                        case 0:
                            break;

                        case 1:
                            break;

                        default:
                            break;
                    }
                }
            });
        }
    }
}
