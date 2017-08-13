package com.example.alainp.myapplication.utils;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.example.alainp.myapplication.R;

/**
 * Created by alainp on 8/13/17.
 */

public class ImageUtils {

    private static ImageUtils sInstance;

    public static ImageUtils getInstance() {
        if (sInstance == null) {
            sInstance = new ImageUtils();
        }

        return sInstance;
    }

    private ImageUtils() {}

    public void loadImage(Context context, ImageView imageView, String url) {
        RequestOptions requestOptions = new RequestOptions()
                .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC)
                .placeholder(R.drawable.ic_cloud_download)
                .centerCrop();

        Glide.with(context)
                .load(url)
                .apply(requestOptions)
                .into(imageView);
    }
}
