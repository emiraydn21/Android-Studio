package com.example.javamaps.model;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.javamaps.roomdb.PlaceDao;

@Database(entities = {Place.class},version = 1)
public abstract class PlaceDatabase extends RoomDatabase {
    public abstract PlaceDao placeDao();
}
