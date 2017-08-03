package org.mazhuang.androiddebughelper.home;

import org.mazhuang.androiddebughelper.base.BasePresenter;
import org.mazhuang.androiddebughelper.base.BaseView;

/**
 * Created by Lenovo on 2017/8/3.
 */

public interface HomeContract {
    interface Presenter extends BasePresenter {
        void setAdbTcpPort();
    }

    interface View extends BaseView {
        void onSetAdbTcpPortSucceed(String ipAddress);
        void onSetAdbTcpPortFailed(String msg);
    }
}
