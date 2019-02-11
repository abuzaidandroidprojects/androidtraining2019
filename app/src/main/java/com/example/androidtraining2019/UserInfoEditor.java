package com.example.androidtraining2019;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.preference.DialogPreference;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UserInfoEditor extends AppCompatActivity {

    @Override
    public void onBackPressed() {

        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Exit");
        alertDialog.setMessage("Exit the current activity?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.setCancelable(true);
        alertDialog.show();
       // super.onBackPressed();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info_editor);
        Button btn_save=findViewById(R.id.btn_save);
        btn_save.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent replyIntent = new Intent();
                replyIntent.putExtra("name", ((EditText)findViewById(R.id.edtxt_name)).getText().toString());
                replyIntent.putExtra("age", ((EditText)findViewById(R.id.edttxt_age)).getText().toString());
                replyIntent.putExtra("isSingle",((RadioButton)findViewById(((RadioGroup)findViewById(R.id.radiogroup_is_single)).getCheckedRadioButtonId())).getText());
                replyIntent.putExtra("address", ((EditText)findViewById(R.id.edttxt_address)).getText().toString());
                setResult(RESULT_OK, replyIntent);
                finish();
            }
        });
       Spinner spinner = (Spinner) findViewById(R.id.spinner);
       spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
           @Override
           public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
               Toast.makeText(getApplicationContext(),((TextView)view).getText().toString(),Toast.LENGTH_LONG).show();
           }
           @Override
           public void onNothingSelected(AdapterView<?> parent) {
           }
       } );
// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.universities_list, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
        spinner.setAdapter(adapter);

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i("onSaveInstanceState",((EditText)findViewById(R.id.edtxt_name)).getText().toString());
        outState.putString("name", ((EditText)findViewById(R.id.edtxt_name)).getText().toString());
//        outState.putString("age", ((EditText)findViewById(R.id.edttxt_age)).getText().toString());
//        outState.putString("isSingle",((RadioButton)findViewById(((RadioGroup)findViewById(R.id.radiogroup_is_single)).getCheckedRadioButtonId())).getText().toString());
//        outState.putString("address", ((EditText)findViewById(R.id.edttxt_address)).getText().toString());
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!= null){
            Log.d("onRestoreInstanceState", savedInstanceState.getString("name").toString());
            ((EditText)findViewById(R.id.edtxt_name)).setText(savedInstanceState.getString("name").toString());
           // outState.putString("age", ((EditText)findViewById(R.id.edttxt_age)).getText().toString());
            // outState.putString("isSingle",((RadioButton)findViewById(((RadioGroup)findViewById(R.id.radiogroup_is_single)).getCheckedRadioButtonId())).getText().toString());
          //  outState.putString("address", ((EditText)findViewById(R.id.edttxt_address)).getText().toString());
        }
    }

    public void showAlertDialog(View view) {
        AlertDialog.Builder alertDialog=new AlertDialog.Builder(this);
        alertDialog.setTitle("Exit");
        alertDialog.setMessage("Exit the current activity?");
        alertDialog.setPositiveButton("Yes", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alertDialog.setNegativeButton("No", new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialog.setCancelable(true);
        alertDialog.show();
    }
}
