package org.mazhuang.androiddebughelper.home;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;

import org.mazhuang.androiddebughelper.util.NetworkUtils;
import org.mazhuang.androiddebughelper.util.WirelessConnectUtils;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by Lenovo on 2017/8/3.
 */

public class TaskScheduler {

    private Executor mExecutor;
    private Handler mHandler;

    public interface TaskResultListener {
        void onSucceed(String data);
        void onFailed(String msg);
    }

    private static class InstanceHolder {
        private static TaskScheduler sInstance = new TaskScheduler();
    }

    public static TaskScheduler getInstance() {
        return InstanceHolder.sInstance;
    }

    private TaskScheduler() {
        mExecutor = Executors.newSingleThreadExecutor();
        mHandler = new Handler(Looper.getMainLooper());
    }

    public void setAdbTcpPort(@NonNull final TaskResultListener listener) {
        final int result = WirelessConnectUtils.setAdbTcpPort();
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                switch (result) {
                    case WirelessConnectUtils.RESULT_FAILED:
                        listener.onFailed("配置失败");
                        break;

                    case WirelessConnectUtils.RESULT_PERMISSION_DENIED:
                        listener.onFailed("需要 ROOT 权限");
                        break;

                    case WirelessConnectUtils.RESULT_SUCCEED:
                        listener.onSucceed(NetworkUtils.getIpAddress());
                        break;

                    default:
                        break;
                }
            }
        });
    }
}
