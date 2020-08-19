package com.example.convertr_rupee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void clickConvertButton(View view) {
        EditText currecyText = (EditText) findViewById(R.id.currencyEditText);
        TextView convertedCurrencyTextView = (TextView) findViewById(R.id.rupeesTextView);
        String currencyString = currecyText.getText().toString();

        if (currencyString.trim().length() == 0){
            Toast.makeText(this, "Please enter amount", Toast.LENGTH_SHORT).show();
            return;
        }

        Log.i("Info", "This is test");
        // rupees = 15.29 * real
        Double enterCurrency = Double.parseDouble(currencyString);
        Double convertedCurrency = 15.29 * enterCurrency;

        convertedCurrencyTextView.setText("₹"+convertedCurrency.toString());
    }
}