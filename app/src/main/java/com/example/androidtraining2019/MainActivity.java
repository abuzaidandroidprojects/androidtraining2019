package com.example.androidtraining2019;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Build;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Switch;
import android.widget.ToggleButton;

import com.example.androidtraining2019.Utils.NotificationHelper;

import java.util.Locale;

public class MainActivity extends AppCompatActivity{
    ImageButton mButton ;
    public static final String MyPREFERENCES = "MyPrefs" ;
    SharedPreferences sharedpreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        sharedpreferences = getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE);
        String local=sharedpreferences.getString("Local","en");
       if(local.equals("ar")){
           Locale locale = new Locale("ar");
           Locale.setDefault(locale);
           Resources res = getResources();
           Configuration config = new Configuration(res.getConfiguration());
           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
               config.setLocale(locale);
               config.setLayoutDirection(locale);
           }else{
               ViewCompat.setLayoutDirection(findViewById(R.id.activity_main), ViewCompat.LAYOUT_DIRECTION_RTL);
           }

           res.updateConfiguration(config, res.getDisplayMetrics());
       }
        setContentView(R.layout.activity_main);
        mButton = findViewById(R.id.button_popup);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(MainActivity.this, mButton);
                popup.getMenuInflater().inflate(
                        R.menu.menu_popup, popup.getMenu());
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        return false;
                    }
                    // implement click listener
                });
                popup.show();
            }
        });
        ToggleButton sw = findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                String language = "en";
                SharedPreferences.Editor editor = sharedpreferences.edit();
                Configuration config;
                Resources res;
                Locale locale;
                if (buttonView.isChecked()) {
                    language = "ar";
                    editor.putString("Local", "ar");
                    locale = new Locale(language);
                    Locale.setDefault(locale);
                    res = getResources();
                    config = new Configuration(res.getConfiguration());
                    config.locale = locale;
                    res.updateConfiguration(config, res.getDisplayMetrics());
                } else {
                    editor.putString("Local", "en");
                    locale = new Locale(language);
                    Locale.setDefault(locale);
                    res = getResources();
                    config = new Configuration(res.getConfiguration());
                    config.locale = locale;

                }
                editor.apply();
                editor.commit();
                res.updateConfiguration(config, res.getDisplayMetrics());
        }
        });


    }
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.btn_scroll_view:
                Intent intent=new Intent(this, ScrollView.class);
                startActivity(intent);
                break;
            case R.id.btn_start_activity_result:
                startActivity(new Intent(this,UserInfo.class));
                break;
            case R.id.btn_saved:
                Log.i("EE","Error");
                startActivity(new Intent(this,UserInfoEditor.class));
                break;
            case R.id.btn_datetime:
                startActivity(new Intent(this,DateTimeActivity.class));
                break;
                case R.id.btn_startchild:
                startActivity(new Intent(this,NavDrawer.class));
                break;
            case R.id.btn_navDrawerFromScratchActivity:
                startActivity(new Intent(this,NavDrawerFromScratchActivity.class));
                break;
            case R.id.btn_tabbedactivity:
                startActivity(new Intent(this,TabbedActivity.class));
                break;
            case R.id.btn_tabbedactionactivity:
                startActivity(new Intent(this,TabbedActivityActionBar.class));
                break;
            case R.id.btn_mani_nav_drawer:
                startActivity(new Intent(this,MainNavDrawer.class));
                break;
            case R.id.btn_drawables:
                startActivity(new Intent(this,DrawableResources.class));
                break;
            case R.id.btn_loadimageactivity:
                startActivity(new Intent(this,LoadImageActivity.class));
                break;
            case R.id.btn_loadbroadcastativity:
                startActivity(new Intent(this,BroadcastActivity.class));
                break;
            case R.id.btn_downloadFileUsingService:
                startActivity(new Intent(this,StartIntentServiceActivity.class));
                break;
            case R.id.btn_openNotification:
                startActivity(new Intent(this,StartNotificationActivity.class));
                break;
            case R.id.btn_AlarmActivity:
                startActivity(new Intent(this,AlarmActivity.class));
                break;
            case R.id.btn_JobServiceActivity:
                startActivity(new Intent(this,JobServiceActivity.class));
                break;


        }
    }

    public void changeLanguage(View view) {
        String language = "en";
        Switch sw = (Switch) view;
        if (sw.isChecked()) {
            language = "ar";
            Locale locale = new Locale(language);
            Locale.setDefault(locale);
            Resources res = getResources();
            Configuration config = new Configuration(res.getConfiguration());
            config.locale = locale;
            res.updateConfiguration(config, res.getDisplayMetrics());
        } else {
            Locale locale = new Locale(language);
            Locale.setDefault(locale);
            Resources res = getResources();
            Configuration config = new Configuration(res.getConfiguration());
            config.locale = locale;
            res.updateConfiguration(config, res.getDisplayMetrics());
        }
    }


}
