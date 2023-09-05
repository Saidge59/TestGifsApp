package com.example.testgifsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testgifsapp.domain.DataResult;
import com.example.testgifsapp.service.MyService;

import retrofit2.Call;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rView = findViewById(R.id.recyclerView);
        rView.setLayoutManager(new GridLayoutManager(this, 3));
        rView.setHasFixedSize(true);

        MyService service = new MyService();
        Call<DataResult> call = service.init();
    }
}