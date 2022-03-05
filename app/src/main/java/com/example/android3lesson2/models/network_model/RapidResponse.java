package com.example.android3lesson2.models.network_model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public class RapidResponse {
    @SerializedName("translatedText")
    private String translatedText;
    @SerializedName("match")
    private List<RapidHits> match = null;

    public String getTranslatedText() {
        return translatedText;
    }

    public void setTranslatedText(String translatedText) {
        this.translatedText = translatedText;
    }

    public List<RapidHits> getMatch() {
        return match;
    }

    public void setMatch(List<RapidHits> match) {
        this.match = match;
    }

}

