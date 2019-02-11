package com.example.androidtraining2019;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class DrawableResources extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_resources);

        ImageButton button_tran = (ImageButton) findViewById(R.id.button_tran);
        button_tran.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TransitionDrawable drawable2 =
                        (TransitionDrawable) ((ImageButton)v).getDrawable();
                drawable2.startTransition(1000);
            }
        });


        Resources res = getResources();
        Drawable shape = ResourcesCompat.getDrawable(res, R.drawable.gradient_box, getTheme());

        TextView tv = (TextView)findViewById(R.id.textview);
        tv.setBackground(shape);
    }
}
