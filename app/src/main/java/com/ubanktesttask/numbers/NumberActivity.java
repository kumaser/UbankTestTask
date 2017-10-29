package com.ubanktesttask.numbers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.ubanktesttask.R;
import com.ubanktesttask.timer.TimerActivity;

public class NumberActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView mNumberSequenceList = (RecyclerView) findViewById(R.id.number_sequence_list);
        mNumberSequenceList.setLayoutManager(new LinearLayoutManager(this));
        NumberSequenceAdapter mAdapter = new NumberSequenceAdapter();
        mNumberSequenceList.setAdapter(mAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_numbers_sequence, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.item_show_timer) {
            showTimerActivity();
        }
        return super.onOptionsItemSelected(item);
    }

    private void showTimerActivity() {
        Intent intent = new Intent(this, TimerActivity.class);
        startActivity(intent);
    }
}
