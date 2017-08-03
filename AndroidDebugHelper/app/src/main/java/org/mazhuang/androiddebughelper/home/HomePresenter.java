package org.mazhuang.androiddebughelper.home;

/**
 * Created by Lenovo on 2017/8/3.
 */

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;

    HomePresenter(HomeContract.View view) {
        mView = view;
    }

    @Override
    public void setAdbTcpPort() {
        TaskScheduler.getInstance().setAdbTcpPort(new TaskScheduler.TaskResultListener() {
            @Override
            public void onSucceed(String data) {
                mView.onSetAdbTcpPortSucceed(data);
            }

            @Override
            public void onFailed(String msg) {
                mView.onSetAdbTcpPortFailed(msg);
            }
        });
    }
}
