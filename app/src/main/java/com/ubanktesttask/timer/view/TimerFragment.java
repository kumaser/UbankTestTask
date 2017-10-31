package com.ubanktesttask.timer.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ubanktesttask.R;
import com.ubanktesttask.timer.TimerContract;

public class TimerFragment extends Fragment implements TimerContract.View, View.OnClickListener {

    private TimerContract.Presenter mPresenter;
    private TimerDialogFragment mDialog;

    public static TimerFragment newInstance() {
        return new TimerFragment();
    }

    @Override
    public void setPresenter(TimerContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_timer, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button mStartTimerButton = (Button) view.findViewById(R.id.button_start_timer);
        mStartTimerButton.setOnClickListener(this);
        mDialog = TimerDialogFragment.newInstance();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public boolean isShown() {
        return mDialog.isShown();
    }

    @Override
    public void showDialogFragment() {
        mDialog.show(getFragmentManager(), toString());
    }

    @Override
    public void onClick(View v) {
        mPresenter.runTimer();
    }

}
