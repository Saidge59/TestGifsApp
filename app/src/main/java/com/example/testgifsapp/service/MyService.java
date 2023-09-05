package com.example.testgifsapp.service;

import com.example.testgifsapp.domain.DataResult;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * MyService initializes the object of interaction with REST API.
 *
 * @author Shesternyak Denis
 * @version 0.0.1
 */

public class MyService {
    private static final String API_KEY = "zXHFGCkDfOA3qPR56L8Kvd58t4Mp8Gt8";
    private static final String BASE_URL = "https://api.giphy.com/v1/gifs/";

    public Call<DataResult> init() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GiphyService giphyService = retrofit.create(GiphyService.class);
        return giphyService.getData(API_KEY);
    }
}
