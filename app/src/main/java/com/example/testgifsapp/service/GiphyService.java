package com.example.testgifsapp.service;

import com.example.testgifsapp.domain.DataResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * GiphyService interface for address management.
 *
 * @author Shesternyak Denis
 * @version 0.0.1
 */

public interface GiphyService {
    @GET("trending")
    Call<DataResult> getData(@Query("api_key") String api_key);
}
