package com.example.eggtimer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timerTextView;
    SeekBar eggTimerSeekBar;
    Button startButton;
    Boolean isCounterActive = false;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timerTextView = (TextView) findViewById(R.id.timerTextView);
        startButton = (Button) findViewById(R.id.timerButton);

        setupSeekBar();
    }

    private void setupSeekBar() {
        int max = 600;
        int startValue = 30;
        eggTimerSeekBar = (SeekBar)findViewById(R.id.eggSeekBar);
        eggTimerSeekBar.setMax(max);
        eggTimerSeekBar.setProgress(startValue);
        eggTimerSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void start(View view) {

        if (isCounterActive) {
            resetTimer();
        } else {
            isCounterActive = true;
            startButton.setText("STOP!");
            eggTimerSeekBar.setEnabled(false);

            countDownTimer = new CountDownTimer(eggTimerSeekBar.getProgress() * 1000 + 100, 1000) {

                @Override
                public void onTick(long millisUntilFinished) {
                    updateTimer((int) millisUntilFinished / 1000);
                }

                @Override
                public void onFinish() {
                    resetTimer();
                    //MediaPlayer mediaPlayer = MediaPlayer.create(this, R.raw.service);
                    //mediaPlayer.start();
                    Log.i("Finish!", "Timer is done.");
                }
            }.start();
        }
    }

    private void resetTimer() {
        timerTextView.setText("0:30");
        eggTimerSeekBar.setProgress(30);
        eggTimerSeekBar.setEnabled(true);
        countDownTimer.cancel();
        startButton.setText("START");
        isCounterActive = false;
    }

    private void updateTimer(int secondsLeft) {
        int minutes = secondsLeft / 60;
        int seconds = secondsLeft - (minutes * 60);
        String secondString = Integer.toString(seconds);

        if (seconds <= 9) {
            secondString = "0" + secondString;
        }

        timerTextView.setText(Integer.toString(minutes) + ":" + secondString);
    }
}