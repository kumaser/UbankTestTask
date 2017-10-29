package com.ubanktesttask.timer;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.ubanktesttask.R;
import com.ubanktesttask.timer.presenter.TimerPresenter;
import com.ubanktesttask.timer.view.TimerFragment;

public class TimerActivity extends AppCompatActivity {

    private TimerContract.Presenter mTimerPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timer);

        TimerFragment timerFragment = (TimerFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        if (timerFragment == null) {
            timerFragment = TimerFragment.newInstance();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.add(R.id.fragment_container, timerFragment);
            transaction.commit();
        }

        mTimerPresenter = (TimerPresenter) getLastCustomNonConfigurationInstance();
        if (mTimerPresenter == null) {
            mTimerPresenter = new TimerPresenter();
        }
        mTimerPresenter.attachView(timerFragment);

    }

    @Override
    public Object onRetainCustomNonConfigurationInstance() {
        return mTimerPresenter;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mTimerPresenter.detachView();
    }
}
