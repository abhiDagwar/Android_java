package com.example.currencyconverter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        Button button = (Button) getView().findViewById(R.id.currencyButton);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                // do something
                EditText currecyText = (EditText) getView().findViewById(R.id.currencyEditText);
                TextView convertedCurrencyTextView = (TextView) getView().findViewById(R.id.convertedCurrencyTextView);
                Log.i("Info", "This is test");
                // rupees = 15.29 * real
                Double enterCurrency = Double.parseDouble(currecyText.getText().toString());
                Double convertedCurrency = 15.29 * enterCurrency;

                Toast.makeText(getActivity(), convertedCurrency.toString(), Toast.LENGTH_SHORT).show();

                convertedCurrencyTextView.setText(convertedCurrency.toString());
            }
        });
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }
}