package com.androidlearn.aparat.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.androidlearn.aparat.models.Video;

@Database(entities = {Video.class}, version = 1, exportSchema = true)
public abstract class VideoDatabase extends RoomDatabase {


    private static VideoDatabase instance = null;

    public abstract IDAO idao();


    public static synchronized VideoDatabase getInstance(Context context){

        if(instance==null){

            instance =  Room.databaseBuilder(context,VideoDatabase.class,"video.db")
                    .allowMainThreadQueries()
                    .build();

        }

        return instance;

    }

}
