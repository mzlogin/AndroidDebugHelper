package org.mazhuang.androiddebughelper;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import org.mazhuang.androiddebughelper.base.BaseActivity;
import org.mazhuang.androiddebughelper.home.HomeActivity;

/**
 * Created by mazhuang on 2017/8/1.
 */

public class SplashActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startHome();
    }

    private void startHome() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
