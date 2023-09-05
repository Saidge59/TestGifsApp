package com.example.testgifsapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.testgifsapp.domain.DataResult;
import com.example.testgifsapp.service.MyCallback;
import com.example.testgifsapp.service.MyService;

import retrofit2.Call;

/**
 * MainActivity creates an optimized list to display a list of gifs.
 *
 * @author Shesternyak Denis
 * @version 0.0.1
 */

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView rView = findViewById(R.id.recyclerView);
        rView.setLayoutManager(new GridLayoutManager(this, 3));
        rView.setHasFixedSize(true);

        MyCallback myCallback = new MyCallback(this, rView);

        MyService service = new MyService();
        Call<DataResult> call = service.init();
        call.enqueue(myCallback);
    }
}