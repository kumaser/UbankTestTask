package com.ubanktesttask.numbers;


import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.ubanktesttask.R;

class NumberSequenceViewHolder extends RecyclerView.ViewHolder {

    private NumberSequenceItem numberSequenceItem;

    NumberSequenceViewHolder(View itemView) {
        super(itemView);
        numberSequenceItem = (NumberSequenceItem) itemView.findViewById(R.id.list_item);
    }

    void bind(String numberSequence, String time) {
        bindNumberSequence(numberSequence);
        bindTime(time);
    }

    private void bindNumberSequence(String numberSequence) {
        numberSequenceItem.setNumberSequence(numberSequence);
    }

    private void bindTime(String time) {
        numberSequenceItem.setTime(time);
    }
}
