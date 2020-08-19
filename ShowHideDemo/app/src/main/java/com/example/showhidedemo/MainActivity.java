package com.example.showhidedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView visibleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        visibleTextView = (TextView)findViewById(R.id.visibleTextView);
    }

    public void show(View view) {
        if (visibleTextView.getVisibility() == View.INVISIBLE) {
            visibleTextView.setVisibility(View.VISIBLE);
        }
    }

    public void hide(View view) {
        if (visibleTextView.getVisibility() == View.VISIBLE) {
            visibleTextView.setVisibility(View.INVISIBLE);
        }
    }
}