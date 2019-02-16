package com.example.androidtraining2019;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v4.app.NavUtils;
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

import java.util.Locale;

public class MainActivity extends AppCompatActivity{
    ImageButton mButton ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                if (buttonView.isChecked()) {
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
