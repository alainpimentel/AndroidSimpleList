package com.example.alainp.myapplication.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by alainp on 8/13/17.
 */

public class UpcomingGuidesResponse {

    @SerializedName("total")
    @Expose
    private String total;
    @SerializedName("data")
    @Expose
    private List<Guide> data = null;

    public String getTotal() {
        return total;
    }

    public List<Guide> getData() {
        return data;
    }
}
