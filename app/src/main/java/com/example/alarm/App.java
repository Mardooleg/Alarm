package com.example.alarm;

import android.app.Application;

import androidx.room.Room;

public class App extends Application {
    public static App instanse;
    private AppDataBase appDatabase;
    @Override
    public void onCreate() {
        instanse = this;
        appDatabase = Room.databaseBuilder(this,AppDataBase.class,"Bazadannux")
                .allowMainThreadQueries()
                .build();

        super.onCreate();
    }
    public static App getInstance(){
        return instanse;
    }
    public AppDataBase getAppDatabase(){
        return appDatabase;
    }

}