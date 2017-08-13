package com.example.alainp.myapplication.ui.activities.adapters;

import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.alainp.myapplication.R;
import com.example.alainp.myapplication.databinding.ListItemGuideBinding;
import com.example.alainp.myapplication.models.Guide;
import com.example.alainp.myapplication.models.Venue;
import com.example.alainp.myapplication.utils.ImageUtils;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

/**
 * Created by alainp on 8/13/17.
 */

public class UpcomingGuidesAdapter extends RecyclerView.Adapter {

    private List<Guide> mGuides;

    public UpcomingGuidesAdapter() {
        mGuides = Collections.emptyList();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemGuideBinding binding = ListItemGuideBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new GuideViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        Guide guide = mGuides.get(position);
        ((GuideViewHolder) holder).bindData(guide);
    }

    @Override
    public int getItemCount() {
        return mGuides.size();
    }

    public void setGuides(List<Guide> guides) {
        this.mGuides = guides;
    }

    private static class GuideViewHolder extends RecyclerView.ViewHolder {
        ListItemGuideBinding mBinding;

        GuideViewHolder(ListItemGuideBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
        }

        void bindData(Guide guide) {
            mBinding.setGuide(guide);

            Venue venue = guide.getVenue();
            if (venue != null) {
                String cityStateText = "San Francisco, CA"; // TODO used for testing since api is not returning data
                if (venue.getCity() != null && venue.getState() != null) {
                     cityStateText = String.format(Locale.US, itemView.getContext().getResources().getString(R.string.city_state), venue.getCity(), venue.getState());
                }
                mBinding.textCityState.setText(cityStateText);
            }

            ImageUtils.getInstance().loadImage(itemView.getContext(), mBinding.imageGuideIcon, guide.getIcon());
        }
    }
}
