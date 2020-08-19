package com.example.loginsample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Boolean isCat1Image = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void LoginClickListner(View view) {
        EditText usernameEditText = (EditText) findViewById(R.id.editTextTextPersonName);
        EditText passwordEditText = (EditText) findViewById(R.id.editTextPassword);

        ImageView catImageView = (ImageView) findViewById(R.id.catImageView);

        Toast.makeText(this, "Welcome "+usernameEditText.getText().toString(), Toast.LENGTH_SHORT).show();

        if (isCat1Image) {
            isCat1Image = false;
            catImageView.setImageResource(R.drawable.cat2);
        } else {
            isCat1Image = true;
            catImageView.setImageResource(R.drawable.cat1);
        }
    }
}