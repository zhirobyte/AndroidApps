package com.example.prodctf;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.google.firebase.database.FirebaseDatabase;

public class level_Easy extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_easy);
    }

    private String uid;
    private String title;
    private String deskripsi;

    public level_Easy() {
    }

    public level_Easy(String uid, String title, String deskripsi) {
        this.uid = uid;
        this.title = title;
        this.deskripsi = deskripsi;
    }

    public String getUid() {
        return uid;
    }

    public String geTitle() {
        return title;
    }

    public String getContent() {
        return deskripsi;
    }



}