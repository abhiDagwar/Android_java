package com.example.currencyconverter;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.util.Log;
import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    public void clickConvertButton(View view) {
        EditText currecyText = (EditText) findViewById(R.id.currencyEditText);
        TextView convertedCurrencyTextView = (TextView) findViewById(R.id.convertedCurrencyTextView);
        Log.i("Info", "This is test");
        // rupees = 15.29 * real
        Double enterCurrency = Double.parseDouble(currecyText.getText().toString());
        Double convertedCurrency = 15.29 * enterCurrency;

        Toast.makeText(this, convertedCurrency.toString(), Toast.LENGTH_SHORT).show();

        convertedCurrencyTextView.setText(convertedCurrency.toString());
    }
}