package com.example.android3lesson2.data.room;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {
    @Insert
    void insert(WordModel wordModel);

    @Query("SELECT * FROM WordModel WHERE category =:userCategory")
    LiveData<List<WordModel>> getAll(String userCategory);
}