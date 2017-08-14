package com.example.alainp.myapplication.ui.activities;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.example.alainp.myapplication.R;
import com.example.alainp.myapplication.databinding.ActivityMainBinding;
import com.example.alainp.myapplication.models.Guide;
import com.example.alainp.myapplication.network.managers.NetworkManager;
import com.example.alainp.myapplication.ui.activities.adapters.UpcomingGuidesAdapter;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.subscribers.DisposableSubscriber;

public class MainActivity extends AppCompatActivity {

    private CompositeDisposable mCompositeDisposable;
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mCompositeDisposable = new CompositeDisposable();

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mBinding.recyclerViewGuides.setLayoutManager(layoutManager);
        UpcomingGuidesAdapter adapter = new UpcomingGuidesAdapter();
        mBinding.recyclerViewGuides.setAdapter(adapter);

        mBinding.textErrorMessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mBinding.progressBar.setVisibility(View.VISIBLE);
                mBinding.textErrorMessage.setVisibility(View.GONE);
                fetchData();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();

        fetchData();
    }

    @Override
    protected void onStop() {
        mCompositeDisposable.clear();
        super.onStop();
    }

    private void fetchData() {
        mCompositeDisposable.add(
                NetworkManager.getInstance().getUpcomingGuides()
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeWith(new DisposableSubscriber<List<Guide>>() {
                            @Override
                            public void onNext(List<Guide> guides) {
                                ((UpcomingGuidesAdapter) mBinding.recyclerViewGuides.getAdapter()).setGuides(guides);
                                // TODO Notify only the items that have changed
                                mBinding.recyclerViewGuides.getAdapter().notifyDataSetChanged();
                                mBinding.progressBar.setVisibility(View.GONE);
                                mBinding.recyclerViewGuides.setVisibility(View.VISIBLE);
                            }

                            @Override
                            public void onError(Throwable t) {
                                mBinding.textErrorMessage.setVisibility(View.VISIBLE);
                                mBinding.progressBar.setVisibility(View.GONE);
                                mBinding.recyclerViewGuides.setVisibility(View.GONE);
                            }

                            @Override
                            public void onComplete() {
                            }
                        })
        );
    }
}
