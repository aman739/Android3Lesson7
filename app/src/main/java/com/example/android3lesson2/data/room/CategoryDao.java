package com.example.android3lesson2.data.room;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface CategoryDao {
    @Insert
    void insert(CategoryModel categoryModels);


    @Query("SELECT * FROM categorymodel")
    LiveData<List<CategoryModel>> getAll();

}
