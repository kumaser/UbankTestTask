package com.ubanktesttask.timer.presenter;

import com.ubanktesttask.timer.TimerContract;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class TimerPresenter implements TimerContract.Presenter {

    private final static int TIMER_PERIOD = 5;

    private TimerContract.View mView;

    public void attachView(TimerContract.View view) {
        this.mView = view;
        view.setPresenter(this);
    }

    public void detachView() {
        mView = null;
    }

    @Override
    public void runTimer() {
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .takeUntil(aLong -> aLong == TIMER_PERIOD - 1)
                .doOnComplete(() -> {
                            if (mView.isActive() && !mView.isShown()) {
                                mView.showDialogFragment();
                            }
                })
                .doOnError(Throwable::printStackTrace)
                .subscribe();
    }

    @Override
    public void subscribe() {
    }

    @Override
    public void unsubscribe() {
    }
}
