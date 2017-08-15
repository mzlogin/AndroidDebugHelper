package org.mazhuang.androiddebughelper.home;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.mazhuang.androiddebughelper.R;
import org.mazhuang.androiddebughelper.base.BaseActivity;
import org.mazhuang.androiddebughelper.util.NetworkUtils;
import org.mazhuang.androiddebughelper.util.SystemInfoUtils;

public class HomeActivity extends BaseActivity implements HomeContract.View {

    private HomeContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        mPresenter = new HomePresenter(this);
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
                        mPresenter.setAdbTcpPort();
                        break;

                    case R.string.show_ip_address:
                        Toast.makeText(HomeActivity.this, NetworkUtils.getIpAddress(), Toast.LENGTH_LONG).show();
                        break;

                    case R.string.show_vm:
                        Toast.makeText(HomeActivity.this, SystemInfoUtils.getVmInUse(), Toast.LENGTH_SHORT).show();
                        break;

                    default:
                        break;
                }
            }
        });
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void onSetAdbTcpPortSucceed(String ipAddress) {
        Toast.makeText(this, ipAddress, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onSetAdbTcpPortFailed(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
}
