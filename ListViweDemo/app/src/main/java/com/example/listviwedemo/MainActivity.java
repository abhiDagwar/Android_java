package com.example.listviwedemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUpListView();
    }

    public void setUpListView() {
        ListView itemListView = findViewById(R.id.itemsListView);

        final ArrayList<String> itemList = new ArrayList<String> (asList("Milk", "Chocolate", "Olive Oil", "Curd", "Biscuit"));
//        itemList.add("Milk");
//        itemList.add("Chocolate");
//        itemList.add("Olive Oil");
//        itemList.add("Cheez");
//        itemList.add("Biscuit");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, itemList);
        itemListView.setAdapter(arrayAdapter);

        itemListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getApplicationContext(), "Item Selected : " +itemList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}