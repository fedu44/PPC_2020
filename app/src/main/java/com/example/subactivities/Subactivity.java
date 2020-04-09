package com.example.subactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class Subactivity extends AppCompatActivity {

    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subactivity);

        et = (EditText)findViewById(R.id.editText);
    }

    public void okPress (View view){
        Intent mainActivity = new Intent(this, MainActivity.class);
        mainActivity.putExtra("newText", et.getText().toString());
        startActivity(mainActivity);
    }

    public void cancelPress (View view){
        Intent mainActivity = new Intent(this, MainActivity.class);
        startActivity(mainActivity);
    }
}
