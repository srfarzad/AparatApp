package com.androidlearn.aparat.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;

@Entity(tableName = "App")
public class App {

    @ColumnInfo(name = "id")
    private int id;

    @ColumnInfo(name = "title")
    private String title;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
