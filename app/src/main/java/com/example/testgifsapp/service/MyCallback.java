package com.example.testgifsapp.service;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import androidx.recyclerview.widget.RecyclerView;

import com.example.testgifsapp.SecondActivity;
import com.example.testgifsapp.adapter.DataAdapter;
import com.example.testgifsapp.domain.*;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyCallback implements Callback<DataResult> {

    public static final String TAG = "MyCallback";

    private Context ctx;
    private RecyclerView rView;
    private List<UrlImg> dataModelArrayList;
    private DataAdapter dataAdapter;

    public MyCallback(Context ctx, RecyclerView textView) {
        this.ctx = ctx;
        this.rView = textView;
        this.dataModelArrayList = new ArrayList<>();
    }

    @Override
    public void onResponse(Call<DataResult> call, Response<DataResult> response) {
        if (!response.isSuccessful()) {
            Log.d(TAG, "onResponse: no response");
            return;
        }

        DataResult dataResult = response.body();
        List<Data> datasets = dataResult.getData();
        for (Data data : datasets) {
            Images images = data.getImages();
            UrlImg urlImg = images.getUrlImg();
            dataModelArrayList.add(urlImg);
        }

        dataAdapter = new DataAdapter(ctx, dataModelArrayList);
        rView.setAdapter(dataAdapter);
        dataAdapter.setOnItemClickListener(pos -> {
                Intent intent = new Intent(ctx, SecondActivity.class);
                UrlImg urlImg = dataModelArrayList.get(pos);

                intent.putExtra("imageUrl", urlImg.getUrl());
                ctx.startActivity(intent);
            });
    }

    @Override
    public void onFailure(Call<DataResult> call, Throwable t) {
        Log.d(TAG, "onFailure: " + t.getMessage());
    }
}
