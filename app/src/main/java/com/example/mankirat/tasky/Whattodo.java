package com.example.mankirat.tasky;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Mankirat on 16-02-2017.
 */

public class Whattodo {

    private String date,time,location,title,category;

    public Whattodo(){

    }

    public String getTime() {
        return time;
    }

    public String getDate() {
        return date;
    }

    public String getTitle() {
        return title;
    }

    public String getLocation() {
        return location;
    }

    public String getCategory() {
        return category;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}
