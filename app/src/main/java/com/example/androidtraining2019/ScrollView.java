package com.example.androidtraining2019;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v4.app.ShareCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class ScrollView extends AppCompatActivity {
    private ActionMode mActionMode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scroll_view);
        findViewById(R.id.textView).setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if (mActionMode != null) return false;
                mActionMode =
                        ScrollView.this.startActionMode(mActionModeCallback);
                v.setSelected(true);
                return true;

            }
        });
    }
    public ActionMode.Callback mActionModeCallback =
            new ActionMode.Callback() {
                @Override
                public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                    mode.getMenuInflater().inflate(R.menu.menu_action_bar, menu);
                    return true;

                }

                @Override
                public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                    return false;
                }

                @Override
                public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.menu_share:
                            String txt = ((TextView)findViewById(R.id.textView)) .getText().toString();
                            String mimeType = "text/plain";
                            ShareCompat.IntentBuilder
                                    .from(ScrollView.this)
                                    .setType(mimeType)
                                    .setChooserTitle(R.string.share_text_with)
                                    .setText(txt)
                                    .startChooser();
                            mode.finish(); // Action picked, so close the action bar
                            return true;
                        case R.id.mi_item1:
                            Toast.makeText(getApplicationContext(), "You clicked on ...", Toast.LENGTH_LONG).show();
                            return true;
                        default:
                            return false;
                    }
                }

                @Override
                public void onDestroyActionMode(ActionMode mode) {
                    mActionMode = null;
                }
                // Implement action mode callbacks here
            };

    public void finish(View view) {
        finish();
    }

}
