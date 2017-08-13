package com.example.alainp.myapplication.models;

import android.app.Application;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by alainp on 8/13/17.
 */

public class Guide {

    @SerializedName("startDate")
    @Expose
    private String startDate;
    @SerializedName("objType")
    @Expose
    private String objType;
    @SerializedName("endDate")
    @Expose
    private String endDate;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("loginRequired")
    @Expose
    private Boolean loginRequired;
    @SerializedName("url")
    @Expose
    private String url;
    @SerializedName("venue")
    @Expose
    private Venue venue;
    @SerializedName("icon")
    @Expose
    private String icon;

    public String getStartDate() {
        return startDate;
    }

    public String getObjType() {
        return objType;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }

    public Boolean getLoginRequired() {
        return loginRequired;
    }

    public String getUrl() {
        return url;
    }

    public Venue getVenue() {
        return venue;
    }

    public String getIcon() {
        return icon;
    }
}
