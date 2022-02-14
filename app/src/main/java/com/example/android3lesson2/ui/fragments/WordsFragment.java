package com.example.android3lesson2.ui.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.android3lesson2.adapter.ImageAdapter;
import com.example.android3lesson2.base.BaseFragment;
import com.example.android3lesson2.databinding.FragmentWordsBinding;
import com.example.android3lesson2.model.Hits;
import com.example.android3lesson2.model.PixabayResponse;
import com.example.android3lesson2.utils.App;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class WordsFragment extends BaseFragment<FragmentWordsBinding> {

    private static final String TAG = "WordsFragment";
    ImageAdapter imageAdapter;


    @Override
    public FragmentWordsBinding bind() {
        return FragmentWordsBinding.inflate(getLayoutInflater());
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initListeners();
        initAdapter();
    }

    private void initListeners() {
        binding.btnFetch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = binding.etWords.getText().toString();

                App.retrofitClient.providePixabayApi().getImages("25678452-c644ee6efc6979cc35175839e", text).enqueue(new Callback<PixabayResponse>() {
                    @Override
                    public void onResponse(Call<PixabayResponse> call, Response<PixabayResponse> response) {
                        imageAdapter.setApiData((ArrayList<Hits>) response.body().getHits());
                        binding.recyclerview.setAdapter(imageAdapter);


                    }

                    @Override
                    public void onFailure(Call<PixabayResponse> call, Throwable t) {
                        Toast.makeText(getContext(), "Fetch wasn't successful", Toast.LENGTH_SHORT).show();

                    }
                });


            }
        });
    }

    private void initAdapter() {
        imageAdapter = new ImageAdapter();
    }


}