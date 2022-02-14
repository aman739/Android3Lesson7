package com.example.android3lesson2.utils;

import android.app.Application;

import com.example.android3lesson2.network.PixabayApi;
import com.example.android3lesson2.network.RetrofitClient;

public class App extends Application {
    PixabayApi api;
    public static RetrofitClient retrofitClient;

    @Override
    public void onCreate() {
        super.onCreate();
        retrofitClient = new RetrofitClient();
        api = retrofitClient.providePixabayApi();
    }
}
