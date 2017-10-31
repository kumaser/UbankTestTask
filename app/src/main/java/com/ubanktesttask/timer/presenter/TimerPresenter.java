package com.ubanktesttask.timer.presenter;

import com.ubanktesttask.timer.TimerContract;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class TimerPresenter implements TimerContract.Presenter {

    private final static int TIMER_PERIOD = 5;

    private TimerContract.View mView;
    private CompositeDisposable mDisposable = new CompositeDisposable();

    public void attachView(TimerContract.View view) {
        this.mView = view;
        view.setPresenter(this);
    }

    public void detachView() {
        mView = null;
    }

    @Override
    public void runTimer() {
        Disposable disposable = Observable.interval(1, TimeUnit.SECONDS)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .takeUntil(aLong -> aLong == TIMER_PERIOD - 1)
                .doOnComplete(() -> {
                    if (mView.isActive() && !mView.isShown()) {
                        mView.showDialogFragment();
                    }
                })
                .doOnError(Throwable::printStackTrace).subscribe();
        mDisposable.add(disposable);
    }

    @Override
    public void subscribe() {
        if (mDisposable.isDisposed()) {
            mDisposable = new CompositeDisposable();
        }
    }

    @Override
    public void unsubscribe() {
        if (!mDisposable.isDisposed()) {
            mDisposable.dispose();
        }
    }

}
