package com.example.alainp.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alainp on 8/13/17.
 */

public class Venue {

    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("state")
    @Expose
    private String state;

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }
}
