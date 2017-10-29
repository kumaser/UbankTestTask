package com.ubanktesttask.timer.view;


import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;

import com.ubanktesttask.R;

public class TimerDialogFragment extends DialogFragment {

    private boolean shown;

    public static TimerDialogFragment newInstance() {
        return new TimerDialogFragment();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new AlertDialog.Builder(getContext())
                .setTitle(R.string.title_timer_alert_dialog)
                .setMessage(R.string.message_timer_alert_dialog)
                .setNegativeButton(R.string.cancel, null)
                .create();
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        shown = false;
    }

    @Override
    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        shown = false;
    }

    @Override
    public void show(FragmentManager manager, String tag) {
        super.show(manager, tag);
        shown = true;
    }

    public boolean isShown() {
        return shown;
    }
}
