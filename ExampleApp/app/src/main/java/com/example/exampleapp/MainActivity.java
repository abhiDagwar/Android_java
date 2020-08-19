package com.example.exampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.InflateException;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickFunction(View view) {
        EditText nameEditText = (EditText) findViewById(R.id.editTextTextPersonName);

        Log.i("Info", "Button Pressed!");
        Log.i("Info", nameEditText.getText().toString());
    }
}

