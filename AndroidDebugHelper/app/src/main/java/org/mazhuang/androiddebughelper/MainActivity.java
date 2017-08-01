package org.mazhuang.androiddebughelper;

import android.os.Bundle;

import org.mazhuang.androiddebughelper.base.BaseActivity;
import org.mazhuang.androiddebughelper.util.LogUtils;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LogUtils.e("hello, debug helper");
    }
}
