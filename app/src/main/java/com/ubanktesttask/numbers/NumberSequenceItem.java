package com.ubanktesttask.numbers;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.ubanktesttask.R;

public class NumberSequenceItem extends LinearLayout {

    private TextView mNumberSequence;
    private TextView mTime;
    private Point mDisplaySize;

    public NumberSequenceItem(Context context, AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater inflater = LayoutInflater.from(context);
        inflater.inflate(R.layout.item_sequence_numbers_with_time, this);
        mNumberSequence = (TextView) findViewById(R.id.number_sequence);
        mTime = (TextView) findViewById(R.id.time);
        Display display = ((Activity) getContext()).getWindowManager().getDefaultDisplay();
        mDisplaySize = new Point();
        display.getSize(mDisplaySize);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int childWidth = mDisplaySize.x - getPaddingStart() - getPaddingEnd();
        int childHeight = mDisplaySize.y - getPaddingTop() - getPaddingBottom();

        mNumberSequence.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.AT_MOST), MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST));
        int mNumberSequenceMeasuredWidth = mNumberSequence.getMeasuredWidth();

        mTime.measure(MeasureSpec.makeMeasureSpec(childWidth, MeasureSpec.AT_MOST), MeasureSpec.makeMeasureSpec(childHeight, MeasureSpec.AT_MOST));
        int mTimeMeasuredWidth = mTime.getMeasuredWidth();
        LinearLayout.LayoutParams mTimeLayoutParams = (LayoutParams) mTime.getLayoutParams();
        int mTimeStartMargin = mTimeLayoutParams.getMarginStart();

        if (mNumberSequenceMeasuredWidth + mTimeMeasuredWidth + mTimeStartMargin >= childWidth) {
            mNumberSequenceMeasuredWidth = childWidth - mTimeMeasuredWidth - mTimeStartMargin;
            mNumberSequence.setMaxWidth(mNumberSequenceMeasuredWidth);
        } else {
            mNumberSequence.setMaxWidth(childWidth);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public void setNumberSequence(String text) {
        mNumberSequence.setText(text);
    }

    public void setTime(String text) {
        mTime.setText(text);
    }
}
