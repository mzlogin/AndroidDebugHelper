package org.mazhuang.androiddebughelper.home;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import org.mazhuang.androiddebughelper.R;
import org.mazhuang.androiddebughelper.base.BaseActivity;

public class HomeActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();
    }

    private void initViews() {
        RecyclerView mRecyclerView = (RecyclerView) findViewById(R.id.features_list);
        mRecyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(mLayoutManager);

        RecyclerView.Adapter mAdapter = new HomeAdapter(new HomeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(HomeAdapter.FeatureItem item) {
                switch (item.mTitleResId) {
                    case R.string.open_debug_mode:
                        startActivity(new Intent(Settings.ACTION_APPLICATION_DEVELOPMENT_SETTINGS));
                        break;

                    case R.string.wireless_connect:
                        break;

                    default:
                        break;
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }
}
