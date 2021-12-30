package com.example.prodctf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class main_level extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_level);
    }


    public void Easy(View view) {
        Intent intent = new Intent(main_level.this, level_Easy.class);
        startActivity(intent);
    }
    public void Medium(View view) {
        Intent intent = new Intent(main_level.this, level_Medium.class);
        startActivity(intent);
    }
    public void Hard(View view) {
        Intent intent = new Intent(main_level.this, level_Hard.class);
        startActivity(intent);
    }
}