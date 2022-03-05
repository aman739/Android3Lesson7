package com.example.android3lesson2.data.room;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class WordModel {
    @PrimaryKey(autoGenerate = true)
    public int id;
    private String word;
    private String category;
    private int image;

    public WordModel(String word, String category, int image) {
        this.word = word;
        this.category = category;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
