package com.example.tp4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.tp4.databinding.ActivityMainBinding;

public class InfosActivity extends AppCompatActivity {
    private ActivityMainBinding ui;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
       // ui = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(R.layout.activity_infos2);
       // setTitle(getLocalClassName());
    }
}