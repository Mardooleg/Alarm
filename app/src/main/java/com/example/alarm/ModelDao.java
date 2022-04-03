package com.example.alarm;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;


@Dao
public interface ModelDao {
    @Query("SELECT* FROM Alarm ")
    List<Alarm> getAll(String name);



    @Query("SELECT * FROM Alarm WHERE id = :id")
    Alarm getById(int id);


    @Insert
    void save(Alarm alarm);

    @Update
    void update (Alarm alarm);

    @Delete
    void delete(Alarm alarm);

    }

