package com.example.subactivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tvText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvText = (TextView)findViewById(R.id.tv_text);
        String newText = getIntent().getStringExtra("newText");
        System.out.println("newText" + newText);
        if(newText != null){
            this.onChangeText(newText);
        } else{
            SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
            this.onChangeText(preferences.getString("oldText", ""));
        }
    }

    public void onChangeText(String text){
        System.out.println("text" + text);
        SharedPreferences preferences = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = preferences.edit();
        Obj_editor.putString("oldText", text);
        Obj_editor.commit();
        tvText.setText(text);
    }

    public void changeTextPress (View view){
        Intent subactivity = new Intent(this, Subactivity.class);
        startActivity(subactivity);
    }
}
