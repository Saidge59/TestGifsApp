package com.example.testgifsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rView = findViewById(R.id.recyclerView);
        rView.setLayoutManager(new GridLayoutManager(this, 3));
        rView.setHasFixedSize(true);
    }
}