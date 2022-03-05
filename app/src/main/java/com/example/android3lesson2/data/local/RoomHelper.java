package com.example.android3lesson2.data.local;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import com.example.android3lesson2.data.room.CategoryDao;
import com.example.android3lesson2.data.room.WordDao;
import com.example.android3lesson2.data.room.AppDatabase;
import com.example.android3lesson2.data.room.CategoryModel;
import com.example.android3lesson2.data.room.WordModel;

import java.util.List;

import javax.inject.Inject;

import dagger.hilt.android.qualifiers.ApplicationContext;

public class RoomHelper {
    AppDatabase appDatabase;
    private WordDao wordDao;
    private CategoryDao categoryDao;

    @Inject
    RoomHelper(WordDao wordDao, CategoryDao categoryDao, AppDatabase appDatabase) {
        this.wordDao = wordDao;
        this.categoryDao = categoryDao;
        this.appDatabase = appDatabase;
    }

    public AppDatabase createDatabase(@ApplicationContext Context context) {
        return  Room.databaseBuilder(context, AppDatabase.class, "database").allowMainThreadQueries().build();


    }

    public CategoryModel insertCategory(CategoryModel categoryModel) {
        categoryDao.insert(categoryModel);
        return categoryModel;
    }

    public LiveData<List<CategoryModel>> getAllCategories() {
        return categoryDao.getAll();

    }

    public WordModel insertWord(WordModel wordModel) {
        wordDao.insert(wordModel);
        return wordModel;
    }

    public LiveData<List<WordModel>> getAllWords(String userCategory) {
        return wordDao.getAll(userCategory);
    }
}
