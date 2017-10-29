package com.ubanktesttask.numbers;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.ubanktesttask.R;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Locale;

class NumberSequenceAdapter extends RecyclerView.Adapter<NumberSequenceViewHolder> {

    private static final int ITEM_COUNT = 100;

    @Override
    public NumberSequenceViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new NumberSequenceViewHolder(inflater.inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(NumberSequenceViewHolder holder, int position) {
        final String numberSequence = getNumberSequenceByPosition(position);
        final String formattedTime = getFormattedTime();
        holder.bind(numberSequence, formattedTime);
    }

    @Override
    public int getItemCount() {
        return ITEM_COUNT;
    }

    private String getNumberSequenceByPosition(int position) {
        String result = "";
        for (int index = 1; index < position + 3; index++) {
            if (index > 1) {
                result += "_";
            }
            result += index;
        }
        return result;
    }

    private String getFormattedTime() {
        DateFormat df = new SimpleDateFormat("HH:mm", Locale.getDefault());
        return df.format(System.currentTimeMillis());
    }
}
