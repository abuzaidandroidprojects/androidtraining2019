package com.example.androidtraining2019.Brodcast;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.androidtraining2019.R;
import com.example.androidtraining2019.Services.DownloadService;
import com.example.androidtraining2019.Utils.Utils;

import java.io.File;

public class DownloadFileFinishedReceiver extends BroadcastReceiver {

    private TextView textView;
    private Activity activity;

    public DownloadFileFinishedReceiver(Activity activity,TextView textView) {
        this.textView = textView;
        this.activity=activity;
    }
    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            String string = bundle.getString(DownloadService.FILEPATH);
            int resultCode = bundle.getInt(DownloadService.RESULT);
            if (resultCode == Activity.RESULT_OK) {
                Toast.makeText(activity.getApplicationContext(),
                        "Download complete. Download URI: " + string,
                        Toast.LENGTH_LONG).show();
                ((ImageView)activity.findViewById(R.id.img_loaded)).setImageURI(Uri.fromFile( new File(string)));
                textView.setText("Download done");
            } else {
                Toast.makeText(activity.getApplicationContext(), "Download failed",
                        Toast.LENGTH_LONG).show();
                textView.setText("Download failed");
            }
        }
    }
}
