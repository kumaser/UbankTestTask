package com.ubanktesttask.timer;


import com.ubanktesttask.timer.presenter.BasePresenter;
import com.ubanktesttask.timer.view.BaseView;

public interface TimerContract {

    interface View extends BaseView<Presenter> {
        boolean isShown();
        void showDialogFragment();
    }

    interface Presenter extends BasePresenter {
        void attachView(View view);
        void detachView();
        void runTimer();
    }
}
