package com.example.testgifsapp.service;

import com.example.testgifsapp.domain.DataResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GiphyService {
    @GET("trending")
    Call<DataResult> getData(@Query("api_key") String api_key);
}
