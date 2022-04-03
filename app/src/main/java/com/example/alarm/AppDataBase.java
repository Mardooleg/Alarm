package com.example.alarm;

import androidx.room.Database;
import androidx.room.RoomDatabase;


@Database(entities = {Alarm.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    public abstract ModelDao modelDao();



}
