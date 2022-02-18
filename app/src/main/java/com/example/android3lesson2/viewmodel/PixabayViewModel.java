package com.example.android3lesson2.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.android3lesson2.network_model.Hits;
import com.example.android3lesson2.repository.PixabayRepository;

import java.util.List;

public class PixabayViewModel extends ViewModel {
    public MutableLiveData<List<Hits>> imageList = new MutableLiveData();
    PixabayRepository repository = PixabayRepository.getInstance();

    public MutableLiveData<List<Hits>> getImages(String word) {
        imageList = repository.getImages(word);
        return imageList;
    }
}
