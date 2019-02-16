package com.example.androidtraining2019.Utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidtraining2019.R;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;

public class DownloadFileAsyncTask extends AsyncTask<String,String, Bitmap> {
    ImageView imgView;
    TextView textView;

    public DownloadFileAsyncTask(ImageView imgView, TextView textView) {
        this.imgView = imgView;
        this.textView=textView;
    }

    @Override
    protected void onPreExecute() {
        imgView.setImageResource(R.drawable.loading_image);
    }

    @Override
    protected void onPostExecute(Bitmap bitmap) {
        imgView.setImageBitmap(bitmap);
    }

    @Override
    protected void onProgressUpdate(String... values) {
        textView.setText(""+values[0]);
    }

    @Override
    protected Bitmap doInBackground(String... strings) {

        try {
            publishProgress("doInBackground started ...");
            Thread.sleep(1000);
            URL url = new URL(strings[0]);
            HttpURLConnection urlcon = (HttpURLConnection) url.openConnection();
            publishProgress("Open the connection ...");
            Thread.sleep(1000);
            urlcon.setDoInput(true);
            urlcon.connect();
            publishProgress("Connected...");
            Thread.sleep(1000);
            InputStream in = urlcon.getInputStream();
            publishProgress("Input stream getted ...");
            Thread.sleep(1000);
            Bitmap mIcon = BitmapFactory.decodeStream(in);
            publishProgress("Loading Done!");
            Thread.sleep(1000);
            return  mIcon;
        }catch (Exception ex){
            Log.e(DownloadFileAsyncTask.class.getSimpleName(),ex.getMessage());
        }
        return null;
    }
}
