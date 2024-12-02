package com.nathannicolau.guarani.app;

import android.app.Application;

import com.nathannicolau.guarani.app.model.AppDatabase;

public class App extends Application {

    private static AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        appDatabase = AppDatabase.getDatabase(getApplicationContext());
    }

    public static AppDatabase getDatabase() {
        return appDatabase;
    }
}
