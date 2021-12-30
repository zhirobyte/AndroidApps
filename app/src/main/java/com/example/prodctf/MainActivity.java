package com.example.prodctf;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }// code ini terdapat pada setiap main yang digunakan untuk menunjukkan fungis utama protected

    //disini adalah tombol untuk masuk kedalam halaman utama level yang berisi tiga level
    public void Level(View view) {
        Intent intent = new Intent(MainActivity.this, main_level.class);
        startActivity(intent);// posisi kalau dipencet ini dia lari ke main_level :)
    }

}