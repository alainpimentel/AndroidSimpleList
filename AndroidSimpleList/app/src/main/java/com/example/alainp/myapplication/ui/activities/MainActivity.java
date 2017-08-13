package com.example.alainp.myapplication.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.alainp.myapplication.R;
import com.example.alainp.myapplication.models.Guide;
import com.example.alainp.myapplication.network.managers.NetworkManager;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subscribers.DisposableSubscriber;

public class MainActivity extends AppCompatActivity {

    protected CompositeDisposable mCompositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mCompositeDisposable = new CompositeDisposable();
    }

    @Override
    protected void onStart() {
        super.onStart();

        mCompositeDisposable.add(
                NetworkManager.getInstance().getUpcomingGuides()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSubscriber<List<Guide>>() {
                            @Override
                            public void onNext(List<Guide> guides) {
                                Log.d("concha", "ere");
                            }

                            @Override
                            public void onError(Throwable t) {
                                Log.d("concha", "ere");
                            }

                            @Override
                            public void onComplete() {
                                Log.d("concha", "ere");
                            }
                        })
        );

    }

    @Override
    protected void onStop() {
        mCompositeDisposable.clear();
        super.onStop();
    }
}
