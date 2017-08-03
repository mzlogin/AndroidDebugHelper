package org.mazhuang.androiddebughelper.home;

import android.content.Context;
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

    private static FeatureItem[] mDataSet = {
            new FeatureItem(R.string.open_debug_mode),
            new FeatureItem(R.string.wireless_connect),
            new FeatureItem(R.string.show_ip_address)
    };

    private OnItemClickListener mItemClickListener;

    interface OnItemClickListener {
        void onItemClick(FeatureItem item);
    }

    HomeAdapter(OnItemClickListener itemClickListener) {
        mItemClickListener = itemClickListener;
    }

    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_feature_view, parent, false);

        return new ViewHolder(v, mItemClickListener);
    }

    @Override
    public void onBindViewHolder(HomeAdapter.ViewHolder holder, int position) {
        holder.mTextView.setText(mDataSet[position].getTitle(holder.mTextView.getContext()));
    }

    @Override
    public int getItemCount() {
        return mDataSet.length;
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        ViewHolder(View v, final OnItemClickListener listener) {
            super(v);
            mTextView  = v.findViewById(R.id.title);
            v.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onItemClick(mDataSet[getLayoutPosition()]);
                }
            });
        }
    }

    static class FeatureItem {
        int mTitleResId;
        private String mTitle;

        FeatureItem(int titleResId) {
            mTitleResId = titleResId;
        }

        String getTitle(Context context) {
            if (mTitle == null) {
                mTitle = context.getString(mTitleResId);
            }
            return mTitle;
        }
    }
}
