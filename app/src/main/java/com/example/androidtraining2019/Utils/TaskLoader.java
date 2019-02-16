package com.example.androidtraining2019.Utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Log;
import android.widget.ImageView;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class TaskLoader extends AsyncTaskLoader<Bitmap> {

    ImageView imgImageView;
    String murl;
    public TaskLoader(@NonNull Context context, ImageView imgImageView, String url) {
        super(context);
        this.imgImageView = imgImageView;
        this.murl=url;
    }

    @Nullable
    @Override
    public Bitmap loadInBackground() {
        try {
            URL url = new URL(murl);
            HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
            urlcon.setDoInput(true);
            urlcon.connect();
            InputStream in = urlcon.getInputStream();
            Bitmap mIcon = BitmapFactory.decodeStream(in);
            return  mIcon;
        }catch (Exception ex){
            Log.e(DownloadFileAsyncTask.class.getSimpleName(),ex.getMessage());
        }
        return null;
    }
}
