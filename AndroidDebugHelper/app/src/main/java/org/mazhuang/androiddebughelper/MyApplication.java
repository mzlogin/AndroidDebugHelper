package org.mazhuang.androiddebughelper;

import android.app.Application;

import org.mazhuang.androiddebughelper.util.LogUtils;

/**
 * Created by Lenovo on 2017/8/1.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        LogUtils.initialize("android-debug-helper.log");
    }
}
