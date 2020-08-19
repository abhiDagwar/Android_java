package com.example.timetables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    ListView timeTableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupListView();
        setupSeekBar();
        generateTimeTable(10);
    }

    private void setupSeekBar() {
        final SeekBar timeTableSeekBar = (SeekBar)findViewById(R.id.timeTableSeekBar);
        int max = 20;
        int staringPosition = 10;
        timeTableSeekBar.setMax(max);
        timeTableSeekBar.setProgress(staringPosition);
        timeTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min = 1;
                int timeTableNumber;

                if (progress < 1) {
                    timeTableNumber = min;
                    timeTableSeekBar.setProgress(timeTableNumber);
                } else {
                    timeTableNumber = progress;
                }

                generateTimeTable(timeTableNumber);

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private void setupListView() {
        timeTableListView = (ListView)findViewById(R.id.timeTableListView);
    }

    public void generateTimeTable(int timesTableNumber) {

        ArrayList<String> timeTableContent = new ArrayList<String>();

        for (int i = 1; i <= 10; i++) {
            timeTableContent.add(Integer.toString(timesTableNumber*i));
        }

        ArrayAdapter<String> timeTableAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, timeTableContent);
        timeTableListView.setAdapter(timeTableAdapter);

    }
}