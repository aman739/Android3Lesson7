package com.example.android3lesson2.data.room;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {CategoryModel.class, WordModel.class}, version = 2, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    AppDatabase appdatabase;

    public AppDatabase getDatabase() {
        return appdatabase;
    }

    public abstract CategoryDao categoryDao();

    public abstract WordDao wordDao();
}
