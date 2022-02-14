package com.example.android3lesson2.network;

import com.example.android3lesson2.model.PixabayResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface PixabayApi {
    @GET("/api")
    Call<PixabayResponse> getImages(@Query("key") String key, @Query("q") String keyWord);

}
