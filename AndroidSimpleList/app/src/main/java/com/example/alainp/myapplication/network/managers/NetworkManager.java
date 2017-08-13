package com.example.alainp.myapplication.network.managers;

import com.example.alainp.myapplication.models.Guide;
import com.example.alainp.myapplication.models.UpcomingGuidesResponse;
import com.example.alainp.myapplication.network.api.WebApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.List;

import io.reactivex.Flowable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by alainp on 8/13/17.
 */

public class NetworkManager {
    private static final String BASE_URL = "https://web.com/"; // TODO Move to a config file

    private static NetworkManager sInstance;
    private WebApi mWebApi;

    public static NetworkManager getInstance() {
        synchronized (NetworkManager.class) {
            if (sInstance == null) {
                sInstance = new NetworkManager();
            }
        }

        return sInstance;
    }

    private NetworkManager() {
        OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder();
        Gson gson = new GsonBuilder()
                .create();

        mWebApi = new Retrofit.Builder().client(clientBuilder.build())
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
                    .create(WebApi.class);
    }

    public Flowable<List<Guide>> getUpcomingGuides() {
        return mWebApi.getGuides()
                .subscribeOn(Schedulers.io())
                .map(new Function<UpcomingGuidesResponse, List<Guide>>() {

                    @Override
                    public List<Guide> apply(UpcomingGuidesResponse upcomingGuidesResponse) throws Exception {
                        return upcomingGuidesResponse.getData();
                    }
                });
    }

}
