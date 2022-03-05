package com.example.android3lesson2.di;

import android.content.Context;

import com.example.android3lesson2.data.local.RoomHelper;
import com.example.android3lesson2.data.room.CategoryDao;
import com.example.android3lesson2.data.room.WordDao;
import com.example.android3lesson2.data.room.AppDatabase;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.android.qualifiers.ApplicationContext;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class RoomModule {
    RoomHelper roomHelper;


    @Singleton
    @Provides
    public AppDatabase provideDatabase(@ApplicationContext Context context) {
        return roomHelper.createDatabase(context);

    }

    @Singleton
    @Provides
    public WordDao provideWordDao(AppDatabase appDatabase) {
        return appDatabase.wordDao();
    }

    @Singleton
    @Provides
    public CategoryDao provideCategoryDao(AppDatabase appDatabase) {
        return appDatabase.categoryDao();
    }

}
