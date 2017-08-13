package com.example.alainp.myapplication.network.api;

import com.example.alainp.myapplication.models.UpcomingGuidesResponse;

import io.reactivex.Flowable;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by alainp on 8/13/17.
 */

public interface WebApi {
    @GET("service/v2/upcomingGuides/")
    Flowable<UpcomingGuidesResponse> getGuides();
}
