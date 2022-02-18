package com.example.android3lesson2.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.android3lesson2.network_model.Hits;
import com.example.android3lesson2.network_model.PixabayResponse;
import com.example.android3lesson2.utils.App;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PixabayRepository {

    public static PixabayRepository pixabayRepository;

    public static PixabayRepository getInstance() {
        if (pixabayRepository == null) {
            return new PixabayRepository();

        }
        return pixabayRepository;
    }

    public MutableLiveData<List<Hits>> getImages(String word) {
        MutableLiveData<List<Hits>> imagesList = new MutableLiveData<>();

        App.retrofitClient.providePixabayApi().getImages(word).enqueue(new Callback<PixabayResponse>() {
            @Override
            public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                if (response.isSuccessful()) {
                    imagesList.postValue(response.body().getHits());

                }

            }

            @Override
            public void onFailure(Call<PixabayResponse> call, Throwable t) {

            }
        });
        return imagesList;


    }
}
