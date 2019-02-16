package com.example.androidtraining2019;

import android.app.LoaderManager;
import android.content.Loader;
import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.androidtraining2019.Utils.DownloadFileAsyncTask;

public class LoadImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_image);

    }

    public void loadImageFromWeb(View view) {
        DownloadFileAsyncTask downloadFileAsyncTask=new DownloadFileAsyncTask((ImageView) findViewById(R.id.img_frominternet),
                (TextView)findViewById(R.id.txtvu_progessresult));
        downloadFileAsyncTask.execute("https://www.android.com/static/2016/img/hero-carousel/banner-android-p-2.jpg");
    }
    public void loadFromLoader(View view) {
    }
}
