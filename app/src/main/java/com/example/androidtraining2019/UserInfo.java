package com.example.androidtraining2019;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class UserInfo extends AppCompatActivity {

    private final int ACTIVITY_USER_INFO=100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
        registerForContextMenu(findViewById(R.id.txtvu_userinfo));
    }
    public void editOrFinish(View view) {
        switch (view.getId()){
            case R.id.btn_edit:
                startActivityForResult(new Intent(this, UserInfoEditor.class),ACTIVITY_USER_INFO);
                break;
            case R.id.btn_finish:
                finish();
                break;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context,menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_whatisthis:
                android.support.v7.app.AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
                alertDialog.setTitle("What is this");
                alertDialog.setMessage("This is a context menu :)");
                alertDialog.setPositiveButton("OK", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
                alertDialog.setCancelable(true);
                alertDialog.show();
                return true;
            default:
                return super.onContextItemSelected(item);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_menu1,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.add_source:
//                return true;
//            default:
//                return super.onOptionsItemSelected(item);
//        }

        Toast.makeText(this,"Menu item selected"+item.getTitle(),Toast.LENGTH_LONG).show();
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == ACTIVITY_USER_INFO) {
            // Test to make sure the intent reply result was good.
            if (resultCode == RESULT_OK) {

                StringBuilder sb=new StringBuilder();
                sb.append("<b> Your Info is:</b>");
                sb.append("<b> Your Name is:</b>");
                sb.append(data.getStringExtra("name"));
                sb.append(" \n");
                sb.append("<b> Your Age is:</b>");
                sb.append(data.getStringExtra("age"));
                sb.append(" \n");
                sb.append("<b> Are you single:</b>");
                sb.append(data.getStringExtra("isSingle"));
                sb.append(" \n");
                sb.append("<b> Your Address is:</b>");
                sb.append(data.getStringExtra("address"));
                ((TextView) findViewById(R.id.txtvu_userinfo)).setText(Html.fromHtml(sb.toString()));
            }
        }

    }
}
